package reader;

import java.sql.Date;

public class Reader {
	private String rid;//���߱��
	private String name;//��������
	private String sex;//�����Ա�
	private String dept;//��������ϵ��
	private int age;//��������
	private String typeid;//�������ͱ��
	private String phone;//���ߵ绰
	private Date regdate;//ע������
	
	public Reader(){
		
	}

	public Reader(String rid, String name, String sex, String dept, int age, String typeid, String phone,
			Date regdate) {
		super();
		this.rid = rid;
		this.name = name;
		this.sex = sex;
		this.dept = dept;
		this.age = age;
		this.typeid = typeid;
		this.phone = phone;
		this.regdate = regdate;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
}
