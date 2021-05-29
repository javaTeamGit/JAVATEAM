package jang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class monthScreen extends JFrame implements MouseListener, ActionListener{
	
	private Container c;
	private JPanel panNorth, panCenter;
	private JLabel lblBack, lblTitle, lblTicket;
	private ImageIcon imgBack;
	private JButton btnOne, btnTwo, btnThree, btnFour;
	
	public monthScreen(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		c = getContentPane();
		c.setBackground(Color.white);
		
		setPanNorth();
		setPanCenter();
		
		c.add(panNorth, BorderLayout.NORTH);
		c.add(panCenter, BorderLayout.CENTER);
		setVisible(true);
	}

	private void setPanNorth() {
		panNorth = new JPanel();
		panNorth.setBackground(Color.white);
		panNorth.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		panNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
		//뒤로 가기 화살표 라벨
		imgBack = new ImageIcon("image/backarrow.png");
		lblBack = new JLabel(imgBack);
		lblBack.addMouseListener(this);
		
		lblTitle = new JLabel("       이용권 구매");
		lblTitle.setFont(new Font("Serif", Font.BOLD, 15));
		
		panNorth.add(lblBack);
		panNorth.add(lblTitle);
	}
	
	private void setPanCenter() {
		panCenter = new JPanel();
		panCenter.setBackground(Color.white);
		panCenter.setBorder(BorderFactory.createEmptyBorder(20, 5, 0, 5));
		panCenter.setLayout(null);
		
		Color color = new Color(175, 196, 224);
		
		lblTicket = new JLabel("고정권");
		lblTicket.setBounds(17, 30, 50, 15);
		lblTicket.setFont(new Font("Serif", Font.BOLD, 15));
		//이용권 버튼
		btnOne = new JButton("1개월                                     100,000원");
		btnOne.setBounds(17, 60, 250, 45);
		btnOne.setFont(new Font("Serif", Font.BOLD, 13));
		btnOne.setBackground(color);
		btnOne.addActionListener(this);
		
		btnTwo = new JButton("2개월                                     190,000원");
		btnTwo.setBounds(17, 120, 250, 45);
		btnTwo.setFont(new Font("Serif", Font.BOLD, 13));
		btnTwo.setBackground(color);
		btnTwo.addActionListener(this);
		
		btnThree = new JButton("3개월                                     280,000원");
		btnThree.setBounds(17, 180, 250, 45);
		btnThree.setFont(new Font("Serif", Font.BOLD, 13));
		btnThree.setBackground(color);
		btnThree.addActionListener(this);
		
		btnFour = new JButton("4개월                                     370,000원");
		btnFour.setBounds(17, 240, 250, 45);
		btnFour.setFont(new Font("Serif", Font.BOLD, 13));
		btnFour.setBackground(color);
		btnFour.addActionListener(this);
		
		
		panCenter.add(lblTicket);
		panCenter.add(btnOne);
		panCenter.add(btnTwo);
		panCenter.add(btnThree);
		panCenter.add(btnFour);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == lblBack) {
			new startScreen("", 300, 230);
			dispose();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btnOne) {
			int result = JOptionPane.showConfirmDialog(null, "[ 1개월 | 100,000 ] 으로 결제하시겠습니까?",
						"결제", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(result == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		} else if(obj == btnTwo) {
			int result = JOptionPane.showConfirmDialog(null, "[ 2개월 | 190,000 ] 으로 결제하시겠습니까?",
					"결제", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(result == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		} else if(obj == btnThree) {
			int result = JOptionPane.showConfirmDialog(null, "[ 3개월 | 280,000 ] 으로 결제하시겠습니까?",
					"결제", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(result == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		} else if(obj == btnFour) {
			int result = JOptionPane.showConfirmDialog(null, "[ 4개월 | 370,000 ] 으로 결제하시겠습니까?",
					"결제", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(result == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}
}