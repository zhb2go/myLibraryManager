package reader;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ReaderTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//����ϵı���
	String[] c = new String[]{"���߱��","��������","�����Ա�","��������ϵ��",
			"��������","�������ͱ��","���ߵ绰","ע������"};
	//�������
	public List<Reader> lsreader = new ReaderJDBC().list();
	//����һ���ж�����
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lsreader.size();
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
    //��ȡ������Ԫ���е�ֵ
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
