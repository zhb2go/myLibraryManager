package readerType;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ReaderTypeTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//表格上的标题
	String[] c = new String[]{"读者类型编号","读者类型名称",
			"最多可借阅图书数量","最长可借阅天数"};
	//表格中的内容
	public List<ReaderType> readertype = new ReaderTypeJDBC().list();
	//返回一共有多少行
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return readertype.size();
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
	//返回指定单元格的值
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		ReaderType rt = readertype.get(rowIndex);
		if(0==columnIndex)
			return rt.getId();
		if(1==columnIndex)
			return rt.getTypename();
		if(2==columnIndex)
			return rt.getMaxborrownum();
		if(3==columnIndex)
			return rt.getDaynum();
		return null;
	}
}
