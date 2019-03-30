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

import reader.Reader;
import reader.ReaderJDBC;
import reader.ReaderTableModel;
import readerType.ReaderType;
import readerType.ReaderTypeJDBC;

public class AddReader{
	
	public static void add(JFrame f){
		final JDialog d = new JDialog(f, "添加读者信息", true);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		d.setSize(800, 600);
		d.setLocationRelativeTo(null);
		
		d.setLayout(new BorderLayout());
		//this.setResizable(false);
		//面板一，用来放置文本框和标签
		panel1.setBackground(Color.DARK_GRAY);
		panel1.setLayout(new FlowLayout());
		JLabel ltitle = new JLabel("    -------------------------请输入以下信息------------------------");
		ltitle.setPreferredSize(new Dimension(d.getWidth(), 60));
		ltitle.setFont(new Font("楷体", Font.BOLD, 20));
		ltitle.setForeground(Color.ORANGE);
		panel1.add(ltitle);
		JLabel lid = new JLabel("  读者编号:");
		lid.setFont(new Font("楷体", Font.BOLD, 25));
		lid.setForeground(Color.CYAN);
		panel1.add(lid);
		final JTextField tfid = new JTextField("");
		tfid.setFont(new Font("楷体", Font.BOLD, 25));
		tfid.setForeground(Color.darkGray);
		tfid.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfid);
		JLabel lname = new JLabel("  读者姓名:");
		lname.setFont(new Font("楷体", Font.BOLD, 25));
		lname.setForeground(Color.CYAN);
		panel1.add(lname);
		final JTextField tfname = new JTextField("");
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
		tfdept.setFont(new Font("楷体", Font.BOLD, 25));
		tfdept.setForeground(Color.darkGray);
		tfdept.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfdept);
	    JLabel lage = new JLabel("  读者年龄:");
		lage.setFont(new Font("楷体", Font.BOLD, 25));
	    lage.setForeground(Color.CYAN);
		panel1.add(lage);
		final JTextField tfage = new JTextField("");
		tfage.setFont(new Font("楷体", Font.BOLD, 25));
		tfage.setForeground(Color.darkGray);
		tfage.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfage);
		JLabel ltypeid = new JLabel("  类型编号:");
		ltypeid.setFont(new Font("楷体", Font.BOLD, 25));
		ltypeid.setForeground(Color.CYAN);
		panel1.add(ltypeid);
		final JTextField tftypeid = new JTextField("");
		tftypeid.setFont(new Font("楷体", Font.BOLD, 25));
		tftypeid.setForeground(Color.darkGray);
		tftypeid.setPreferredSize(new Dimension(180, 30));
		panel1.add(tftypeid);
		JLabel lphone = new JLabel("  读者电话:");
		lphone.setFont(new Font("楷体", Font.BOLD, 25));
		lphone.setForeground(Color.CYAN);
		panel1.add(lphone);
		final JTextField tfphone = new JTextField("");
		tfphone.setFont(new Font("楷体", Font.BOLD, 25));
		tfphone.setForeground(Color.darkGray);
		tfphone.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfphone);
		JLabel lregdate = new JLabel("  注册日期:");
		final Date regdate = new Date(System.currentTimeMillis());//获取当前日期
		lregdate.setFont(new Font("楷体", Font.BOLD, 25));
		lregdate.setForeground(Color.CYAN);
		panel1.add(lregdate);
		JTextField tfregdate = new JTextField(regdate.toString());
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
		JButton b = new JButton("添加");
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
		//设置按钮监听器
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String rid = tfid.getText();//获取读者编号
				String name = tfname.getText();//获取读者姓名
				String sex = null;
				if(bsex1.isSelected()){
					sex = "男";
				}else if(bsex2.isSelected()){
					sex = "女";
				}
				
				String dept = tfdept.getText();//获取读者所在系部
				
				String typeid = tftypeid.getText();//获取读者类型编号
				String phone = tfphone.getText();//获取读者电话号码
				
				if(rid.equals("")||name.equals("")||sex.equals(null)||dept.equals("")||tfage.getText().equals("")||typeid.equals("")||phone.equals("")){
					JOptionPane.showMessageDialog(d, "信息填写不完整");
				}else {
					try{
						int age = Integer.parseInt(tfage.getText());//获取读者年龄
						//创建ReaderJDBC对象，调用add方法
						ReaderJDBC rj = new ReaderJDBC();
						List<Reader> lsreader = rj.list();
						int j;
						//判断读书编号是否已存在
						for(j=0; j<lsreader.size(); j++){
							if(lsreader.get(j).getRid().equals(rid)){
								JOptionPane.showMessageDialog(d, "图书编号已存在");
								break;
							}
						}
						//图书编号不存在可以继续
						if(j>=lsreader.size()){
							//创建ReaderTypeJDBC对象,判断输入的图书类型是否已存在，已存在则可以添加
							ReaderTypeJDBC rtj = new ReaderTypeJDBC();
							List<ReaderType> list = rtj.list();//获取图书类型集合
							int i;
							for(i=0; i<list.size(); i++){
								//图书类型已存在可以添加
								if(list.get(i).getId().equals(typeid)){
									//创建Reader 对象
									Reader reader = new Reader(rid, name, sex, dept, age, typeid, phone, regdate);
									rj.add(reader);
									//更新TableModel中的数据
									rtm.lsreader = rj.list();
									//刷新
									table.updateUI();
									JOptionPane.showMessageDialog(d, "提交成功");
									break;
								}
							}
							
							if(i>=list.size()){
								JOptionPane.showMessageDialog(d, "不存在此读者类型，请先添加此图书类型！");
							}
						}
					}catch(NumberFormatException e1){
						JOptionPane.showMessageDialog(d, "年龄格式不正确!");
					}
				}
			}
		});
		
		d.setVisible(true);
	}
	
}
