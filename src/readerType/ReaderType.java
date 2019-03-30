package readerType;

public class ReaderType {
	private String id;//读者类型编号
	private String typename;//读者类型名称
	private int maxborrownum;//最多可借阅图书数量
	private int daynum;//最长可借阅天数
	//无参构造
	public ReaderType(){
		
	}
	//有参构造
	public ReaderType(String id, String typename, int maxborrownum, int daynum) {
		this.id = id;
		this.typename = typename;
		this.maxborrownum = maxborrownum;
		this.daynum = daynum;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public int getMaxborrownum() {
		return maxborrownum;
	}
	public void setMaxborrownum(int maxborrownum) {
		this.maxborrownum = maxborrownum;
	}
	public int getDaynum() {
		return daynum;
	}
	public void setDaynum(int daynum) {
		this.daynum = daynum;
	}
	
}
