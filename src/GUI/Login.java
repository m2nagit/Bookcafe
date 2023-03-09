package GUI;

import bookcafe.Member;
import bookcafe.MemberMgr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Login extends JFrame {
    public Login() {
        setTitle("로그인");
        
        super.setPreferredSize(new Dimension(500, 230));
		super.setLocationRelativeTo(null); 
        setLayout(new GridLayout(3, 1));
        setSize(getPreferredSize());
        Dimension frameSize = getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2,
                (windowSize.height - frameSize.height) / 2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new GridLayout());
        JLabel lb2 = new JLabel("고유번호 :");
        lb2.setHorizontalAlignment(JLabel.CENTER);
		lb2.setFont(new Font("Menlo", Font.BOLD, 15));
        namePanel.add(lb2);
        JTextField tf1 = new JTextField();
        namePanel.add(tf1);
        add(namePanel);
        
        JPanel phonePanel = new JPanel();
        phonePanel.setLayout(new GridLayout(1, 10));
        JLabel lb3 = new JLabel("비밀번호 :");
        lb3.setHorizontalAlignment(JLabel.CENTER);
		lb3.setFont(new Font("Menlo", Font.BOLD, 15));
        phonePanel.add(lb3);
        JTextField tf2 = new JPasswordField("",20);
        phonePanel.add(tf2);
        add(phonePanel);

        JPanel panel1 = new JPanel();
        JButton bt1 = new JButton("로그인");
        JButton bt2 = new JButton("회원가입");
        panel1.add(bt1);
        panel1.add(bt2);
        add(panel1);

        super.pack();

        bt1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String[] userIdInfo = new String[2];
                 userIdInfo[0] = tf1.getText();
                userIdInfo[1] = tf2.getText();
                compare(userIdInfo);

            }

        });

        bt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MembershipScreen();
                MembershipScreen.createAndShowGui();

            }
        });
        setVisible(true);
    }

    public void compare(String[] userIdInfo) {
        try {
            String s = null;
            boolean isOk = false;
            BufferedReader br = new BufferedReader(new FileReader("member.txt"));

            while ((s = br.readLine()) != null) {
                String[] array = s.split(" ");
                System.out.println(array[1]);
                if (array[1].equals(userIdInfo[1])) { // 비밀번호 매치
                    System.out.println("번호 매칭");
                    if (array[0].equals(userIdInfo[0])) { // 고유번호 매치
                        isOk = true;
                        MemberMgr.userName=array[2];
                        break;
                    }
                }
            }
            if (isOk) {
                JOptionPane.showMessageDialog(null, "로그인에 성공");
                JOptionPane.showMessageDialog(null, MemberMgr.userName+"님 환영합니다!");
                dispose();
                new MainScreen();
            } else {
                JOptionPane.showMessageDialog(null, "아이디가 없습니다. 회원가입이 필요합니다.");
                dispose();
                new MembershipScreen();;
                MembershipScreen.createAndShowGui();
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "실패");
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}