package library;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import readerType.ReaderType;
import readerType.ReaderTypeJDBC;
import readerType.ReaderTypeTableModel;

public class UpdateReaderType {
	public static void update(JFrame f){
		final JDialog d = new JDialog(f, "���Ӷ������", true);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		d.setSize(500, 500);
		d.setLocationRelativeTo(null);
		
		d.setLayout(new BorderLayout());
		
		
		panel1.setBackground(Color.DARK_GRAY);
		panel1.setLayout(new FlowLayout());
		JLabel ltitle = new JLabel("     ---�����·����������Ϣ---");
		ltitle.setPreferredSize(new Dimension(d.getWidth(), 60));
		ltitle.setFont(new Font("����", Font.BOLD, 25));
		ltitle.setForeground(Color.ORANGE);
		panel1.add(ltitle);
		
		JLabel ltypeid = new JLabel("����� : ");
		ltypeid.setFont(new Font("����", Font.BOLD, 30));
		ltypeid.setForeground(Color.CYAN);
		panel1.add(ltypeid);
		final JTextField tftypeid = new JTextField("");
		tftypeid.setEditable(false);
		tftypeid.setFont(new Font("����", Font.BOLD, 30));
		tftypeid.setForeground(Color.darkGray);
		tftypeid.setPreferredSize(new Dimension(250, 35));
		panel1.add(tftypeid);
		
		JLabel ltypename = new JLabel("������� : ");
		ltypename.setFont(new Font("����", Font.BOLD, 30));
		ltypename.setForeground(Color.CYAN);
		panel1.add(ltypename);
		final JTextField tftypename = new JTextField("");
		tftypename.setFont(new Font("����", Font.BOLD, 30));
		tftypename.setForeground(Color.darkGray);
		tftypename.setPreferredSize(new Dimension(250, 35));
		panel1.add(tftypename);
		
		JLabel lmaxnum = new JLabel("���ɽ���ͼ�� : ");
		lmaxnum.setFont(new Font("����", Font.BOLD, 25));
		lmaxnum.setForeground(Color.CYAN);
		panel1.add(lmaxnum);
		final JTextField tfmaxnum = new JTextField("");
		tfmaxnum.setFont(new Font("����", Font.BOLD, 25));
		tfmaxnum.setForeground(Color.darkGray);
		tfmaxnum.setPreferredSize(new Dimension(250, 30));
		panel1.add(tfmaxnum);
		
		JLabel ldaynum = new JLabel("��ɽ������� : ");
		ldaynum.setFont(new Font("����", Font.BOLD, 25));
		ldaynum.setForeground(Color.CYAN);
		panel1.add(ldaynum);
		final JTextField tfdaynum = new JTextField("");
		tfdaynum.setFont(new Font("����", Font.BOLD, 25));
		tfdaynum.setForeground(Color.darkGray);
		tfdaynum.setPreferredSize(new Dimension(250, 30));
		panel1.add(tfdaynum);
		
		JLabel ltitle1 = new JLabel("     -------------------------");
		ltitle1.setPreferredSize(new Dimension(d.getWidth(), 30));
		ltitle1.setFont(new Font("����", Font.BOLD, 25));
		ltitle1.setForeground(Color.ORANGE);
		panel1.add(ltitle1);
		//����ύ��ť
		JButton b = new JButton("�޸�");
		b.setFont(new Font("����", Font.BOLD, 30));
		b.setPreferredSize(new Dimension(100, 35));
		panel1.add(b);
		JLabel ltitle2 = new JLabel("     -------------------------");
		ltitle2.setPreferredSize(new Dimension(d.getWidth(), 30));
		ltitle2.setFont(new Font("����", Font.BOLD, 25));
		ltitle2.setForeground(Color.ORANGE);
		panel1.add(ltitle2);
		//�������������ö��������Ϣ
		panel2.setPreferredSize(new Dimension(ImageObserver.WIDTH, 80));
		//����TableModel����
		final ReaderTypeTableModel rttm = new ReaderTypeTableModel();
		//����Table����
		final JTable table = new JTable(rttm);
		//��Table���뵽���������
		panel2.setLayout(new BorderLayout());
		JScrollPane sp = new JScrollPane(table);
		//�����������뵽panel2��
		panel2.add(sp,BorderLayout.CENTER);
		d.add(panel1, BorderLayout.CENTER);
		d.add(panel2, BorderLayout.SOUTH);
		
		//���������ѡ��
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// ��ȡ��ѡ��
				int row = table.getSelectedRow();
				//��ȡ����
				ReaderType rt = rttm.readertype.get(row);
				String typeid = rt.getId();
				String typename = rt.getTypename();
				int maxnum = rt.getMaxborrownum();
				int daynum = rt.getDaynum();
				String maxnum0 = String.valueOf(maxnum);
				String daynum0 = String.valueOf(daynum);
				tftypeid.setText(typeid);
				tftypename.setText(typename);
				tfmaxnum.setText(maxnum0);
				tfdaynum.setText(daynum0);
			}
		});
		//���ð�ť������
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ��ȡ�ı�������
				String typeid = tftypeid.getText();
				String typename = tftypename.getText();
				String maxnum0 = tfmaxnum.getText();
				String daynum0 = tfdaynum.getText();
				//�ж��Ƿ�Ϊ��
				if(typeid.equals("")||typename.equals("")||maxnum0.equals("")||daynum0.equals("")){
					JOptionPane.showMessageDialog(d, "��Ϣ��д������");
				}else{
					try{
						int maxnum = Integer.parseInt(maxnum0);
						int daynum = Integer.parseInt(daynum0);
						//�жϱ���Ƿ��ظ�
						ReaderTypeJDBC rtj = new ReaderTypeJDBC();
						ReaderType rt = new ReaderType(typeid, typename, maxnum, daynum);
						int option = JOptionPane.showConfirmDialog(d, "ȷ���޸���");
						if(option==JOptionPane.OK_OPTION){
							rtj.update(rt);;
							//����
							rttm.readertype = rtj.list();
							//ˢ��
							table.updateUI();
							JOptionPane.showMessageDialog(d, "�޸ĳɹ�");
						}
					}catch(NumberFormatException e1){
						JOptionPane.showMessageDialog(d, "���ָ�ʽ���ڴ���");
					}
				}
				
			}
		});
		d.setVisible(true);
	}
}
