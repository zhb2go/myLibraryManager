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
 * 主界面
 */
public class MainMenu {
	public static void showMenu(){
		final String name = Login.username;
		final JFrame f = new JFrame("图书管理系统");
		f.setExtendedState(Frame.MAXIMIZED_BOTH);
		f.setSize(1200,800);
		//使窗体居中
		f.setLocationRelativeTo(null);
		//背景图片的路径
		final String path = "picture/2.PNG";
		//使图片自适应窗口大小变化
		JPanel iPanel = new JPanel(){
			private static final long serialVersionUID = 1L;
			public void paintComponent(Graphics g) {
				ImageIcon icon =new ImageIcon(path);
				g.drawImage(icon.getImage(), 0, 0, f.getSize().width,f.getSize().height,f);
			}
		};
		//将面板加入到主窗体中
		f.add(iPanel);
		
		//菜单栏
		JMenuBar mb = new JMenuBar();
		//读者信息管理菜单
		JMenu mreader = new JMenu("读者信息管理");
		mreader.setFont(new Font("楷体", Font.BOLD, 20));
		JMenuItem addReader = new JMenuItem("增加读者信息");
		addReader.setFont(new Font("楷体", Font.BOLD, 20));
		JMenuItem updateReader = new JMenuItem("修改读者信息");
		updateReader.setFont(new Font("楷体", Font.BOLD, 20));
		JMenuItem queryReader = new JMenuItem("查询读者信息");
		queryReader.setFont(new Font("楷体", Font.BOLD, 20));
		JMenuItem deleteReader = new JMenuItem("删除读者信息");
		deleteReader.setFont(new Font("楷体", Font.BOLD, 20));
		mreader.add(addReader);
		mreader.add(updateReader);
		mreader.add(queryReader);
		mreader.add(deleteReader);
		//增加读者信息监听器
		addReader.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 调用增加读者方法
				AddReader.add(f);
			}
		});
		//修改读者信息监听器
		updateReader.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 调用修改读者方法
				UpdateReader.update(f);
			}
		});
		//查询读者信息监听器
		queryReader.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 调用查询读者方法
				QueryReader.query(f);
			}
		});
		//删除读者信息监听器
		deleteReader.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//调用删除读者方法
				DeleteReader.delete(f);
			}
		});
		//图书信息管理菜单
		JMenu mbook = new JMenu("图书信息管理");
		mbook.setFont(new Font("楷体", Font.BOLD, 20));
		JMenuItem addBook = new JMenuItem("增加图书信息");
		addBook.setFont(new Font("楷体", Font.BOLD, 20));
		JMenuItem updateBook = new JMenuItem("修改图书信息");
		updateBook.setFont(new Font("楷体", Font.BOLD, 20));
		JMenuItem queryBook = new JMenuItem("查询图书信息");
		queryBook.setFont(new Font("楷体", Font.BOLD, 20));
		JMenuItem deleteBook = new JMenuItem("删除图书信息");
		deleteBook.setFont(new Font("楷体", Font.BOLD, 20));
		mbook.add(addBook);
		mbook.add(updateBook);
		mbook.add(queryBook);
		mbook.add(deleteBook);
		//增加图书信息监听器
		addBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 调用增加图书方法
				AddBook.add(f);
			}
		});
		//修改图书信息监听器
		updateBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 调用修改图书方法
				UpdateBook.update(f);
			}
		});
		//查询图书信息监听器
		queryBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 调用查询图书方法
				QueryBook.query(f);
			}
		});
		//删除图书信息监听器
		deleteBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 调用删除图书方法
				DeleteBook.delete(f);
			}
		});
		//图书借阅管理菜单
		JMenu mborrow = new JMenu("图书借阅管理");
		mborrow.setFont(new Font("楷体", Font.BOLD, 20));
		JMenuItem borrowBook = new JMenuItem("图书借阅");
		borrowBook.setFont(new Font("楷体", Font.BOLD, 20));
		JMenuItem returnBook = new JMenuItem("图书归还");
		returnBook.setFont(new Font("楷体", Font.BOLD, 20));
		mborrow.add(borrowBook);
		mborrow.add(returnBook);
		//图书借阅监听器
		borrowBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//调用借阅方法
				BorrowBook.borrow(f);
				
			}
		});
		//图书归还监听器
		returnBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//调用归还方法
				ReturnBook.returnbook(f);
			}
		});
		//用户管理菜单
		JMenu muser = new JMenu("用户管理");
		muser.setFont(new Font("楷体", Font.BOLD, 20));
		JMenuItem updatePassword = new JMenuItem("修改密码");
		updatePassword.setFont(new Font("楷体", Font.BOLD, 20));
		JMenuItem addUser = new JMenuItem("添加用户");
		addUser.setFont(new Font("楷体", Font.BOLD, 20));
		JMenuItem deleteUser = new JMenuItem("删除用户");
		deleteUser.setFont(new Font("楷体", Font.BOLD, 20));
		muser.add(updatePassword);
		muser.add(addUser);
		muser.add(deleteUser);
		//修改密码监听器
		updatePassword.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 添加修改密码方法
				UpdateUser.update(f);
			}
		});
		//添加用户监听器
		addUser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 添加用户方法
				if(name.equals("zhb")){
					AddUser.add(f);
				}else{
					JOptionPane.showMessageDialog(f, "不好意思，只有管理员才有权限！");
				}
				
			}
		});
		//删除用户监听器
		deleteUser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 删除用户方法
				if(name.equals("zhb")){
					DeleteUser.delete(f);
				}else{
					JOptionPane.showMessageDialog(f, "不好意思，只有管理员才有权限！");
				}
				
			}
		});
		//信息维护菜单
		JMenu minformation = new JMenu("信息维护");
		minformation.setFont(new Font("楷体", Font.BOLD, 20));
		JMenu mbooktype = new JMenu("图书类别设置");
		mbooktype.setFont(new Font("楷体", Font.BOLD, 20));
		JMenuItem addBookType = new JMenuItem("增加图书类别信息");
		addBookType.setFont(new Font("楷体", Font.BOLD, 20));
		JMenuItem updateBookType = new JMenuItem("修改图书类别信息");
		updateBookType.setFont(new Font("楷体", Font.BOLD, 20));
		JMenuItem queryBookType = new JMenuItem("查询图书类别信息");
		queryBookType.setFont(new Font("楷体", Font.BOLD, 20));
		JMenuItem deleteBookType = new JMenuItem("删除图书类别信息");
		deleteBookType.setFont(new Font("楷体", Font.BOLD, 20));
		mbooktype.add(addBookType);
		mbooktype.add(updateBookType);
		mbooktype.add(queryBookType);
		mbooktype.add(deleteBookType);
		JMenu mreadertype = new JMenu("读者类别设置");
		mreadertype.setFont(new Font("楷体", Font.BOLD, 20));
		JMenuItem addReaderType = new JMenuItem("增加读者类别信息");
		addReaderType.setFont(new Font("楷体", Font.BOLD, 20));
		JMenuItem updateReaderType = new JMenuItem("修改读者类别信息");
		updateReaderType.setFont(new Font("楷体", Font.BOLD, 20));
		JMenuItem queryReaderType = new JMenuItem("查询读者类别信息");
		queryReaderType.setFont(new Font("楷体", Font.BOLD, 20));
		JMenuItem deleteReaderType = new JMenuItem("删除读者类别信息");
		deleteReaderType.setFont(new Font("楷体", Font.BOLD, 20));
		mreadertype.add(addReaderType);
		mreadertype.add(updateReaderType);
		mreadertype.add(queryReaderType);
		mreadertype.add(deleteReaderType);
		
		minformation.add(mbooktype);
		minformation.add(mreadertype);
		
		//增加图书类别信息监听器
		addBookType.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 增加图书类别方法
				AddBookType.add(f);
			}
		});
		//修改图书类别信息监听器
		updateBookType.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 修改图书类别方法
				UpdateBookType.update(f);
			}
		});
		//查询图书类别信息监听器
		queryBookType.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 查询图书类别方法
				QueryBookType.query(f);
			}
		});
		//删除图书类别信息监听器
		deleteBookType.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 删除图书类别方法
				DeleteBookType.delete(f);
				
			}
		});
		//增加读者类别信息监听器
		addReaderType.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 增加读者类别方法
				AddReaderType.add(f);
			}
		});
		//修改读者类别信息监听器
		updateReaderType.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 修改读者类别方法
				UpdateReaderType.update(f);
			}
		});
		//查询读者类别信息监听器
		queryReaderType.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 查询读者类别方法
				QueryReaderType.query(f);
			}
		});
		//删除读者类别信息监听器
		deleteReaderType.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 删除读者类别方法
				DeleteReaderType.delete(f);
			}
		});
		//退出系统菜单
		JMenu mexit = new JMenu("退出系统");
		mexit.setFont(new Font("楷体", Font.BOLD, 20));
		JMenuItem exit = new JMenuItem("退出系统");
		exit.setFont(new Font("楷体", Font.BOLD, 20));
		mexit.add(exit);
		//退出系统菜单监听器
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int option = JOptionPane.showConfirmDialog(f, "确定要退出系统？");
				if(option==JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}
		});
		//把菜单加入到菜单栏
		mb.add(mreader);
		mb.add(mbook);
		mb.add(mborrow);
		mb.add(muser);
		mb.add(minformation);
		mb.add(mexit);
		//把菜单栏加入到frame中
		f.setJMenuBar(mb);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
