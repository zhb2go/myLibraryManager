package book;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class BookTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//表格上的标题
	String[] c = new String[] {"图书ISBN号","图书名称","图书作者","图书类型编号",
			"图书出版日期","图书出版数量","图书出版社","图书价格"};
	//表格上的内容
	public List<Book> lsbook = new BookJDBC().list();
	//返回一共有多少行
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lsbook.size();
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
	//每一个单元格中的值
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Book b = lsbook.get(rowIndex);
		if(0==columnIndex)
			return b.getIsbn();
		if(1==columnIndex)
			return b.getBookname();
		if(2==columnIndex)
			return b.getAuthor();
		if(3==columnIndex)
			return b.getTypeid();
		if(4==columnIndex)
			return b.getPublishdate();
		if(5==columnIndex)
			return b.getPublishnum();
		if(6==columnIndex)
			return b.getPublish();
		if(7==columnIndex)
			return b.getPrice();
		return null;
	}
	
}
