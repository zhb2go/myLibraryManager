package readerType;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ReaderTypeTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//����ϵı���
	String[] c = new String[]{"�������ͱ��","������������",
			"���ɽ���ͼ������","��ɽ�������"};
	//����е�����
	public List<ReaderType> readertype = new ReaderTypeJDBC().list();
	//����һ���ж�����
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return readertype.size();
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
