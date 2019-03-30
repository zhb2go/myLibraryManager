package library;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.sql.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import reader.Reader;
import reader.ReaderJDBC;
import reader.ReaderTableModel;
import readerType.ReaderType;
import readerType.ReaderTypeJDBC;

public class AddReader{
	
	public static void add(JFrame f){
		final JDialog d = new JDialog(f, "��Ӷ�����Ϣ", true);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		d.setSize(800, 600);
		d.setLocationRelativeTo(null);
		
		d.setLayout(new BorderLayout());
		//this.setResizable(false);
		//���һ�����������ı���ͱ�ǩ
		panel1.setBackground(Color.DARK_GRAY);
		panel1.setLayout(new FlowLayout());
		JLabel ltitle = new JLabel("    -------------------------������������Ϣ------------------------");
		ltitle.setPreferredSize(new Dimension(d.getWidth(), 60));
		ltitle.setFont(new Font("����", Font.BOLD, 20));
		ltitle.setForeground(Color.ORANGE);
		panel1.add(ltitle);
		JLabel lid = new JLabel("  ���߱��:");
		lid.setFont(new Font("����", Font.BOLD, 25));
		lid.setForeground(Color.CYAN);
		panel1.add(lid);
		final JTextField tfid = new JTextField("");
		tfid.setFont(new Font("����", Font.BOLD, 25));
		tfid.setForeground(Color.darkGray);
		tfid.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfid);
		JLabel lname = new JLabel("  ��������:");
		lname.setFont(new Font("����", Font.BOLD, 25));
		lname.setForeground(Color.CYAN);
		panel1.add(lname);
		final JTextField tfname = new JTextField("");
		tfname.setFont(new Font("����", Font.BOLD, 25));
		tfname.setForeground(Color.darkGray);
		tfname.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfname);
		JLabel lsex = new JLabel("  �����Ա�:");
		lsex.setFont(new Font("����", Font.BOLD, 25));
		lsex.setForeground(Color.CYAN);
		panel1.add(lsex);
		final JRadioButton bsex1 = new JRadioButton("��");
		bsex1.setSelected(true);
		bsex1.setFont(new Font("����", Font.BOLD, 25));
		bsex1.setPreferredSize(new Dimension(87, 30));
		final JRadioButton bsex2 = new JRadioButton("Ů");
		bsex2.setFont(new Font("����", Font.BOLD, 25));
		bsex2.setPreferredSize(new Dimension(87, 30));
		ButtonGroup bg = new ButtonGroup();
		bg.add(bsex1);
		bg.add(bsex2);
		panel1.add(bsex1);
		panel1.add(bsex2);
		JLabel ldept = new JLabel("  ����ϵ��:");
		ldept.setFont(new Font("����", Font.BOLD, 25));
		ldept.setForeground(Color.CYAN);
		panel1.add(ldept);
		final JTextField tfdept = new JTextField("");
		tfdept.setFont(new Font("����", Font.BOLD, 25));
		tfdept.setForeground(Color.darkGray);
		tfdept.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfdept);
	    JLabel lage = new JLabel("  ��������:");
		lage.setFont(new Font("����", Font.BOLD, 25));
	    lage.setForeground(Color.CYAN);
		panel1.add(lage);
		final JTextField tfage = new JTextField("");
		tfage.setFont(new Font("����", Font.BOLD, 25));
		tfage.setForeground(Color.darkGray);
		tfage.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfage);
		JLabel ltypeid = new JLabel("  ���ͱ��:");
		ltypeid.setFont(new Font("����", Font.BOLD, 25));
		ltypeid.setForeground(Color.CYAN);
		panel1.add(ltypeid);
		final JTextField tftypeid = new JTextField("");
		tftypeid.setFont(new Font("����", Font.BOLD, 25));
		tftypeid.setForeground(Color.darkGray);
		tftypeid.setPreferredSize(new Dimension(180, 30));
		panel1.add(tftypeid);
		JLabel lphone = new JLabel("  ���ߵ绰:");
		lphone.setFont(new Font("����", Font.BOLD, 25));
		lphone.setForeground(Color.CYAN);
		panel1.add(lphone);
		final JTextField tfphone = new JTextField("");
		tfphone.setFont(new Font("����", Font.BOLD, 25));
		tfphone.setForeground(Color.darkGray);
		tfphone.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfphone);
		JLabel lregdate = new JLabel("  ע������:");
		final Date regdate = new Date(System.currentTimeMillis());//��ȡ��ǰ����
		lregdate.setFont(new Font("����", Font.BOLD, 25));
		lregdate.setForeground(Color.CYAN);
		panel1.add(lregdate);
		JTextField tfregdate = new JTextField(regdate.toString());
		tfregdate.setEditable(false);
		tfregdate.setFont(new Font("����", Font.BOLD, 25));
		tfregdate.setForeground(Color.darkGray);
		tfregdate.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfregdate);
		JLabel ltail = new JLabel("    --------------------------------------------------------------");
		ltail.setPreferredSize(new Dimension(d.getWidth(), 60));
		ltail.setFont(new Font("����", Font.BOLD, 20));
		ltail.setForeground(Color.ORANGE);
		panel1.add(ltail);
		//����ύ��ť
		JButton b = new JButton("���");
		b.setFont(new Font("����", Font.BOLD, 25));
		b.setPreferredSize(new Dimension(120, 60));
		panel1.add(b);
		//�������������ö�����Ϣ
		panel2.setPreferredSize(new Dimension(ImageObserver.WIDTH, 200));
		//����TableModel����
		final ReaderTableModel rtm = new ReaderTableModel();
		//����Table����
		final JTable table = new JTable(rtm);
		//��Table���뵽���������
		panel2.setLayout(new BorderLayout());
		JScrollPane sp = new JScrollPane(table);
		//�����������뵽panel2��
		panel2.add(sp,BorderLayout.CENTER);
		d.add(panel1, BorderLayout.CENTER);
		d.add(panel2, BorderLayout.SOUTH);
		//���ð�ť������
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String rid = tfid.getText();//��ȡ���߱��
				String name = tfname.getText();//��ȡ��������
				String sex = null;
				if(bsex1.isSelected()){
					sex = "��";
				}else if(bsex2.isSelected()){
					sex = "Ů";
				}
				
				String dept = tfdept.getText();//��ȡ��������ϵ��
				
				String typeid = tftypeid.getText();//��ȡ�������ͱ��
				String phone = tfphone.getText();//��ȡ���ߵ绰����
				
				if(rid.equals("")||name.equals("")||sex.equals(null)||dept.equals("")||tfage.getText().equals("")||typeid.equals("")||phone.equals("")){
					JOptionPane.showMessageDialog(d, "��Ϣ��д������");
				}else {
					try{
						int age = Integer.parseInt(tfage.getText());//��ȡ��������
						//����ReaderJDBC���󣬵���add����
						ReaderJDBC rj = new ReaderJDBC();
						List<Reader> lsreader = rj.list();
						int j;
						//�ж϶������Ƿ��Ѵ���
						for(j=0; j<lsreader.size(); j++){
							if(lsreader.get(j).getRid().equals(rid)){
								JOptionPane.showMessageDialog(d, "ͼ�����Ѵ���");
								break;
							}
						}
						//ͼ���Ų����ڿ��Լ���
						if(j>=lsreader.size()){
							//����ReaderTypeJDBC����,�ж������ͼ�������Ƿ��Ѵ��ڣ��Ѵ�����������
							ReaderTypeJDBC rtj = new ReaderTypeJDBC();
							List<ReaderType> list = rtj.list();//��ȡͼ�����ͼ���
							int i;
							for(i=0; i<list.size(); i++){
								//ͼ�������Ѵ��ڿ������
								if(list.get(i).getId().equals(typeid)){
									//����Reader ����
									Reader reader = new Reader(rid, name, sex, dept, age, typeid, phone, regdate);
									rj.add(reader);
									//����TableModel�е�����
									rtm.lsreader = rj.list();
									//ˢ��
									table.updateUI();
									JOptionPane.showMessageDialog(d, "�ύ�ɹ�");
									break;
								}
							}
							
							if(i>=list.size()){
								JOptionPane.showMessageDialog(d, "�����ڴ˶������ͣ�������Ӵ�ͼ�����ͣ�");
							}
						}
					}catch(NumberFormatException e1){
						JOptionPane.showMessageDialog(d, "�����ʽ����ȷ!");
					}
				}
			}
		});
		
		d.setVisible(true);
	}
	
}
