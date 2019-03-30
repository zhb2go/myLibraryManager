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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import user.User;
import user.UserJDBC;
import user.UserTableModel;

public class AddUser {
	public static void add(JFrame f){
		final JDialog d = new JDialog(f, "����û�", true);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		d.setSize(500, 400);
		d.setLocationRelativeTo(null);
		
		d.setLayout(new BorderLayout());
		
		
		panel1.setBackground(Color.DARK_GRAY);
		panel1.setLayout(new FlowLayout());
		JLabel ltitle = new JLabel("     ---�����·����������Ϣ---");
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
		
		JLabel lnewpassword = new JLabel(" ��  �� : ");
		lnewpassword.setFont(new Font("����", Font.BOLD, 30));
		lnewpassword.setForeground(Color.CYAN);
		panel1.add(lnewpassword);
		final JPasswordField tfnewpassword = new JPasswordField("");
		tfnewpassword.setEchoChar('*');
		tfnewpassword.setFont(new Font("����", Font.BOLD, 30));
		tfnewpassword.setForeground(Color.darkGray);
		tfnewpassword.setPreferredSize(new Dimension(250, 35));
		panel1.add(tfnewpassword);
		
		JLabel lagain = new JLabel(" ȷ  �� : ");
		lagain.setFont(new Font("����", Font.BOLD, 30));
		lagain.setForeground(Color.CYAN);
		panel1.add(lagain);
		final JPasswordField tfagain = new JPasswordField("");
		tfagain.setEchoChar('*');
		tfagain.setFont(new Font("����", Font.BOLD, 30));
		tfagain.setForeground(Color.darkGray);
		tfagain.setPreferredSize(new Dimension(250, 35));
		panel1.add(tfagain);
		
		//����ύ��ť
		JButton b = new JButton("�ύ");
		b.setFont(new Font("����", Font.BOLD, 30));
		b.setPreferredSize(new Dimension(100, 35));
		panel1.add(b);
		JLabel ltitle1 = new JLabel("     -------------------------");
		ltitle1.setPreferredSize(new Dimension(d.getWidth(), 30));
		ltitle1.setFont(new Font("����", Font.BOLD, 25));
		ltitle1.setForeground(Color.ORANGE);
		panel1.add(ltitle1);
		//���������������û���Ϣ
		panel2.setPreferredSize(new Dimension(ImageObserver.WIDTH, 80));
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
		//������ť������
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UserJDBC uj = new UserJDBC();
				List<User> listuser = uj.list();
				//��ȡ�û���
				String name = tfname.getText();
				//��ȡ����
				char[] p = tfnewpassword.getPassword();
				//������ת��Ϊ�ַ���
				String password = String.valueOf(p);
				//��ȡȷ������
				char[] p1 = tfagain.getPassword();
				//��ȷ������ת��Ϊ�ַ���
				String password1 = String.valueOf(p1);
				
				//Ϊ���ж�
				if(name.equals("")&&!password.equals("")){
					JOptionPane.showMessageDialog(d,"�û���Ϊ�գ�");
				}else if(!name.equals("")&&password.equals("")){
					JOptionPane.showMessageDialog(d,"����Ϊ�գ�");
				}else if(name.equals("")&&password.equals("")){
					JOptionPane.showMessageDialog(d, "�������û���������");
				}else if(!name.equals("")&&!password.equals("")&&password1.equals("")){
					JOptionPane.showMessageDialog(d, "���ٴ��������룡");
				}else{
					//�ж������ȷ�������Ƿ�һ��
					if(password.equals(password1)){
						//�ж��û����Ƿ��Ѵ���
						int i;
						for(i=0; i<listuser.size(); i++){
							if(name.equals(listuser.get(i).getId())){
								break;
							}
						}
						if(i>=listuser.size()){
							//���û�����������뵽���ݿ���
							User user = new User(name, password);
							uj.add(user);
							//����
							utm.user = uj.list();
							//ˢ��
							table.updateUI();
							JOptionPane.showMessageDialog(d, "��ӳɹ�");
						}else{
							JOptionPane.showMessageDialog(d, "�û����Ѵ��ڣ�");
						}
					}else{
						JOptionPane.showMessageDialog(d, "���벻һ��");
					}
				}
			}
		});
		
		
		d.setVisible(true);
	}
}
