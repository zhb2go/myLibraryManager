package reader;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ReaderTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//表格上的标题
	String[] c = new String[]{"读者编号","读者姓名","读者性别","读者所在系部",
			"读者年龄","读者类型编号","读者电话","注册日期"};
	//表格内容
	public List<Reader> lsreader = new ReaderJDBC().list();
	//返回一共有多少行
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lsreader.size();
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
    //获取各个单元格中的值
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Reader r = lsreader.get(rowIndex);
		if(0==columnIndex)
			return r.getRid();
		if(1==columnIndex)
			return r.getName();
		if(2==columnIndex)
			return r.getSex();
		if(3==columnIndex)
			return r.getDept();
		if(4==columnIndex)
			return r.getAge();
		if(5==columnIndex)
			return r.getTypeid();
		if(6==columnIndex)
			return r.getPhone();
		if(7==columnIndex)
			return r.getRegdate();
		return null;
	}

}
