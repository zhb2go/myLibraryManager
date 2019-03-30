package book;

import java.sql.Date;

public class Book {
	private String isbn;//图书ISBN号
	private String bookname;//图书名称
	private String author;//图书作者
	private String typeid;//图书类型编号
	private Date publishdate;//图书出版日期
	private int publishnum;//图书出版数量
	private String publish;//图书出版社
	private double price;//图书价格
	
	public Book() {
		
	}
	
	public Book(String isbn, String bookname, String author, String typeid, Date publishdate, int publishnum,
			String publish, double price) {
		this.isbn = isbn;
		this.bookname = bookname;
		this.author = author;
		this.typeid = typeid;
		this.publishdate = publishdate;
		this.publishnum = publishnum;
		this.publish = publish;
		this.price = price;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getBookname() {
		return bookname;
	}
	
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getTypeid() {
		return typeid;
	}
	
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	
	public Date getPublishdate() {
		return publishdate;
	}
	
	public void setPublishdate(Date publishdate) {
		this.publishdate = publishdate;
	}
	
	public int getPublishnum() {
		return publishnum;
	}
	
	public void setPublishnum(int publishnum) {
		this.publishnum = publishnum;
	}
	
	public String getPublish() {
		return publish;
	}
	
	public void setPublish(String publish) {
		this.publish = publish;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
}
