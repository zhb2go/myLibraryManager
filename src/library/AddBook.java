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

public class AddBook {
	public static void add(JFrame f){
		final JDialog d = new JDialog(f, "添加图书信息", true);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		d.setSize(800, 600);
		d.setLocationRelativeTo(null);
		
		d.setLayout(new BorderLayout());
		
		panel1.setBackground(Color.DARK_GRAY);
		panel1.setLayout(new FlowLayout());
		JLabel ltitle = new JLabel("    -------------------------请输入以下信息------------------------");
		ltitle.setPreferredSize(new Dimension(d.getWidth(), 60));
		ltitle.setFont(new Font("楷体", Font.BOLD, 20));
		ltitle.setForeground(Color.ORANGE);
		panel1.add(ltitle);
		JLabel lisbn = new JLabel("图书ISBN号:");
		lisbn.setFont(new Font("楷体", Font.BOLD, 25));
		lisbn.setForeground(Color.CYAN);
		panel1.add(lisbn);
		final JTextField tfisbn = new JTextField("");
		tfisbn.setFont(new Font("楷体", Font.BOLD, 25));
		tfisbn.setForeground(Color.darkGray);
		tfisbn.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfisbn);
		JLabel lbookname = new JLabel("  图书名称:");
		lbookname.setFont(new Font("楷体", Font.BOLD, 25));
		lbookname.setForeground(Color.CYAN);
		panel1.add(lbookname);
		final JTextField tfbookname = new JTextField("");
		tfbookname.setFont(new Font("楷体", Font.BOLD, 25));
		tfbookname.setForeground(Color.darkGray);
		tfbookname.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfbookname);
		JLabel lauthor = new JLabel("  图书作者:");
		lauthor.setFont(new Font("楷体", Font.BOLD, 25));
		lauthor.setForeground(Color.CYAN);
		panel1.add(lauthor);
		final JTextField tfauthor = new JTextField("");
		tfauthor.setFont(new Font("楷体", Font.BOLD, 25));
		tfauthor.setForeground(Color.darkGray);
		tfauthor.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfauthor);
		JLabel ltypeid = new JLabel("  类型编号:");
		ltypeid.setFont(new Font("楷体", Font.BOLD, 25));
		ltypeid.setForeground(Color.CYAN);
		panel1.add(ltypeid);
		final JTextField tftypeid = new JTextField("");
		tftypeid.setFont(new Font("楷体", Font.BOLD, 25));
		tftypeid.setForeground(Color.darkGray);
		tftypeid.setPreferredSize(new Dimension(180, 30));
		panel1.add(tftypeid);
	    JLabel lpublishdate = new JLabel("  出版日期:");
		lpublishdate.setFont(new Font("楷体", Font.BOLD, 25));
	    lpublishdate.setForeground(Color.CYAN);
		panel1.add(lpublishdate);
		final JTextField tfpublishdate = new JTextField("");
		tfpublishdate.setFont(new Font("楷体", Font.BOLD, 25));
		tfpublishdate.setForeground(Color.darkGray);
		tfpublishdate.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfpublishdate);
		JLabel lpublishnum = new JLabel("  出版数量:");
		lpublishnum.setFont(new Font("楷体", Font.BOLD, 25));
		lpublishnum.setForeground(Color.CYAN);
		panel1.add(lpublishnum);
		final JTextField tfpublishnum = new JTextField("");
		tfpublishnum.setFont(new Font("楷体", Font.BOLD, 25));
		tfpublishnum.setForeground(Color.darkGray);
		tfpublishnum.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfpublishnum);
		JLabel lpublish = new JLabel("   出版社 :");
		lpublish.setFont(new Font("楷体", Font.BOLD, 25));
		lpublish.setForeground(Color.CYAN);
		panel1.add(lpublish);
		final JTextField tfpublish = new JTextField("");
		tfpublish.setFont(new Font("楷体", Font.BOLD, 25));
		tfpublish.setForeground(Color.darkGray);
		tfpublish.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfpublish);
		JLabel lprice = new JLabel("  图书价格:");
		lprice.setFont(new Font("楷体", Font.BOLD, 25));
		lprice.setForeground(Color.CYAN);
		panel1.add(lprice);
		final JTextField tfprice = new JTextField("");
		tfprice.setFont(new Font("楷体", Font.BOLD, 25));
		tfprice.setForeground(Color.darkGray);
		tfprice.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfprice);
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
				// TODO Auto-generated method stub
				String isbn = tfisbn.getText();
				String bookname = tfbookname.getText();
				String author = tfauthor.getText();
				String typeid = tftypeid.getText();
				
				String publishdate0 = tfpublishdate.getText();
				String publishnum0 = tfpublishnum.getText();
				String publish = tfpublish.getText();
				String price0 = tfprice.getText();
				if(isbn.equals("")||bookname.equals("")||author.equals("")||typeid.equals("")||
						publishdate0.equals("")||publishnum0.equals("")||publish.equals("")||price0.equals("")){
					JOptionPane.showMessageDialog(d, "信息填写不完整");
				}else {
					try{
						int publishnum = Integer.parseInt(publishnum0);
						double price = Double.parseDouble(price0);
						Date publishdate = Date.valueOf(publishdate0);
						
						BookJDBC bj = new BookJDBC();
						BookTypeJDBC btj = new BookTypeJDBC();
						List<Book> blist = bj.list();
						
						//判断该图书是否已存在
						int i;
						for(i=0; i<blist.size(); i++){
							if(isbn.equals(blist.get(i).getIsbn())){
								//已存在
								JOptionPane.showMessageDialog(d, "该图书已存在");
								break;
							}
						}
						//图书不存在，继续添加操作,判断图书类型是否存在
						if(i>=blist.size()){
							List<BookType> btlist = btj.list();
							int j;
							for(j=0; j<btlist.size(); j++){
								if(typeid.equals(btlist.get(j).getId())){
									//存在，则添加
									Book book = new Book(isbn, bookname, author, typeid, publishdate, publishnum, publish, price);
									bj.add(book);
									//更新tableModel数据
									btm.lsbook = bj.list();
									//刷新
									table.updateUI();
									JOptionPane.showMessageDialog(d, "提交成功");
									break;
								}
							}
							
							if(j>=btlist.size()){
								JOptionPane.showMessageDialog(d, "该图书类型不存在，请先添加图书类型！");
							}
						}
						
					}catch(NumberFormatException e1){
						JOptionPane.showMessageDialog(d, "出版数量或图书价格格式不正确!");
					}catch(IllegalArgumentException e2){
						JOptionPane.showMessageDialog(d, "日期格式错误,请按照xxxx-xx-xx的格式来写!");
					}
				}
			}
		});
		
		d.setVisible(true);
	}
}
