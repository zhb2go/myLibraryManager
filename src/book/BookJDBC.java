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
	//�ڹ��췽���н���������ʼ��
	public BookJDBC(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	//����һ�����Ӷ���
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection
				("jdbc:mysql://localhost/db_book?characterEncoding=UTF-8","root","123456");
	}
	//�鿴ͼ��
	@Override
	public List<Book> list() {
		List<Book> ls = null;
		try(Connection conn = getConnection();
				Statement s = conn.createStatement()){
			String sql = "select * from book";
			ResultSet rs = s.executeQuery(sql);
			ls = new ArrayList<>();
			
			while(rs.next()){
				//��ȡ����ֵ
				String isbn = rs.getString(1);
				String bookname = rs.getString(2);
				String author = rs.getString(3);
				String typeid = rs.getString(4);
				Date publishdate = rs.getDate(5);
				int publishnum = rs.getInt(6);
				String publish = rs.getString(7);
				double price = rs.getDouble(8);
				//������ֵ��ӵ�Book��
				Book book = new Book();
				book.setIsbn(isbn);
				book.setBookname(bookname);
				book.setAuthor(author);
				book.setTypeid(typeid);
				book.setPublishdate(publishdate);
				book.setPublishnum(publishnum);
				book.setPublish(publish);
				book.setPrice(price);
				
				//��Book������뵽������
				ls.add(book);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ls;
	}
	
	//����ͼ��
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
			
			//ִ��
			ps.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	//ɾ��ͼ��
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
	
	//����ͼ��
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
			
			//ִ��
			ps.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
