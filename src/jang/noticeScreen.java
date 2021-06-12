package jang;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import hwang.mainScreen;

public class noticeScreen extends JFrame implements MouseListener{
	
	private Container c;
	private JLabel lblScreen;
	private ImageIcon imgPay;
	private mainScreen ms;
	
	
	public noticeScreen(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		c = getContentPane();
		
		setScreen();
		
		c.add(lblScreen);
		setVisible(true);
	}
	
	private void setScreen() {
		imgPay = new ImageIcon("image/notice.png");
		lblScreen = new JLabel(imgPay);
		lblScreen.addMouseListener(this);
	}
	
	public static void main(String[] args) {
		new noticeScreen("", 700, 510);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == lblScreen) {
			ms = new mainScreen("", 400, 500);
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
