package park.log;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class login extends JFrame implements  MouseListener, KeyListener {
	private JTextField email;
	private JTextField pw;
	private JButton lgBtn;
	private JLabel IDPWlook;
	private JLabel Sign;
	public login(String title,int width,int height) {
		setTitle(title);
		setSize(width, height);
		setDefaultCloseOperation(3);
		setLocationRelativeTo(null);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.setBackground(Color.white);
		//jp1;
		JPanel jp1 = new JPanel();
		jp1.setLayout(new BorderLayout());
		ImageIcon icon = new ImageIcon("image/lock.png");
		JLabel jl = new JLabel(icon);
		jl.setOpaque(true);
		jl.setBackground(Color.white);
		jp1.add(jl,BorderLayout.CENTER);
		
		//jp2;
		JPanel jp2 = new JPanel();
		jp2.setBackground(Color.white);
		jp2.setLayout(new GridLayout(0,1,15,15));
		jp2.setBorder(BorderFactory.createEmptyBorder(30, 27, 30, 25));
		email = new JTextField();
//		email.setPreferredSize(new Dimension(380,30));
//		email.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
		email.addMouseListener(this);
		email.addKeyListener(this);
		email.setForeground(Color.gray);
		email.setText("이메일 주소");
		pw = new JTextField();
//		pw.setPreferredSize(new Dimension(380, 30));
		pw.addMouseListener(this);
		pw.setForeground(Color.gray);
		pw.setText("비밀번호");
		jp2.add(email);
		jp2.add(pw);
		
		//jp3;
		JPanel jp3 = new JPanel();
		jp3.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp3.setPreferredSize(new Dimension(400, 100));
		jp3.setBackground(Color.white);
		lgBtn = new JButton("로그인");
		lgBtn.setPreferredSize(new Dimension(340, 40));
		lgBtn.setBackground(new Color(0,0,255,190));
		lgBtn.setForeground(Color.white);
		IDPWlook = new JLabel("ID/PW 찾기");
		JLabel jl2 =new JLabel(" | ");
		Sign = new JLabel("회원가입");
		jp3.add(lgBtn);
		jp3.add(IDPWlook);
		jp3.add(jl2);
		jp3.add(Sign);
		
		
		
		add(jp1,BorderLayout.NORTH);
		add(jp2,BorderLayout.CENTER);
		add(jp3,BorderLayout.SOUTH);
		setVisible(true);
	}
	public static void main(String[] args) {
		JFrame j = new JFrame();
		new login("로그인화면",400,400);
	}
	@Override
	public void mousePressed(MouseEvent e) {

		Object obj = e.getSource();
		if(obj==email) {
			if(email.getForeground().equals(Color.gray)) {
		email.setForeground(Color.black);
		email.setText("");
			}
		}
		else if(obj==pw) {
			if(pw.getForeground().equals(Color.gray)) {
			pw.setForeground(Color.black);
			pw.setText("");
			}
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {

		Object obj = e.getSource();
		if(obj==email) {
			if(email.getForeground().equals(Color.gray)) {
		email.setForeground(Color.black);
		email.setText("");
			}
		}
		else if(obj==pw) {
			if(pw.getForeground().equals(Color.gray)) {
			pw.setForeground(Color.black);
			pw.setText("");
			}
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
