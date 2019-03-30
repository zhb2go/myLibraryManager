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
 * 登录界面
 */
public class Login {
	//定义一个静态变量，用于存放当前登录的用户
	static String username;
	//主方法
	public static void main(String[] args) {
		final JFrame frame = new JFrame("图书管理系统");
		frame.setSize(600,400);
		frame.setLocationRelativeTo(null);//使窗体居中
		frame.setResizable(false);
		//背景图片的路径
		final String path = "picture/1.PNG";
		//使图片自适应窗口大小变化
		JPanel imagePanel = new JPanel(){
			private static final long serialVersionUID = 1L;
			public void paintComponent(Graphics g) {
				ImageIcon icon =new ImageIcon(path);
				g.drawImage(icon.getImage(), 0, 0, frame.getSize().width,frame.getSize().height,frame);
			}
		};
		//布局为默认
		imagePanel.setLayout(null);
		frame.add(imagePanel);
		//创建面板，用于放置组件
		final JPanel panel = new JPanel();
		panel.setLayout(null);
		//设置为透明
		panel.setOpaque(false);
		panel.setBounds(0, 100, 600, 300);
		imagePanel.add(panel);
		//创建标签
		JLabel l1 = new JLabel("用户名:");
		l1.setBounds(100, 10, 150, 30);
		l1.setFont(new Font("宋体", Font.BOLD, 30));//设置字体格式
		panel.add(l1);
		//创建文本框
		final JTextField tf1 = new JTextField("");
		tf1.setBounds(250, 10, 200, 30);
		tf1.setFont(new Font("宋体", Font.BOLD, 25));
		panel.add(tf1);
		//创建标签
		JLabel l2 = new JLabel("密  码:");
		l2.setBounds(100, 60, 150, 30);
		l2.setFont(new Font("宋体", Font.BOLD, 30));//设置字体格式
		panel.add(l2);
		//创建密码框
		final JPasswordField pf = new JPasswordField("");
		pf.setBounds(250, 60, 200, 30);
		pf.setFont(new Font("宋体", Font.BOLD, 25));
		panel.add(pf);
		//设置登录按钮组件
		JButton b = new JButton("登录");
		b.setBounds(150, 120, 100, 50);
		b.setForeground(Color.BLUE);
		b.setFont(new Font("宋体", Font.BOLD, 25));
		panel.add(b);
		//设置注册按钮组件
		JButton b1 = new JButton("注册");
		b1.setBounds(320, 120, 100, 50);
		b1.setForeground(Color.BLUE);
		b1.setFont(new Font("宋体", Font.BOLD, 25));
		panel.add(b1);
		
		//获取数据库中user的数据
		final UserJDBC uj = new UserJDBC();
		
		//设置登录按钮监听器
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<User> listuser = uj.list();
				//获取用户名
				String name = tf1.getText();
				//获取密码
				char[] p = pf.getPassword();
				//将密码转化为字符串
				String password = String.valueOf(p);
				if(name.equals("")&&!password.equals("")){
					JOptionPane.showMessageDialog(frame,"用户名为空！");
				}else if(!name.equals("")&&password.equals("")){
					JOptionPane.showMessageDialog(frame,"密码为空！");
				}else if(name.equals("")&&password.equals("")){
					JOptionPane.showMessageDialog(frame, "请输入用户名和密码");
				}else{
					//遍历listuser
					int i;
					for(i=0; i<listuser.size(); i++){
						User user = listuser.get(i);//获取每个对象
						//判断是否存在该用户名
						if(name.equals(user.getId())){
							if(password.equals(user.getPassword())){
								username = name;
								frame.setVisible(false);//隐藏登录界面
								MainMenu.showMenu();//显示主界面
								//JOptionPane.showMessageDialog(frame, "欢迎来到图书管理系统");
							}else{
								JOptionPane.showMessageDialog(frame, "密码错误！");
							}
							break;
						}
					}
					if(i>=listuser.size()){
						JOptionPane.showMessageDialog(frame, "不存在该用户");
					}
				}
			}
		});
		
		//设置注册按钮监听器
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 点击注册时，弹出注册界面
				final JDialog d = new JDialog(frame, "注册", true);//设置为模态
				d.setSize(350, 250);//大小
				d.setLocationRelativeTo(frame);//位置
				d.setLayout(new FlowLayout());//设置布局
				
				//创建用户名标签
				JLabel l1 = new JLabel("用户名:");
				l1.setFont(new Font("宋体", Font.BOLD, 28));//设置字体格式
				d.add(l1);
				//创建文本框
				final JTextField tf1 = new JTextField("");
				tf1.setPreferredSize(new Dimension(120, 30));
				tf1.setFont(new Font("宋体", Font.BOLD, 28));
				d.add(tf1);
				//创建密码标签
				JLabel l2 = new JLabel("密  码:");
				l2.setFont(new Font("宋体", Font.BOLD, 28));//设置字体格式
				d.add(l2);
				//创建密码框
				final JPasswordField pf = new JPasswordField("");
				pf.setPreferredSize(new Dimension(120, 30));
				pf.setFont(new Font("宋体", Font.BOLD, 25));
				d.add(pf);
				//创建确认标签
				JLabel l3 = new JLabel("确  认:");
				l3.setFont(new Font("宋体", Font.BOLD, 28));//设置字体格式
				d.add(l3);
				//创建密码框
				final JPasswordField pf1 = new JPasswordField("");
				pf1.setPreferredSize(new Dimension(120, 30));
				pf1.setFont(new Font("宋体", Font.BOLD, 25));
				d.add(pf1);
				//创建提交按钮
				JButton button = new JButton("提交");
				button.setForeground(Color.BLUE);
				button.setPreferredSize(new Dimension(120, 50));
				button.setFont(new Font("宋体", Font.BOLD, 25));
				d.add(button);
				
				//创建提交按钮监听器
				button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						List<User> listuser = uj.list();
						//获取用户名
						String name = tf1.getText();
						//获取密码
						char[] p = pf.getPassword();
						//将密码转化为字符串
						String password = String.valueOf(p);
						//获取确认密码
						char[] p1 = pf1.getPassword();
						//将确认密码转化为字符串
						String password1 = String.valueOf(p1);
						
						//为空判断
						if(name.equals("")&&!password.equals("")){
							JOptionPane.showMessageDialog(d,"用户名为空！");
						}else if(!name.equals("")&&password.equals("")){
							JOptionPane.showMessageDialog(d,"密码为空！");
						}else if(name.equals("")&&password.equals("")){
							JOptionPane.showMessageDialog(d, "请输入用户名和密码");
						}else if(!name.equals("")&&!password.equals("")&&password1.equals("")){
							JOptionPane.showMessageDialog(d, "请再次输入密码！");
						}else{
							//判断密码和确认密码是否一致
							if(password.equals(password1)){
								//判断用户名是否已存在
								int i;
								for(i=0; i<listuser.size(); i++){
									if(name.equals(listuser.get(i).getId())){
										break;
									}
								}
								if(i>=listuser.size()){
									//将用户名和密码加入到数据库中
									User user = new User(name, password);
									uj.add(user);
									JOptionPane.showMessageDialog(d, "注册成功");
								}else{
									JOptionPane.showMessageDialog(d, "用户名已存在！");
								}
							}else{
								JOptionPane.showMessageDialog(d, "密码不一致");
							}
						}
					}
				});
				
				d.setVisible(true);//可见
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
