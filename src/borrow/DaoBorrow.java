package borrow;

import java.util.List;

import book.Book;
import reader.Reader;

public interface DaoBorrow {
	//�鿴
	public List<Borrow> list();
	//����
	public void borrowBook(Reader reader,Book book);
	//����
	public long returnBook(Borrow borrow);
}
