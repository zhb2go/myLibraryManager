package readerType;

import java.util.List;

public interface DaoReaderType {
	//�鿴��������
	public List<ReaderType> list();
	//���Ӷ�������
	public void add(ReaderType rt);
	//ɾ����������
	public void delete(ReaderType rt);
	//�޸Ķ�������
	public void update(ReaderType rt);
}
