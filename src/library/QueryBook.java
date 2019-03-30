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
		final JDialog d = new JDialog(f, "��ѯͼ����Ϣ", true);
		JPanel panel1 = new JPanel();
		final JPanel panel2 = new JPanel();
		d.setSize(800, 600);
		d.setLocationRelativeTo(null);
		
		d.setLayout(new BorderLayout());
		
		panel1.setBackground(Color.DARK_GRAY);
		panel1.setLayout(new FlowLayout());
		JLabel ltitle = new JLabel("    ---------------------------��ϸ��Ϣ----------------------------");
		ltitle.setPreferredSize(new Dimension(d.getWidth(), 60));
		ltitle.setFont(new Font("����", Font.BOLD, 20));
		ltitle.setForeground(Color.ORANGE);
		panel1.add(ltitle);
		JLabel lisbn = new JLabel("ͼ��ISBN��:");
		lisbn.setFont(new Font("����", Font.BOLD, 25));
		lisbn.setForeground(Color.CYAN);
		panel1.add(lisbn);
		final JTextField tfisbn = new JTextField("");
		tfisbn.setEditable(false);
		tfisbn.setFont(new Font("����", Font.BOLD, 25));
		tfisbn.setForeground(Color.darkGray);
		tfisbn.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfisbn);
		JLabel lbookname = new JLabel("  ͼ������:");
		lbookname.setFont(new Font("����", Font.BOLD, 25));
		lbookname.setForeground(Color.CYAN);
		panel1.add(lbookname);
		final JTextField tfbookname = new JTextField("");
		tfbookname.setEditable(false);
		tfbookname.setFont(new Font("����", Font.BOLD, 25));
		tfbookname.setForeground(Color.darkGray);
		tfbookname.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfbookname);
		JLabel lauthor = new JLabel("  ͼ������:");
		lauthor.setFont(new Font("����", Font.BOLD, 25));
		lauthor.setForeground(Color.CYAN);
		panel1.add(lauthor);
		final JTextField tfauthor = new JTextField("");
		tfauthor.setEditable(false);
		tfauthor.setFont(new Font("����", Font.BOLD, 25));
		tfauthor.setForeground(Color.darkGray);
		tfauthor.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfauthor);
		JLabel ltypeid = new JLabel("  ���ͱ��:");
		ltypeid.setFont(new Font("����", Font.BOLD, 25));
		ltypeid.setForeground(Color.CYAN);
		panel1.add(ltypeid);
		final JTextField tftypeid = new JTextField("");
		tftypeid.setEditable(false);
		tftypeid.setFont(new Font("����", Font.BOLD, 25));
		tftypeid.setForeground(Color.darkGray);
		tftypeid.setPreferredSize(new Dimension(180, 30));
		panel1.add(tftypeid);
	    JLabel lpublishdate = new JLabel("  ��������:");
		lpublishdate.setFont(new Font("����", Font.BOLD, 25));
	    lpublishdate.setForeground(Color.CYAN);
		panel1.add(lpublishdate);
		final JTextField tfpublishdate = new JTextField("");
		tfpublishdate.setEditable(false);
		tfpublishdate.setFont(new Font("����", Font.BOLD, 25));
		tfpublishdate.setForeground(Color.darkGray);
		tfpublishdate.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfpublishdate);
		JLabel lpublishnum = new JLabel("  ��������:");
		lpublishnum.setFont(new Font("����", Font.BOLD, 25));
		lpublishnum.setForeground(Color.CYAN);
		panel1.add(lpublishnum);
		final JTextField tfpublishnum = new JTextField("");
		tfpublishnum.setEditable(false);
		tfpublishnum.setFont(new Font("����", Font.BOLD, 25));
		tfpublishnum.setForeground(Color.darkGray);
		tfpublishnum.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfpublishnum);
		JLabel lpublish = new JLabel("   ������ :");
		lpublish.setFont(new Font("����", Font.BOLD, 25));
		lpublish.setForeground(Color.CYAN);
		panel1.add(lpublish);
		final JTextField tfpublish = new JTextField("");
		tfpublish.setEditable(false);
		tfpublish.setFont(new Font("����", Font.BOLD, 25));
		tfpublish.setForeground(Color.darkGray);
		tfpublish.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfpublish);
		JLabel lprice = new JLabel("  ͼ��۸�:");
		lprice.setFont(new Font("����", Font.BOLD, 25));
		lprice.setForeground(Color.CYAN);
		panel1.add(lprice);
		final JTextField tfprice = new JTextField("");
		tfprice.setEditable(false);
		tfprice.setFont(new Font("����", Font.BOLD, 25));
		tfprice.setForeground(Color.darkGray);
		tfprice.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfprice);
		JLabel ltypename = new JLabel("  ��������:");
		ltypename.setFont(new Font("����", Font.BOLD, 25));
		ltypename.setForeground(Color.CYAN);
		panel1.add(ltypename);
		final JTextField tftypename = new JTextField("");
		tftypename.setEditable(false);
		tftypename.setFont(new Font("����", Font.BOLD, 25));
		tftypename.setForeground(Color.darkGray);
		tftypename.setPreferredSize(new Dimension(180, 30));
		panel1.add(tftypename);
		JLabel lexit = new JLabel("  �Ƿ��ڹ�:");
		lexit.setFont(new Font("����", Font.BOLD, 25));
		lexit.setForeground(Color.CYAN);
		panel1.add(lexit);
		final JTextField tfexit = new JTextField("");
		tfexit.setEditable(false);
		tfexit.setFont(new Font("����", Font.BOLD, 25));
		tfexit.setForeground(Color.darkGray);
		tfexit.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfexit);
		JLabel ltail = new JLabel("    -------------------��������Ҫ��ѯͼ��ı��--------------------");
		ltail.setPreferredSize(new Dimension(d.getWidth(), 30));
		ltail.setFont(new Font("����", Font.BOLD, 20));
		ltail.setForeground(Color.ORANGE);
		panel1.add(ltail);
		JLabel lid0 = new JLabel("ͼ����:");
		lid0.setFont(new Font("����", Font.BOLD, 25));
		lid0.setForeground(Color.CYAN);
		panel1.add(lid0);
		final JTextField tfid0 = new JTextField("");
		tfid0.setFont(new Font("����", Font.BOLD, 25));
		tfid0.setForeground(Color.darkGray);
		tfid0.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfid0);
		JLabel empty = new JLabel("    ");
		empty.setFont(new Font("����", Font.BOLD, 25));
		empty.setForeground(Color.CYAN);
		panel1.add(empty);
		//��Ӳ�ѯ��ť 
		JButton b = new JButton("��ѯ");
		b.setFont(new Font("����", Font.BOLD, 25));
		b.setPreferredSize(new Dimension(100, 30));
		panel1.add(b);
		JLabel ltail0 = new JLabel("    -----------------------------------------------------------");
		ltail0.setPreferredSize(new Dimension(d.getWidth(), 25));
		ltail0.setFont(new Font("����", Font.BOLD, 20));
		ltail0.setForeground(Color.ORANGE);
		panel1.add(ltail0);
		//��������������ͼ����Ϣ
		panel2.setPreferredSize(new Dimension(ImageObserver.WIDTH, 200));
		//����TableModel����
		final BookTableModel btm = new BookTableModel();
		//����Table����
		final JTable table = new JTable(btm);
		//��Table���뵽���������
		panel2.setLayout(new BorderLayout());
		JScrollPane sp = new JScrollPane(table);
		//�����������뵽panel2��
		panel2.add(sp,BorderLayout.CENTER);
		d.add(panel1, BorderLayout.CENTER);
		d.add(panel2, BorderLayout.SOUTH);
		//���ð�ť������
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BookJDBC bj = new BookJDBC();
				List<Book> lsbook = bj.list();
				int i;
				String isbn = tfid0.getText();
				if(isbn.equals("")){
					JOptionPane.showMessageDialog(d, "����Ϊ�գ�");
				}else{
					for(i=0; i<lsbook.size(); i++){
						if(isbn.equals(lsbook.get(i).getIsbn())){
							//���ڴ�ͼ��,��ȡ����ֵ
							Book book = lsbook.get(i);
							//�������Է����ı�����
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
							//��ȡͼ����������
							BookTypeJDBC btj = new BookTypeJDBC();
							List<BookType> lsbooktype = btj.list();
							for(int j=0 ;j<lsbooktype.size(); j++){
								if(book.getTypeid().equals(lsbooktype.get(j).getId())){
									tftypename.setText(lsbooktype.get(j).getTypename());
									break;
								}
							}
							//�ж��Ƿ��ڹ�
							BorrowJDBC boj = new BorrowJDBC();
							List<Borrow> lsborrow = boj.list();
							int x;
							for(x=0; x<lsborrow.size(); x++){
								if(isbn.equals(lsborrow.get(x).getIsbn())){
									tfexit.setText("�ѽ��");
									break;
								}
							}
							if(x>=lsborrow.size()){
								tfexit.setText("�ڹ�");
							}
							break;
						}
					}
					if(i>=lsbook.size()){
						JOptionPane.showMessageDialog(d, "�����ڴ�ͼ��");
					}
				}
			}
		});
		d.setVisible(true);
	}
}
