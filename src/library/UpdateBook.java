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

public class UpdateBook {
	public static void update(JFrame f){
		final JDialog d = new JDialog(f, "�޸�ͼ����Ϣ", true);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		d.setSize(800, 600);
		d.setLocationRelativeTo(null);
		
		d.setLayout(new BorderLayout());
		
		panel1.setBackground(Color.DARK_GRAY);
		panel1.setLayout(new FlowLayout());
		JLabel ltitle = new JLabel("    -----------------�����·������ѡ����Ҫ�޸ĵ���-----------------");
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
		tfbookname.setFont(new Font("����", Font.BOLD, 25));
		tfbookname.setForeground(Color.darkGray);
		tfbookname.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfbookname);
		JLabel lauthor = new JLabel("  ͼ������:");
		lauthor.setFont(new Font("����", Font.BOLD, 25));
		lauthor.setForeground(Color.CYAN);
		panel1.add(lauthor);
		final JTextField tfauthor = new JTextField("");
		tfauthor.setFont(new Font("����", Font.BOLD, 25));
		tfauthor.setForeground(Color.darkGray);
		tfauthor.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfauthor);
		JLabel ltypeid = new JLabel("  ���ͱ��:");
		ltypeid.setFont(new Font("����", Font.BOLD, 25));
		ltypeid.setForeground(Color.CYAN);
		panel1.add(ltypeid);
		final JTextField tftypeid = new JTextField("");
		tftypeid.setFont(new Font("����", Font.BOLD, 25));
		tftypeid.setForeground(Color.darkGray);
		tftypeid.setPreferredSize(new Dimension(180, 30));
		panel1.add(tftypeid);
	    JLabel lpublishdate = new JLabel("  ��������:");
		lpublishdate.setFont(new Font("����", Font.BOLD, 25));
	    lpublishdate.setForeground(Color.CYAN);
		panel1.add(lpublishdate);
		final JTextField tfpublishdate = new JTextField("");
		tfpublishdate.setFont(new Font("����", Font.BOLD, 25));
		tfpublishdate.setForeground(Color.darkGray);
		tfpublishdate.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfpublishdate);
		JLabel lpublishnum = new JLabel("  ��������:");
		lpublishnum.setFont(new Font("����", Font.BOLD, 25));
		lpublishnum.setForeground(Color.CYAN);
		panel1.add(lpublishnum);
		final JTextField tfpublishnum = new JTextField("");
		tfpublishnum.setFont(new Font("����", Font.BOLD, 25));
		tfpublishnum.setForeground(Color.darkGray);
		tfpublishnum.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfpublishnum);
		JLabel lpublish = new JLabel("   ������ :");
		lpublish.setFont(new Font("����", Font.BOLD, 25));
		lpublish.setForeground(Color.CYAN);
		panel1.add(lpublish);
		final JTextField tfpublish = new JTextField("");
		tfpublish.setFont(new Font("����", Font.BOLD, 25));
		tfpublish.setForeground(Color.darkGray);
		tfpublish.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfpublish);
		JLabel lprice = new JLabel("  ͼ��۸�:");
		lprice.setFont(new Font("����", Font.BOLD, 25));
		lprice.setForeground(Color.CYAN);
		panel1.add(lprice);
		final JTextField tfprice = new JTextField("");
		tfprice.setFont(new Font("����", Font.BOLD, 25));
		tfprice.setForeground(Color.darkGray);
		tfprice.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfprice);
		JLabel ltail = new JLabel("    --------------------------------------------------------------");
		ltail.setPreferredSize(new Dimension(d.getWidth(), 60));
		ltail.setFont(new Font("����", Font.BOLD, 20));
		ltail.setForeground(Color.ORANGE);
		panel1.add(ltail);
		//����ύ��ť
		JButton b = new JButton("�޸�");
		b.setFont(new Font("����", Font.BOLD, 25));
		b.setPreferredSize(new Dimension(120, 60));
		panel1.add(b);
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
		//ʹ��selection����������table���ĸ���Ŀ��ѡ��
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				//��ȡ��һ�б�ѡ����
				int row = table.getSelectedRow();
				//����ѡ�е��У���TableModel��ȥѡ����
				Book book = btm.lsbook.get(row);
				//�������Է����ı�����
				String isbn = book.getIsbn();
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
			}
		});
		//���ð�ť������
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ��ȡ�ı������Ϣ
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
					JOptionPane.showMessageDialog(d, "��Ϣ��д������");
				}else {
					try{
						int publishnum = Integer.parseInt(publishnum0);
						double price = Double.parseDouble(price0);
						Date publishdate = Date.valueOf(publishdate0);
						
						BookJDBC bj = new BookJDBC();
						BookTypeJDBC btj = new BookTypeJDBC();
						List<BookType> btlist = btj.list();
						int j;
						for(j=0; j<btlist.size(); j++){
							if(typeid.equals(btlist.get(j).getId())){
								//���ڣ������
								Book book = new Book(isbn, bookname, author, typeid, publishdate, publishnum, publish, price);
								bj.update(book);;
								//����tableModel����
								btm.lsbook = bj.list();
								//ˢ��
								table.updateUI();
								JOptionPane.showMessageDialog(d, "�޸ĳɹ�");
								break;
							}
						}
						if(j>=btlist.size()){
							JOptionPane.showMessageDialog(d, "��ͼ�����Ͳ����ڣ��������ͼ�����ͣ�");
						}
					}catch(NumberFormatException e1){
						JOptionPane.showMessageDialog(d, "����������ͼ��۸��ʽ����ȷ!");
					}catch(IllegalArgumentException e2){
						JOptionPane.showMessageDialog(d, "���ڸ�ʽ�����밴��xxxx-xx-xx�ĸ�ʽ��д!");
					}
				}
			}
		});
		
		d.setVisible(true);
	}
}
