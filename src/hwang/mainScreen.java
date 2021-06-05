package hwang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class mainScreen extends JFrame implements ActionListener{
	private JButton btnNotice, btnInfo, btnPayment, btnRoom;
	private JLabel time;
	//private startScreen ss;
	private studyRoom sr;
	public mainScreen(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(3);
		setResizable(false);
		
		Container c = getContentPane();
		c.setBackground(Color.white);
		c.setLayout(new BorderLayout());
		
		JPanel p1 = new JPanel();
		p1.setBackground(Color.white);
		p1.setLayout(new GridLayout(3,1));
		JLabel sp1 = new JLabel("");
		JLabel sp2 = new JLabel("");
		JLabel lbl1 = new JLabel("독서실 인하공전점");
		lbl1.setFont(new Font("맑은 고딕",Font.BOLD,18));
		lbl1.setHorizontalAlignment(JLabel.CENTER);
		p1.add(sp1);
		p1.add(lbl1);
		p1.add(sp2);
		
		JPanel p2 = new JPanel();
		p2.setBackground(Color.white);
		p2.setLayout(new FlowLayout());
		JLabel text = new JLabel(" 잔여 시간: ");
		text.setFont(new Font("맑은 고딕",Font.BOLD,18));
		text.setBorder(new LineBorder(Color.BLACK,1));
		text.setOpaque(true);
		text.setBackground(new Color(200,200,200,255));
		time = new JLabel("00일 00시간 00분 남음                 ");
		time.setFont(new Font("맑은 고딕",Font.BOLD,15));
		JLabel sp3= new JLabel("");
		sp3.setPreferredSize(new Dimension(340, 150));
		btnNotice = new JButton("매장 공지");
		btnInfo = new JButton("매장 정보");
		btnPayment = new JButton("이용권 구매");
		btnRoom = new JButton("입퇴실");
		btnNotice.setFont(new Font("맑은 고딕",Font.BOLD,15));
		btnInfo.setFont(new Font("맑은 고딕",Font.BOLD,15));
		btnPayment.setFont(new Font("맑은 고딕",Font.BOLD,15));
		btnRoom.setFont(new Font("맑은 고딕",Font.BOLD,15));
		btnNotice.setPreferredSize(new Dimension(170, 60));
		btnInfo.setPreferredSize(new Dimension(170, 60));
		btnPayment.setPreferredSize(new Dimension(170, 60));
		btnRoom.setPreferredSize(new Dimension(170, 60));
		btnNotice.setBackground(new Color(72,160,109,255));
		btnInfo.setBackground(new Color(62,120,136,255));
		btnPayment.setBackground(new Color(131,158,75,255));
		btnRoom.setBackground(new Color(11,181,31,255));
		btnNotice.setForeground(Color.white);
		btnInfo.setForeground(Color.white);
		btnPayment.setForeground(Color.white);
		btnRoom.setForeground(Color.white);
		btnNotice.addActionListener(this);
		btnInfo.addActionListener(this);
		btnPayment.addActionListener(this);
		btnRoom.addActionListener(this);
		p2.add(text);
		p2.add(time);
		p2.add(btnNotice);
		p2.add(btnInfo);
		p2.add(sp3);
		p2.add(btnPayment);
		p2.add(btnRoom);
		
		c.add(p1,BorderLayout.NORTH);
		c.add(p2,BorderLayout.CENTER);
		setVisible(true);
	}

	public static void main(String[] args) {
		new mainScreen("메인 화면",400,500);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj==btnNotice) {
			
		}else if(obj==btnInfo) {
			
		}else if(obj==btnPayment) {
			//ss=new startScreen("",300,230);
		}else if(obj==btnRoom) {
			sr=new studyRoom("입/퇴실",500,500);
		}
	}

}