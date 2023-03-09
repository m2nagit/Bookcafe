package GUI;

import bookcafe.Bookcafe;
import bookcafe.Member;
import bookcafe.MemberMgr;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;

public class MainScreen extends JFrame{

    public static void main(String[] args) {
		new MainScreen();
    }

	public MainScreen() {	

		setVisible(true);
		setTitle("북카페 메인");
		setResizable(false);
		setLocationRelativeTo(null); 
		final ImagePanel panel = new ImagePanel(new ImageIcon
				("/Users/kangminha/eclipse-workspace/Bookcafe2/src/image/wood.jpeg").getImage());
		setSize(640, 640);
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JLabel title = new JLabel("Bookcafe");
		title.setFont(new Font("Menlo", Font.BOLD | Font.ITALIC, 40));
		title.setBounds(218, 25, 210, 100);
		title.setHorizontalAlignment(SwingConstants.CENTER); 
		panel.add(title);
		
		JButton button1 = new JButton("     좌석");
		button1.setBackground(new Color(170, 121, 65));
		button1.setFont(new Font("Menlo", Font.BOLD | Font.ITALIC, 18));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SeatGui();
			}
		});
		button1.setBounds(50, 250, 150, 150);
		panel.add(button1);
		ImageIcon icon1 = new ImageIcon("/Users/kangminha/eclipse-workspace/Bookcafe2/src/image/seat.png");
		Image img1 = icon1.getImage();
		Image cImg1 = img1.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon cIcon1 = new ImageIcon(cImg1);
        JLabel la1 = new JLabel(cIcon1);
        button1.add(la1);
		
		JButton button2 = new JButton("     음식주문");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ItemOrderScreen();
			}
		});
		button2.setBounds(245, 250, 150, 150);
		button2.setFont(new Font("Menlo", Font.BOLD | Font.ITALIC, 18));
		panel.add(button2);
		ImageIcon icon2 = new ImageIcon("/Users/kangminha/eclipse-workspace/Bookcafe2/src/image/food.png");
		Image img2 = icon2.getImage();
		Image cImg2 = img2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon cIcon2 = new ImageIcon(cImg2);
        JLabel la2 = new JLabel(cIcon2);
        button2.add(la2);
		
		JButton button3 = new JButton("      책찾기");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new bookGUI();
			}
		});
		button3.setBounds(442, 250, 150, 150);
		button3.setFont(new Font("Menlo", Font.BOLD | Font.ITALIC, 18));
		panel.add(button3);
		ImageIcon icon3 = new ImageIcon("/Users/kangminha/eclipse-workspace/Bookcafe2/src/image/book.png");
		Image img3 = icon3.getImage();
		Image cImg3 = img3.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon cIcon3 = new ImageIcon(cImg3);
        JLabel la3 = new JLabel(cIcon3);
        button3.add(la3);
        
		JButton button4 = new JButton("    퇴실");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "퇴실처리 되었습니다.\n이용해주셔서 감사합니다.");
				dispose();
				new Login();
			}
		});
		button4.setBounds(442, 526, 150, 80);
		button4.setFont(new Font("Menlo", Font.BOLD | Font.ITALIC, 18));
		panel.add(button4);
		
		ImageIcon icon4 = new ImageIcon("/Users/kangminha/eclipse-workspace/Bookcafe2/src/image/exit.png");
		Image img4 = icon4.getImage();
		Image cImg4 = img4.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon cIcon4 = new ImageIcon(cImg4);
        JLabel la4 = new JLabel(cIcon4);
        button4.add(la4);


        LocalTime now = LocalTime.now();
        String time = (now.getHour()+"시"+now.getMinute()+"분");

		JLabel infoLabel = new JLabel("<html>회원이름 : "+MemberMgr.userName+"<br>입실시간 : "+time+"</html>");
		infoLabel.setFont(new Font("Menlo", Font.PLAIN, 18));
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER); 
		infoLabel.setBounds(440, 24, 200, 101);
		panel.add(infoLabel);
        
		setLocationRelativeTo(null);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}