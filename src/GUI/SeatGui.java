package GUI;

import bookcafe.MemberMgr;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.naming.directory.SearchControls;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import com.jgoodies.forms.factories.DefaultComponentFactory;

public class SeatGui extends JFrame implements ActionListener{

	private JPanel contentPane;


	public static void main(String[] args) {
		new SeatGui();
	}

	public SeatGui() {
		setVisible(true);
		setTitle("좌석배정");
		//setResizable(false);
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(490, 440);
		//setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        Dimension frameSize = getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2,
                (windowSize.height - frameSize.height) / 2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton a1 = new JButton("A-01");
		a1.setBounds(104, 97, 63, 36);
		a1.addActionListener(this);
		contentPane.add(a1);

		JButton a2 = new JButton("A-02");
		a2.addActionListener(this);
		a2.setBounds(104, 143, 63, 36);
		contentPane.add(a2);

		JButton a3 = new JButton("A-03");
		a3.addActionListener(this);
		a3.setBounds(104, 189, 63, 36);
		contentPane.add(a3);

		JButton a4 = new JButton("A-04");
		a4.addActionListener(this);
		a4.setBounds(104, 235, 63, 36);
		contentPane.add(a4);

		JButton a5 = new JButton("A-05");
		a5.addActionListener(this);
		a5.setBounds(104, 281, 63, 36);
		contentPane.add(a5);

		JButton a6 = new JButton("A-06");
		a6.addActionListener(this);
		a6.setBounds(166, 97, 63, 36);
		contentPane.add(a6);

		JButton a7 = new JButton("A-07");
		a7.addActionListener(this);
		a7.setBounds(166, 143, 63, 36);
		contentPane.add(a7);

		JButton a8 = new JButton("A-08");
		a8.addActionListener(this);
		a8.setBounds(166, 189, 63, 36);
		contentPane.add(a8);

		JButton a9 = new JButton("A-09");
		a9.addActionListener(this);
		a9.setBounds(166, 235, 63, 36);
		contentPane.add(a9);

		JButton a10 = new JButton("A-10");
		a10.addActionListener(this);
		a10.setBounds(166, 281, 63, 36);
		contentPane.add(a10);

		JButton b1 = new JButton("B-01");
		b1.setBackground(Color.LIGHT_GRAY);
		b1.addActionListener(this);
		b1.setBounds(258, 97, 63, 36);
		contentPane.add(b1);

		JButton b2 = new JButton("B-02");
		b2.setBackground(Color.LIGHT_GRAY);
		b2.addActionListener(this);
		b2.setBounds(258, 143, 63, 36);
		contentPane.add(b2);

		JButton b3 = new JButton("B-03");
		b3.setBackground(Color.LIGHT_GRAY);
		b3.addActionListener(this);
		b3.setBounds(258, 189, 63, 36);
		contentPane.add(b3);

		JButton b4 = new JButton("B-04");
		b4.setBackground(Color.LIGHT_GRAY);
		b4.addActionListener(this);
		b4.setBounds(258, 235, 63, 36);
		contentPane.add(b4);

		JButton b5 = new JButton("B-05");
		b5.setBackground(Color.LIGHT_GRAY);
		b5.addActionListener(this);
		b5.setBounds(258, 281, 63, 36);
		contentPane.add(b5);

		JButton b6 = new JButton("B-06");
		b6.setBackground(Color.LIGHT_GRAY);
		b6.addActionListener(this);
		b6.setBounds(323, 97, 63, 36);
		contentPane.add(b6);

		JButton b7 = new JButton("B-07");
		b7.setBackground(Color.LIGHT_GRAY);
		b7.addActionListener(this);
		b7.setBounds(323, 143, 63, 36);
		contentPane.add(b7);

		JButton b8 = new JButton("B-08");
		b8.setBackground(Color.LIGHT_GRAY);
		b8.addActionListener(this);
		b8.setBounds(323, 189, 63, 36);
		contentPane.add(b8);

		JButton b9 = new JButton("B-9");
		b9.setBackground(Color.LIGHT_GRAY);
		b9.addActionListener(this);
		b9.setBounds(323, 235, 63, 36);
		contentPane.add(b9);

		JButton b10 = new JButton("B-10");
		b10.setBackground(Color.LIGHT_GRAY);
		b10.addActionListener(this);
		b10.setBounds(323, 281, 63, 36);
		contentPane.add(b10);

		JLabel lblNewLabel = new JLabel("좌석 현황");
		lblNewLabel.setBounds(218, 49, 57, 15);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("이전");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MainScreen();
			}
		});
		btnNewButton.setBounds(205, 347, 84, 23);
		contentPane.add(btnNewButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		b.setBackground(Color.RED);
		b.setEnabled(false);
		new SeatClickGUI();
	}
}
