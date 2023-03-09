package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import bookcafe.Book;
import bookcafe.BookMgr;

public class bookGUI2 extends JFrame implements ActionListener, ListSelectionListener{
	
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JLabel cantRead;
	private JTable table;
	private JTable table_1;
	private JButton takebook;
	private JButton returnbook;
	private JButton previousButton;
	private JScrollPane scrollPane;
	BookMgr BM = new BookMgr();
	
	public static void main(String[] args) {
		new bookGUI2();
	}

	String columnNames[] = { "책 이름", "출판사", "출판년도", "책 개수", "분류기호", "저자" };
	DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0){  
 		 // 셀 수정 못하게 하는 부분
 		 public boolean isCellEditable(int row, int column){
 			    return false;
 		 }
		};
	DefaultTableModel tableModel2 = new DefaultTableModel(columnNames, 0){  
	 	// 셀 수정 못하게 하는 부분
	 	public boolean isCellEditable(int row, int column){
		    return false;
	 	}
	};

	void filltable() {
				//대여 가능 테이블 채우기
				for (Book b : BM.Abooks) {
					if(b.bookset > 0)
		   				tableModel.addRow(b.getUiTexts());
				}
				
				//대여 불가 테이블 채우기
				for(Book b : BM.Abooks) {
					if(b.bookset <= 0)
						tableModel2.addRow(b.getUiTexts());
				}
	}
	
	public bookGUI2() {
		setTitle("책 대여 기능");
		setVisible(true); // 추가
		//setLocationRelativeTo(null); 
		//setBounds(100, 100, 690, 600);
		setSize(690, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
        Dimension frameSize = getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2,
                (windowSize.height - frameSize.height) / 2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
		JPanel panel = new JPanel();
		panel.setBounds(15, 10, 686, 563);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel canRead = new JLabel("대여 불가 목록");
		canRead.setBounds(0, 236, 202, 27);
		panel.add(canRead);
		cantRead = new JLabel("대여 가능 목록");
		cantRead.setBounds(0, 0, 202, 27);
		panel.add(cantRead);
		
		BM.readAll("book.txt");
		
		filltable();
		
   		table = new JTable(tableModel);
		table.setPreferredScrollableViewportSize(new Dimension(674,200));
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel rowSM = table.getSelectionModel();
		rowSM.addListSelectionListener(this);
		
		JPanel table1Panel = new JPanel(new BorderLayout());
		table1Panel.setBounds(0, 26, 658, 200);
		scrollPane = new JScrollPane(table);
		table1Panel.add(scrollPane,BorderLayout.CENTER);
		panel.add(table1Panel);
		
		table_1 = new JTable(tableModel2);
		table_1.setPreferredScrollableViewportSize(new Dimension(674,200));
		table_1.setFillsViewportHeight(true);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JPanel table2Panel = new JPanel(new BorderLayout());
		table2Panel.setBounds(0, 262, 658, 200);
		scrollPane = new JScrollPane(table_1);
		table2Panel.add(scrollPane,BorderLayout.CENTER);
		panel.add(table2Panel);
		
		takebook = new JButton("대여");
		takebook.setBounds(67, 500, 164, 36);
		takebook.addActionListener(this);
		panel.add(takebook);
		
		returnbook = new JButton("반납");
		returnbook.setBounds(450, 500, 172, 36);
		returnbook.addActionListener(this);
		panel.add(returnbook);
		
		previousButton = new JButton("←");
		previousButton.addActionListener(this); 
		previousButton.setBounds(0, 534, 117, 29);
		panel.add(previousButton);
		}

	@Override
	public void valueChanged(ListSelectionEvent e) {
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("대여")) {
			DefaultTableModel data = (DefaultTableModel)(table.getModel());
			int row = table.getSelectedRow();
			String value = (String) table.getValueAt(row, 0); 
			for(Book b : BM.Abooks) {
				if((b.name).equals(value))
					b.borrowBook();
			}
			tableModel.setRowCount(0);
			tableModel2.setRowCount(0);
			filltable();
		}
		
		else if (e.getActionCommand().equals("반납")) {
			DefaultTableModel data = (DefaultTableModel)(table_1.getModel());
			int row = table_1.getSelectedRow();
			String value = (String) table_1.getValueAt(row, 0);
			for(Book b : BM.Abooks) {
				if((b.name).equals(value))
					b.returnBook();
			}
			tableModel.setRowCount(0);
			tableModel2.setRowCount(0);
			filltable();
		}
		
		else {
			dispose();
			new bookGUI();
		}
	}
	
}

