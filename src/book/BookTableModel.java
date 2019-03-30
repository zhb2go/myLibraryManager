package book;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class BookTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//����ϵı���
	String[] c = new String[] {"ͼ��ISBN��","ͼ������","ͼ������","ͼ�����ͱ��",
			"ͼ���������","ͼ���������","ͼ�������","ͼ��۸�"};
	//����ϵ�����
	public List<Book> lsbook = new BookJDBC().list();
	//����һ���ж�����
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lsbook.size();
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
	//ÿһ����Ԫ���е�ֵ
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
