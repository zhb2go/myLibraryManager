package library;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * ������
 */
public class MainMenu {
	public static void showMenu(){
		final String name = Login.username;
		final JFrame f = new JFrame("ͼ�����ϵͳ");
		f.setExtendedState(Frame.MAXIMIZED_BOTH);
		f.setSize(1200,800);
		//ʹ�������
		f.setLocationRelativeTo(null);
		//����ͼƬ��·��
		final String path = "picture/2.PNG";
		//ʹͼƬ����Ӧ���ڴ�С�仯
		JPanel iPanel = new JPanel(){
			private static final long serialVersionUID = 1L;
			public void paintComponent(Graphics g) {
				ImageIcon icon =new ImageIcon(path);
				g.drawImage(icon.getImage(), 0, 0, f.getSize().width,f.getSize().height,f);
			}
		};
		//�������뵽��������
		f.add(iPanel);
		
		//�˵���
		JMenuBar mb = new JMenuBar();
		//������Ϣ����˵�
		JMenu mreader = new JMenu("������Ϣ����");
		mreader.setFont(new Font("����", Font.BOLD, 20));
		JMenuItem addReader = new JMenuItem("���Ӷ�����Ϣ");
		addReader.setFont(new Font("����", Font.BOLD, 20));
		JMenuItem updateReader = new JMenuItem("�޸Ķ�����Ϣ");
		updateReader.setFont(new Font("����", Font.BOLD, 20));
		JMenuItem queryReader = new JMenuItem("��ѯ������Ϣ");
		queryReader.setFont(new Font("����", Font.BOLD, 20));
		JMenuItem deleteReader = new JMenuItem("ɾ��������Ϣ");
		deleteReader.setFont(new Font("����", Font.BOLD, 20));
		mreader.add(addReader);
		mreader.add(updateReader);
		mreader.add(queryReader);
		mreader.add(deleteReader);
		//���Ӷ�����Ϣ������
		addReader.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// �������Ӷ��߷���
				AddReader.add(f);
			}
		});
		//�޸Ķ�����Ϣ������
		updateReader.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// �����޸Ķ��߷���
				UpdateReader.update(f);
			}
		});
		//��ѯ������Ϣ������
		queryReader.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ���ò�ѯ���߷���
				QueryReader.query(f);
			}
		});
		//ɾ��������Ϣ������
		deleteReader.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//����ɾ�����߷���
				DeleteReader.delete(f);
			}
		});
		//ͼ����Ϣ����˵�
		JMenu mbook = new JMenu("ͼ����Ϣ����");
		mbook.setFont(new Font("����", Font.BOLD, 20));
		JMenuItem addBook = new JMenuItem("����ͼ����Ϣ");
		addBook.setFont(new Font("����", Font.BOLD, 20));
		JMenuItem updateBook = new JMenuItem("�޸�ͼ����Ϣ");
		updateBook.setFont(new Font("����", Font.BOLD, 20));
		JMenuItem queryBook = new JMenuItem("��ѯͼ����Ϣ");
		queryBook.setFont(new Font("����", Font.BOLD, 20));
		JMenuItem deleteBook = new JMenuItem("ɾ��ͼ����Ϣ");
		deleteBook.setFont(new Font("����", Font.BOLD, 20));
		mbook.add(addBook);
		mbook.add(updateBook);
		mbook.add(queryBook);
		mbook.add(deleteBook);
		//����ͼ����Ϣ������
		addBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ��������ͼ�鷽��
				AddBook.add(f);
			}
		});
		//�޸�ͼ����Ϣ������
		updateBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// �����޸�ͼ�鷽��
				UpdateBook.update(f);
			}
		});
		//��ѯͼ����Ϣ������
		queryBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ���ò�ѯͼ�鷽��
				QueryBook.query(f);
			}
		});
		//ɾ��ͼ����Ϣ������
		deleteBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ����ɾ��ͼ�鷽��
				DeleteBook.delete(f);
			}
		});
		//ͼ����Ĺ���˵�
		JMenu mborrow = new JMenu("ͼ����Ĺ���");
		mborrow.setFont(new Font("����", Font.BOLD, 20));
		JMenuItem borrowBook = new JMenuItem("ͼ�����");
		borrowBook.setFont(new Font("����", Font.BOLD, 20));
		JMenuItem returnBook = new JMenuItem("ͼ��黹");
		returnBook.setFont(new Font("����", Font.BOLD, 20));
		mborrow.add(borrowBook);
		mborrow.add(returnBook);
		//ͼ����ļ�����
		borrowBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//���ý��ķ���
				BorrowBook.borrow(f);
				
			}
		});
		//ͼ��黹������
		returnBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//���ù黹����
				ReturnBook.returnbook(f);
			}
		});
		//�û�����˵�
		JMenu muser = new JMenu("�û�����");
		muser.setFont(new Font("����", Font.BOLD, 20));
		JMenuItem updatePassword = new JMenuItem("�޸�����");
		updatePassword.setFont(new Font("����", Font.BOLD, 20));
		JMenuItem addUser = new JMenuItem("����û�");
		addUser.setFont(new Font("����", Font.BOLD, 20));
		JMenuItem deleteUser = new JMenuItem("ɾ���û�");
		deleteUser.setFont(new Font("����", Font.BOLD, 20));
		muser.add(updatePassword);
		muser.add(addUser);
		muser.add(deleteUser);
		//�޸����������
		updatePassword.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ����޸����뷽��
				UpdateUser.update(f);
			}
		});
		//����û�������
		addUser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ����û�����
				if(name.equals("zhb")){
					AddUser.add(f);
				}else{
					JOptionPane.showMessageDialog(f, "������˼��ֻ�й���Ա����Ȩ�ޣ�");
				}
				
			}
		});
		//ɾ���û�������
		deleteUser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ɾ���û�����
				if(name.equals("zhb")){
					DeleteUser.delete(f);
				}else{
					JOptionPane.showMessageDialog(f, "������˼��ֻ�й���Ա����Ȩ�ޣ�");
				}
				
			}
		});
		//��Ϣά���˵�
		JMenu minformation = new JMenu("��Ϣά��");
		minformation.setFont(new Font("����", Font.BOLD, 20));
		JMenu mbooktype = new JMenu("ͼ���������");
		mbooktype.setFont(new Font("����", Font.BOLD, 20));
		JMenuItem addBookType = new JMenuItem("����ͼ�������Ϣ");
		addBookType.setFont(new Font("����", Font.BOLD, 20));
		JMenuItem updateBookType = new JMenuItem("�޸�ͼ�������Ϣ");
		updateBookType.setFont(new Font("����", Font.BOLD, 20));
		JMenuItem queryBookType = new JMenuItem("��ѯͼ�������Ϣ");
		queryBookType.setFont(new Font("����", Font.BOLD, 20));
		JMenuItem deleteBookType = new JMenuItem("ɾ��ͼ�������Ϣ");
		deleteBookType.setFont(new Font("����", Font.BOLD, 20));
		mbooktype.add(addBookType);
		mbooktype.add(updateBookType);
		mbooktype.add(queryBookType);
		mbooktype.add(deleteBookType);
		JMenu mreadertype = new JMenu("�����������");
		mreadertype.setFont(new Font("����", Font.BOLD, 20));
		JMenuItem addReaderType = new JMenuItem("���Ӷ��������Ϣ");
		addReaderType.setFont(new Font("����", Font.BOLD, 20));
		JMenuItem updateReaderType = new JMenuItem("�޸Ķ��������Ϣ");
		updateReaderType.setFont(new Font("����", Font.BOLD, 20));
		JMenuItem queryReaderType = new JMenuItem("��ѯ���������Ϣ");
		queryReaderType.setFont(new Font("����", Font.BOLD, 20));
		JMenuItem deleteReaderType = new JMenuItem("ɾ�����������Ϣ");
		deleteReaderType.setFont(new Font("����", Font.BOLD, 20));
		mreadertype.add(addReaderType);
		mreadertype.add(updateReaderType);
		mreadertype.add(queryReaderType);
		mreadertype.add(deleteReaderType);
		
		minformation.add(mbooktype);
		minformation.add(mreadertype);
		
		//����ͼ�������Ϣ������
		addBookType.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ����ͼ����𷽷�
				AddBookType.add(f);
			}
		});
		//�޸�ͼ�������Ϣ������
		updateBookType.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// �޸�ͼ����𷽷�
				UpdateBookType.update(f);
			}
		});
		//��ѯͼ�������Ϣ������
		queryBookType.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ��ѯͼ����𷽷�
				QueryBookType.query(f);
			}
		});
		//ɾ��ͼ�������Ϣ������
		deleteBookType.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ɾ��ͼ����𷽷�
				DeleteBookType.delete(f);
				
			}
		});
		//���Ӷ��������Ϣ������
		addReaderType.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ���Ӷ�����𷽷�
				AddReaderType.add(f);
			}
		});
		//�޸Ķ��������Ϣ������
		updateReaderType.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// �޸Ķ�����𷽷�
				UpdateReaderType.update(f);
			}
		});
		//��ѯ���������Ϣ������
		queryReaderType.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ��ѯ������𷽷�
				QueryReaderType.query(f);
			}
		});
		//ɾ�����������Ϣ������
		deleteReaderType.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ɾ��������𷽷�
				DeleteReaderType.delete(f);
			}
		});
		//�˳�ϵͳ�˵�
		JMenu mexit = new JMenu("�˳�ϵͳ");
		mexit.setFont(new Font("����", Font.BOLD, 20));
		JMenuItem exit = new JMenuItem("�˳�ϵͳ");
		exit.setFont(new Font("����", Font.BOLD, 20));
		mexit.add(exit);
		//�˳�ϵͳ�˵�������
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int option = JOptionPane.showConfirmDialog(f, "ȷ��Ҫ�˳�ϵͳ��");
				if(option==JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}
		});
		//�Ѳ˵����뵽�˵���
		mb.add(mreader);
		mb.add(mbook);
		mb.add(mborrow);
		mb.add(muser);
		mb.add(minformation);
		mb.add(mexit);
		//�Ѳ˵������뵽frame��
		f.setJMenuBar(mb);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
