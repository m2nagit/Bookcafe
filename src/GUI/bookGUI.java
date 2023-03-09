package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class bookGUI extends JFrame {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new bookGUI();
	}

	 public bookGUI() {
		setVisible(true);
		setLocationRelativeTo(null); 
		setTitle("책 대여 기능");
		setBounds(100, 100, 600, 640);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null); 

		JButton B_button = new JButton("B 구역");
		B_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new bookGUI3(); // B구역 -> bookGUI3
			}
		});
		B_button.setBounds(480, 102, 80, 345);
		getContentPane().add(B_button);

		
		JPanel seat = new JPanel(); // 좌석 모양을 위해 추가한 부분
		seat.setBorder(new EmptyBorder(5, 5, 5, 5));
		seat.setSize(490, 440);
		seat.setBounds(50, 100, 401, 322);
		seat.setLayout(null);
		setButtons(seat);
		getContentPane().add(seat);
				
		JButton A_button = new JButton("A 구역");
		A_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new bookGUI2(); // A구역 -> bookGUI2
			}
		});
		A_button.setBounds(120, 10, 345, 70);
		getContentPane().add(A_button);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 686, 562);
		getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("←");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MainScreen();
			}
		});
		btnNewButton.setBounds(10, 574, 117, 29);
		getContentPane().add(btnNewButton);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	public void setButtons(Container contentPane) { //좌석 버튼 생성 
											// 클래스에서 가져오면 창이 팝업되어서 새로 생성함
		JButton a1 = new JButton("A-01");
		a1.setBackground(Color.LIGHT_GRAY);
		a1.setBounds(104, 97, 63, 36);
		contentPane.add(a1);
		a1.setEnabled(false);
		
		JButton a2 = new JButton("A-02");
		a2.setBackground(Color.LIGHT_GRAY);
		a2.setBounds(104, 143, 63, 36);
		contentPane.add(a2);
		a2.setEnabled(false);

		JButton a3 = new JButton("A-03");
		a3.setBackground(Color.LIGHT_GRAY);
		a3.setBounds(104, 189, 63, 36);
		contentPane.add(a3);
		a3.setEnabled(false);

		JButton a4 = new JButton("A-04");
		a4.setBackground(Color.LIGHT_GRAY);
		a4.setBounds(104, 235, 63, 36);
		contentPane.add(a4);
		a4.setEnabled(false);
		
		JButton a5 = new JButton("A-05");
		a5.setBackground(Color.LIGHT_GRAY);
		a5.setBounds(104, 281, 63, 36);
		contentPane.add(a5);
		a5.setEnabled(false);
		
		JButton a6 = new JButton("A-06");
		a6.setBackground(Color.LIGHT_GRAY);
		a6.setBounds(166, 97, 63, 36);
		contentPane.add(a6);
		a6.setEnabled(false);
		
		JButton a7 = new JButton("A-07");
		a7.setBackground(Color.LIGHT_GRAY);
		a7.setBounds(166, 143, 63, 36);
		contentPane.add(a7);
		a7.setEnabled(false);
		
		JButton a8 = new JButton("A-08");
		a8.setBackground(Color.LIGHT_GRAY);
		a8.setBounds(166, 189, 63, 36);
		contentPane.add(a8);
		a8.setEnabled(false);
		
		JButton a9 = new JButton("A-09");
		a9.setBackground(Color.LIGHT_GRAY);
		a9.setBounds(166, 235, 63, 36);
		contentPane.add(a9);
		a9.setEnabled(false);
		
		JButton a10 = new JButton("A-10");
		a10.setBackground(Color.LIGHT_GRAY);
		a10.setBounds(166, 281, 63, 36);
		contentPane.add(a10);
		a10.setEnabled(false);
		
		JButton b1 = new JButton("B-01");
		b1.setBackground(Color.LIGHT_GRAY);
		b1.setBounds(258, 97, 63, 36);
		contentPane.add(b1);
		b1.setEnabled(false);
		
		JButton b2 = new JButton("B-02");
		b2.setBackground(Color.LIGHT_GRAY);
		b2.setBounds(258, 143, 63, 36);
		contentPane.add(b2);
		b2.setEnabled(false);
		
		JButton b3 = new JButton("B-03");
		b3.setBackground(Color.LIGHT_GRAY);
		b3.setBounds(258, 189, 63, 36);
		contentPane.add(b3);
		b3.setEnabled(false);
		
		JButton b4 = new JButton("B-04");
		b4.setBackground(Color.LIGHT_GRAY);
		b4.setBounds(258, 235, 63, 36);
		contentPane.add(b4);
		b4.setEnabled(false);
		
		JButton b5 = new JButton("B-05");
		b5.setBackground(Color.LIGHT_GRAY);
		b5.setBounds(258, 281, 63, 36);
		contentPane.add(b5);
		b5.setEnabled(false);
		
		JButton b6 = new JButton("B-06");
		b6.setBackground(Color.LIGHT_GRAY);
		b6.setBounds(323, 97, 63, 36);
		contentPane.add(b6);
		b6.setEnabled(false);
		
		JButton b7 = new JButton("B-07");
		b7.setBackground(Color.LIGHT_GRAY);
		b7.setBounds(323, 143, 63, 36);
		contentPane.add(b7);
		b7.setEnabled(false);
		
		JButton b8 = new JButton("B-08");
		b8.setBackground(Color.LIGHT_GRAY);
		b8.setBounds(323, 189, 63, 36);
		contentPane.add(b8);
		b8.setEnabled(false);
		
		JButton b9 = new JButton("B-9");
		b9.setBackground(Color.LIGHT_GRAY);
		b9.setBounds(323, 235, 63, 36);
		contentPane.add(b9);
		b9.setEnabled(false);
		
		JButton b10 = new JButton("B-10");
		b10.setBackground(Color.LIGHT_GRAY);
		b10.setBounds(323, 281, 63, 36);
		contentPane.add(b10);
		b10.setEnabled(false);
	}
}
