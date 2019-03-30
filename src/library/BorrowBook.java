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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import book.Book;
import book.BookJDBC;
import book.BookTableModel;
import bookType.BookType;
import bookType.BookTypeJDBC;
import borrow.Borrow;
import borrow.BorrowJDBC;
import reader.Reader;
import reader.ReaderJDBC;
import readerType.ReaderType;
import readerType.ReaderTypeJDBC;
public class BorrowBook {
	public static void borrow(JFrame f){
		final JDialog d = new JDialog(f, "借书", true);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		d.setSize(800, 600);
		d.setLocationRelativeTo(null);
		
		d.setLayout(new BorderLayout());
		
		//面板一，用来放置文本框和标签
		panel1.setBackground(Color.DARK_GRAY);
		panel1.setLayout(new FlowLayout());
		JLabel ltitle = new JLabel("    ---------------------------详细信息----------------------------");
		ltitle.setPreferredSize(new Dimension(d.getWidth(), 60));
		ltitle.setFont(new Font("楷体", Font.BOLD, 20));
		ltitle.setForeground(Color.ORANGE);
		panel1.add(ltitle);
		JLabel lreadername = new JLabel("  读者姓名:");
		lreadername.setFont(new Font("楷体", Font.BOLD, 25));
		lreadername.setForeground(Color.CYAN);
		panel1.add(lreadername);
		final JTextField tfreadername = new JTextField("");
		tfreadername.setEditable(false);
		tfreadername.setFont(new Font("楷体", Font.BOLD, 25));
		tfreadername.setForeground(Color.darkGray);
		tfreadername.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfreadername);
		JLabel lreadertype = new JLabel("  读者类型:");
		lreadertype.setFont(new Font("楷体", Font.BOLD, 25));
		lreadertype.setForeground(Color.CYAN);
		panel1.add(lreadertype);
		final JTextField tfreadertype = new JTextField("");
		tfreadertype.setEditable(false);
		tfreadertype.setFont(new Font("楷体", Font.BOLD, 25));
		tfreadertype.setForeground(Color.darkGray);
		tfreadertype.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfreadertype);
		JLabel lbookname = new JLabel("  图书名称:");
		lbookname.setFont(new Font("楷体", Font.BOLD, 25));
		lbookname.setForeground(Color.CYAN);
		panel1.add(lbookname);
		final JTextField tfbookname = new JTextField("");
		tfbookname.setEditable(false);
		tfbookname.setFont(new Font("楷体", Font.BOLD, 25));
		tfbookname.setForeground(Color.darkGray);
		tfbookname.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfbookname);
		JLabel lbooktype = new JLabel("  图书类型:");
		lbooktype.setFont(new Font("楷体", Font.BOLD, 25));
		lbooktype.setForeground(Color.CYAN);
		panel1.add(lbooktype);
		final JTextField tfbooktype = new JTextField("");
		tfbooktype.setEditable(false);
		tfbooktype.setFont(new Font("楷体", Font.BOLD, 25));
		tfbooktype.setForeground(Color.darkGray);
		tfbooktype.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfbooktype);
		JLabel lborrowdate = new JLabel("  借书日期:");
		lborrowdate.setFont(new Font("楷体", Font.BOLD, 25));
		lborrowdate.setForeground(Color.CYAN);
		panel1.add(lborrowdate);
		final JTextField tfborrowdate = new JTextField("");
		tfborrowdate.setEditable(false);
		tfborrowdate.setFont(new Font("楷体", Font.BOLD, 25));
		tfborrowdate.setForeground(Color.darkGray);
		tfborrowdate.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfborrowdate);
		JLabel ldaynum = new JLabel("  可借天数:");
		ldaynum.setFont(new Font("楷体", Font.BOLD, 25));
		ldaynum.setForeground(Color.CYAN);
		panel1.add(ldaynum);
		final JTextField tfdaynum = new JTextField("");
		tfdaynum.setEditable(false);
		tfdaynum.setFont(new Font("楷体", Font.BOLD, 25));
		tfdaynum.setForeground(Color.darkGray);
		tfdaynum.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfdaynum);
		JLabel ltail = new JLabel("    -------------------请输入读者编号和图书编号---------------------");
		ltail.setPreferredSize(new Dimension(d.getWidth(), 30));
		ltail.setFont(new Font("楷体", Font.BOLD, 20));
		ltail.setForeground(Color.ORANGE);
		panel1.add(ltail);
		JLabel lrid = new JLabel("读者编号:");
		lrid.setFont(new Font("楷体", Font.BOLD, 25));
		lrid.setForeground(Color.CYAN);
		panel1.add(lrid);
		final JTextField tfrid = new JTextField("");
		tfrid.setFont(new Font("楷体", Font.BOLD, 25));
		tfrid.setForeground(Color.darkGray);
		tfrid.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfrid);
		JLabel lisbn = new JLabel("  图书编号:");
		lisbn.setFont(new Font("楷体", Font.BOLD, 25));
		lisbn.setForeground(Color.CYAN);
		panel1.add(lisbn);
		final JTextField tfisbn = new JTextField("");
		tfisbn.setFont(new Font("楷体", Font.BOLD, 25));
		tfisbn.setForeground(Color.darkGray);
		tfisbn.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfisbn);
		
		//添加借书按钮 
		JButton b = new JButton("借书");
		b.setFont(new Font("楷体", Font.BOLD, 50));
		b.setPreferredSize(new Dimension(150, 60));
		panel1.add(b);
		JLabel ltail0 = new JLabel("    --------------------或在下方选择要借图书-----------------------");
		ltail0.setPreferredSize(new Dimension(d.getWidth(), 30));
		ltail0.setFont(new Font("楷体", Font.BOLD, 20));
		ltail0.setForeground(Color.ORANGE);
		panel1.add(ltail0);
		
		//面板二，用来放置图书信息
		panel2.setPreferredSize(new Dimension(ImageObserver.WIDTH, 200));
		//创建TableModel对象
		final BookTableModel btm = new BookTableModel();
		//创建Table对象
		final JTable table = new JTable(btm);
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
				//根据选中的行，到TableModel中去选对象
				Book book = btm.lsbook.get(row);
				//将图书编号放在文本框中
				String isbn  =book.getIsbn();
				tfisbn.setText(isbn);
			}
		});
		
		//设置按钮监听器
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 获取文本框中的内容
				String rid = tfrid.getText();
				String isbn = tfisbn.getText();
				int maxnum = 0;
				//判断是否为空
				if(rid.equals("")||isbn.equals("")){
					JOptionPane.showMessageDialog(d, "信息输入不完整");
				}else{
					//不为空,则将文本框内容填写完整
					//读者
					ReaderJDBC rj = new ReaderJDBC();
					List<Reader> lsreader = rj.list();
					ReaderTypeJDBC rtj = new ReaderTypeJDBC();
					List<ReaderType> lsreadertype = rtj.list();
					int i;
					for(i=0; i<lsreader.size(); i++){
						if(rid.equals(lsreader.get(i).getRid())){
							//读者存在时，根据相同的读者编号获取读者姓名
							tfreadername.setText(lsreader.get(i).getName());
							//根据读者类型编号来获取读者类型
							for(int j=0; j<lsreadertype.size(); j++){
								if(lsreader.get(i).getTypeid().equals(lsreadertype.get(j).getId())){
									//获取读者类型
									tfreadertype.setText(lsreadertype.get(j).getTypename());
									//获取期限
									tfdaynum.setText(String.valueOf(lsreadertype.get(j).getDaynum()));
									//获取该读者类型可借图书数量
									maxnum = lsreadertype.get(j).getMaxborrownum();
									break;
								}
							}
							//在读者存在的前提下，去获取图书
							//图书
							BookJDBC bj = new BookJDBC();
							List<Book> lsbook = bj.list();
							BookTypeJDBC btj = new BookTypeJDBC();
							List<BookType> lsbooktype = btj.list();
							int x;
							for(x=0; x<lsbook.size(); x++){
								if(isbn.equals(lsbook.get(x).getIsbn())){
									//判断图书是否已经借出
									BorrowJDBC boj = new BorrowJDBC();
									List<Borrow> lsborrow = boj.list();
									int t;
									for(t=0; t<lsborrow.size(); t++){
										if(isbn.equals(lsborrow.get(t).getIsbn())){
											break;
										}
									}
									//获取该读者当前再借数量
									int num=0;
									for(int y=0; y<lsborrow.size(); y++){
										if(rid.equals(lsborrow.get(y).getRid())){
											num++;
										}
									}
									//图书存在时，根据相同的ISBN号来获取图书名称
									tfbookname.setText(lsbook.get(x).getBookname());
									//根据图书类型编号来获取图书类型名称
									for(int y=0; y<lsbooktype.size(); y++){
										if(lsbook.get(x).getTypeid().equals(lsbooktype.get(y).getId())){
											tfbooktype.setText(lsbooktype.get(y).getTypename());
											break;
										}
									}
									//在读者和图书都存在的情况下，去获取日期和天数
									//日期为当前日期
									Date borrowdate0 = new Date(System.currentTimeMillis());
									//转化为字符串
									String borrowdate = borrowdate0.toString();
									//加入到文本框
									tfborrowdate.setText(borrowdate);
									//文本框填好之后，开始执行借书操作
									if(maxnum>num){
										if(t<lsborrow.size()){
											JOptionPane.showMessageDialog(d, "不好意思，图书已经借出");
										}else{
											int option = JOptionPane.showConfirmDialog(d, "确定借阅吗？");
											if(option==JOptionPane.OK_OPTION){
												//借阅
												boj.borrowBook(lsreader.get(i), lsbook.get(x));
												JOptionPane.showMessageDialog(d, "借阅成功");
												int n = maxnum-num-1;
												JOptionPane.showMessageDialog(d, "还可以再借"+n+"本");
											}
										}
									}
									break;
								}
							}
							if(x>=lsbook.size()){
								JOptionPane.showMessageDialog(d, "不存在该图书");
							}
							break;
						}
					}
					if(i>=lsreader.size()){
						JOptionPane.showMessageDialog(d, "不存在该读者!");
					}
				}
			}
		});
		d.setVisible(true);
	}
}
