package borrow;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import book.Book;
import reader.Reader;

public class BorrowJDBC implements DaoBorrow{
	static double fine = 1;
	//在构造方法中进行驱动初始化
	public BorrowJDBC(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	//返回一个连接对象
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection
				("jdbc:mysql://localhost/db_book?characterEncoding=UTF-8","root","123456");
	}
	
	//借书，添加数据
	@Override
	public void borrowBook(Reader reader, Book book) {
		String sql = "insert into borrow values(?,?,?,?,?)";
		try(Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);){
			//借书时，根据读者编号和图书ISBN号插入数据
			Date borrowdate = new Date(System.currentTimeMillis());//借书时间
			String rid = reader.getRid();//借书读者的编号
			String isbn = book.getIsbn();//被借图书的编号
			Borrow borrow = new Borrow(rid, isbn, borrowdate, fine, null);//初始化
			ps.setString(1, borrow.getRid());//将读者编号放入数据库
			ps.setString(2, borrow.getIsbn());//将图书ISBN号放入数据库
			ps.setDate(3, borrow.getBorrowdate());//将借书时间放入数据库
			ps.setDouble(4, borrow.getFine());//将每天罚金放入数据库
			ps.setDate(5, borrow.getReturndate());//将归还时间放入数据库
			//执行
			ps.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	//还书，返回一个借阅的天数，并将借阅表中的数据删除
	@Override
	public long returnBook(Borrow borrow) {
		long days=0;
		try(Connection conn = getConnection();
				Statement s = conn.createStatement()){
			Date returndate = new Date(System.currentTimeMillis());
			Date borrowdate = borrow.getBorrowdate();
			
			days = (returndate.getTime()-borrowdate.getTime())/(1000*3600*24);//计算借阅的天数
			String sql = "delete from borrow where rid="+borrow.getRid()+" and isbn='"+borrow.getIsbn()+"'";
			s.execute(sql);//执行删除数据
		}catch(SQLException e){
			e.printStackTrace();
		}
		return days;
	}
	//查看
	@Override
	public List<Borrow> list() {
		List<Borrow> ls = null;
		try(Connection conn = getConnection();
				Statement s = conn.createStatement()){
			String sql = "select * from borrow";
			ResultSet rs = s.executeQuery(sql);
			ls = new ArrayList<>();
			while(rs.next()){
				Borrow borrow = new Borrow();
				borrow.setRid(rs.getString(1));
				borrow.setIsbn(rs.getString(2));
				borrow.setBorrowdate(rs.getDate(3));
				borrow.setFine(rs.getDouble(4));
				borrow.setReturndate(rs.getDate(5));
				
				//将对象插入到容器中
				ls.add(borrow);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ls;
	}
}
