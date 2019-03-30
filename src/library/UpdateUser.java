package library;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import user.User;
import user.UserJDBC;

public class UpdateUser {
	public static void update(JFrame f){
		//��ȡ��ǰ�û�
		final String name = Login.username;
		final JDialog d = new JDialog(f, "��������", true);
		JPanel panel = new JPanel();
		d.setSize(500, 400);
		d.setLocationRelativeTo(null);
		
		d.setLayout(new BorderLayout());
		
		
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(new FlowLayout());
		JLabel ltitle = new JLabel("     ---�����·����������Ϣ---");
		ltitle.setPreferredSize(new Dimension(d.getWidth(), 60));
		ltitle.setFont(new Font("����", Font.BOLD, 25));
		ltitle.setForeground(Color.ORANGE);
		panel.add(ltitle);
		JLabel lname = new JLabel("��ǰ�û�: ");
		lname.setFont(new Font("����", Font.BOLD, 30));
		lname.setForeground(Color.CYAN);
		panel.add(lname);
		final JTextField tfname = new JTextField("");
		tfname.setText(name);
		tfname.setEditable(false);
		tfname.setFont(new Font("����", Font.BOLD, 30));
		tfname.setForeground(Color.darkGray);
		tfname.setPreferredSize(new Dimension(250, 35));
		panel.add(tfname);
		JLabel loldpassword = new JLabel(" ������ : ");
		loldpassword.setFont(new Font("����", Font.BOLD, 30));
		loldpassword.setForeground(Color.CYAN);
		panel.add(loldpassword);
		final JPasswordField tfoldpassword = new JPasswordField("");
		tfoldpassword.setEchoChar('*');
		tfoldpassword.setFont(new Font("����", Font.BOLD, 30));
		tfoldpassword.setForeground(Color.darkGray);
		tfoldpassword.setPreferredSize(new Dimension(250, 35));
		panel.add(tfoldpassword);
		JLabel lnewpassword = new JLabel(" ������ : ");
		lnewpassword.setFont(new Font("����", Font.BOLD, 30));
		lnewpassword.setForeground(Color.CYAN);
		panel.add(lnewpassword);
		final JPasswordField tfnewpassword = new JPasswordField("");
		tfnewpassword.setEchoChar('*');
		tfnewpassword.setFont(new Font("����", Font.BOLD, 30));
		tfnewpassword.setForeground(Color.darkGray);
		tfnewpassword.setPreferredSize(new Dimension(250, 35));
		panel.add(tfnewpassword);
		JLabel lagain = new JLabel("ȷ    ��: ");
		lagain.setFont(new Font("����", Font.BOLD, 30));
		lagain.setForeground(Color.CYAN);
		panel.add(lagain);
		final JPasswordField tfagain = new JPasswordField("");
		tfagain.setEchoChar('*');
		tfagain.setFont(new Font("����", Font.BOLD, 30));
		tfagain.setForeground(Color.darkGray);
		tfagain.setPreferredSize(new Dimension(250, 35));
		panel.add(tfagain);
		d.add(panel,BorderLayout.CENTER);
		JLabel ltitle1 = new JLabel("     -------------------------");
		ltitle1.setPreferredSize(new Dimension(d.getWidth(), 30));
		ltitle1.setFont(new Font("����", Font.BOLD, 25));
		ltitle1.setForeground(Color.ORANGE);
		panel.add(ltitle1);
		//����ύ��ť
		JButton b = new JButton("�ύ");
		b.setFont(new Font("����", Font.BOLD, 45));
		b.setPreferredSize(new Dimension(150, 50));
		panel.add(b);
		//���ð�ť������
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				char[] c1 = tfoldpassword.getPassword();
				String oldpassword = String.valueOf(c1);
				char[] c2 = tfnewpassword.getPassword();
				String newpassword = String.valueOf(c2);
				char[] c3 = tfagain.getPassword();
				String again = String.valueOf(c3);
				// �ж������Ƿ�Ϊ��
				if(oldpassword.equals("")||newpassword.equals("")||again.equals("")){
					JOptionPane.showMessageDialog(d, "��Ϣ���벻����");
				}else{
					//�����������жϾ������Ƿ���ȷ
					UserJDBC uj = new UserJDBC();
					List<User> lsuser = uj.list();
					int i;
					for(i=0; i<lsuser.size(); i++){
						if(name.equals(lsuser.get(i).getId())){
							//�ҳ���ǰ�û�����ʼ�ж������Ƿ����
							if(oldpassword.equals(lsuser.get(i).getPassword())){
								//������ȷ��������������,�ж���������������Ƿ�һ��
								if(newpassword.equals(again)){
									//һ�£�������������
									User user0 = new User(name, newpassword);
									//����
									int option = JOptionPane.showConfirmDialog(d, "ȷ���޸���");
									if(JOptionPane.OK_OPTION==option){
										uj.update(user0);
										JOptionPane.showMessageDialog(d, "�޸ĳɹ�");
									}
								}else{
									JOptionPane.showMessageDialog(d, "���벻һ�£����ٴ�����ȷ������");
								}
							}else{
								JOptionPane.showMessageDialog(d, "���������벻��ȷ��");
							}
							break;
						}
					}
				}
				
			}
		});
		d.setVisible(true);
	}
}
