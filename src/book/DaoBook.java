package book;

import java.util.List;

public interface DaoBook {
	//查看图书类型
	public List<Book> list();
	//增加图书类型
	public void add(Book book);
	//删除图书类型
	public void delete(Book book);
	//修改图书类型
	public void update(Book book);
}
