package GUI;

import bookcafe.Member;
import bookcafe.MemberMgr;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SeatClickGUI extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeatClickGUI frame = new SeatClickGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				new SeatGui();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	SeatClickGUI() {		
		super("창2"); //타이틀
        JPanel jPanel = new JPanel();

        setSize(216, 134);

        getContentPane().add(jPanel);
        jPanel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel(MemberMgr.userName+"님 좌석 배정 완료");
        lblNewLabel.setBounds(45, 25, 200, 15);
        jPanel.add(lblNewLabel);
                
        JButton btnNewButton = new JButton("확인");
        btnNewButton.setBounds(56, 50, 80, 23);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        		JButton j = new JButton();
        		j.setEnabled(false);
        	}
        });
        jPanel.add(btnNewButton);

        Dimension frameSize = getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2,
                (windowSize.height - frameSize.height) / 2); //화면 중앙에 띄우기
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
	}

}
