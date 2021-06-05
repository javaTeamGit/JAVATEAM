package jang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class startScreen extends JFrame implements ActionListener{
	
	private Container c;
	private JPanel panNorth, panCenter, panSouth;
	private JLabel lblTitle;
	private JButton btnDaily, btnMonth, btnExit;
	private ImageIcon imgDaily, imgMonth;
	private dailyScreen ds;
	private monthScreen ms;
	
	public startScreen(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		c = getContentPane();
		c.setBackground(Color.white);
		
		setpanNorth();
		setpanCenter();
		setpanSouth();
		
		c.add(panNorth, BorderLayout.NORTH);
		c.add(panCenter, BorderLayout.CENTER);
		c.add(panSouth, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	private void setpanNorth() {
		panNorth = new JPanel();
		panNorth.setBackground(Color.white);
		
		lblTitle = new JLabel("이용권 구매");
		lblTitle.setFont(new Font("Serif", Font.BOLD, 15));
		
		panNorth.add(lblTitle);
	}
	
	private void setpanCenter() {
		panCenter = new JPanel();
		panCenter.setBackground(Color.white);
		panCenter.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		
		imgDaily = new ImageIcon("image/daily.png");
		imgMonth = new ImageIcon("image/month.png");
		
		Color color = new Color(175, 196, 224);
		
		btnDaily = new JButton("당일이용권", imgDaily);
		btnDaily.setBackground(color);
		btnDaily.setHorizontalTextPosition(JButton.CENTER);
		btnDaily.setVerticalTextPosition(JButton.BOTTOM);
		btnDaily.addActionListener(this);
		
		btnMonth = new JButton("정기이용권", imgMonth);
		btnMonth.setBackground(color);
		btnMonth.setHorizontalTextPosition(JButton.CENTER);
		btnMonth.setVerticalTextPosition(JButton.BOTTOM);
		btnMonth.addActionListener(this);
		
		panCenter.add(btnDaily);
		panCenter.add(btnMonth);
	}
	
	private void setpanSouth() {
		panSouth = new JPanel();
		panSouth.setBackground(Color.white);
		panSouth.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		
		btnExit = new JButton("닫기");
		btnExit.setBackground(Color.LIGHT_GRAY);
		//닫기 버튼을 누를시 메인화면으로 넘어가게 나중에 설정하기
		btnExit.addActionListener(this);
		
		panSouth.add(btnExit);
	}

	public static void main(String[] args) {
		new startScreen("", 300, 230);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btnDaily) {
			ds = new dailyScreen("", 300, 600);
			dispose();
		} else if(obj == btnMonth) {
			ms = new monthScreen("", 300, 600);
			dispose();
		}
		//if(obj == btnExit) 할시 메인화면으로 돌아가는 코드 구현하기 나중에
	}
}
