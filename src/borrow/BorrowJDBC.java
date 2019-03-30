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
	//�ڹ��췽���н���������ʼ��
	public BorrowJDBC(){
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
	
	//���飬�������
	@Override
	public void borrowBook(Reader reader, Book book) {
		String sql = "insert into borrow values(?,?,?,?,?)";
		try(Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);){
			//����ʱ�����ݶ��߱�ź�ͼ��ISBN�Ų�������
			Date borrowdate = new Date(System.currentTimeMillis());//����ʱ��
			String rid = reader.getRid();//������ߵı��
			String isbn = book.getIsbn();//����ͼ��ı��
			Borrow borrow = new Borrow(rid, isbn, borrowdate, fine, null);//��ʼ��
			ps.setString(1, borrow.getRid());//�����߱�ŷ������ݿ�
			ps.setString(2, borrow.getIsbn());//��ͼ��ISBN�ŷ������ݿ�
			ps.setDate(3, borrow.getBorrowdate());//������ʱ��������ݿ�
			ps.setDouble(4, borrow.getFine());//��ÿ�췣��������ݿ�
			ps.setDate(5, borrow.getReturndate());//���黹ʱ��������ݿ�
			//ִ��
			ps.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	//���飬����һ�����ĵ��������������ı��е�����ɾ��
	@Override
	public long returnBook(Borrow borrow) {
		long days=0;
		try(Connection conn = getConnection();
				Statement s = conn.createStatement()){
			Date returndate = new Date(System.currentTimeMillis());
			Date borrowdate = borrow.getBorrowdate();
			
			days = (returndate.getTime()-borrowdate.getTime())/(1000*3600*24);//������ĵ�����
			String sql = "delete from borrow where rid="+borrow.getRid()+" and isbn='"+borrow.getIsbn()+"'";
			s.execute(sql);//ִ��ɾ������
		}catch(SQLException e){
			e.printStackTrace();
		}
		return days;
	}
	//�鿴
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
				
				//��������뵽������
				ls.add(borrow);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ls;
	}
}
