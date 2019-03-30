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
		JLabel lborrowdate = new JLabel("  ��������:");
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
		JLabel ltail = new JLabel("    -------------------��������߱�ź�ͼ����---------------------");
		ltail.setPreferredSize(new Dimension(d.getWidth(), 30));
		ltail.setFont(new Font("����", Font.BOLD, 20));
		ltail.setForeground(Color.ORANGE);
		panel1.add(ltail);
		JLabel lrid = new JLabel("���߱��:");
		lrid.setFont(new Font("����", Font.BOLD, 25));
		lrid.setForeground(Color.CYAN);
		panel1.add(lrid);
		final JTextField tfrid = new JTextField("");
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
		
		//���ð�ť������
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ��ȡ�ı����е�����
				String rid = tfrid.getText();
				String isbn = tfisbn.getText();
				int maxnum = 0;
				//�ж��Ƿ�Ϊ��
				if(rid.equals("")||isbn.equals("")){
					JOptionPane.showMessageDialog(d, "��Ϣ���벻����");
				}else{
					//��Ϊ��,���ı���������д����
					//����
					ReaderJDBC rj = new ReaderJDBC();
					List<Reader> lsreader = rj.list();
					ReaderTypeJDBC rtj = new ReaderTypeJDBC();
					List<ReaderType> lsreadertype = rtj.list();
					int i;
					for(i=0; i<lsreader.size(); i++){
						if(rid.equals(lsreader.get(i).getRid())){
							//���ߴ���ʱ��������ͬ�Ķ��߱�Ż�ȡ��������
							tfreadername.setText(lsreader.get(i).getName());
							//���ݶ������ͱ������ȡ��������
							for(int j=0; j<lsreadertype.size(); j++){
								if(lsreader.get(i).getTypeid().equals(lsreadertype.get(j).getId())){
									//��ȡ��������
									tfreadertype.setText(lsreadertype.get(j).getTypename());
									//��ȡ����
									tfdaynum.setText(String.valueOf(lsreadertype.get(j).getDaynum()));
									//��ȡ�ö������Ϳɽ�ͼ������
									maxnum = lsreadertype.get(j).getMaxborrownum();
									break;
								}
							}
							//�ڶ��ߴ��ڵ�ǰ���£�ȥ��ȡͼ��
							//ͼ��
							BookJDBC bj = new BookJDBC();
							List<Book> lsbook = bj.list();
							BookTypeJDBC btj = new BookTypeJDBC();
							List<BookType> lsbooktype = btj.list();
							int x;
							for(x=0; x<lsbook.size(); x++){
								if(isbn.equals(lsbook.get(x).getIsbn())){
									//�ж�ͼ���Ƿ��Ѿ����
									BorrowJDBC boj = new BorrowJDBC();
									List<Borrow> lsborrow = boj.list();
									int t;
									for(t=0; t<lsborrow.size(); t++){
										if(isbn.equals(lsborrow.get(t).getIsbn())){
											break;
										}
									}
									//��ȡ�ö��ߵ�ǰ�ٽ�����
									int num=0;
									for(int y=0; y<lsborrow.size(); y++){
										if(rid.equals(lsborrow.get(y).getRid())){
											num++;
										}
									}
									//ͼ�����ʱ��������ͬ��ISBN������ȡͼ������
									tfbookname.setText(lsbook.get(x).getBookname());
									//����ͼ�����ͱ������ȡͼ����������
									for(int y=0; y<lsbooktype.size(); y++){
										if(lsbook.get(x).getTypeid().equals(lsbooktype.get(y).getId())){
											tfbooktype.setText(lsbooktype.get(y).getTypename());
											break;
										}
									}
									//�ڶ��ߺ�ͼ�鶼���ڵ�����£�ȥ��ȡ���ں�����
									//����Ϊ��ǰ����
									Date borrowdate0 = new Date(System.currentTimeMillis());
									//ת��Ϊ�ַ���
									String borrowdate = borrowdate0.toString();
									//���뵽�ı���
									tfborrowdate.setText(borrowdate);
									//�ı������֮�󣬿�ʼִ�н������
									if(maxnum>num){
										if(t<lsborrow.size()){
											JOptionPane.showMessageDialog(d, "������˼��ͼ���Ѿ����");
										}else{
											int option = JOptionPane.showConfirmDialog(d, "ȷ��������");
											if(option==JOptionPane.OK_OPTION){
												//����
												boj.borrowBook(lsreader.get(i), lsbook.get(x));
												JOptionPane.showMessageDialog(d, "���ĳɹ�");
												int n = maxnum-num-1;
												JOptionPane.showMessageDialog(d, "�������ٽ�"+n+"��");
											}
										}
									}
									break;
								}
							}
							if(x>=lsbook.size()){
								JOptionPane.showMessageDialog(d, "�����ڸ�ͼ��");
							}
							break;
						}
					}
					if(i>=lsreader.size()){
						JOptionPane.showMessageDialog(d, "�����ڸö���!");
					}
				}
			}
		});
		d.setVisible(true);
	}
}
