package user;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class UserTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//����еı���
	String[] c = new String[] {"�û�����","�û�����"};
	//����е�����
	public List<User> user = new UserJDBC().list();
	//����һ���ж�����
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return user.size();
	}
	//����һ���ж�����
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return c.length;
	}
	// ��ȡÿһ�е�����
    public String getColumnName(int columnIndex) {
        // TODO Auto-generated method stub
        return c[columnIndex];
    }
    // ��Ԫ���Ƿ�����޸�
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    //ÿһ����Ԫ���ֵ
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		User u = user.get(rowIndex);//��ȡ�����һ������Ӧ��User����
		//����ÿ����Ԫ������Ӧ��ֵ
		if(0==columnIndex)
			return u.getId();
		if(1==columnIndex)
			return u.getPassword();
		return null;
	}
}
