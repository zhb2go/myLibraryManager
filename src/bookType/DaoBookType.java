package bookType;

import java.util.List;
public interface DaoBookType {
	//�鿴ͼ������
	public List<BookType> list();
	//����ͼ������
	public void add(BookType bt);
	//ɾ��ͼ������
	public void delete(BookType bt);
	//�޸�ͼ������
	public void update(BookType bt);
}
