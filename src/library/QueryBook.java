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

import book.Book;
import book.BookJDBC;
import book.BookTableModel;
import bookType.BookType;
import bookType.BookTypeJDBC;
import borrow.Borrow;
import borrow.BorrowJDBC;

public class QueryBook {
	public static void query(JFrame f){
		final JDialog d = new JDialog(f, "查询图书信息", true);
		JPanel panel1 = new JPanel();
		final JPanel panel2 = new JPanel();
		d.setSize(800, 600);
		d.setLocationRelativeTo(null);
		
		d.setLayout(new BorderLayout());
		
		panel1.setBackground(Color.DARK_GRAY);
		panel1.setLayout(new FlowLayout());
		JLabel ltitle = new JLabel("    ---------------------------详细信息----------------------------");
		ltitle.setPreferredSize(new Dimension(d.getWidth(), 60));
		ltitle.setFont(new Font("楷体", Font.BOLD, 20));
		ltitle.setForeground(Color.ORANGE);
		panel1.add(ltitle);
		JLabel lisbn = new JLabel("图书ISBN号:");
		lisbn.setFont(new Font("楷体", Font.BOLD, 25));
		lisbn.setForeground(Color.CYAN);
		panel1.add(lisbn);
		final JTextField tfisbn = new JTextField("");
		tfisbn.setEditable(false);
		tfisbn.setFont(new Font("楷体", Font.BOLD, 25));
		tfisbn.setForeground(Color.darkGray);
		tfisbn.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfisbn);
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
		JLabel lauthor = new JLabel("  图书作者:");
		lauthor.setFont(new Font("楷体", Font.BOLD, 25));
		lauthor.setForeground(Color.CYAN);
		panel1.add(lauthor);
		final JTextField tfauthor = new JTextField("");
		tfauthor.setEditable(false);
		tfauthor.setFont(new Font("楷体", Font.BOLD, 25));
		tfauthor.setForeground(Color.darkGray);
		tfauthor.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfauthor);
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
	    JLabel lpublishdate = new JLabel("  出版日期:");
		lpublishdate.setFont(new Font("楷体", Font.BOLD, 25));
	    lpublishdate.setForeground(Color.CYAN);
		panel1.add(lpublishdate);
		final JTextField tfpublishdate = new JTextField("");
		tfpublishdate.setEditable(false);
		tfpublishdate.setFont(new Font("楷体", Font.BOLD, 25));
		tfpublishdate.setForeground(Color.darkGray);
		tfpublishdate.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfpublishdate);
		JLabel lpublishnum = new JLabel("  出版数量:");
		lpublishnum.setFont(new Font("楷体", Font.BOLD, 25));
		lpublishnum.setForeground(Color.CYAN);
		panel1.add(lpublishnum);
		final JTextField tfpublishnum = new JTextField("");
		tfpublishnum.setEditable(false);
		tfpublishnum.setFont(new Font("楷体", Font.BOLD, 25));
		tfpublishnum.setForeground(Color.darkGray);
		tfpublishnum.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfpublishnum);
		JLabel lpublish = new JLabel("   出版社 :");
		lpublish.setFont(new Font("楷体", Font.BOLD, 25));
		lpublish.setForeground(Color.CYAN);
		panel1.add(lpublish);
		final JTextField tfpublish = new JTextField("");
		tfpublish.setEditable(false);
		tfpublish.setFont(new Font("楷体", Font.BOLD, 25));
		tfpublish.setForeground(Color.darkGray);
		tfpublish.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfpublish);
		JLabel lprice = new JLabel("  图书价格:");
		lprice.setFont(new Font("楷体", Font.BOLD, 25));
		lprice.setForeground(Color.CYAN);
		panel1.add(lprice);
		final JTextField tfprice = new JTextField("");
		tfprice.setEditable(false);
		tfprice.setFont(new Font("楷体", Font.BOLD, 25));
		tfprice.setForeground(Color.darkGray);
		tfprice.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfprice);
		JLabel ltypename = new JLabel("  类型名称:");
		ltypename.setFont(new Font("楷体", Font.BOLD, 25));
		ltypename.setForeground(Color.CYAN);
		panel1.add(ltypename);
		final JTextField tftypename = new JTextField("");
		tftypename.setEditable(false);
		tftypename.setFont(new Font("楷体", Font.BOLD, 25));
		tftypename.setForeground(Color.darkGray);
		tftypename.setPreferredSize(new Dimension(180, 30));
		panel1.add(tftypename);
		JLabel lexit = new JLabel("  是否在馆:");
		lexit.setFont(new Font("楷体", Font.BOLD, 25));
		lexit.setForeground(Color.CYAN);
		panel1.add(lexit);
		final JTextField tfexit = new JTextField("");
		tfexit.setEditable(false);
		tfexit.setFont(new Font("楷体", Font.BOLD, 25));
		tfexit.setForeground(Color.darkGray);
		tfexit.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfexit);
		JLabel ltail = new JLabel("    -------------------请输入所要查询图书的编号--------------------");
		ltail.setPreferredSize(new Dimension(d.getWidth(), 30));
		ltail.setFont(new Font("楷体", Font.BOLD, 20));
		ltail.setForeground(Color.ORANGE);
		panel1.add(ltail);
		JLabel lid0 = new JLabel("图书编号:");
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
		JLabel ltail0 = new JLabel("    -----------------------------------------------------------");
		ltail0.setPreferredSize(new Dimension(d.getWidth(), 25));
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
		//设置按钮监听器
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BookJDBC bj = new BookJDBC();
				List<Book> lsbook = bj.list();
				int i;
				String isbn = tfid0.getText();
				if(isbn.equals("")){
					JOptionPane.showMessageDialog(d, "输入为空！");
				}else{
					for(i=0; i<lsbook.size(); i++){
						if(isbn.equals(lsbook.get(i).getIsbn())){
							//存在此图书,获取各个值
							Book book = lsbook.get(i);
							//将各属性放在文本框中
							String bookname = book.getBookname();
							String author = book.getAuthor();
							String typeid = book.getTypeid();
							Date publishdate0 = book.getPublishdate();
							String publishdate = publishdate0.toString();
							int publishnum0 = book.getPublishnum();
							String publishnum = String.valueOf(publishnum0);
							String publish = book.getPublish();
							double price0 = book.getPrice();
							String price = String.valueOf(price0);
							tfisbn.setText(isbn);
							tfbookname.setText(bookname);
							tfauthor.setText(author);
							tftypeid.setText(typeid);
							tfpublishdate.setText(publishdate);
							tfpublishnum.setText(publishnum);
							tfpublish.setText(publish);
							tfprice.setText(price);
							//获取图书类型名称
							BookTypeJDBC btj = new BookTypeJDBC();
							List<BookType> lsbooktype = btj.list();
							for(int j=0 ;j<lsbooktype.size(); j++){
								if(book.getTypeid().equals(lsbooktype.get(j).getId())){
									tftypename.setText(lsbooktype.get(j).getTypename());
									break;
								}
							}
							//判断是否在馆
							BorrowJDBC boj = new BorrowJDBC();
							List<Borrow> lsborrow = boj.list();
							int x;
							for(x=0; x<lsborrow.size(); x++){
								if(isbn.equals(lsborrow.get(x).getIsbn())){
									tfexit.setText("已借出");
									break;
								}
							}
							if(x>=lsborrow.size()){
								tfexit.setText("在馆");
							}
							break;
						}
					}
					if(i>=lsbook.size()){
						JOptionPane.showMessageDialog(d, "不存在此图书");
					}
				}
			}
		});
		d.setVisible(true);
	}
}
