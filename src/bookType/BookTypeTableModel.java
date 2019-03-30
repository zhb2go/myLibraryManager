package bookType;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class BookTypeTableModel extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//表格上的标题
	String[] c = new String[] {"图书类型编号","图书类型名称"};
	//表格的内容
	public List<BookType> lsbooktype = new BookTypeJDBC().list();
	//返回一共有多少行
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lsbooktype.size();
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
		BookType bt = lsbooktype.get(rowIndex);
		if(0==columnIndex)
			return bt.getId();
		if(1==columnIndex)
			return bt.getTypename();
		return null;
	}

}
