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

public class ReturnBook {
	public static void returnbook(JFrame f){
		final JDialog d = new JDialog(f, "还书", true);
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
		JLabel lborrowdate = new JLabel("  已借天数:");
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
		JLabel ltail = new JLabel("    ----------------------请输入图书编号-----------------------");
		ltail.setPreferredSize(new Dimension(d.getWidth(), 30));
		ltail.setFont(new Font("楷体", Font.BOLD, 20));
		ltail.setForeground(Color.ORANGE);
		panel1.add(ltail);
		JLabel lrid = new JLabel("读者编号:");
		lrid.setFont(new Font("楷体", Font.BOLD, 25));
		lrid.setForeground(Color.CYAN);
		panel1.add(lrid);
		final JTextField tfrid = new JTextField("");
		tfrid.setEditable(false);
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
		JButton b = new JButton("还书");
		b.setFont(new Font("楷体", Font.BOLD, 50));
		b.setPreferredSize(new Dimension(150, 60));
		panel1.add(b);
		JLabel ltail0 = new JLabel("    --------------------或在下方选择要还图书-----------------------");
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
		
		//按钮监听器
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String isbn = tfisbn.getText();
				BookJDBC bj = new BookJDBC();
				List<Book> lsbook = bj.list();
				//首先判断输入是否为空
				if(isbn.equals("")){
					JOptionPane.showMessageDialog(d, "输入为空，请重新输入！");
				}else{
					//然后判断输入的图书ISBN号存不存在
					int i;
					for(i=0; i<lsbook.size(); i++){
						if(isbn.equals(lsbook.get(i).getIsbn())){
							//存在，继续判断是否已经归还
							BorrowJDBC boj = new BorrowJDBC();
							List<Borrow> lsborrow = boj.list();
							int j;
							for(j=0 ;j<lsborrow.size(); j++){
								if(isbn.equals(lsborrow.get(j).getIsbn())){
									//未归还，继续执行归还操作
									//获取各个信息，填入文本框中
									//获取读者编号
									String rid = lsborrow.get(j).getRid();
									tfrid.setText(rid);
							
									//获取读者姓名和类型
									ReaderJDBC rj = new ReaderJDBC();
									List<Reader> lsreader = rj.list();
									ReaderTypeJDBC rtj = new ReaderTypeJDBC();
									List<ReaderType> lsreadertype = rtj.list();
									int daynum0 = 0;
									for(int x=0; x<lsreader.size(); x++){
										if(rid.equals(lsreader.get(x).getRid())){
											String name = lsreader.get(x).getName();
											tfreadername.setText(name);
											//获取读者的类型和可借天数
											for(int y=0; y<lsreadertype.size(); y++){
												if(lsreader.get(x).getTypeid().equals(lsreadertype.get(y).getId())){
													String rtname = lsreadertype.get(y).getTypename();
													tfreadertype.setText(rtname);
													daynum0 = lsreadertype.get(y).getDaynum();
													String daynum = String.valueOf(daynum0);
													tfdaynum.setText(daynum);
													break;
												}
											}
											break;
										}
									}
									//获取图书名称和图书类型
									String bookname = lsbook.get(i).getBookname();
									tfbookname.setText(bookname);
									BookTypeJDBC btj = new BookTypeJDBC();
									List<BookType> lsbooktype = btj.list();
									for(int x=0; x<lsbooktype.size(); x++){
										if(lsbook.get(i).getTypeid().equals(lsbooktype.get(x).getId())){
											String booktype = lsbooktype.get(x).getTypename();
											tfbooktype.setText(booktype);
											break;
										}
									}
									//执行还书操作
									int option = JOptionPane.showConfirmDialog(d, "确当归还吗?");
									if(option==JOptionPane.OK_OPTION){
										long days0 = boj.returnBook(lsborrow.get(j));
										//将已借天数放到文本框中
										String borrowdate = String.valueOf(days0);
										tfborrowdate.setText(borrowdate);
										if(days0>daynum0){
											double fine = lsborrow.get(j).getFine()*(days0-daynum0);
											JOptionPane.showMessageDialog(d, "应缴费"+fine+"元");
										}else{
											JOptionPane.showMessageDialog(d, "应缴费0元");
										}
									}
									
									break;
								}
							}
							if(j>=lsborrow.size()){
								JOptionPane.showMessageDialog(d, "该图书已归还，请重新输入");
							}
							break;
						}
					}
					if(i>=lsbook.size()){
						JOptionPane.showMessageDialog(d, "该图书不存在,请重新输入！");
					}
				}
			}
		});
		d.setVisible(true);
	}
}
