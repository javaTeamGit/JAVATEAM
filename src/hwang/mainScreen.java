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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import jang.infoScreen;
import jang.noticeScreen;
import jang.startScreen;
import park.log.PRecord;
import park.log.login;

public class mainScreen extends JFrame implements ActionListener{
	private JButton btnNotice, btnInfo, btnPayment, btnRoom, btnLogout, btnPRecord, btnDeveloper;
	private JLabel id, time, seatlb;
	private startScreen ss;
	private studyRoom sr;
	private long rmtime = 0;
	private int seat;
	
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
		p1.setLayout(new GridLayout(1,4));
		btnNotice = new JButton("매장 공지");
		btnInfo = new JButton("매장 정보");
		btnPayment = new JButton("이용권 구매");
		btnRoom = new JButton("입퇴실");
		btnNotice.setFont(new Font("맑은 고딕",Font.BOLD,14));
		btnInfo.setFont(new Font("맑은 고딕",Font.BOLD,14));
		btnPayment.setFont(new Font("맑은 고딕",Font.BOLD,13));
		btnRoom.setFont(new Font("맑은 고딕",Font.BOLD,14));
		btnNotice.setPreferredSize(new Dimension(170, 50));
		btnInfo.setPreferredSize(new Dimension(170, 50));
		btnPayment.setPreferredSize(new Dimension(170, 50));
		btnRoom.setPreferredSize(new Dimension(170, 50));
		btnNotice.setBackground(new Color(80,188,223,255));
		btnInfo.setBackground(new Color(118,199,228,255));
		btnPayment.setBackground(new Color(150,210,234,255));
		btnRoom.setBackground(new Color(178,221,239,255));
		btnNotice.setForeground(Color.black);
		btnInfo.setForeground(Color.black);
		btnPayment.setForeground(Color.black);
		btnRoom.setForeground(Color.black);
		btnNotice.addActionListener(this);
		btnInfo.addActionListener(this);
		btnPayment.addActionListener(this);
		btnRoom.addActionListener(this);
		
		p1.add(btnNotice);
		p1.add(btnInfo);
		p1.add(btnPayment);
		p1.add(btnRoom);
		
		
		JPanel p2 = new JPanel();
		p2.setBackground(Color.white);
		p2.setLayout(null);
		JLabel lbl1 = new JLabel("독서실 인하공전점");
		lbl1.setFont(new Font("맑은 고딕",Font.BOLD,18));
		lbl1.setHorizontalAlignment(JLabel.CENTER);
		lbl1.setBounds(0, 20, 430, 20);
		ImageIcon imgmain = new ImageIcon("image/main.png");
		JLabel lblScreen = new JLabel(imgmain);
		lblScreen.setBounds(15, 40, 400, 430);
		ImageIcon imgseat = new ImageIcon("image/mainseat.png");
		JLabel lbl2 = new JLabel(imgseat);
		lbl2.setBounds(15, 200, 400, 100);
		ImageIcon imginf = new ImageIcon("image/maininfo.png");
		JLabel lbl3 = new JLabel(imginf);
		lbl3.setBounds(15, 80, 400, 100);
		ImageIcon imglogo = new ImageIcon("image/bookmark.png");
		JLabel lbl4 = new JLabel(imglogo);
		lbl4.setBounds(40, 90, 70, 70);
		id = new JLabel(title);
		id.setFont(new Font("맑은 고딕",Font.PLAIN,14));
		id.setBounds(120, 95, 150, 40);
		JLabel notice = new JLabel("알림: 0  쪽지: 0");
		notice.setFont(new Font("맑은 고딕",Font.BOLD,14));
		notice.setBounds(120, 125, 100, 40);
		JLabel lbl5 = new JLabel("개인실");
		lbl5.setFont(new Font("맑은 고딕",Font.BOLD,15));
		lbl5.setBounds(70, 210, 100, 40);
		JLabel seatsu = new JLabel("/ 35");
		seatsu.setFont(new Font("맑은 고딕",Font.BOLD,18));
		seatsu.setBounds(90, 235, 100, 40);
		setSeat();
		seatlb=new JLabel();
		seatlb.setText(String.valueOf(seat));
		seatlb.setFont(new Font("맑은 고딕",Font.BOLD,18));
		seatlb.setBounds(60, 235, 100, 40);
		
		btnLogout = new JButton("로그아웃");
		btnLogout.setFont(new Font("맑은 고딕",Font.BOLD,10));
		btnLogout.setBackground(new Color(118,199,228,255));
		btnLogout.setForeground(Color.white);
		btnLogout.addActionListener(this);
		btnLogout.setBounds(300, 100, 74, 30);
		
		
		JLabel lbl6 = new JLabel(" 잔여 시간:");
		lbl6.setFont(new Font("맑은 고딕",Font.BOLD,15));
		lbl6.setOpaque(true);
		lbl6.setBackground(new Color(204,232,244,255));
		lbl6.setBounds(30, 320, 370, 35);
		time = new JLabel("00일 00시간 00분 남음");
		time.setFont(new Font("맑은 고딕",Font.BOLD,15));
		time.setBounds(110, 320, 200, 35);
		
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
						time.setText(""+rmdy+"일 "+rmhr+"시간 남음");
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
							time.setText(""+rmda+"일 "+rmho+"시간 "+rmmi+"분 남음");
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		btnPRecord = new JButton("이용 현황");
		btnPRecord.setFont(new Font("맑은 고딕",Font.BOLD,15));
		btnPRecord.setBackground(new Color(90,170,200,255));
		btnPRecord.setForeground(Color.white);
		btnPRecord.addActionListener(this);
		btnPRecord.setBounds(30, 380, 180, 50);
		
		btnDeveloper = new JButton("개발 정보");
		btnDeveloper.setFont(new Font("맑은 고딕",Font.BOLD,15));
		btnDeveloper.setBackground(new Color(120,180,210,255));
		btnDeveloper.setForeground(Color.white);
		btnDeveloper.addActionListener(this);
		btnDeveloper.setBounds(290, 380, 100, 50);
		
		p2.add(time);
		p2.add(lbl6);
		p2.add(lbl1);
		p2.add(lbl4);
		p2.add(id);
		p2.add(notice);
		p2.add(btnLogout);
		p2.add(seatsu);
		p2.add(seatlb);
		p2.add(lbl5);
		p2.add(lbl3);
		p2.add(btnPRecord);
		p2.add(btnDeveloper);
		p2.add(lbl2);
		p2.add(lblScreen);
		
		
		c.add(p1,BorderLayout.NORTH);
		c.add(p2,BorderLayout.CENTER);
		setVisible(true);
	}

	private void setSeat() {
		seat=35;
		String r="SELECT SEATID FROM TIME WHERE SEATID IS NOT NULL"; //실시간 좌석을 해놨을 경우
		ResultSet result = db.JDBC.getResultSet(r);
		try {
			while(result.next()) {
				seat=seat-1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String r1="SELECT SEATID FROM FIXEDSEAT WHERE SEATID IS NOT NULL"; //고정좌석 확인
		ResultSet result1 = db.JDBC.getResultSet(r1);
		try {
			while(result1.next()) {
				seat=seat-1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		db.JDBC.init();
		new mainScreen("hydra",450,600);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj==btnNotice) {
			new noticeScreen("매장 공지",700,510);
		}else if(obj==btnInfo) {
			new infoScreen("매장 정보",700,510);
		}else if(obj==btnPayment) {
			String fsck1="SELECT * FROM FIXEDSEAT WHERE CUSTID = '"+id.getText()+"'";
			ResultSet rfs1 = db.JDBC.getResultSet(fsck1);
			try {
				if(rfs1.next()) { //고정석 결제되어있는 경우
					JOptionPane.showMessageDialog(this, "이미 결제되어있는 계정입니다. 모든 시간 소모 후 재결제 바랍니다.","안내",JOptionPane.PLAIN_MESSAGE);
				}else {
					String fsck2="SELECT * FROM TIME WHERE CUSTID = '"+id.getText()+"'";
					ResultSet rfs2 = db.JDBC.getResultSet(fsck2);
					if(rfs2.next()) { //실시간 결제되어있는 경우
						JOptionPane.showMessageDialog(this, "이미 결제되어있는 계정입니다. 모든 시간 소모 후 재결제 바랍니다.","안내",JOptionPane.PLAIN_MESSAGE);
					}else {
						ss=new startScreen(id.getText(),300,230);
						dispose();
					}
				}
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
										seat= seat+1;
										seatlb.setText(String.valueOf(seat));
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
											if(rs3.next()) {	//남은시간 계산해서 보여줌
												long rm = rs3.getLong("RMTIME");
												rmtime = rm - diffs;
												long rmmi = rmtime /60%60;
												long rmho = rmtime /(60*60)%24;
												long rmda = rmtime /(24*60*60);
												time.setText(""+rmda+"일 "+rmho+"시간 "+rmmi+"분 남음");
												String sql5="UPDATE TIME SET RMTIME='"+rmtime+"' WHERE CUSTID = '"+id.getText()+"'";
												db.JDBC.executeQuery(sql5);
												System.out.println(sql5);
												if(rmtime<=0) { //남은시간이 0보다 적을경우 재구매를 위해 실시간 정보 삭제
													String sql7 = "DELETE FROM TIME WHERE CUSTID = '"+id.getText()+"'";
													db.JDBC.executeQuery(sql7);
												}
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
		}else if(obj==btnPRecord) {
			new PRecord(id.getText(),700,500);
		}else if(obj==btnDeveloper) {
			JOptionPane.showMessageDialog(this, "박형준: 로그인 관련 전부, 이용 현황\n장민수: 결제 전부, 매장 공지, 매장 정보, 매출\n황의충: 메인 화면, 좌석 관련","개발 정보",JOptionPane.PLAIN_MESSAGE);
		}
	}

}