package bookType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookTypeJDBC implements DaoBookType{
	//在构造方法中进行驱动初始化
	public BookTypeJDBC(){
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
	
	//查看图书类型
	@Override
	public List<BookType> list() {
		List<BookType> ls = null;
		try(Connection conn = getConnection();
				Statement s = conn.createStatement()){
			String sql = "select * from booktype";
			ResultSet rs = s.executeQuery(sql);
			ls = new ArrayList<>();
			
			while(rs.next()){
				BookType bt = new BookType(rs.getString(1), rs.getString(2));
				ls.add(bt);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ls;
	}
	
	//添加图书类型
	@Override
	public void add(BookType bt) {
		String sql = "insert into booktype values(?,?)";
		try(Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, bt.getId());//设置图书类型编号
			ps.setString(2, bt.getTypename());//设置图书类型名称
			ps.execute();//执行
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	//删除图书类型
	@Override
	public void delete(BookType bt) {
		try(Connection conn = getConnection();
				Statement s = conn.createStatement()){
			String sql = "delete from booktype where id='"+bt.getId()+"'";
			s.execute(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	//修改图书类型
	@Override
	public void update(BookType bt) {
		String sql = "update booktype set typename=? where id=+'"+bt.getId()+"'";
		try(Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			//修改图书类型名称
			ps.setString(1, bt.getTypename());
			//执行
			ps.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}