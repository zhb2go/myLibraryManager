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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import reader.Reader;
import reader.ReaderJDBC;
import reader.ReaderTableModel;

public class DeleteReader {
	public static void delete(JFrame f){
		final JDialog d = new JDialog(f, "ɾ��������Ϣ", true);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		d.setSize(800, 600);
		d.setLocationRelativeTo(null);
		
		d.setLayout(new BorderLayout());
		//this.setResizable(false);
		//���һ�����������ı���ͱ�ǩ
		panel1.setBackground(Color.DARK_GRAY);
		panel1.setLayout(new FlowLayout());
		JLabel ltitle = new JLabel("    -----------------�����·������ѡ����Ҫɾ������-----------------");
		ltitle.setPreferredSize(new Dimension(d.getWidth(), 60));
		ltitle.setFont(new Font("����", Font.BOLD, 20));
		ltitle.setForeground(Color.ORANGE);
		panel1.add(ltitle);
		JLabel lid = new JLabel("  ���߱��:");
		lid.setFont(new Font("����", Font.BOLD, 25));
		lid.setForeground(Color.CYAN);
		panel1.add(lid);
		final JTextField tfid = new JTextField("");
		tfid.setEditable(false);
		tfid.setEditable(false);
		tfid.setFont(new Font("����", Font.BOLD, 25));
		tfid.setForeground(Color.darkGray);
		tfid.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfid);
		JLabel lname = new JLabel("  ��������:");
		lname.setFont(new Font("����", Font.BOLD, 25));
		lname.setForeground(Color.CYAN);
		panel1.add(lname);
		final JTextField tfname = new JTextField("");
		tfname.setEditable(false);
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
		tfdept.setEditable(false);
		tfdept.setFont(new Font("����", Font.BOLD, 25));
		tfdept.setForeground(Color.darkGray);
		tfdept.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfdept);
	    JLabel lage = new JLabel("  ��������:");
		lage.setFont(new Font("����", Font.BOLD, 25));
	    lage.setForeground(Color.CYAN);
		panel1.add(lage);
		final JTextField tfage = new JTextField("");
		tfage.setEditable(false);
		tfage.setFont(new Font("����", Font.BOLD, 25));
		tfage.setForeground(Color.darkGray);
		tfage.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfage);
		JLabel ltypeid = new JLabel("  ���ͱ��:");
		ltypeid.setFont(new Font("����", Font.BOLD, 25));
		ltypeid.setForeground(Color.CYAN);
		panel1.add(ltypeid);
		final JTextField tftypeid = new JTextField("");
		tftypeid.setEditable(false);
		tftypeid.setFont(new Font("����", Font.BOLD, 25));
		tftypeid.setForeground(Color.darkGray);
		tftypeid.setPreferredSize(new Dimension(180, 30));
		panel1.add(tftypeid);
		JLabel lphone = new JLabel("  ���ߵ绰:");
		lphone.setFont(new Font("����", Font.BOLD, 25));
		lphone.setForeground(Color.CYAN);
		panel1.add(lphone);
		final JTextField tfphone = new JTextField("");
		tfphone.setEditable(false);
		tfphone.setFont(new Font("����", Font.BOLD, 25));
		tfphone.setForeground(Color.darkGray);
		tfphone.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfphone);
		JLabel lregdate = new JLabel("  ע������:");
		lregdate.setFont(new Font("����", Font.BOLD, 25));
		lregdate.setForeground(Color.CYAN);
		panel1.add(lregdate);
		final JTextField tfregdate = new JTextField("");
		tfregdate.setEditable(false);
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
		JButton b = new JButton("ɾ��");
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
		
		//ʹ��selection����������table���ĸ���Ŀ��ѡ��
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			// ��ѡ��ĳһ��ʱ�������¼�
			@Override
			public void valueChanged(ListSelectionEvent e) {
				//��ȡ��һ�б�ѡ����
				int row = table.getSelectedRow();
				//����ѡ�е��У���ReaderTableModel�л�ȡ����
				Reader reader = rtm.lsreader.get(row);
				//��������ֵ�����ı�����
				String rid = reader.getRid();//��ȡ���߱��
				String name = reader.getName();//��ȡ��������
				String sex = reader.getSex();//��ȡ���ߵ��Ա�
				int age0 = reader.getAge();
				String age = String.valueOf(age0);
				String dept = reader.getDept();//��ȡ��������ϵ��
				String typeid = reader.getTypeid();//��ȡ�������ͱ��
				String phone = reader.getPhone();//��ȡ���ߵ绰
				Date regdate0 = reader.getRegdate();//��ȡע������
				String regdate = regdate0.toString();
				tfid.setText(rid);
				tfname.setText(name);
				tfage.setText(age);
				tfdept.setText(dept);
				tftypeid.setText(typeid);
				tfphone.setText(phone);
				tfregdate.setText(regdate);
				if(sex.equals("��")){
					bsex1.setSelected(true);
				}else{
					bsex2.setSelected(true);
				}
			}
		});
		
		//���ð�ť������
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ReaderJDBC rj = new ReaderJDBC();
				List<Reader> lsreader = rj.list();
				for(int i=0; i<lsreader.size(); i++){
					if(tfid.getText().equals(lsreader.get(i).getRid())){
						int option = JOptionPane.showConfirmDialog(d, "ȷ��Ҫɾ����");
						if(option==JOptionPane.OK_OPTION){
							rj.delete(lsreader.get(i));
							//����TableModel�е�����
							rtm.lsreader = rj.list();
							//ˢ�±��
							table.updateUI();
							JOptionPane.showMessageDialog(d, "ɾ���ɹ�");
						}
						
					}
				}
				
			}
		});
		d.setVisible(true);
	}
}
