package user;

import java.util.List;

public interface DaoUser {
	//查看读者类型
	public List<User> list();
	//增加读者类型
	public void add(User user);
	//删除读者类型
	public void delete(User user);
	//修改读者类型
	public void update(User user);
}
