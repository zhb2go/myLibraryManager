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

import readerType.ReaderType;
import readerType.ReaderTypeJDBC;
import readerType.ReaderTypeTableModel;

public class UpdateReaderType {
	public static void update(JFrame f){
		final JDialog d = new JDialog(f, "增加读者类别", true);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		d.setSize(500, 500);
		d.setLocationRelativeTo(null);
		
		d.setLayout(new BorderLayout());
		
		
		panel1.setBackground(Color.DARK_GRAY);
		panel1.setLayout(new FlowLayout());
		JLabel ltitle = new JLabel("     ---请在下方输入相关信息---");
		ltitle.setPreferredSize(new Dimension(d.getWidth(), 60));
		ltitle.setFont(new Font("楷体", Font.BOLD, 25));
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
		
		JLabel lmaxnum = new JLabel("最多可借阅图书 : ");
		lmaxnum.setFont(new Font("楷体", Font.BOLD, 25));
		lmaxnum.setForeground(Color.CYAN);
		panel1.add(lmaxnum);
		final JTextField tfmaxnum = new JTextField("");
		tfmaxnum.setFont(new Font("楷体", Font.BOLD, 25));
		tfmaxnum.setForeground(Color.darkGray);
		tfmaxnum.setPreferredSize(new Dimension(250, 30));
		panel1.add(tfmaxnum);
		
		JLabel ldaynum = new JLabel("最长可借阅天数 : ");
		ldaynum.setFont(new Font("楷体", Font.BOLD, 25));
		ldaynum.setForeground(Color.CYAN);
		panel1.add(ldaynum);
		final JTextField tfdaynum = new JTextField("");
		tfdaynum.setFont(new Font("楷体", Font.BOLD, 25));
		tfdaynum.setForeground(Color.darkGray);
		tfdaynum.setPreferredSize(new Dimension(250, 30));
		panel1.add(tfdaynum);
		
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
		//面板二，用来放置读者类别信息
		panel2.setPreferredSize(new Dimension(ImageObserver.WIDTH, 80));
		//创建TableModel对象
		final ReaderTypeTableModel rttm = new ReaderTypeTableModel();
		//创建Table对象
		final JTable table = new JTable(rttm);
		//将Table加入到滚动面板中
		panel2.setLayout(new BorderLayout());
		JScrollPane sp = new JScrollPane(table);
		//将滚动面板加入到panel2中
		panel2.add(sp,BorderLayout.CENTER);
		d.add(panel1, BorderLayout.CENTER);
		d.add(panel2, BorderLayout.SOUTH);
		
		//监听表格所选行
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// 获取所选行
				int row = table.getSelectedRow();
				//获取对象
				ReaderType rt = rttm.readertype.get(row);
				String typeid = rt.getId();
				String typename = rt.getTypename();
				int maxnum = rt.getMaxborrownum();
				int daynum = rt.getDaynum();
				String maxnum0 = String.valueOf(maxnum);
				String daynum0 = String.valueOf(daynum);
				tftypeid.setText(typeid);
				tftypename.setText(typename);
				tfmaxnum.setText(maxnum0);
				tfdaynum.setText(daynum0);
			}
		});
		//设置按钮监听器
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 获取文本框内容
				String typeid = tftypeid.getText();
				String typename = tftypename.getText();
				String maxnum0 = tfmaxnum.getText();
				String daynum0 = tfdaynum.getText();
				//判断是否为空
				if(typeid.equals("")||typename.equals("")||maxnum0.equals("")||daynum0.equals("")){
					JOptionPane.showMessageDialog(d, "信息填写不完整");
				}else{
					try{
						int maxnum = Integer.parseInt(maxnum0);
						int daynum = Integer.parseInt(daynum0);
						//判断编号是否重复
						ReaderTypeJDBC rtj = new ReaderTypeJDBC();
						ReaderType rt = new ReaderType(typeid, typename, maxnum, daynum);
						int option = JOptionPane.showConfirmDialog(d, "确定修改吗");
						if(option==JOptionPane.OK_OPTION){
							rtj.update(rt);;
							//更新
							rttm.readertype = rtj.list();
							//刷新
							table.updateUI();
							JOptionPane.showMessageDialog(d, "修改成功");
						}
					}catch(NumberFormatException e1){
						JOptionPane.showMessageDialog(d, "数字格式存在错误");
					}
				}
				
			}
		});
		d.setVisible(true);
	}
}
