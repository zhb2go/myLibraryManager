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
	//在构造方法中进行驱动初始化
	public ReaderTypeJDBC(){
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
	public List<ReaderType> list() {
		// TODO Auto-generated method stub
		List<ReaderType> ls = null;//初始化list
		try(Connection conn = getConnection();//建立连接对象
				Statement s = conn.createStatement()){
			String sql = "select * from readertype";//创建sql语句
			ResultSet rs = s.executeQuery(sql);//获取查询结果
			ls = new ArrayList<>();//创建集合类对象，用于存储读者类型对象
			//遍历结果集
			while(rs.next()){
				String id = rs.getString(1);//得到读者类型编号
				String typename = rs.getString(2);//获取读者类型名称
				int maxborrownum = rs.getInt(3);//获取最大借阅数目
				int daynum = rs.getInt(4);//获取最长借阅天数
				ReaderType rt = new ReaderType(id, typename, maxborrownum, daynum);//初始化
				ls.add(rt);//将对象添加到容器中
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ls;//返回一个list对象
	}
	//添加
	@Override
	public void add(ReaderType rt) {
		// TODO Auto-generated method stub
		String sql = "insert into readertype values(?,?,?,?)";
		try(Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, rt.getId());//设置编号
			ps.setString(2, rt.getTypename());//设置名称
			ps.setInt(3, rt.getMaxborrownum());//设置最大借阅数量
			ps.setInt(4, rt.getDaynum());//设置最长借阅天数
			ps.execute();//执行
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	//删除
	@Override
	public void delete(ReaderType rt) {
		// TODO Auto-generated method stub
		try(Connection conn = getConnection();
				Statement s = conn.createStatement()){
			String sql = "delete from readerType where id='"+rt.getId()+"'";//创建删除sql语句
			s.execute(sql);//执行
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	//更新
	@Override
	public void update(ReaderType rt) {
		// TODO Auto-generated method stub
		String sql = "update readertype set typename=?,maxborrownum=?,daynum=? where id='"+rt.getId()+"'";
		try(Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, rt.getTypename());//更新名称
			ps.setInt(2, rt.getMaxborrownum());//更新最大借阅量
			ps.setInt(3, rt.getDaynum());//更新最长借阅天数
			ps.execute();//执行
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
