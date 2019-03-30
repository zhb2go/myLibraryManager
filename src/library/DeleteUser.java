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
		final JDialog d = new JDialog(f, "删除用户", true);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		d.setSize(500, 400);
		d.setLocationRelativeTo(null);
		
		d.setLayout(new BorderLayout());
		
		
		panel1.setBackground(Color.DARK_GRAY);
		panel1.setLayout(new FlowLayout());
		JLabel ltitle = new JLabel("     --请在下方输入所要删除用户--");
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
		//添加提交按钮
		JButton b = new JButton("删除");
		b.setFont(new Font("楷体", Font.BOLD, 35));
		b.setPreferredSize(new Dimension(130, 50));
		panel1.add(b);
		JLabel ltitle1 = new JLabel("    ------或从表格中选择所要删除用户------");
		ltitle1.setPreferredSize(new Dimension(d.getWidth(), 30));
		ltitle1.setFont(new Font("楷体", Font.BOLD, 20));
		ltitle1.setForeground(Color.ORANGE);
		panel1.add(ltitle1);
		//面板二，用来放置用户信息
		panel2.setPreferredSize(new Dimension(ImageObserver.WIDTH, 150));
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
		//使用selection监听器监听table的哪个条目被选中
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// 获取哪一行被选中了
				int row = table.getSelectedRow();
				//根据选中的行，到usetTableModel中获取对象
				User user0 = utm.user.get(row);
				//将各属性放在文本框中
				String name = user0.getId();
				tfname.setText(name);
			}
		});
		//设置按钮监听器
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UserJDBC uj = new UserJDBC();
				List<User> lsuser = uj.list();
				String name = tfname.getText();
				// 判断输入是否为空
				if(name.equals("")){
					JOptionPane.showMessageDialog(d, "输入为空");
				}else if(name.equals("zhb")){
					JOptionPane.showMessageDialog(d, "管理员不可删除！");
				}else{
					//判断是否存在
					int i;
					for(i=0; i<lsuser.size(); i++){
						if(name.equals(lsuser.get(i).getId())){
							//存在，执行删除操作
							int option = JOptionPane.showConfirmDialog(d, "确定要删除吗");
							if(option==JOptionPane.OK_OPTION){
								uj.delete(lsuser.get(i));
								//更新
								utm.user = uj.list();
								//刷新
								table.updateUI();
								JOptionPane.showMessageDialog(d, "删除成功");
							}
							break;
						}
					}
					if(i>=lsuser.size()){
						JOptionPane.showMessageDialog(d, "不存在该用户,请重新输入");
					}
				}
				
			}
		});
		d.setVisible(true);
	}
}
