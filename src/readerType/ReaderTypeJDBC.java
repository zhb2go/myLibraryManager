package readerType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;

public class ReaderTypeJDBC implements DaoReaderType{
	//�ڹ��췽���н���������ʼ��
	public ReaderTypeJDBC(){
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
	//�鿴
	@Override
	public List<ReaderType> list() {
		// TODO Auto-generated method stub
		List<ReaderType> ls = null;//��ʼ��list
		try(Connection conn = getConnection();//�������Ӷ���
				Statement s = conn.createStatement()){
			String sql = "select * from readertype";//����sql���
			ResultSet rs = s.executeQuery(sql);//��ȡ��ѯ���
			ls = new ArrayList<>();//����������������ڴ洢�������Ͷ���
			//���������
			while(rs.next()){
				String id = rs.getString(1);//�õ��������ͱ��
				String typename = rs.getString(2);//��ȡ������������
				int maxborrownum = rs.getInt(3);//��ȡ��������Ŀ
				int daynum = rs.getInt(4);//��ȡ���������
				ReaderType rt = new ReaderType(id, typename, maxborrownum, daynum);//��ʼ��
				ls.add(rt);//��������ӵ�������
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ls;//����һ��list����
	}
	//���
	@Override
	public void add(ReaderType rt) {
		// TODO Auto-generated method stub
		String sql = "insert into readertype values(?,?,?,?)";
		try(Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, rt.getId());//���ñ��
			ps.setString(2, rt.getTypename());//��������
			ps.setInt(3, rt.getMaxborrownum());//��������������
			ps.setInt(4, rt.getDaynum());//�������������
			ps.execute();//ִ��
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	//ɾ��
	@Override
	public void delete(ReaderType rt) {
		// TODO Auto-generated method stub
		try(Connection conn = getConnection();
				Statement s = conn.createStatement()){
			String sql = "delete from readerType where id='"+rt.getId()+"'";//����ɾ��sql���
			s.execute(sql);//ִ��
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	//����
	@Override
	public void update(ReaderType rt) {
		// TODO Auto-generated method stub
		String sql = "update readertype set typename=?,maxborrownum=?,daynum=? where id='"+rt.getId()+"'";
		try(Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, rt.getTypename());//��������
			ps.setInt(2, rt.getMaxborrownum());//������������
			ps.setInt(3, rt.getDaynum());//�������������
			ps.execute();//ִ��
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
