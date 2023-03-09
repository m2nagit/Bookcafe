package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import bookcafe.MemberMgr;

@SuppressWarnings("serial")
public class MembershipScreen extends JPanel {
	JTextField[] kwdTextField = new JTextField[7];
	String[] kwdList = { "고유번호    ", "비밀번호    ", "이름          ", "핸드폰       ", "생년월일    " };


	static void createAndShowGui() {
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null); 
		frame.setSize(600, 800);

        Dimension frameSize = frame.getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((windowSize.width - frameSize.width) / 2,
                (windowSize.height - frameSize.height) / 2);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MembershipScreen membershipScreen = new MembershipScreen();
		membershipScreen.setupScreen();
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
		JButton back = new JButton("←");
		back.setBackground(Color.DARK_GRAY);
		//back.setForeground(Color.white);
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getActionCommand().equals("←")) {
					frame.dispose();
					new Login();
				}
			}
		});
		topPanel.add(back);
		frame.add(topPanel,BorderLayout.NORTH);
		frame.add(membershipScreen,BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}

	void setupScreen() {
		setLayout(new BorderLayout());
		JPanel topPane = new JPanel();
		topPane.setLayout(new BorderLayout());
		JLabel mem = new JLabel("회원가입");
		mem.setFont(new Font("맑은 고딕", 0, 45));
		mem.setHorizontalAlignment(SwingConstants.CENTER);
		topPane.add(mem, BorderLayout.CENTER);

		JLabel topextraLabel[] = new JLabel[4];
		for (int i = 0; i < 3; i++) {
			topextraLabel[i] = new JLabel("      ");
			topextraLabel[i].setFont(new Font("맑은 고딕", 0, 30));
		}
		JLabel topexboLabel = new JLabel("      ");
		topexboLabel.setFont(new Font("맑은 고딕", 0, 30));

		topPane.add(topextraLabel[0], BorderLayout.NORTH);
		topPane.add(topextraLabel[1], BorderLayout.SOUTH);
		topPane.add(topextraLabel[2], BorderLayout.EAST);

		JPanel westInLabel = new JPanel();
		westInLabel.setLayout(new BorderLayout());
		JPanel westbuttonPanel = new JPanel();

		westInLabel.add(westbuttonPanel, BorderLayout.NORTH);
		westInLabel.add(topexboLabel, BorderLayout.CENTER);
		topPane.add(westInLabel, BorderLayout.WEST);
		JLabel label[] = new JLabel[5];

		JPanel middlePane[] = new JPanel[5];
		for (int i = 0; i < 4; i++) {
			middlePane[i] = new JPanel();
			middlePane[i].setLayout(new BoxLayout(middlePane[i], BoxLayout.X_AXIS));
			label[i] = new JLabel(kwdList[i]);
			label[i].setFont(new Font("맑은 고딕", 0, 20));
			middlePane[i].add(label[i]);
			kwdTextField[i] = new JTextField("", 20);
			middlePane[i].add(kwdTextField[i]);
		}

		middlePane[4] = new JPanel();
		label[4] = new JLabel(kwdList[4]);
		label[4].setFont(new Font("맑은 고딕", 0, 20));
		middlePane[4].add(label[4]);
		middlePane[4].setLayout(new BoxLayout(middlePane[4], BoxLayout.X_AXIS));
		for (int i = 4; i < 7; i++) {
			kwdTextField[i] = new JTextField("", 6);
			middlePane[4].add(kwdTextField[i]);
		}

		JPanel extraPane[] = new JPanel[5];
		JLabel extraLabel[] = new JLabel[5];
		for (int i = 0; i < 5; i++) {
			extraPane[i] = new JPanel();
			extraPane[i].setLayout(new BorderLayout());
			extraLabel[i] = new JLabel("      ");
			extraLabel[i].setFont(new Font("맑은 고딕", 0, 20));
			extraPane[i].add(extraLabel[i]);
		}

		JPanel allMiddlePane = new JPanel();
		allMiddlePane.setLayout(new BoxLayout(allMiddlePane, BoxLayout.Y_AXIS));
		for (int i = 0; i < 5; i++) {
			allMiddlePane.add(middlePane[i]);
			allMiddlePane.add(extraPane[i]);
		}

		JPanel bottomPane = new JPanel();
		bottomPane.setLayout(new BorderLayout());
		JButton complete = new JButton("완료");
		JPanel bottominPane = new JPanel();
		bottominPane.add(complete);
		bottomPane.add(bottominPane, BorderLayout.CENTER);

		JLabel bottomextraLabel[] = new JLabel[4];
		for (int i = 0; i < 4; i++) {
			bottomextraLabel[i] = new JLabel("            ");
			bottomextraLabel[i].setFont(new Font("맑은 고딕", 0, 25));
		}

		bottomPane.add(bottomextraLabel[0], BorderLayout.NORTH);
		bottomPane.add(bottomextraLabel[1], BorderLayout.SOUTH);
		bottomPane.add(bottomextraLabel[2], BorderLayout.WEST);
		bottomPane.add(bottomextraLabel[3], BorderLayout.EAST);

		JPanel westPane = new JPanel();
		westPane.setLayout(new BorderLayout());
		JLabel wLabel = new JLabel("      ");
		wLabel.setFont(new Font("맑은 고딕", 0, 20));
		westPane.add(wLabel);

		JPanel eastPane = new JPanel();
		eastPane.setLayout(new BorderLayout());
		JLabel eLabel = new JLabel("      ");
		eLabel.setFont(new Font("맑은 고딕", 0, 20));
		eastPane.add(eLabel);

		add(topPane, BorderLayout.NORTH);
		add(allMiddlePane, BorderLayout.CENTER);
		add(bottomPane, BorderLayout.SOUTH);
		add(westPane, BorderLayout.WEST);
		add(eastPane, BorderLayout.EAST);

		complete.addActionListener(new ActionListener() {
			MemberMgr mMgr = MemberMgr.getInstance();

			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("완료")) {
					try {
						String[] list = new String[7];
						for (int i = 0; i < 7; i++) {
							list[i] = kwdTextField[i].getText();
						}
						mMgr.addNewItem(list);
						BufferedWriter bw = new BufferedWriter(new FileWriter("member.txt", true));
						BufferedReader br = new BufferedReader(new FileReader("member.txt"));
						System.out.println("추가 성공");
						JOptionPane.showMessageDialog(null, "회원 가입 성공");
						String s = null;
						boolean isOk = false;

						if (e.getSource() == complete) {

							// 정보 입력시 중복이 없으면 데이터 보냄
							bw.write("\n");
							for (int i = 0; i < 7; i++) {
									bw.write(kwdTextField[i].getText() + " ");
								}
								bw.close();

						}	for (JTextField edit : kwdTextField)
							edit.setText("");

					} catch (Exception ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "회원 정보 오류");
						return;
					}
				}
			}
		});
	}

	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGui();
				new MembershipScreen();
			}
		});
	}
}
