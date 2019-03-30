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

import readerType.ReaderType;
import readerType.ReaderTypeJDBC;
import readerType.ReaderTypeTableModel;

public class QueryReaderType {
	public static void query(JFrame f){
		final JDialog d = new JDialog(f, "查询读者类别", true);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		d.setSize(500, 500);
		d.setLocationRelativeTo(null);
		
		d.setLayout(new BorderLayout());
		
		
		panel1.setBackground(Color.DARK_GRAY);
		panel1.setLayout(new FlowLayout());
		JLabel ltitle = new JLabel("     ---------详细信息---------");
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
		tftypename.setEditable(false);
		tftypename.setFont(new Font("楷体", Font.BOLD, 30));
		tftypename.setForeground(Color.darkGray);
		tftypename.setPreferredSize(new Dimension(250, 35));
		panel1.add(tftypename);
		
		JLabel lmaxnum = new JLabel("最多可借阅图书 : ");
		lmaxnum.setFont(new Font("楷体", Font.BOLD, 25));
		lmaxnum.setForeground(Color.CYAN);
		panel1.add(lmaxnum);
		final JTextField tfmaxnum = new JTextField("");
		tfmaxnum.setEditable(false);
		tfmaxnum.setFont(new Font("楷体", Font.BOLD, 25));
		tfmaxnum.setForeground(Color.darkGray);
		tfmaxnum.setPreferredSize(new Dimension(250, 30));
		panel1.add(tfmaxnum);
		
		JLabel ldaynum = new JLabel("最长可借阅天数 : ");
		ldaynum.setFont(new Font("楷体", Font.BOLD, 25));
		ldaynum.setForeground(Color.CYAN);
		panel1.add(ldaynum);
		final JTextField tfdaynum = new JTextField("");
		tfdaynum.setEditable(false);
		tfdaynum.setFont(new Font("楷体", Font.BOLD, 25));
		tfdaynum.setForeground(Color.darkGray);
		tfdaynum.setPreferredSize(new Dimension(250, 30));
		panel1.add(tfdaynum);
		
		JLabel ltitle1 = new JLabel("     -------------------------");
		ltitle1.setPreferredSize(new Dimension(d.getWidth(), 30));
		ltitle1.setFont(new Font("楷体", Font.BOLD, 25));
		ltitle1.setForeground(Color.ORANGE);
		panel1.add(ltitle1);
		JLabel ltypeid1 = new JLabel("类别编号:");
		ltypeid1.setFont(new Font("楷体", Font.BOLD, 20));
		ltypeid1.setForeground(Color.CYAN);
		panel1.add(ltypeid1);
		final JTextField tftypeid1 = new JTextField("");
		tftypeid1.setFont(new Font("楷体", Font.BOLD, 20));
		tftypeid1.setForeground(Color.darkGray);
		tftypeid1.setPreferredSize(new Dimension(150, 25));
		panel1.add(tftypeid1);
		//添加提交按钮
		JButton b = new JButton("查询");
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
		//设置按钮监听器
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 判断是否为空
				String typeid = tftypeid1.getText();
				if(typeid.equals("")){
					JOptionPane.showMessageDialog(d, "输入为空");
				}else{
					ReaderTypeJDBC rtj = new ReaderTypeJDBC();
					List<ReaderType> lsreadertype = rtj.list();
					int i;
					for(i=0; i<lsreadertype.size(); i++){
						if(typeid.equals(lsreadertype.get(i).getId())){
							ReaderType rt = lsreadertype.get(i);
							String typename = rt.getTypename();
							int maxnum = rt.getMaxborrownum();
							int daynum = rt.getDaynum();
							String maxnum0 = String.valueOf(maxnum);
							String daynum0 = String.valueOf(daynum);
							tftypeid.setText(typeid);
							tftypename.setText(typename);
							tfmaxnum.setText(maxnum0);
							tfdaynum.setText(daynum0);
							break;
						}
					}
					
					if(i>=lsreadertype.size()){
						JOptionPane.showMessageDialog(d, "不存在读者类型");
					}
				}
			}
		});
		d.setVisible(true);
	}
}
