package library;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
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

/*
 * ��¼����
 */
public class Login {
	//����һ����̬���������ڴ�ŵ�ǰ��¼���û�
	static String username;
	//������
	public static void main(String[] args) {
		final JFrame frame = new JFrame("ͼ�����ϵͳ");
		frame.setSize(600,400);
		frame.setLocationRelativeTo(null);//ʹ�������
		frame.setResizable(false);
		//����ͼƬ��·��
		final String path = "picture/1.PNG";
		//ʹͼƬ����Ӧ���ڴ�С�仯
		JPanel imagePanel = new JPanel(){
			private static final long serialVersionUID = 1L;
			public void paintComponent(Graphics g) {
				ImageIcon icon =new ImageIcon(path);
				g.drawImage(icon.getImage(), 0, 0, frame.getSize().width,frame.getSize().height,frame);
			}
		};
		//����ΪĬ��
		imagePanel.setLayout(null);
		frame.add(imagePanel);
		//������壬���ڷ������
		final JPanel panel = new JPanel();
		panel.setLayout(null);
		//����Ϊ͸��
		panel.setOpaque(false);
		panel.setBounds(0, 100, 600, 300);
		imagePanel.add(panel);
		//������ǩ
		JLabel l1 = new JLabel("�û���:");
		l1.setBounds(100, 10, 150, 30);
		l1.setFont(new Font("����", Font.BOLD, 30));//���������ʽ
		panel.add(l1);
		//�����ı���
		final JTextField tf1 = new JTextField("");
		tf1.setBounds(250, 10, 200, 30);
		tf1.setFont(new Font("����", Font.BOLD, 25));
		panel.add(tf1);
		//������ǩ
		JLabel l2 = new JLabel("��  ��:");
		l2.setBounds(100, 60, 150, 30);
		l2.setFont(new Font("����", Font.BOLD, 30));//���������ʽ
		panel.add(l2);
		//���������
		final JPasswordField pf = new JPasswordField("");
		pf.setBounds(250, 60, 200, 30);
		pf.setFont(new Font("����", Font.BOLD, 25));
		panel.add(pf);
		//���õ�¼��ť���
		JButton b = new JButton("��¼");
		b.setBounds(150, 120, 100, 50);
		b.setForeground(Color.BLUE);
		b.setFont(new Font("����", Font.BOLD, 25));
		panel.add(b);
		//����ע�ᰴť���
		JButton b1 = new JButton("ע��");
		b1.setBounds(320, 120, 100, 50);
		b1.setForeground(Color.BLUE);
		b1.setFont(new Font("����", Font.BOLD, 25));
		panel.add(b1);
		
		//��ȡ���ݿ���user������
		final UserJDBC uj = new UserJDBC();
		
		//���õ�¼��ť������
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<User> listuser = uj.list();
				//��ȡ�û���
				String name = tf1.getText();
				//��ȡ����
				char[] p = pf.getPassword();
				//������ת��Ϊ�ַ���
				String password = String.valueOf(p);
				if(name.equals("")&&!password.equals("")){
					JOptionPane.showMessageDialog(frame,"�û���Ϊ�գ�");
				}else if(!name.equals("")&&password.equals("")){
					JOptionPane.showMessageDialog(frame,"����Ϊ�գ�");
				}else if(name.equals("")&&password.equals("")){
					JOptionPane.showMessageDialog(frame, "�������û���������");
				}else{
					//����listuser
					int i;
					for(i=0; i<listuser.size(); i++){
						User user = listuser.get(i);//��ȡÿ������
						//�ж��Ƿ���ڸ��û���
						if(name.equals(user.getId())){
							if(password.equals(user.getPassword())){
								username = name;
								frame.setVisible(false);//���ص�¼����
								MainMenu.showMenu();//��ʾ������
								//JOptionPane.showMessageDialog(frame, "��ӭ����ͼ�����ϵͳ");
							}else{
								JOptionPane.showMessageDialog(frame, "�������");
							}
							break;
						}
					}
					if(i>=listuser.size()){
						JOptionPane.showMessageDialog(frame, "�����ڸ��û�");
					}
				}
			}
		});
		
		//����ע�ᰴť������
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ���ע��ʱ������ע�����
				final JDialog d = new JDialog(frame, "ע��", true);//����Ϊģ̬
				d.setSize(350, 250);//��С
				d.setLocationRelativeTo(frame);//λ��
				d.setLayout(new FlowLayout());//���ò���
				
				//�����û�����ǩ
				JLabel l1 = new JLabel("�û���:");
				l1.setFont(new Font("����", Font.BOLD, 28));//���������ʽ
				d.add(l1);
				//�����ı���
				final JTextField tf1 = new JTextField("");
				tf1.setPreferredSize(new Dimension(120, 30));
				tf1.setFont(new Font("����", Font.BOLD, 28));
				d.add(tf1);
				//���������ǩ
				JLabel l2 = new JLabel("��  ��:");
				l2.setFont(new Font("����", Font.BOLD, 28));//���������ʽ
				d.add(l2);
				//���������
				final JPasswordField pf = new JPasswordField("");
				pf.setPreferredSize(new Dimension(120, 30));
				pf.setFont(new Font("����", Font.BOLD, 25));
				d.add(pf);
				//����ȷ�ϱ�ǩ
				JLabel l3 = new JLabel("ȷ  ��:");
				l3.setFont(new Font("����", Font.BOLD, 28));//���������ʽ
				d.add(l3);
				//���������
				final JPasswordField pf1 = new JPasswordField("");
				pf1.setPreferredSize(new Dimension(120, 30));
				pf1.setFont(new Font("����", Font.BOLD, 25));
				d.add(pf1);
				//�����ύ��ť
				JButton button = new JButton("�ύ");
				button.setForeground(Color.BLUE);
				button.setPreferredSize(new Dimension(120, 50));
				button.setFont(new Font("����", Font.BOLD, 25));
				d.add(button);
				
				//�����ύ��ť������
				button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						List<User> listuser = uj.list();
						//��ȡ�û���
						String name = tf1.getText();
						//��ȡ����
						char[] p = pf.getPassword();
						//������ת��Ϊ�ַ���
						String password = String.valueOf(p);
						//��ȡȷ������
						char[] p1 = pf1.getPassword();
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
									JOptionPane.showMessageDialog(d, "ע��ɹ�");
								}else{
									JOptionPane.showMessageDialog(d, "�û����Ѵ��ڣ�");
								}
							}else{
								JOptionPane.showMessageDialog(d, "���벻һ��");
							}
						}
					}
				});
				
				d.setVisible(true);//�ɼ�
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
