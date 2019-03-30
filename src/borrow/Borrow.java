package borrow;

import java.sql.Date;

public class Borrow {
	private String rid;//读者编号
	private String isbn;//图书ISBN号
	private Date borrowdate;//借书日期
	private double fine;//罚金
	private Date returndate;//还书日期
	public Borrow() {
		
	}
	public Borrow(String rid, String isbn, Date borrowdate, double fine, Date returndate) {
		this.rid = rid;
		this.isbn = isbn;
		this.borrowdate = borrowdate;
		this.fine = fine;
		this.returndate = returndate;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Date getBorrowdate() {
		return borrowdate;
	}
	public void setBorrowdate(Date borrowdate) {
		this.borrowdate = borrowdate;
	}
	public double getFine() {
		return fine;
	}
	public void setFine(double fine) {
		this.fine = fine;
	}
	public Date getReturndate() {
		return returndate;
	}
	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}
	
}
