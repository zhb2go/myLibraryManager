package library;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.sql.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import reader.Reader;
import reader.ReaderJDBC;
import reader.ReaderTableModel;

public class DeleteReader {
	public static void delete(JFrame f){
		final JDialog d = new JDialog(f, "删除读者信息", true);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		d.setSize(800, 600);
		d.setLocationRelativeTo(null);
		
		d.setLayout(new BorderLayout());
		//this.setResizable(false);
		//面板一，用来放置文本框和标签
		panel1.setBackground(Color.DARK_GRAY);
		panel1.setLayout(new FlowLayout());
		JLabel ltitle = new JLabel("    -----------------请在下方表格中选中所要删除的项-----------------");
		ltitle.setPreferredSize(new Dimension(d.getWidth(), 60));
		ltitle.setFont(new Font("楷体", Font.BOLD, 20));
		ltitle.setForeground(Color.ORANGE);
		panel1.add(ltitle);
		JLabel lid = new JLabel("  读者编号:");
		lid.setFont(new Font("楷体", Font.BOLD, 25));
		lid.setForeground(Color.CYAN);
		panel1.add(lid);
		final JTextField tfid = new JTextField("");
		tfid.setEditable(false);
		tfid.setEditable(false);
		tfid.setFont(new Font("楷体", Font.BOLD, 25));
		tfid.setForeground(Color.darkGray);
		tfid.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfid);
		JLabel lname = new JLabel("  读者姓名:");
		lname.setFont(new Font("楷体", Font.BOLD, 25));
		lname.setForeground(Color.CYAN);
		panel1.add(lname);
		final JTextField tfname = new JTextField("");
		tfname.setEditable(false);
		tfname.setFont(new Font("楷体", Font.BOLD, 25));
		tfname.setForeground(Color.darkGray);
		tfname.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfname);
		JLabel lsex = new JLabel("  读者性别:");
		lsex.setFont(new Font("楷体", Font.BOLD, 25));
		lsex.setForeground(Color.CYAN);
		panel1.add(lsex);
		final JRadioButton bsex1 = new JRadioButton("男");
		bsex1.setSelected(true);
		bsex1.setFont(new Font("楷体", Font.BOLD, 25));
		bsex1.setPreferredSize(new Dimension(87, 30));
		final JRadioButton bsex2 = new JRadioButton("女");
		bsex2.setFont(new Font("楷体", Font.BOLD, 25));
		bsex2.setPreferredSize(new Dimension(87, 30));
		ButtonGroup bg = new ButtonGroup();
		bg.add(bsex1);
		bg.add(bsex2);
		panel1.add(bsex1);
		panel1.add(bsex2);
		JLabel ldept = new JLabel("  所在系部:");
		ldept.setFont(new Font("楷体", Font.BOLD, 25));
		ldept.setForeground(Color.CYAN);
		panel1.add(ldept);
		final JTextField tfdept = new JTextField("");
		tfdept.setEditable(false);
		tfdept.setFont(new Font("楷体", Font.BOLD, 25));
		tfdept.setForeground(Color.darkGray);
		tfdept.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfdept);
	    JLabel lage = new JLabel("  读者年龄:");
		lage.setFont(new Font("楷体", Font.BOLD, 25));
	    lage.setForeground(Color.CYAN);
		panel1.add(lage);
		final JTextField tfage = new JTextField("");
		tfage.setEditable(false);
		tfage.setFont(new Font("楷体", Font.BOLD, 25));
		tfage.setForeground(Color.darkGray);
		tfage.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfage);
		JLabel ltypeid = new JLabel("  类型编号:");
		ltypeid.setFont(new Font("楷体", Font.BOLD, 25));
		ltypeid.setForeground(Color.CYAN);
		panel1.add(ltypeid);
		final JTextField tftypeid = new JTextField("");
		tftypeid.setEditable(false);
		tftypeid.setFont(new Font("楷体", Font.BOLD, 25));
		tftypeid.setForeground(Color.darkGray);
		tftypeid.setPreferredSize(new Dimension(180, 30));
		panel1.add(tftypeid);
		JLabel lphone = new JLabel("  读者电话:");
		lphone.setFont(new Font("楷体", Font.BOLD, 25));
		lphone.setForeground(Color.CYAN);
		panel1.add(lphone);
		final JTextField tfphone = new JTextField("");
		tfphone.setEditable(false);
		tfphone.setFont(new Font("楷体", Font.BOLD, 25));
		tfphone.setForeground(Color.darkGray);
		tfphone.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfphone);
		JLabel lregdate = new JLabel("  注册日期:");
		lregdate.setFont(new Font("楷体", Font.BOLD, 25));
		lregdate.setForeground(Color.CYAN);
		panel1.add(lregdate);
		final JTextField tfregdate = new JTextField("");
		tfregdate.setEditable(false);
		tfregdate.setEditable(false);
		tfregdate.setFont(new Font("楷体", Font.BOLD, 25));
		tfregdate.setForeground(Color.darkGray);
		tfregdate.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfregdate);
		JLabel ltail = new JLabel("    --------------------------------------------------------------");
		ltail.setPreferredSize(new Dimension(d.getWidth(), 60));
		ltail.setFont(new Font("楷体", Font.BOLD, 20));
		ltail.setForeground(Color.ORANGE);
		panel1.add(ltail);
		//添加提交按钮
		JButton b = new JButton("删除");
		b.setFont(new Font("楷体", Font.BOLD, 25));
		b.setPreferredSize(new Dimension(120, 60));
		panel1.add(b);
		//面板二，用来放置读者信息
		panel2.setPreferredSize(new Dimension(ImageObserver.WIDTH, 200));
		//创建TableModel对象
		final ReaderTableModel rtm = new ReaderTableModel();
		//创建Table对象
		final JTable table = new JTable(rtm);
		//将Table加入到滚动面板中
		panel2.setLayout(new BorderLayout());
		JScrollPane sp = new JScrollPane(table);
		//将滚动面板加入到panel2中
		panel2.add(sp,BorderLayout.CENTER);
		d.add(panel1, BorderLayout.CENTER);
		d.add(panel2, BorderLayout.SOUTH);
		
		//使用selection监听器监听table的哪个条目被选中
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			// 当选择某一行时触发该事件
			@Override
			public void valueChanged(ListSelectionEvent e) {
				//获取那一行被选中了
				int row = table.getSelectedRow();
				//根据选中的行，到ReaderTableModel中获取对象
				Reader reader = rtm.lsreader.get(row);
				//将各属性值放在文本框中
				String rid = reader.getRid();//获取读者编号
				String name = reader.getName();//获取读者姓名
				String sex = reader.getSex();//获取读者的性别
				int age0 = reader.getAge();
				String age = String.valueOf(age0);
				String dept = reader.getDept();//获取读者所在系部
				String typeid = reader.getTypeid();//获取读者类型编号
				String phone = reader.getPhone();//获取读者电话
				Date regdate0 = reader.getRegdate();//获取注册日期
				String regdate = regdate0.toString();
				tfid.setText(rid);
				tfname.setText(name);
				tfage.setText(age);
				tfdept.setText(dept);
				tftypeid.setText(typeid);
				tfphone.setText(phone);
				tfregdate.setText(regdate);
				if(sex.equals("男")){
					bsex1.setSelected(true);
				}else{
					bsex2.setSelected(true);
				}
			}
		});
		
		//设置按钮监听器
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ReaderJDBC rj = new ReaderJDBC();
				List<Reader> lsreader = rj.list();
				for(int i=0; i<lsreader.size(); i++){
					if(tfid.getText().equals(lsreader.get(i).getRid())){
						int option = JOptionPane.showConfirmDialog(d, "确定要删除吗？");
						if(option==JOptionPane.OK_OPTION){
							rj.delete(lsreader.get(i));
							//更新TableModel中的数据
							rtm.lsreader = rj.list();
							//刷新表格
							table.updateUI();
							JOptionPane.showMessageDialog(d, "删除成功");
						}
						
					}
				}
				
			}
		});
		d.setVisible(true);
	}
}
