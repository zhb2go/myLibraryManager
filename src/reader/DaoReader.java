package reader;

import java.util.List;

public interface DaoReader {
	//�鿴����
	public List<Reader> list();
	//���Ӷ���
	public void add(Reader r);
	//ɾ������
	public void delete(Reader r);
	//�޸Ķ���
	public void update(Reader r);
}
