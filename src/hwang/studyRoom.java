package hwang;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import park.log.Registe;

public class studyRoom extends JFrame implements ActionListener{
	private JButton bt1, bt2,bt3,bt4,bt5,bt6,bt7;
	private JButton bt8, bt9,bt10,bt11,bt12,bt13,bt14;
	private JButton bt15, bt16,bt17,bt18,bt19,bt20,bt21;
	private JButton bt22, bt23,bt24,bt25,bt26,bt27,bt28;
	private JButton bt29, bt30,bt31,bt32,bt33,bt34,bt35 ,btBack;
	private String st;
	public studyRoom(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setResizable(false);
		st = new String(title);
		
		Container c = getContentPane();
		c.setBackground(new Color(80,80,80,255));
		c.setLayout(null);
		bt1= new JButton("1");
		bt2= new JButton("2");
		bt3= new JButton("3");
		bt4= new JButton("4");
		bt5= new JButton("5");
		bt6= new JButton("6");
		bt7= new JButton("7");
		bt1.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt1.setBackground(new Color(20,20,150,255));
		bt1.setForeground(Color.white);
		bt1.setBounds(20, 20, 50, 50);
		bt2.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt2.setBackground(new Color(20,20,150,255));
		bt2.setForeground(Color.white);
		bt2.setBounds(70, 20, 50, 50);
		bt3.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt3.setBackground(new Color(20,20,150,255));
		bt3.setForeground(Color.white);
		bt3.setBounds(120, 20, 50, 50);
		bt4.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt4.setBackground(new Color(20,20,150,255));
		bt4.setForeground(Color.white);
		bt4.setBounds(170, 20, 50, 50);
		bt5.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt5.setBackground(new Color(20,20,150,255));
		bt5.setForeground(Color.white);
		bt5.setBounds(220, 20, 50, 50);
		bt6.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt6.setBackground(new Color(20,20,150,255));
		bt6.setForeground(Color.white);
		bt6.setBounds(270, 20, 50, 50);
		bt7.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt7.setBackground(new Color(20,20,150,255));
		bt7.setForeground(Color.white);
		bt7.setBounds(320, 20, 50, 50);
		
		bt8= new JButton("8");
		bt9= new JButton("9");
		bt10= new JButton("10");
		bt11= new JButton("11");
		bt12= new JButton("12");
		bt13= new JButton("13");
		bt14= new JButton("14");
		bt8.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt8.setBackground(new Color(20,20,150,255));
		bt8.setForeground(Color.white);
		bt8.setBounds(20, 140, 50, 50);
		bt9.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt9.setBackground(new Color(20,20,150,255));
		bt9.setForeground(Color.white);
		bt9.setBounds(70, 140, 50, 50);
		bt10.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt10.setBackground(new Color(20,20,150,255));
		bt10.setForeground(Color.white);
		bt10.setBounds(120, 140, 50, 50);
		bt11.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt11.setBackground(new Color(20,20,150,255));
		bt11.setForeground(Color.white);
		bt11.setBounds(170, 140, 50, 50);
		bt12.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt12.setBackground(new Color(20,20,150,255));
		bt12.setForeground(Color.white);
		bt12.setBounds(220, 140, 50, 50);
		bt13.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt13.setBackground(new Color(20,20,150,255));
		bt13.setForeground(Color.white);
		bt13.setBounds(270, 140, 50, 50);
		bt14.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt14.setBackground(new Color(20,20,150,255));
		bt14.setForeground(Color.white);
		bt14.setBounds(320, 140, 50, 50);
		
		bt15= new JButton("15");
		bt16= new JButton("16");
		bt17= new JButton("17");
		bt18= new JButton("18");
		bt19= new JButton("19");
		bt20= new JButton("20");
		bt21= new JButton("21");
		bt15.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt15.setBackground(new Color(20,20,150,255));
		bt15.setForeground(Color.white);
		bt15.setBounds(20, 190, 50, 50);
		bt16.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt16.setBackground(new Color(20,20,150,255));
		bt16.setForeground(Color.white);
		bt16.setBounds(70, 190, 50, 50);
		bt17.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt17.setBackground(new Color(20,20,150,255));
		bt17.setForeground(Color.white);
		bt17.setBounds(120, 190, 50, 50);
		bt18.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt18.setBackground(new Color(20,20,150,255));
		bt18.setForeground(Color.white);
		bt18.setBounds(170, 190, 50, 50);
		bt19.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt19.setBackground(new Color(20,20,150,255));
		bt19.setForeground(Color.white);
		bt19.setBounds(220, 190, 50, 50);
		bt20.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt20.setBackground(new Color(20,20,150,255));
		bt20.setForeground(Color.white);
		bt20.setBounds(270, 190, 50, 50);
		bt21.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt21.setBackground(new Color(20,20,150,255));
		bt21.setForeground(Color.white);
		bt21.setBounds(320, 190, 50, 50);
		
		bt22= new JButton("22");
		bt23= new JButton("23");
		bt24= new JButton("24");
		bt25= new JButton("25");
		bt26= new JButton("26");
		bt27= new JButton("27");
		bt28= new JButton("28");
		bt22.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt22.setBackground(new Color(20,20,150,255));
		bt22.setForeground(Color.white);
		bt22.setBounds(20, 310, 50, 50);
		bt23.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt23.setBackground(new Color(20,20,150,255));
		bt23.setForeground(Color.white);
		bt23.setBounds(70, 310, 50, 50);
		bt24.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt24.setBackground(new Color(20,20,150,255));
		bt24.setForeground(Color.white);
		bt24.setBounds(120, 310, 50, 50);
		bt25.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt25.setBackground(new Color(20,20,150,255));
		bt25.setForeground(Color.white);
		bt25.setBounds(170, 310, 50, 50);
		bt26.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt26.setBackground(new Color(20,20,150,255));
		bt26.setForeground(Color.white);
		bt26.setBounds(220, 310, 50, 50);
		bt27.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt27.setBackground(new Color(20,20,150,255));
		bt27.setForeground(Color.white);
		bt27.setBounds(270, 310, 50, 50);
		bt28.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt28.setBackground(new Color(20,20,150,255));
		bt28.setForeground(Color.white);
		bt28.setBounds(320, 310, 50, 50);
		
		bt29= new JButton("29");
		bt30= new JButton("30");
		bt31= new JButton("31");
		bt32= new JButton("32");
		bt33= new JButton("33");
		bt34= new JButton("34");
		bt35= new JButton("35");
		bt29.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt29.setBackground(new Color(20,20,150,255));
		bt29.setForeground(Color.white);
		bt29.setBounds(420, 20, 50, 50);
		bt30.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt30.setBackground(new Color(20,20,150,255));
		bt30.setForeground(Color.white);
		bt30.setBounds(420, 70, 50, 50);
		bt31.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt31.setBackground(new Color(20,20,150,255));
		bt31.setForeground(Color.white);
		bt31.setBounds(420, 120, 50, 50);
		bt32.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt32.setBackground(new Color(20,20,150,255));
		bt32.setForeground(Color.white);
		bt32.setBounds(420, 170, 50, 50);
		bt33.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt33.setBackground(new Color(20,20,150,255));
		bt33.setForeground(Color.white);
		bt33.setBounds(420, 220, 50, 50);
		bt34.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt34.setBackground(new Color(20,20,150,255));
		bt34.setForeground(Color.white);
		bt34.setBounds(420, 270, 50, 50);
		bt35.setFont(new Font("맑은 고딕",Font.BOLD,10));
		bt35.setBackground(new Color(20,20,150,255));
		bt35.setForeground(Color.white);
		bt35.setBounds(420, 320, 50, 50);
		btBack = new JButton("뒤로");
		btBack.setFont(new Font("맑은 고딕",Font.BOLD,10));
		btBack.setBackground(new Color(250,250,250,255));
		btBack.setForeground(Color.black);
		btBack.setBounds(370, 380, 100, 50);
		
		
		c.add(bt1);
		c.add(bt2);
		c.add(bt3);
		c.add(bt4);
		c.add(bt5);
		c.add(bt6);
		c.add(bt7);
		
		c.add(bt8);
		c.add(bt9);
		c.add(bt10);
		c.add(bt11);
		c.add(bt12);
		c.add(bt13);
		c.add(bt14);
		
		c.add(bt15);
		c.add(bt16);
		c.add(bt17);
		c.add(bt18);
		c.add(bt19);
		c.add(bt20);
		c.add(bt21);
		
		c.add(bt22);
		c.add(bt23);
		c.add(bt24);
		c.add(bt25);
		c.add(bt26);
		c.add(bt27);
		c.add(bt28);
		
		c.add(bt29);
		c.add(bt30);
		c.add(bt31);
		c.add(bt32);
		c.add(bt33);
		c.add(bt34);
		c.add(bt35);
		c.add(btBack);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		bt5.addActionListener(this);
		bt6.addActionListener(this);
		bt7.addActionListener(this);
		bt8.addActionListener(this);
		bt9.addActionListener(this);
		bt10.addActionListener(this);
		bt11.addActionListener(this);
		bt12.addActionListener(this);
		bt13.addActionListener(this);
		bt14.addActionListener(this);
		bt15.addActionListener(this);
		bt16.addActionListener(this);
		bt17.addActionListener(this);
		bt18.addActionListener(this);
		bt19.addActionListener(this);
		bt20.addActionListener(this);
		bt21.addActionListener(this);
		bt22.addActionListener(this);
		bt23.addActionListener(this);
		bt24.addActionListener(this);
		bt25.addActionListener(this);
		bt26.addActionListener(this);
		bt27.addActionListener(this);
		bt28.addActionListener(this);
		bt29.addActionListener(this);
		bt30.addActionListener(this);
		bt31.addActionListener(this);
		bt32.addActionListener(this);
		bt33.addActionListener(this);
		bt34.addActionListener(this);
		bt35.addActionListener(this);
		btBack.addActionListener(this);
		setVisible(true);
	}
	public static void main(String[] args) {
		db.JDBC.init();
		new studyRoom("", 500, 480);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==bt1) {
			int result = JOptionPane.showConfirmDialog(null, "입실하시겠습니까?", "입실",JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION) {
				String sql1 = "UPDATE TIME SET SEATID = 1  WHERE CUSTID= '" + st + "'";
				db.JDBC.executeQuery(sql1);
				System.out.println(sql1);
				Timestamp ts = new Timestamp(System.currentTimeMillis());
				String sq1 = "UPDATE TIME SET ENTRANCE = '"+ts+"'  WHERE CUSTID= '" + st + "'";
				db.JDBC.executeQuery(sq1);
				System.out.println(sq1);
				new mainScreen(st,400,500);
				dispose();
			}
		}
		else if(obj==btBack) {
			new mainScreen(st,400,500);
			dispose();
		}
		
	}

}
