package book;

import java.util.List;

public interface DaoBook {
	//�鿴ͼ������
	public List<Book> list();
	//����ͼ������
	public void add(Book book);
	//ɾ��ͼ������
	public void delete(Book book);
	//�޸�ͼ������
	public void update(Book book);
}
