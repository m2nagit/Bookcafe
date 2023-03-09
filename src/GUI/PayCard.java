package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PayCard extends JFrame{

	private JTextField textField_1;

	public static void main(String[] args) {
		new PayCard();
	}

	 public PayCard() {
		setTitle("결제창");
		setVisible(true);

		setBounds(100, 100, 320, 320);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.NORTH);
		setLocationRelativeTo(null); 

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);

		ImageIcon icon1 = new ImageIcon("/Users/kangminha/eclipse-workspace/Bookcafe2/src/image/card.png");
		Image img = icon1.getImage();
		Image cImg = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon cIcon = new ImageIcon(cImg);

		JLabel la1 = new JLabel(cIcon);
		panel_3.add(la1);

		JLabel lblNewLabel = new JLabel("카드결제");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		panel_2.add(lblNewLabel);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("총 결제금액");
		lblNewLabel_1.setBounds(65, 40, 61, 16);
		panel.add(lblNewLabel_1);

		textField_1 = new JTextField("" + ItemOrderScreen.totalSum);
		textField_1.setBounds(135, 35, 130, 26);
		textField_1.setColumns(10);
		textField_1.setEnabled(false);
		panel.add(textField_1);

		JLabel lblNewLabel_2 = new JLabel("카드를 투입구에 넣어주세요.");
		lblNewLabel_2.setBounds(65, 120, 200, 16);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER); 
		panel.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("이전");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PayGui();
				dispose();
			}
		});
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("확인");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "결제가 완료되었습니다.. \n감사합니다.");
				dispose();
				new MainScreen();
			}
		});
		panel_1.add(btnNewButton_1);
	}

}
