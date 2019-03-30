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
		final JDialog d = new JDialog(f, "����", true);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		d.setSize(800, 600);
		d.setLocationRelativeTo(null);
		
		d.setLayout(new BorderLayout());
		
		//���һ�����������ı���ͱ�ǩ
		panel1.setBackground(Color.DARK_GRAY);
		panel1.setLayout(new FlowLayout());
		JLabel ltitle = new JLabel("    ---------------------------��ϸ��Ϣ----------------------------");
		ltitle.setPreferredSize(new Dimension(d.getWidth(), 60));
		ltitle.setFont(new Font("����", Font.BOLD, 20));
		ltitle.setForeground(Color.ORANGE);
		panel1.add(ltitle);
		JLabel lreadername = new JLabel("  ��������:");
		lreadername.setFont(new Font("����", Font.BOLD, 25));
		lreadername.setForeground(Color.CYAN);
		panel1.add(lreadername);
		final JTextField tfreadername = new JTextField("");
		tfreadername.setEditable(false);
		tfreadername.setFont(new Font("����", Font.BOLD, 25));
		tfreadername.setForeground(Color.darkGray);
		tfreadername.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfreadername);
		JLabel lreadertype = new JLabel("  ��������:");
		lreadertype.setFont(new Font("����", Font.BOLD, 25));
		lreadertype.setForeground(Color.CYAN);
		panel1.add(lreadertype);
		final JTextField tfreadertype = new JTextField("");
		tfreadertype.setEditable(false);
		tfreadertype.setFont(new Font("����", Font.BOLD, 25));
		tfreadertype.setForeground(Color.darkGray);
		tfreadertype.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfreadertype);
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
		JLabel lbooktype = new JLabel("  ͼ������:");
		lbooktype.setFont(new Font("����", Font.BOLD, 25));
		lbooktype.setForeground(Color.CYAN);
		panel1.add(lbooktype);
		final JTextField tfbooktype = new JTextField("");
		tfbooktype.setEditable(false);
		tfbooktype.setFont(new Font("����", Font.BOLD, 25));
		tfbooktype.setForeground(Color.darkGray);
		tfbooktype.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfbooktype);
		JLabel lborrowdate = new JLabel("  �ѽ�����:");
		lborrowdate.setFont(new Font("����", Font.BOLD, 25));
		lborrowdate.setForeground(Color.CYAN);
		panel1.add(lborrowdate);
		final JTextField tfborrowdate = new JTextField("");
		tfborrowdate.setEditable(false);
		tfborrowdate.setFont(new Font("����", Font.BOLD, 25));
		tfborrowdate.setForeground(Color.darkGray);
		tfborrowdate.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfborrowdate);
		JLabel ldaynum = new JLabel("  �ɽ�����:");
		ldaynum.setFont(new Font("����", Font.BOLD, 25));
		ldaynum.setForeground(Color.CYAN);
		panel1.add(ldaynum);
		final JTextField tfdaynum = new JTextField("");
		tfdaynum.setEditable(false);
		tfdaynum.setFont(new Font("����", Font.BOLD, 25));
		tfdaynum.setForeground(Color.darkGray);
		tfdaynum.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfdaynum);
		JLabel ltail = new JLabel("    ----------------------������ͼ����-----------------------");
		ltail.setPreferredSize(new Dimension(d.getWidth(), 30));
		ltail.setFont(new Font("����", Font.BOLD, 20));
		ltail.setForeground(Color.ORANGE);
		panel1.add(ltail);
		JLabel lrid = new JLabel("���߱��:");
		lrid.setFont(new Font("����", Font.BOLD, 25));
		lrid.setForeground(Color.CYAN);
		panel1.add(lrid);
		final JTextField tfrid = new JTextField("");
		tfrid.setEditable(false);
		tfrid.setFont(new Font("����", Font.BOLD, 25));
		tfrid.setForeground(Color.darkGray);
		tfrid.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfrid);
		JLabel lisbn = new JLabel("  ͼ����:");
		lisbn.setFont(new Font("����", Font.BOLD, 25));
		lisbn.setForeground(Color.CYAN);
		panel1.add(lisbn);
		final JTextField tfisbn = new JTextField("");
		tfisbn.setFont(new Font("����", Font.BOLD, 25));
		tfisbn.setForeground(Color.darkGray);
		tfisbn.setPreferredSize(new Dimension(180, 30));
		panel1.add(tfisbn);
		
		//��ӽ��鰴ť 
		JButton b = new JButton("����");
		b.setFont(new Font("����", Font.BOLD, 50));
		b.setPreferredSize(new Dimension(150, 60));
		panel1.add(b);
		JLabel ltail0 = new JLabel("    --------------------�����·�ѡ��Ҫ��ͼ��-----------------------");
		ltail0.setPreferredSize(new Dimension(d.getWidth(), 30));
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
		
		//ʹ��selection����������table���ĸ���Ŀ��ѡ��
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// ��ȡ��һ�б�ѡ����
				int row = table.getSelectedRow();
				//����ѡ�е��У���TableModel��ȥѡ����
				Book book = btm.lsbook.get(row);
				//��ͼ���ŷ����ı�����
				String isbn  =book.getIsbn();
				tfisbn.setText(isbn);
			}
		});
		
		//��ť������
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String isbn = tfisbn.getText();
				BookJDBC bj = new BookJDBC();
				List<Book> lsbook = bj.list();
				//�����ж������Ƿ�Ϊ��
				if(isbn.equals("")){
					JOptionPane.showMessageDialog(d, "����Ϊ�գ����������룡");
				}else{
					//Ȼ���ж������ͼ��ISBN�Ŵ治����
					int i;
					for(i=0; i<lsbook.size(); i++){
						if(isbn.equals(lsbook.get(i).getIsbn())){
							//���ڣ������ж��Ƿ��Ѿ��黹
							BorrowJDBC boj = new BorrowJDBC();
							List<Borrow> lsborrow = boj.list();
							int j;
							for(j=0 ;j<lsborrow.size(); j++){
								if(isbn.equals(lsborrow.get(j).getIsbn())){
									//δ�黹������ִ�й黹����
									//��ȡ������Ϣ�������ı�����
									//��ȡ���߱��
									String rid = lsborrow.get(j).getRid();
									tfrid.setText(rid);
							
									//��ȡ��������������
									ReaderJDBC rj = new ReaderJDBC();
									List<Reader> lsreader = rj.list();
									ReaderTypeJDBC rtj = new ReaderTypeJDBC();
									List<ReaderType> lsreadertype = rtj.list();
									int daynum0 = 0;
									for(int x=0; x<lsreader.size(); x++){
										if(rid.equals(lsreader.get(x).getRid())){
											String name = lsreader.get(x).getName();
											tfreadername.setText(name);
											//��ȡ���ߵ����ͺͿɽ�����
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
									//��ȡͼ�����ƺ�ͼ������
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
									//ִ�л������
									int option = JOptionPane.showConfirmDialog(d, "ȷ���黹��?");
									if(option==JOptionPane.OK_OPTION){
										long days0 = boj.returnBook(lsborrow.get(j));
										//���ѽ������ŵ��ı�����
										String borrowdate = String.valueOf(days0);
										tfborrowdate.setText(borrowdate);
										if(days0>daynum0){
											double fine = lsborrow.get(j).getFine()*(days0-daynum0);
											JOptionPane.showMessageDialog(d, "Ӧ�ɷ�"+fine+"Ԫ");
										}else{
											JOptionPane.showMessageDialog(d, "Ӧ�ɷ�0Ԫ");
										}
									}
									
									break;
								}
							}
							if(j>=lsborrow.size()){
								JOptionPane.showMessageDialog(d, "��ͼ���ѹ黹������������");
							}
							break;
						}
					}
					if(i>=lsbook.size()){
						JOptionPane.showMessageDialog(d, "��ͼ�鲻����,���������룡");
					}
				}
			}
		});
		d.setVisible(true);
	}
}
