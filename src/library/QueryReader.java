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
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import borrow.Borrow;
import borrow.BorrowJDBC;
import reader.Reader;
import reader.ReaderJDBC;
import reader.ReaderTableModel;

public class QueryReader {
	public static void query(JFrame f){
		final JDialog d = new JDialog(f, "查询读者信息", true);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		d.setSize(800, 600);
		d.setLocationRelativeTo(null);
		
		d.setLayout(new BorderLayout());
		//this.setResizable(false);
		//面板一，用来放置文本框和标签
		panel1.setBackground(Color.DARK_GRAY);
		panel1.setLayout(new FlowLayout());
		JLabel ltitle = new JLabel("    ---------------------------查询结果----------------------------");
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
		final JTextField tfsex = new JTextField("");
		tfsex.setEditable(false);
		tfsex.setFont(new Font("楷体", Font.BOLD, 25));
		tfsex.setForeground(Color.darkGray);
		tfsex.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfsex);
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
		tfregdate.setFont(new Font("楷体", Font.BOLD, 25));
		tfregdate.setForeground(Color.darkGray);
		tfregdate.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfregdate);
		JLabel lbooknum = new JLabel("在借图书数目 :");
		lbooknum.setFont(new Font("楷体", Font.BOLD, 25));
		lbooknum.setForeground(Color.CYAN);
		panel1.add(lbooknum);
		final JTextField tfbooknum = new JTextField("");
		tfbooknum.setEditable(false);
		tfbooknum.setEditable(false);
		tfbooknum.setFont(new Font("楷体", Font.BOLD, 25));
		tfbooknum.setForeground(Color.darkGray);
		tfbooknum.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfbooknum);
		JLabel ltail = new JLabel("    -------------------请输入所要查询读者的编号--------------------");
		ltail.setPreferredSize(new Dimension(d.getWidth(), 30));
		ltail.setFont(new Font("楷体", Font.BOLD, 20));
		ltail.setForeground(Color.ORANGE);
		panel1.add(ltail);
		JLabel lid0 = new JLabel("读者编号:");
		lid0.setFont(new Font("楷体", Font.BOLD, 25));
		lid0.setForeground(Color.CYAN);
		panel1.add(lid0);
		final JTextField tfid0 = new JTextField("");
		tfid0.setFont(new Font("楷体", Font.BOLD, 25));
		tfid0.setForeground(Color.darkGray);
		tfid0.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfid0);
		JLabel empty = new JLabel("    ");
		empty.setFont(new Font("楷体", Font.BOLD, 25));
		empty.setForeground(Color.CYAN);
		panel1.add(empty);
		//添加查询按钮 
		JButton b = new JButton("查询");
		b.setFont(new Font("楷体", Font.BOLD, 25));
		b.setPreferredSize(new Dimension(100, 30));
		panel1.add(b);
		JLabel ltail0 = new JLabel("    --------------------------------------------------------------");
		ltail0.setPreferredSize(new Dimension(d.getWidth(), 20));
		ltail0.setFont(new Font("楷体", Font.BOLD, 20));
		ltail0.setForeground(Color.ORANGE);
		panel1.add(ltail0);
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
		
		//设置查询按钮监听器
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 先得到所有的读者信息
				ReaderJDBC rj = new ReaderJDBC();
				List<Reader> lsreader = rj.list();
				if(tfid0.getText().equals("")){
					JOptionPane.showMessageDialog(d, "输入内容为空");
				}else{
					int i;
					for(i=0; i<lsreader.size(); i++){
						if(tfid0.getText().equals(lsreader.get(i).getRid())){
							//所要查询的的读者编号存在
							Reader reader = lsreader.get(i);
							String rid = reader.getRid();
							String name = reader.getName();
							String sex = reader.getSex();
							String dept = reader.getDept();
							int age0 = reader.getAge();
							String age = String.valueOf(age0);
							String typeid = reader.getTypeid();
							String phone = reader.getPhone();
							Date regdate0 = reader.getRegdate();
							String redate = regdate0.toString();
							tfid.setText(rid);
							tfname.setText(name);
							tfsex.setText(sex);
							tfdept.setText(dept);
							tfage.setText(age);
							tftypeid.setText(typeid);
							tfphone.setText(phone);
							tfregdate.setText(redate);
							
							//查询在借阅图书数目
							BorrowJDBC bj = new BorrowJDBC();
							List<Borrow> borrow = bj.list();
							int num = 0;
							for(int j=0; j<borrow.size(); j++){
								if(rid.equals(borrow.get(j).getRid())){
									num++;
								}
							}
							
							String booknum = String.valueOf(num);
							tfbooknum.setText(booknum);
							break;
						}
					}
					//所要查询的的读者编号不存在
					if(i>=lsreader.size()){
						JOptionPane.showMessageDialog(d, "该读者不存在!");
						
					}
				}
			}
		});
		d.setVisible(true);
	}
}