package park.log;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class MainLog extends JFrame implements ActionListener {
	private JLabel lbtime;
	javax.swing.Timer timer;
	private int hour,min,sec;
	private Container c;
	private Graphics gd;
	private Image background = new ImageIcon("image/dokp1.jpg").getImage();
	private int seccov;
	private JButton jb3;
	private JButton jb1;
	private JButton jb2;
	public MainLog(String title,int width,int height) {
			setTitle(title);
			setSize(width, height);
			setDefaultCloseOperation(3);
			setLocationRelativeTo(null);
			setLayout(new BorderLayout());
			JPanel jp1 = new JPanel();
			jp1.setLayout(new FlowLayout(FlowLayout.RIGHT,10,10));
			jp1.setBackground(Color.white);
			JPanel jp2 = new JPanel();
			jp2.setBackground(Color.white);
			jp2.setLayout(null);
			jb1 = new JButton("관리자 로그인");
			jb1.setForeground(new Color(255,204,204));//204,204,255
			jb1.setBounds(135, 150, 140, 80);
			jb1.setBackground(Color.white);
			jb1.setOpaque(false);
			jb1.setFocusable(false);
			jb1.setFont(new Font("휴먼모음T", Font.BOLD, 17));
			jb2 = new JButton("사용자 로그인");
			jb2.setForeground(new Color(204,204,255));
			jb2.setBounds(315, 150, 140, 80);
			jb2.setBackground(Color.white);
			jb2.setFont(new Font("휴먼모음T", Font.BOLD, 17));
			jb1.addActionListener(this);
			jb2.addActionListener(this);
			jb2.setOpaque(false);
			jb2.setFocusable(false);
			jb1.setBorder(BorderFactory.createEtchedBorder(new Color(204,204,255), new Color(204,204,255)));
			jb2.setBorder(BorderFactory.createEtchedBorder(new Color(255,204,204), new Color(255,204,204)));
			JLabel jl = new JLabel("독서실");
			JLabel jl2 = new JLabel("관리시스템");
			ImageIcon img = new ImageIcon("image/dokp1.jpg");
			JLabel jl3 = new JLabel(img);
			jl3.setBounds(0, 0, 600, 430);
			jl.setForeground(new Color(255,204,204));
			jl2.setForeground(new Color(204,204,255));
			jl.setFont(new Font("", Font.BOLD, 35));
			jl2.setFont(new Font("", Font.BOLD, 35));
			jl.setBounds(245,50,300,50);
			jl2.setBounds(210,90,300,50);
			Timer();
			jp1.add(lbtime);
			jp2.add(jb1);
			jp2.add(jb2);
			jp2.add(jl);
			jp2.add(jl2);
			jp2.add(jl3);
			add(jp1,BorderLayout.NORTH);
			add(jp2,BorderLayout.CENTER);
			
			setVisible(true);
		}

	private void Timer() {
		Calendar cal1 = Calendar.getInstance();
		hour = cal1.get(Calendar.HOUR_OF_DAY);
		min = cal1.get(Calendar.MINUTE);
		sec = cal1.get(Calendar.SECOND);
		seccov=0;
        timer = new javax.swing.Timer(1000, this);
        timer.setInitialDelay(0);
        timer.start();
		timer.addActionListener(this);
		lbtime = new JLabel(hour + "시  " + min + "분   " + sec + "초",
                lbtime.RIGHT);
		lbtime.setForeground(new Color(153,153,255));
		lbtime.setFont(new Font("", Font.BOLD, 20));
		lbtime.setBackground(new Color(255,0,0,0));
		lbtime.setOpaque(false);
		
	}
	public static void main(String[] args) {
		JFrame j = new JFrame();
		new MainLog("로그인시작",600,500);
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==jb1) {
			dispose();
			new jang.admin.adminLogin("관리자 로그인화면", 400, 400);
			
		}
		if(obj==jb2) {
			dispose();
			new login("로그인화면", 400, 400);
		}
		++sec;
		Calendar cal2 = Calendar.getInstance();
		hour = cal2.get(Calendar.HOUR_OF_DAY);
		min=cal2.get(Calendar.MINUTE);
		sec=cal2.get(Calendar.SECOND);
		lbtime.setText(hour+"시"+min+"분"+sec+"초");
//		System.out.println(seccov);
//		if(seccov==7) {
//			background=new ImageIcon("image/dokp2.png").getImage();
//			repaint();
//		}
//		if(seccov==14) {
//		background=new ImageIcon("image/dokp3.jpg").getImage();
//		jp1.repaint();
//		}
//		if(seccov==21) {
//			background=new ImageIcon("image/dokp4.jpg").getImage();
//			repaint();	}
//		if(seccov==28) {
//			background=new ImageIcon("image/dokp1.jpg").getImage();
//			repaint();
//			seccov=0;
//		}

//		jb3.repaint();
	}

}
