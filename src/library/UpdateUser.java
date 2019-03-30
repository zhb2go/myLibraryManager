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
		//获取当前用户
		final String name = Login.username;
		final JDialog d = new JDialog(f, "更改密码", true);
		JPanel panel = new JPanel();
		d.setSize(500, 400);
		d.setLocationRelativeTo(null);
		
		d.setLayout(new BorderLayout());
		
		
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(new FlowLayout());
		JLabel ltitle = new JLabel("     ---请在下方输入相关信息---");
		ltitle.setPreferredSize(new Dimension(d.getWidth(), 60));
		ltitle.setFont(new Font("楷体", Font.BOLD, 25));
		ltitle.setForeground(Color.ORANGE);
		panel.add(ltitle);
		JLabel lname = new JLabel("当前用户: ");
		lname.setFont(new Font("楷体", Font.BOLD, 30));
		lname.setForeground(Color.CYAN);
		panel.add(lname);
		final JTextField tfname = new JTextField("");
		tfname.setText(name);
		tfname.setEditable(false);
		tfname.setFont(new Font("楷体", Font.BOLD, 30));
		tfname.setForeground(Color.darkGray);
		tfname.setPreferredSize(new Dimension(250, 35));
		panel.add(tfname);
		JLabel loldpassword = new JLabel(" 旧密码 : ");
		loldpassword.setFont(new Font("楷体", Font.BOLD, 30));
		loldpassword.setForeground(Color.CYAN);
		panel.add(loldpassword);
		final JPasswordField tfoldpassword = new JPasswordField("");
		tfoldpassword.setEchoChar('*');
		tfoldpassword.setFont(new Font("楷体", Font.BOLD, 30));
		tfoldpassword.setForeground(Color.darkGray);
		tfoldpassword.setPreferredSize(new Dimension(250, 35));
		panel.add(tfoldpassword);
		JLabel lnewpassword = new JLabel(" 新密码 : ");
		lnewpassword.setFont(new Font("楷体", Font.BOLD, 30));
		lnewpassword.setForeground(Color.CYAN);
		panel.add(lnewpassword);
		final JPasswordField tfnewpassword = new JPasswordField("");
		tfnewpassword.setEchoChar('*');
		tfnewpassword.setFont(new Font("楷体", Font.BOLD, 30));
		tfnewpassword.setForeground(Color.darkGray);
		tfnewpassword.setPreferredSize(new Dimension(250, 35));
		panel.add(tfnewpassword);
		JLabel lagain = new JLabel("确    认: ");
		lagain.setFont(new Font("楷体", Font.BOLD, 30));
		lagain.setForeground(Color.CYAN);
		panel.add(lagain);
		final JPasswordField tfagain = new JPasswordField("");
		tfagain.setEchoChar('*');
		tfagain.setFont(new Font("楷体", Font.BOLD, 30));
		tfagain.setForeground(Color.darkGray);
		tfagain.setPreferredSize(new Dimension(250, 35));
		panel.add(tfagain);
		d.add(panel,BorderLayout.CENTER);
		JLabel ltitle1 = new JLabel("     -------------------------");
		ltitle1.setPreferredSize(new Dimension(d.getWidth(), 30));
		ltitle1.setFont(new Font("楷体", Font.BOLD, 25));
		ltitle1.setForeground(Color.ORANGE);
		panel.add(ltitle1);
		//添加提交按钮
		JButton b = new JButton("提交");
		b.setFont(new Font("楷体", Font.BOLD, 45));
		b.setPreferredSize(new Dimension(150, 50));
		panel.add(b);
		//设置按钮监听器
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				char[] c1 = tfoldpassword.getPassword();
				String oldpassword = String.valueOf(c1);
				char[] c2 = tfnewpassword.getPassword();
				String newpassword = String.valueOf(c2);
				char[] c3 = tfagain.getPassword();
				String again = String.valueOf(c3);
				// 判断输入是否为空
				if(oldpassword.equals("")||newpassword.equals("")||again.equals("")){
					JOptionPane.showMessageDialog(d, "信息输入不完整");
				}else{
					//输入完整则判断旧密码是否正确
					UserJDBC uj = new UserJDBC();
					List<User> lsuser = uj.list();
					int i;
					for(i=0; i<lsuser.size(); i++){
						if(name.equals(lsuser.get(i).getId())){
							//找出当前用户，开始判断密码是否相等
							if(oldpassword.equals(lsuser.get(i).getPassword())){
								//密码正确，继续后续操作,判断两次输入的密码是否一致
								if(newpassword.equals(again)){
									//一致，继续后续操作
									User user0 = new User(name, newpassword);
									//更新
									int option = JOptionPane.showConfirmDialog(d, "确认修改吗？");
									if(JOptionPane.OK_OPTION==option){
										uj.update(user0);
										JOptionPane.showMessageDialog(d, "修改成功");
									}
								}else{
									JOptionPane.showMessageDialog(d, "密码不一致，请再次输入确认密码");
								}
							}else{
								JOptionPane.showMessageDialog(d, "旧密码输入不正确！");
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
