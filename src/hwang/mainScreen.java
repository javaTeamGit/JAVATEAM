package hwang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import jang.startScreen;
import park.log.login;

public class mainScreen extends JFrame implements ActionListener{
	private JButton btnNotice, btnInfo, btnPayment, btnRoom, btnLogout;
	private JLabel id, time;
	private startScreen ss;
	private studyRoom sr;
	private long rmtime = 0;
	
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
		p1.setLayout(new GridLayout(4,1));
		JLabel sp1 = new JLabel("");
		JLabel sp2 = new JLabel("");
		JLabel lbl1 = new JLabel("독서실 인하공전점");
		lbl1.setFont(new Font("맑은 고딕",Font.BOLD,18));
		lbl1.setHorizontalAlignment(JLabel.CENTER);
		id = new JLabel(title);
		id.setHorizontalAlignment(JLabel.CENTER);
		id.setFont(new Font("맑은 고딕",Font.PLAIN,14));
		p1.add(sp1);
		p1.add(lbl1);
		p1.add(sp2);
		p1.add(id);
		
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
		
		String s="SELECT * FROM FIXEDSEAT WHERE CUSTID='"+id.getText()+"'";
		ResultSet result0=db.JDBC.getResultSet(s);
		try {
			if(result0.next()) { //고정석을 사놓았을 경우
				String s1="SELECT ENDDAYS FROM FIXEDSEAT WHERE CUSTID='"+id.getText()+"'";
				ResultSet result1 = db.JDBC.getResultSet(s1);
				if(result1.next()) {
					Timestamp cutime = new Timestamp(System.currentTimeMillis());
					Timestamp endtime = result1.getTimestamp("ENDDAYS");
					long rmday = endtime.getTime() - cutime.getTime();
					if(rmday<=0) {//남은시간이 0 이하라면 새로 구매하기 위해 데이터 삭제
						String sq1="DELETE FROM FIXEDSEAT WHERE CUSTID ='"+id.getText()+"'";
						db.JDBC.executeQuery(sq1);
					}else { //남은시간이 있으면 계산해서 보여줌
						long rmhr = rmday/(60*60*1000)%24;
						long rmdy = rmday/(24*60*60*1000);
						time.setText(""+rmdy+"일 "+rmhr+"시간 남음                        ");
						System.out.println(rmdy);
					}
				}
			}else { //고정석을 사놓지 않았을 경우
				String sq="SELECT RMTIME FROM TIME WHERE CUSTID = '"+id.getText()+"'"; //고정석은 없지만 실시간계산을 해놨을경우
				ResultSet result = db.JDBC.getResultSet(sq);
				try {
					if(result.next()) {
						long rmtime = result.getLong("RMTIME");
						if(rmtime<=0) { //남은시간이 0분 이하라면 새로 구매하기 위해 데이터 삭제
							String sq2="DELETE FROM TIME WHERE CUSTID ='"+id.getText()+"'";
							db.JDBC.executeQuery(sq2);
						}else { //남은시간이 있으면 남은시간 계산해서 잔여시간 보여줌
							long rmmi = rmtime /60%60;
							long rmho = rmtime /(60*60)%24;
							long rmda = rmtime /(24*60*60);
							time.setText(""+rmda+"일 "+rmho+"시간 "+rmmi+"분 남음                 ");
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
		
		
		JPanel p3 = new JPanel();
		p3.setBackground(Color.white);
		p3.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel spp = new JLabel("   ");
		btnLogout = new JButton("로그아웃");
		btnLogout.setFont(new Font("맑은 고딕",Font.BOLD,15));
		btnLogout.setBackground(new Color(72,160,109,255));
		btnLogout.setForeground(Color.white);
		btnLogout.addActionListener(this);
		p3.add(spp);
		p3.add(btnLogout);
		
		c.add(p1,BorderLayout.NORTH);
		c.add(p2,BorderLayout.CENTER);
		c.add(p3,BorderLayout.SOUTH);
		setVisible(true);
	}

	public static void main(String[] args) {
		db.JDBC.init();
		new mainScreen("",400,500);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj==btnNotice) {
			
		}else if(obj==btnInfo) {
			
		}else if(obj==btnPayment) {
			ss=new startScreen(id.getText(),300,230);
			dispose();
		}else if(obj==btnRoom) {
			String fsck="SELECT * FROM FIXEDSEAT WHERE CUSTID = '"+id.getText()+"'";
			ResultSet rfs = db.JDBC.getResultSet(fsck);
			try {//고정석일경우 좌석선택 불가
				if(rfs.next()) {
					JOptionPane.showMessageDialog(this, "고정석 고객은 좌석 선택이 불가능합니다.","안내",JOptionPane.PLAIN_MESSAGE);
				}
				else {
					String sq="SELECT * FROM TIME WHERE CUSTID = '"+id.getText()+"' AND RMTIME>0";
					ResultSet r= db.JDBC.getResultSet(sq);
					try {
						if(r.next()) { //남은 시간이 0 이상이면 좌석 이용 가능
							String sql = "SELECT * FROM TIME WHERE CUSTID ='" + id.getText() + "' AND SEATID IS NOT NULL";
							ResultSet rs = db.JDBC.getResultSet(sql);
							System.out.println(sql);
							try {
								if(rs.next()) { //이미 좌석에 앉아있었을 경우
									int result = JOptionPane.showConfirmDialog(null, "퇴실하시겠습니까?","퇴실",JOptionPane.YES_NO_OPTION);
									if(result == JOptionPane.YES_OPTION) {
										String sql1 = "UPDATE TIME SET SEATID = NULL  WHERE CUSTID= '"+id.getText()+"'"; // 퇴실 선택하면 좌석번호 없앰
										db.JDBC.executeQuery(sql1);
										Timestamp ts = new Timestamp(System.currentTimeMillis());
										String sq1 = "UPDATE TIME SET EXIT = '"+ts+"'  WHERE CUSTID= '" +id.getText()+ "'"; // 퇴실 시간 저장
										db.JDBC.executeQuery(sq1);
										System.out.println(sq1);
										String sql2 = "SELECT ENTRANCE FROM TIME WHERE CUSTID= '"+id.getText()+"'";
										ResultSet rs1 =db.JDBC.getResultSet(sql2);
										String sql3 = "SELECT EXIT FROM TIME WHERE CUSTID= '"+id.getText()+"'";
										ResultSet rs2 =db.JDBC.getResultSet(sql3);
										if(rs1.next()&&rs2.next()) { //사용시간 계산 (초 기준)
											Timestamp t1 = rs1.getTimestamp("ENTRANCE");
											Timestamp t2 = rs2.getTimestamp("EXIT");
											long diff = t2.getTime() - t1.getTime();
											long diffs =diff/1000;
											System.out.println(diffs);
											String sql4 = "SELECT RMTIME FROM TIME WHERE CUSTID = '"+id.getText()+"'";
											ResultSet rs3 = db.JDBC.getResultSet(sql4);
											if(rs3.next()) {
												long rm = rs3.getLong("RMTIME");
												rmtime = rm - diffs;
												long rmmi = rmtime /60%60;
												long rmho = rmtime /(60*60)%24;
												long rmda = rmtime /(24*60*60);
												time.setText(""+rmda+"일 "+rmho+"시간 "+rmmi+"분 남음                 ");
												String sql5="UPDATE TIME SET RMTIME='"+rmtime+"' WHERE CUSTID = '"+id.getText()+"'";
												db.JDBC.executeQuery(sql5);
												System.out.println(sql5);
											}
										}
									}
								}else { //입실하는 경우 좌석선택 화면 열기
									sr=new studyRoom(id.getText(),500,480);
									dispose();
								}
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}else { //남은시간이 0이하면 이용권 결제 안내
							JOptionPane.showMessageDialog(this, "이용권을 결제하세요.","안내",JOptionPane.PLAIN_MESSAGE);
						}
					} catch (HeadlessException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			} catch (HeadlessException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(obj==btnLogout) {
			new login("로그인화면",400,400);
			dispose();
		}
	}

}