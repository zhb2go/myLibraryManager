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
		final JDialog d = new JDialog(f, "添加用户", true);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		d.setSize(500, 400);
		d.setLocationRelativeTo(null);
		
		d.setLayout(new BorderLayout());
		
		
		panel1.setBackground(Color.DARK_GRAY);
		panel1.setLayout(new FlowLayout());
		JLabel ltitle = new JLabel("     ---请在下方输入相关信息---");
		ltitle.setPreferredSize(new Dimension(d.getWidth(), 60));
		ltitle.setFont(new Font("楷体", Font.BOLD, 25));
		ltitle.setForeground(Color.ORANGE);
		panel1.add(ltitle);
		
		JLabel lname = new JLabel(" 用户名 : ");
		lname.setFont(new Font("楷体", Font.BOLD, 30));
		lname.setForeground(Color.CYAN);
		panel1.add(lname);
		final JTextField tfname = new JTextField("");
		tfname.setFont(new Font("楷体", Font.BOLD, 30));
		tfname.setForeground(Color.darkGray);
		tfname.setPreferredSize(new Dimension(250, 35));
		panel1.add(tfname);
		
		JLabel lnewpassword = new JLabel(" 密  码 : ");
		lnewpassword.setFont(new Font("楷体", Font.BOLD, 30));
		lnewpassword.setForeground(Color.CYAN);
		panel1.add(lnewpassword);
		final JPasswordField tfnewpassword = new JPasswordField("");
		tfnewpassword.setEchoChar('*');
		tfnewpassword.setFont(new Font("楷体", Font.BOLD, 30));
		tfnewpassword.setForeground(Color.darkGray);
		tfnewpassword.setPreferredSize(new Dimension(250, 35));
		panel1.add(tfnewpassword);
		
		JLabel lagain = new JLabel(" 确  认 : ");
		lagain.setFont(new Font("楷体", Font.BOLD, 30));
		lagain.setForeground(Color.CYAN);
		panel1.add(lagain);
		final JPasswordField tfagain = new JPasswordField("");
		tfagain.setEchoChar('*');
		tfagain.setFont(new Font("楷体", Font.BOLD, 30));
		tfagain.setForeground(Color.darkGray);
		tfagain.setPreferredSize(new Dimension(250, 35));
		panel1.add(tfagain);
		
		//添加提交按钮
		JButton b = new JButton("提交");
		b.setFont(new Font("楷体", Font.BOLD, 30));
		b.setPreferredSize(new Dimension(100, 35));
		panel1.add(b);
		JLabel ltitle1 = new JLabel("     -------------------------");
		ltitle1.setPreferredSize(new Dimension(d.getWidth(), 30));
		ltitle1.setFont(new Font("楷体", Font.BOLD, 25));
		ltitle1.setForeground(Color.ORANGE);
		panel1.add(ltitle1);
		//面板二，用来放置用户信息
		panel2.setPreferredSize(new Dimension(ImageObserver.WIDTH, 80));
		//创建TableModel对象
		final UserTableModel utm = new UserTableModel();
		//创建Table对象
		final JTable table = new JTable(utm);
		//将Table加入到滚动面板中
		panel2.setLayout(new BorderLayout());
		JScrollPane sp = new JScrollPane(table);
		//将滚动面板加入到panel2中
		panel2.add(sp,BorderLayout.CENTER);
		d.add(panel1, BorderLayout.CENTER);
		d.add(panel2, BorderLayout.SOUTH);
		//创建按钮监听器
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UserJDBC uj = new UserJDBC();
				List<User> listuser = uj.list();
				//获取用户名
				String name = tfname.getText();
				//获取密码
				char[] p = tfnewpassword.getPassword();
				//将密码转化为字符串
				String password = String.valueOf(p);
				//获取确认密码
				char[] p1 = tfagain.getPassword();
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
							//更新
							utm.user = uj.list();
							//刷新
							table.updateUI();
							JOptionPane.showMessageDialog(d, "添加成功");
						}else{
							JOptionPane.showMessageDialog(d, "用户名已存在！");
						}
					}else{
						JOptionPane.showMessageDialog(d, "密码不一致");
					}
				}
			}
		});
		
		
		d.setVisible(true);
	}
}
