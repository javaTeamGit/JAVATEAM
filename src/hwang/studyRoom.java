package hwang;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import park.log.Registe;

public class studyRoom extends JFrame implements ActionListener{
	private JButton[] bt=new JButton[36];
	private JButton btBack;
	private String st;
	public studyRoom(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setResizable(false);
		st = new String(title);
		
		Container c = getContentPane();
		c.setBackground(new Color(120,120,120,255));
		c.setLayout(null);
		for(int i=1;i<36;i++) {
			bt[i] = new JButton(""+i);
			bt[i].setFont(new Font("맑은 고딕",Font.BOLD,10));
			bt[i].setBackground(new Color(50,50,150,255));
			bt[i].setForeground(Color.white);
		}
		bt[1].setBounds(20, 20, 50, 50);
		bt[2].setBounds(70, 20, 50, 50);
		bt[3].setBounds(120, 20, 50, 50);
		bt[4].setBounds(170, 20, 50, 50);
		bt[5].setBounds(220, 20, 50, 50);
		bt[6].setBounds(270, 20, 50, 50);
		bt[7].setBounds(320, 20, 50, 50);
		
		bt[8].setBounds(20, 140, 50, 50);
		bt[9].setBounds(70, 140, 50, 50);
		bt[10].setBounds(120, 140, 50, 50);
		bt[11].setBounds(170, 140, 50, 50);
		bt[12].setBounds(220, 140, 50, 50);
		bt[13].setBounds(270, 140, 50, 50);
		bt[14].setBounds(320, 140, 50, 50);
		
		bt[15].setBounds(20, 190, 50, 50);
		bt[16].setBounds(70, 190, 50, 50);
		bt[17].setBounds(120, 190, 50, 50);
		bt[18].setBounds(170, 190, 50, 50);
		bt[19].setBounds(220, 190, 50, 50);
		bt[20].setBounds(270, 190, 50, 50);
		bt[21].setBounds(320, 190, 50, 50);
		
		bt[22].setBounds(20, 310, 50, 50);
		bt[23].setBounds(70, 310, 50, 50);
		bt[24].setBounds(120, 310, 50, 50);
		bt[25].setBounds(170, 310, 50, 50);
		bt[26].setBounds(220, 310, 50, 50);
		bt[27].setBounds(270, 310, 50, 50);
		bt[28].setBounds(320, 310, 50, 50);
		
		bt[29].setBounds(420, 20, 50, 50);
		bt[30].setBounds(420, 70, 50, 50);
		bt[31].setBounds(420, 120, 50, 50);
		bt[32].setBounds(420, 170, 50, 50);
		bt[33].setBounds(420, 220, 50, 50);
		bt[34].setBounds(420, 270, 50, 50);
		bt[35].setBounds(420, 320, 50, 50);
		btBack = new JButton("뒤로");
		btBack.setFont(new Font("맑은 고딕",Font.BOLD,10));
		btBack.setBackground(new Color(250,250,250,255));
		btBack.setForeground(Color.black);
		btBack.setBounds(370, 380, 100, 50);

		SetButton();
		
		for(int i=1 ; i<36;i++) {
			c.add(bt[i]);
			bt[i].addActionListener(this);
		}
		c.add(btBack);
		btBack.addActionListener(this);
		setVisible(true);
	}
	public static void main(String[] args) {
		db.JDBC.init();
		new studyRoom("", 500, 480);
	}
	private void SetButton() {
		String r="SELECT SEATID FROM TIME WHERE SEATID IS NOT NULL";
		ResultSet result = db.JDBC.getResultSet(r);
		try {
			while(result.next()) {
				int i=result.getInt("SEATID");
				bt[i].setBackground(new Color(200,0,0,255));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		for(int i=1;i<36;i++) {
			if(obj==bt[i]) {
				int result = JOptionPane.showConfirmDialog(null, "입실하시겠습니까?", "입실",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {
					String sql1 = "UPDATE TIME SET SEATID = '"+i+"'  WHERE CUSTID= '" + st + "'";
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
		}
		if(obj==btBack) {
			new mainScreen(st,400,500);
			dispose();
		}
		
	}

}
