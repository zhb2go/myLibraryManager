package reader;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReaderJDBC implements DaoReader{
	//�ڹ��췽���н���������ʼ��
	public ReaderJDBC(){
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
	public List<Reader> list() {
		// ��list�����ʼ��Ϊnull
		List<Reader> ls = null;
		try(Connection conn = getConnection();//�������Ӷ���
				Statement s = conn.createStatement()){
			String sql = "select * from reader";
			ResultSet rs = s.executeQuery(sql);
			ls = new ArrayList<>();//����ArrayList�������ڴ洢Reader
			while(rs.next()){
				Reader reader = new Reader();//����һ��Reader����
				//��ȡ������ֵ
				String rid = rs.getString(1);
				String name = rs.getString(2);
				String sex = rs.getString(3);
				String dept = rs.getString(4);
				int age = rs.getInt(5);
				String typeid = rs.getString(6);
				String phone = rs.getString(7);
				Date regdate = rs.getDate(8);
				//��ӵ�Reader������
				reader.setRid(rid);
				reader.setName(name);
				reader.setSex(sex);
				reader.setDept(dept);
				reader.setAge(age);
				reader.setTypeid(typeid);
				reader.setPhone(phone);
				reader.setRegdate(regdate);
				//��������ӵ�������
				ls.add(reader);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ls;//����list����
	}
	//��Ӷ���
	@Override
	public void add(Reader r) {
		String sql = "insert into reader values(?,?,?,?,?,?,?,?)";
		try(Connection conn = getConnection();//�������Ӷ���
				PreparedStatement ps = conn.prepareStatement(sql)){
			//���ø�������ֵ
			ps.setString(1, r.getRid());//���ö��߱��
			ps.setString(2, r.getName());//���ö�������
			ps.setString(3, r.getSex());//���ö����Ա�
			ps.setString(4, r.getDept());//���ö���ϵ��
			ps.setInt(5, r.getAge());//���ö�������
			ps.setString(6, r.getTypeid());//���ö������ͱ��
			ps.setString(7, r.getPhone());//���ö��ߵ绰
			ps.setDate(8, r.getRegdate());//���ö���ע������
			//ִ��
			ps.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	//ɾ������
	@Override
	public void delete(Reader r) {
		try(Connection conn = getConnection();//�������Ӷ���
				Statement s = conn.createStatement()){
			String sql = "delete from reader where rid='"+r.getRid()+"'";
			s.execute(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	//�޸Ķ�����Ϣ
	@Override
	public void update(Reader r) {
		String sql = "update reader set name=?,sex=?,dept=?,age=?,typeid=?,phone=?,regdate=? where rid='"+r.getRid()+"'";
		try(Connection conn = getConnection();//�������Ӷ���
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, r.getName());//��������
			ps.setString(2, r.getSex());//�����Ա�
			ps.setString(3, r.getDept());//����ϵ��
			ps.setInt(4, r.getAge());//��������
			ps.setString(5, r.getTypeid());//�������ͱ��
			ps.setString(6, r.getPhone());//���µ绰
			ps.setDate(7, r.getRegdate());//����ע������
			
			//ִ��
			ps.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}