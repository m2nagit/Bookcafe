package GUI;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import java.awt.Font;
import javax.swing.SwingConstants;

public class PayGui extends JFrame{

	public static void main(String[] args) {
		new PayGui();
	}

	 public PayGui() {

		setTitle("결제창");
		setVisible(true);

		setBounds(100, 100, 640, 640);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); 

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton btnNewButton_2 = new JButton();
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		btnNewButton_2.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton_2.setText("현금결제");
		btnNewButton_2.setBounds(100, 150, 200, 210);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PayMoney();
				dispose();
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButton_2);
		ImageIcon icon1 = new ImageIcon("/Users/kangminha/eclipse-workspace/Bookcafe2/src/image/money.png");
		Image img1 = icon1.getImage();
		Image cImg1 = img1.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		ImageIcon cIcon1 = new ImageIcon(cImg1);
        JLabel la1 = new JLabel(cIcon1);
        btnNewButton_2.add(la1);
		
		JButton btnNewButton_3 = new JButton();
		btnNewButton_3.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		btnNewButton_3.setText("카드결제");
		btnNewButton_3.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton_3.setBounds(335, 150, 200, 210);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PayCard();
				dispose();
			}
		});
		panel.add(btnNewButton_3);
		ImageIcon icon2 = new ImageIcon("/Users/kangminha/eclipse-workspace/Bookcafe2/src/image/card.png");
		Image img2 = icon2.getImage();
		Image cImg2 = img2.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		ImageIcon cIcon2 = new ImageIcon(cImg2);
        JLabel la2 = new JLabel(cIcon2);
        btnNewButton_3.add(la2);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("이전");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ItemOrderScreen();
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("확인");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		
		ImageIcon icon3 = new ImageIcon("/Users/kangminha/eclipse-workspace/Bookcafe2/src/image/pay.png");
		Image img3 = icon3.getImage();
		Image cImg3 = img3.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon cIcon3 = new ImageIcon(cImg3);
		

        JLabel la3 = new JLabel(cIcon3);
		panel_3.add(la3);
		
		JLabel lblNewLabel = new JLabel("결제");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		panel_2.add(lblNewLabel);
	}
}
