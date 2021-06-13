package jang;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import hwang.mainScreen;

public class infoScreen extends JFrame implements MouseListener{
	//매장 정보 스크린
	
	private Container c;
	private JLabel lblScreen;
	private ImageIcon imgPay;
	private mainScreen ms;
	private String strId;
	
	
	public infoScreen(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		
		strId = new String(title);
		
		c = getContentPane();
		
		setScreen();
		
		c.add(lblScreen);
		setVisible(true);
	}
	
	private void setScreen() {
		imgPay = new ImageIcon("image/info.png");
		lblScreen = new JLabel(imgPay);
		lblScreen.addMouseListener(this);
	}
	
	public static void main(String[] args) {
		new infoScreen("", 700, 510);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == lblScreen) {
			ms = new mainScreen(strId, 400, 500);
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
