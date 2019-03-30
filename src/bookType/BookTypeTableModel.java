package bookType;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class BookTypeTableModel extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//����ϵı���
	String[] c = new String[] {"ͼ�����ͱ��","ͼ����������"};
	//��������
	public List<BookType> lsbooktype = new BookTypeJDBC().list();
	//����һ���ж�����
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lsbooktype.size();
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
	//����ָ����Ԫ���ֵ
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
