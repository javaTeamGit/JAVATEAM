package jang;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class endScreen extends JFrame implements MouseListener{
	
	private Container c;
	private JLabel lblFirst, lblSecond, lblThird,lblResult;
	private ImageIcon imgResult;
	
	public endScreen(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.white);
		
		setScreen();
		
		c.add(lblFirst);
		c.add(lblSecond);
		c.add(lblThird);
		c.add(lblResult);
		setVisible(true);
	}
	
	private void setScreen() {
		lblFirst = new JLabel("결제가 완료되었습니다.");
		lblFirst.setFont(new Font("나눔고딕", Font.BOLD, 14));
		lblFirst.setBounds(125, 100, 400, 15);
		
		lblSecond = new JLabel("결제 완료");
		lblSecond.setFont(new Font("궁서체", Font.BOLD, 16));
		lblSecond.setBounds(100, 125, 90, 25);
		
		lblThird = new JLabel("버튼을 눌러주세요.");
		lblThird.setFont(new Font("나눔고딕", Font.BOLD, 14));
		lblThird.setBounds(180, 130, 200, 15);
		
		imgResult = new ImageIcon("image/result.png");
		
		lblResult = new JLabel(imgResult);
		lblResult.setBounds(40, 250, 310, 70);
		lblResult.addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == lblResult) {
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
}
