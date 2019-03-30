package borrow;

import java.util.List;

import book.Book;
import reader.Reader;

public interface DaoBorrow {
	//查看
	public List<Borrow> list();
	//借书
	public void borrowBook(Reader reader,Book book);
	//还书
	public long returnBook(Borrow borrow);
}
