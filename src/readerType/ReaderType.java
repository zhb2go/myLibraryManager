package readerType;

public class ReaderType {
	private String id;//�������ͱ��
	private String typename;//������������
	private int maxborrownum;//���ɽ���ͼ������
	private int daynum;//��ɽ�������
	//�޲ι���
	public ReaderType(){
		
	}
	//�вι���
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
