package bookType;

public class BookType {
	private String id;//ͼ�����ͱ��
	private String typename;//ͼ����������
	public BookType() {
		
	}
	public BookType(String id, String typename) {
		this.id = id;
		this.typename = typename;
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
}
