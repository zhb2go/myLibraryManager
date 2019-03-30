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
	//�ڹ��췽���н���������ʼ��
	public BookTypeJDBC(){
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
	
	//�鿴ͼ������
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
	
	//���ͼ������
	@Override
	public void add(BookType bt) {
		String sql = "insert into booktype values(?,?)";
		try(Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, bt.getId());//����ͼ�����ͱ��
			ps.setString(2, bt.getTypename());//����ͼ����������
			ps.execute();//ִ��
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	//ɾ��ͼ������
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
	//�޸�ͼ������
	@Override
	public void update(BookType bt) {
		String sql = "update booktype set typename=? where id=+'"+bt.getId()+"'";
		try(Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			//�޸�ͼ����������
			ps.setString(1, bt.getTypename());
			//ִ��
			ps.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}