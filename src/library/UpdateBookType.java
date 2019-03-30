package library;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;

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

import bookType.BookType;
import bookType.BookTypeJDBC;
import bookType.BookTypeTableModel;

public class UpdateBookType {
	public static void update(JFrame f){
		final JDialog d = new JDialog(f, "修改图书类别", true);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		d.setSize(500, 400);
		d.setLocationRelativeTo(null);
		
		d.setLayout(new BorderLayout());
		
		
		panel1.setBackground(Color.DARK_GRAY);
		panel1.setLayout(new FlowLayout());
		JLabel ltitle = new JLabel("      ----请在下方表格选中要修改的项----");
		ltitle.setPreferredSize(new Dimension(d.getWidth(), 60));
		ltitle.setFont(new Font("楷体", Font.BOLD, 20));
		ltitle.setForeground(Color.ORANGE);
		panel1.add(ltitle);
		
		JLabel ltypeid = new JLabel("类别编号 : ");
		ltypeid.setFont(new Font("楷体", Font.BOLD, 30));
		ltypeid.setForeground(Color.CYAN);
		panel1.add(ltypeid);
		final JTextField tftypeid = new JTextField("");
		tftypeid.setEditable(false);
		tftypeid.setFont(new Font("楷体", Font.BOLD, 30));
		tftypeid.setForeground(Color.darkGray);
		tftypeid.setPreferredSize(new Dimension(250, 35));
		panel1.add(tftypeid);
		
		JLabel ltypename = new JLabel("类别名称 : ");
		ltypename.setFont(new Font("楷体", Font.BOLD, 30));
		ltypename.setForeground(Color.CYAN);
		panel1.add(ltypename);
		final JTextField tftypename = new JTextField("");
		tftypename.setFont(new Font("楷体", Font.BOLD, 30));
		tftypename.setForeground(Color.darkGray);
		tftypename.setPreferredSize(new Dimension(250, 35));
		panel1.add(tftypename);
		JLabel ltitle1 = new JLabel("     -------------------------");
		ltitle1.setPreferredSize(new Dimension(d.getWidth(), 30));
		ltitle1.setFont(new Font("楷体", Font.BOLD, 25));
		ltitle1.setForeground(Color.ORANGE);
		panel1.add(ltitle1);
		//添加提交按钮
		JButton b = new JButton("修改");
		b.setFont(new Font("楷体", Font.BOLD, 30));
		b.setPreferredSize(new Dimension(100, 35));
		panel1.add(b);
		JLabel ltitle2 = new JLabel("     -------------------------");
		ltitle2.setPreferredSize(new Dimension(d.getWidth(), 30));
		ltitle2.setFont(new Font("楷体", Font.BOLD, 25));
		ltitle2.setForeground(Color.ORANGE);
		panel1.add(ltitle2);
		//面板二，用来放置图书类别信息
		panel2.setPreferredSize(new Dimension(ImageObserver.WIDTH, 80));
		//创建TableModel对象
		final BookTypeTableModel bttm = new BookTypeTableModel();
		//创建Table对象
		final JTable table = new JTable(bttm);
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
				//根据选中的行获取对象
				BookType bt = bttm.lsbooktype.get(row);
				//将各个属性放在文本框中
				String typeid = bt.getId();
				String typename = bt.getTypename();
				tftypeid.setText(typeid);
				tftypename.setText(typename);
			}
		});
		
		//设置按钮监听器
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 判断类型名称是否为空
				String typeid = tftypeid.getText();
				String typename = tftypename.getText();
				BookTypeJDBC btj = new BookTypeJDBC();
				if(typename.equals("")){
					JOptionPane.showMessageDialog(d, "类型名称输入为空");
				}else{
					BookType bt = new BookType(typeid, typename);
					int option = JOptionPane.showConfirmDialog(d, "确定要修改吗");
					if(option==JOptionPane.OK_OPTION){
						btj.update(bt);
						JOptionPane.showMessageDialog(d, "修改成功");
					}
				}
				
			}
		});
		d.setVisible(true);
	}
}
