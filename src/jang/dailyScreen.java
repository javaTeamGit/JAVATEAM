package jang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class dailyScreen extends JFrame implements MouseListener, ActionListener {
	
	private Container c;
	private JPanel panNorth, panCenter, panSouth;
	private JLabel lblExit, lblTitle, lblExplan, lblTicket, lblWay, lblName, lblEmail, lblNum, lblBack;
	private JLabel lbl1, lbl2, lbl3, lbl4;		//칸 띄우기용 JLabel
	private ImageIcon imgExit, imgBack;
	private JComboBox<String> cbTicket, cbWay;
	private JTextField tfName, tfEmail, tfNum;
	private JButton btnPay;
	private Color color;
	private payScreen ps;
	
	private String[] strTicket = {"3시간 ------------------------------------- 3,000원", "6시간 ------------------------------------- 5,000원", 
			"9시간 ------------------------------------- 7,000원", "12시간 ------------------------------------ 9,000원"};
	private String[] strWay = {"카드결제","계좌이체","무통자입급","휴대폰결제","카카오페이"};
	
	public dailyScreen(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.white);
		
		setPanNorth();
		setPanCenter();
		setPanSouth();
		
		c.add(panNorth);
		c.add(panCenter);
		c.add(panSouth);
		setVisible(true);
	}

	private void setPanNorth() {
		color = new Color(130, 0, 255);
		
		//북쪽 레이아웃 설정
		panNorth = new JPanel();
		panNorth.setBounds(0, 0, 300, 90);
		panNorth.setBackground(color);
		panNorth.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		panNorth.setLayout(null);
		//종료 아이콘 라벨
		imgExit = new ImageIcon("image/exit.png");
		lblExit = new JLabel(imgExit);
		lblExit.setBounds(260, 5, 20, 20);
		lblExit.addMouseListener(this);
		//메인타이틀
		lblTitle = new JLabel("결제하기", lblTitle.CENTER);
		lblTitle.setForeground(Color.white);
		lblTitle.setFont(new Font("나눔고딕", Font.BOLD, 25));
		lblTitle.setBounds(48, 20, 200, 30);
		//보조타이틀
		lblExplan = new JLabel("아래의 정보를 입력해주세요", lblExplan.CENTER);
		lblExplan.setForeground(Color.white);
		lblExplan.setFont(new Font("나눔고딕", Font.BOLD, 12));
		lblExplan.setBounds(48, 50, 200, 30);
		
		panNorth.add(lblExit);
		panNorth.add(lblTitle);
		panNorth.add(lblExplan);
	}
	
	private void setPanCenter() {
		panCenter = new JPanel();
		panCenter.setBackground(Color.white);
		panCenter.setBounds(0, 90, 300, 390);
		panCenter.setLayout(new FlowLayout(FlowLayout.LEFT));
		panCenter.setBorder(BorderFactory.createEmptyBorder(20, 5, 0, 5));
		//고정권
		lblTicket = new JLabel("1회권");
		lblTicket.setFont(new Font("나눔고딕", Font.BOLD, 14));
		lblTicket.setPreferredSize(new Dimension(290, 20));
		cbTicket = new JComboBox<String>(strTicket);
		cbTicket.setPreferredSize(new Dimension(260, 30));
		
		lbl1 = new JLabel("");
		lbl1.setPreferredSize(new Dimension(200, 10));
		
		//결제수단
		lblWay = new JLabel("결제수단");
		lblWay.setFont(new Font("나눔고딕", Font.BOLD, 14));
		lblWay.setPreferredSize(new Dimension(290, 20));
		cbWay = new JComboBox<String>(strWay);
		cbWay.setPreferredSize(new Dimension(260, 30));
		
		lbl2 = new JLabel("");
		lbl2.setPreferredSize(new Dimension(200, 10));
		
		//결제자 성함
		lblName = new JLabel("결제자 성함 *");
		lblName.setFont(new Font("나눔고딕", Font.BOLD, 14));
		lblName.setPreferredSize(new Dimension(290, 20));
		tfName = new JTextField(" 이름");
		tfName.setPreferredSize(new Dimension(260, 30));
		
		lbl3 = new JLabel("");
		lbl3.setPreferredSize(new Dimension(200, 10));
		
		//결제자 이메일
		lblEmail = new JLabel("결제자 Email");
		lblEmail.setFont(new Font("나눔고딕", Font.BOLD, 14));
		lblEmail.setPreferredSize(new Dimension(290, 20));
		tfEmail = new JTextField("");
		tfEmail.setPreferredSize(new Dimension(260, 30));
		
		lbl4 = new JLabel("");
		lbl4.setPreferredSize(new Dimension(200, 10));
		
		//결제자 이메일
		lblNum = new JLabel("결제자 전화번호 *");
		lblNum.setFont(new Font("나눔고딕", Font.BOLD, 14));
		lblNum.setPreferredSize(new Dimension(290, 20));
		tfNum = new JTextField("");
		tfNum.setPreferredSize(new Dimension(260, 30));
		
		panCenter.add(lblTicket);
		panCenter.add(cbTicket);
		panCenter.add(lbl1);
		panCenter.add(lblWay);
		panCenter.add(cbWay);
		panCenter.add(lbl2);
		panCenter.add(lblName);
		panCenter.add(tfName);
		panCenter.add(lbl3);
		panCenter.add(lblEmail);
		panCenter.add(tfEmail);
		panCenter.add(lbl4);
		panCenter.add(lblNum);
		panCenter.add(tfNum);
	}
	
	private void setPanSouth() {
		color = new Color(0, 150, 0);
		
		panSouth = new JPanel();
		panSouth.setBackground(Color.white);
		panSouth.setBounds(0, 480, 300, 120);
		panSouth.setLayout(null);
		//뒤로가기 아이콘 라벨
		imgBack = new ImageIcon("image/back.png");
		lblBack = new JLabel(imgBack);
		lblBack.setBounds(10, 25, 48, 48);
		lblBack.addMouseListener(this);
		
		//결제하기 아이콘 라벨
		btnPay = new JButton("결제하기");
		btnPay.setFont(new Font("나눔고딕", Font.BOLD, 20));
		btnPay.setForeground(color.white);
		btnPay.setBackground(color);
		btnPay.setBounds(60, 25, 200, 50);
		btnPay.addActionListener(this);
		
		panSouth.add(lblBack);
		panSouth.add(btnPay);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(color.GRAY);
		g.drawLine(0, 520, 300, 520);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == lblExit) {
			dispose();
		} else if(obj == lblBack) {
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
		if(obj == btnPay) {
			ps = new payScreen("", 400, 400);
			dispose();
		}
	}
}
