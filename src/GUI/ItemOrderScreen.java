package GUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import bookcafe.Item;
import bookcafe.ItemMgr;

public class ItemOrderScreen extends JFrame{
	int count = 0;
	Scanner scan = new Scanner(System.in);
	int sum = 0;
	public static int totalSum = 0;
	ItemMgr IM = new ItemMgr();

	public ItemOrderScreen() {
		setBounds(0, 0, 750, 740);
		setBackground(Color.black);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null); 

		final ImagePanel panel = new ImagePanel(new ImageIcon("/Users/kangminha/eclipse-workspace/Bookcafe2/src/image/wood2.jpeg").getImage());
		getContentPane().add(panel, BorderLayout.SOUTH);
		setSize(750, 740);
		
		Panel North = new Panel();
		North.setLayout(null);
		North.setSize(750, 500);
		
		String[] menuList = { "에스프레소", "아메리카노", " 카페라떼", " 페퍼민트", " 캐모마일", "레몬에이드", "  크로플", " 쿠키세트", " 비스킷슈", "허니브레드"};
		int price[] = { 3000, 3500, 4000, 4000, 4000, 4000, 3800, 4500, 2300, 5000};
		JButton button[] = new JButton[menuList.length];
		TextField subject[] = new TextField[menuList.length];
		Button minus[] = new Button[menuList.length];
		Button plus[] = new Button[menuList.length];
		JButton check[] = new JButton[menuList.length];
		Label label[] = new Label[menuList.length];
		Label label2[] = new Label[menuList.length];
		ImageIcon icon[] = new ImageIcon[menuList.length];

		for (int i = 0; i < menuList.length; i++) {
			button[i] = new JButton();
			if (i < 5) {
				button[i].setBounds(25 + i * 150, 50, 100, 100);
			} else {
				button[i].setBounds(25 + (i - 5) * 150, 300, 100, 100);
			}

			icon[i] = new ImageIcon("/Users/kangminha/eclipse-workspace/Bookcafe2/src/image/" + i + ".png");
			button[i].setIcon(icon[i]);

			subject[i] = new TextField("0");
			subject[i].setBackground(Color.white);
			subject[i].setEditable(false);
			subject[i].setBounds(button[i].getX() + 30, button[i].getY() + 130, 40, 20);

			minus[i] = new Button("-");
			minus[i].setBounds(button[i].getX(), subject[i].getY(), 20, 20);
			minus[i].setEnabled(false);

			plus[i] = new Button("+");
			plus[i].setBounds(button[i].getX() + (100 - 20), subject[i].getY(), 20, 20);
			plus[i].setEnabled(false);

			label[i] = new Label("       "+price[i] + "원");
			label[i].setBounds(button[i].getX(), subject[i].getY() - 25, 100, 20);
			
			label2[i] = new Label("      "+menuList[i]);
			label2[i].setBounds(button[i].getX(), subject[i].getY() - 150, 100, 20);
			
			check[i] = new JButton("확인");
			check[i].setBounds(button[i].getX(), subject[i].getY() + 30, 100, 20);
			check[i].setEnabled(false);

			North.add(button[i]);
			North.add(subject[i]);
			North.add(minus[i]);
			North.add(plus[i]);
			North.add(label[i]);
			North.add(check[i]);
			North.add(label2[i]);
					
			panel.add(button[i]);
			panel.add(subject[i]);
			panel.add(minus[i]);
			panel.add(plus[i]);
			panel.add(label[i]);
			panel.add(check[i]);
			panel.add(label2[i]);
		}
		
		Panel South = new Panel();
		TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
		ta.setText("        상품명           가격           수량           합계\n\n");
		ta.setBackground(Color.white);
		ta.setEditable(false);

		Button button1 = new Button("주문");
		Button button2 = new Button("초기화");
		Button button3 = new Button("뒤로");
		South.add(button1);
		South.add(button2);
		South.add(button3);
		

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, ta.getText() + "\n\n확인버튼을 누르면 결제화면으로 넘어갑니다.");
				for (int i = 0; i < menuList.length; i++) {
					button[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					subject[i].setText("0");
					ta.setText("        상품명          가격       수량       합계\n\n");
				}
				new PayGui();
				setVisible(false);
			}
		});

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < menuList.length; i++) {
					button[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					subject[i].setText("0");
					ta.setText("        상품명          가격       수량       합계\n\n");
				}
			}
		});

		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainScreen();
				setVisible(false);
			}
		});

		add(North, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		add(South, BorderLayout.SOUTH);
		setVisible(true);

		for (int i = 0; i < menuList.length; i++) {
			int j = i;
			
			button[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					minus[j].setEnabled(true);
					plus[j].setEnabled(true);
					button[j].setEnabled(false);
					check[j].setEnabled(true);
					count = 0;
				}
			});
			
			minus[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (count > 0) {
						count = count - 1;
						subject[j].setText(count + "");
						check[j].setEnabled(true);
					} else {
						minus[j].setEnabled(false);
					}
				}
			});

			plus[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					count = count + 1;
					subject[j].setText(count + "");
					check[j].setEnabled(true);
					if (count > 0) {
						minus[j].setEnabled(true);
					}
				}
			});

			check[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Label show = label2[j];
					sum = price[j] * count;

					ta.append(show.getText() + "       " + price[j] + "        " + count + "         " + sum + "원" + "\n");
					check[j].setEnabled(false);
					totalSum += sum;
				}
			});
		}

	}

	public static void main(String[] args) {
		new ItemOrderScreen();
	}
}