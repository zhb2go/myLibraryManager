package readerType;

import java.util.List;

public interface DaoReaderType {
	//查看读者类型
	public List<ReaderType> list();
	//增加读者类型
	public void add(ReaderType rt);
	//删除读者类型
	public void delete(ReaderType rt);
	//修改读者类型
	public void update(ReaderType rt);
}
