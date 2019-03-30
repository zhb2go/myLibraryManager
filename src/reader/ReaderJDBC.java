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
	//在构造方法中进行驱动初始化
	public ReaderJDBC(){
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
	
	//查看
	@Override
	public List<Reader> list() {
		// 将list对象初始化为null
		List<Reader> ls = null;
		try(Connection conn = getConnection();//建立连接对象
				Statement s = conn.createStatement()){
			String sql = "select * from reader";
			ResultSet rs = s.executeQuery(sql);
			ls = new ArrayList<>();//创建ArrayList对象用于存储Reader
			while(rs.next()){
				Reader reader = new Reader();//创建一个Reader对象
				//获取各个列值
				String rid = rs.getString(1);
				String name = rs.getString(2);
				String sex = rs.getString(3);
				String dept = rs.getString(4);
				int age = rs.getInt(5);
				String typeid = rs.getString(6);
				String phone = rs.getString(7);
				Date regdate = rs.getDate(8);
				//添加到Reader对象中
				reader.setRid(rid);
				reader.setName(name);
				reader.setSex(sex);
				reader.setDept(dept);
				reader.setAge(age);
				reader.setTypeid(typeid);
				reader.setPhone(phone);
				reader.setRegdate(regdate);
				//将对象添加到容器中
				ls.add(reader);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ls;//返回list对象
	}
	//添加读者
	@Override
	public void add(Reader r) {
		String sql = "insert into reader values(?,?,?,?,?,?,?,?)";
		try(Connection conn = getConnection();//建立连接对象
				PreparedStatement ps = conn.prepareStatement(sql)){
			//设置各个属性值
			ps.setString(1, r.getRid());//设置读者编号
			ps.setString(2, r.getName());//设置读者姓名
			ps.setString(3, r.getSex());//设置读者性别
			ps.setString(4, r.getDept());//设置读者系部
			ps.setInt(5, r.getAge());//设置读者年龄
			ps.setString(6, r.getTypeid());//设置读者类型编号
			ps.setString(7, r.getPhone());//设置读者电话
			ps.setDate(8, r.getRegdate());//设置读者注册日期
			//执行
			ps.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	//删除读者
	@Override
	public void delete(Reader r) {
		try(Connection conn = getConnection();//建立连接对象
				Statement s = conn.createStatement()){
			String sql = "delete from reader where rid='"+r.getRid()+"'";
			s.execute(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	//修改读者信息
	@Override
	public void update(Reader r) {
		String sql = "update reader set name=?,sex=?,dept=?,age=?,typeid=?,phone=?,regdate=? where rid='"+r.getRid()+"'";
		try(Connection conn = getConnection();//建立连接对象
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, r.getName());//更新姓名
			ps.setString(2, r.getSex());//更新性别
			ps.setString(3, r.getDept());//更新系部
			ps.setInt(4, r.getAge());//更新年龄
			ps.setString(5, r.getTypeid());//更新类型编号
			ps.setString(6, r.getPhone());//更新电话
			ps.setDate(7, r.getRegdate());//更新注册日期
			
			//执行
			ps.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}