package user;

import java.util.List;

public interface DaoUser {
	//�鿴��������
	public List<User> list();
	//���Ӷ�������
	public void add(User user);
	//ɾ����������
	public void delete(User user);
	//�޸Ķ�������
	public void update(User user);
}
