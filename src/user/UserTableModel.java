package user;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class UserTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//表格中的标题
	String[] c = new String[] {"用户名称","用户密码"};
	//表格中的内容
	public List<User> user = new UserJDBC().list();
	//返回一共有多少行
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return user.size();
	}
	//返回一共有多少列
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return c.length;
	}
	// 获取每一列的名称
    public String getColumnName(int columnIndex) {
        // TODO Auto-generated method stub
        return c[columnIndex];
    }
    // 单元格是否可以修改
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    //每一个单元格的值
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		User u = user.get(rowIndex);//获取表格中一行所对应的User对象
		//返回每个单元格所对应的值
		if(0==columnIndex)
			return u.getId();
		if(1==columnIndex)
			return u.getPassword();
		return null;
	}
}
