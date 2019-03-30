package library;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.util.List;

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

import user.User;
import user.UserJDBC;
import user.UserTableModel;

public class DeleteUser {
	public static void delete(JFrame f){
		final JDialog d = new JDialog(f, "ɾ���û�", true);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		d.setSize(500, 400);
		d.setLocationRelativeTo(null);
		
		d.setLayout(new BorderLayout());
		
		
		panel1.setBackground(Color.DARK_GRAY);
		panel1.setLayout(new FlowLayout());
		JLabel ltitle = new JLabel("     --�����·�������Ҫɾ���û�--");
		ltitle.setPreferredSize(new Dimension(d.getWidth(), 60));
		ltitle.setFont(new Font("����", Font.BOLD, 25));
		ltitle.setForeground(Color.ORANGE);
		panel1.add(ltitle);
		
		JLabel lname = new JLabel(" �û��� : ");
		lname.setFont(new Font("����", Font.BOLD, 30));
		lname.setForeground(Color.CYAN);
		panel1.add(lname);
		final JTextField tfname = new JTextField("");
		tfname.setFont(new Font("����", Font.BOLD, 30));
		tfname.setForeground(Color.darkGray);
		tfname.setPreferredSize(new Dimension(250, 35));
		panel1.add(tfname);
		//����ύ��ť
		JButton b = new JButton("ɾ��");
		b.setFont(new Font("����", Font.BOLD, 35));
		b.setPreferredSize(new Dimension(130, 50));
		panel1.add(b);
		JLabel ltitle1 = new JLabel("    ------��ӱ����ѡ����Ҫɾ���û�------");
		ltitle1.setPreferredSize(new Dimension(d.getWidth(), 30));
		ltitle1.setFont(new Font("����", Font.BOLD, 20));
		ltitle1.setForeground(Color.ORANGE);
		panel1.add(ltitle1);
		//���������������û���Ϣ
		panel2.setPreferredSize(new Dimension(ImageObserver.WIDTH, 150));
		//����TableModel����
		final UserTableModel utm = new UserTableModel();
		//����Table����
		final JTable table = new JTable(utm);
		//��Table���뵽���������
		panel2.setLayout(new BorderLayout());
		JScrollPane sp = new JScrollPane(table);
		//�����������뵽panel2��
		panel2.add(sp,BorderLayout.CENTER);
		d.add(panel1, BorderLayout.CENTER);
		d.add(panel2, BorderLayout.SOUTH);
		//ʹ��selection����������table���ĸ���Ŀ��ѡ��
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// ��ȡ��һ�б�ѡ����
				int row = table.getSelectedRow();
				//����ѡ�е��У���usetTableModel�л�ȡ����
				User user0 = utm.user.get(row);
				//�������Է����ı�����
				String name = user0.getId();
				tfname.setText(name);
			}
		});
		//���ð�ť������
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UserJDBC uj = new UserJDBC();
				List<User> lsuser = uj.list();
				String name = tfname.getText();
				// �ж������Ƿ�Ϊ��
				if(name.equals("")){
					JOptionPane.showMessageDialog(d, "����Ϊ��");
				}else if(name.equals("zhb")){
					JOptionPane.showMessageDialog(d, "����Ա����ɾ����");
				}else{
					//�ж��Ƿ����
					int i;
					for(i=0; i<lsuser.size(); i++){
						if(name.equals(lsuser.get(i).getId())){
							//���ڣ�ִ��ɾ������
							int option = JOptionPane.showConfirmDialog(d, "ȷ��Ҫɾ����");
							if(option==JOptionPane.OK_OPTION){
								uj.delete(lsuser.get(i));
								//����
								utm.user = uj.list();
								//ˢ��
								table.updateUI();
								JOptionPane.showMessageDialog(d, "ɾ���ɹ�");
							}
							break;
						}
					}
					if(i>=lsuser.size()){
						JOptionPane.showMessageDialog(d, "�����ڸ��û�,����������");
					}
				}
				
			}
		});
		d.setVisible(true);
	}
}
