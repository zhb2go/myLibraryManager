package reader;

import java.util.List;

public interface DaoReader {
	//查看读者
	public List<Reader> list();
	//增加读者
	public void add(Reader r);
	//删除读者
	public void delete(Reader r);
	//修改读者
	public void update(Reader r);
}
