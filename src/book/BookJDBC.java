package book;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookJDBC implements DaoBook{
	//在构造方法中进行驱动初始化
	public BookJDBC(){
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
	//查看图书
	@Override
	public List<Book> list() {
		List<Book> ls = null;
		try(Connection conn = getConnection();
				Statement s = conn.createStatement()){
			String sql = "select * from book";
			ResultSet rs = s.executeQuery(sql);
			ls = new ArrayList<>();
			
			while(rs.next()){
				//获取属性值
				String isbn = rs.getString(1);
				String bookname = rs.getString(2);
				String author = rs.getString(3);
				String typeid = rs.getString(4);
				Date publishdate = rs.getDate(5);
				int publishnum = rs.getInt(6);
				String publish = rs.getString(7);
				double price = rs.getDouble(8);
				//将属性值添加到Book中
				Book book = new Book();
				book.setIsbn(isbn);
				book.setBookname(bookname);
				book.setAuthor(author);
				book.setTypeid(typeid);
				book.setPublishdate(publishdate);
				book.setPublishnum(publishnum);
				book.setPublish(publish);
				book.setPrice(price);
				
				//将Book对象加入到容器中
				ls.add(book);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ls;
	}
	
	//增加图书
	@Override
	public void add(Book book) {
		String sql = "insert into book values(?,?,?,?,?,?,?,?)";
		try(Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, book.getIsbn());
			ps.setString(2, book.getBookname());
			ps.setString(3, book.getAuthor());
			ps.setString(4, book.getTypeid());
			ps.setDate(5, book.getPublishdate());
			ps.setInt(6, book.getPublishnum());
			ps.setString(7, book.getPublish());
			ps.setDouble(8, book.getPrice());
			
			//执行
			ps.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	//删除图书
	@Override
	public void delete(Book book) {
		try(Connection conn = getConnection();
				Statement s = conn.createStatement()){
			String sql = "delete from book where isbn='"+book.getIsbn()+"'";
			s.execute(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	//更新图书
	@Override
	public void update(Book book) {
		String sql = "update book set bookname=?,author=?,typeid=?,publishdate=?,publishnum=?,publish=?,price=? where isbn='"+book.getIsbn()+"'";
		try(Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, book.getBookname());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getTypeid());
			ps.setDate(4, book.getPublishdate());
			ps.setInt(5, book.getPublishnum());
			ps.setString(6, book.getPublish());
			ps.setDouble(7, book.getPrice());
			
			//执行
			ps.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
