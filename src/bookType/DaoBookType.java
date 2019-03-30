package bookType;

import java.util.List;
public interface DaoBookType {
	//查看图书类型
	public List<BookType> list();
	//增加图书类型
	public void add(BookType bt);
	//删除图书类型
	public void delete(BookType bt);
	//修改图书类型
	public void update(BookType bt);
}
