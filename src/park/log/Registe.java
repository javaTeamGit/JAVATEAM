package park.log;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class Registe extends JFrame implements ActionListener {
	EtchedBorder eborder;
	private JButton rgBtn;
	private JButton Cancle;
	private JTextField[] jt;

	public Registe(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setDefaultCloseOperation(3);
		setLocationRelativeTo(null);
		Container c = getContentPane();
		c.setBackground(Color.white);
		c.setLayout(new FlowLayout());
		// jp1
		JPanel jp1 = new JPanel();
		jp1.setPreferredSize(new Dimension(400, 90));
		jp1.setBackground(Color.white);
		jp1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		ImageIcon icon = new ImageIcon("image/bookmark.png");
		JLabel jl = new JLabel(icon);
		JLabel jl2 = new JLabel("도서관");
		jl2.setBorder(BorderFactory.createEmptyBorder(20, 10, 0, 0));
		Font font = new Font("HY견고딕", Font.BOLD, 35);
		jl2.setFont(font);
		jl2.setForeground(new Color(102, 102, 255));
		jp1.add(jl);
		jp1.add(jl2);

		// jp2
		JPanel jp2 = new JPanel();
		jp2.setLayout(new FlowLayout(FlowLayout.LEFT, 100, 5));
		jp2.setPreferredSize(new Dimension(400, 320));
		jp2.setBackground(Color.white);
		JLabel jl3 = new JLabel("*(필수입력)");
		jl3.setForeground(new Color(102, 102, 255));
		jl3.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 100));
		jp2.add(jl3);
		jt = new JTextField[6];
		JLabel[] jla = new JLabel[6];
		String[] s = { "*아이디", "*패스워드(6글자이상,영문,숫자,특수문자 포함)", "*패스워드 재확인", "*이름", "이메일", "*핸드폰번호(-없이 입력)" };
		Font font2 = new Font("", Font.BOLD, 12);
		for (int i = 0; i < jt.length; i++) {
			if(i>=1&&i<=2) {
			jt[i] = new JPasswordField(20);	
			}
			else {
			jt[i] = new JTextField(20);
			}
			jla[i] = new JLabel(s[i]);
			jla[i].setFont(font2);
			jt[i].setBorder(BorderFactory.createEtchedBorder(new Color(102, 102, 255), Color.white));

			jp2.add(jla[i]);
			jp2.add(jt[i]);
		}

		JPanel jp3 = new JPanel();
		jp3.setBackground(Color.white);
		jp3.setLayout(new FlowLayout());
		rgBtn = new JButton("회원가입");
		rgBtn.setPreferredSize(new Dimension(150, 40));
		rgBtn.setBackground(new Color(0, 0, 255, 190));
		rgBtn.setForeground(Color.white);
		Cancle = new JButton("뒤로가기");
		Cancle.setPreferredSize(new Dimension(150, 40));
		Cancle.setBackground(new Color(0, 0, 255, 190));
		Cancle.setForeground(Color.white);
		jp3.add(rgBtn);
		rgBtn.addActionListener(this);
		jp3.add(Cancle);
		Cancle.addActionListener(this);
		add(jp1);
		add(jp2);
		add(jp3);
		setVisible(true);
	}

	public static void main(String[] args) {
		JFrame j = new JFrame();
		db.JDBC.init();
		new Registe("회원가입", 400, 540);
	}

	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.black);
			g.drawLine(0, 60, 100, 60);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		
		//rgBtn 버튼 클릭
		if (obj == rgBtn) {
			//id가 없으면 입력 메세지
			if (jt[0].getText().equals("")) {
				JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
				for (int i = 0; i < jt.length; i++) {
					jt[i].setBorder(BorderFactory.createEtchedBorder(new Color(102, 102, 255), Color.white));
				}
				jt[0].setBorder(BorderFactory.createEtchedBorder(new Color(255, 0, 0), Color.white));
			}
			//id가 아닌 경우
			else {
				String sql = "SELECT * FROM REGIST WHERE ID ='" + jt[0].getText() + "'";
				ResultSet rs = db.JDBC.getResultSet(sql);
				
				//rs에 의한 try구문
				try {
					//ID가 있을 시(중복 절차)
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "중복된 아이디입니다. 다시 입력해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
						for (int i = 0; i < jt.length; i++) {
							jt[i].setBorder(BorderFactory.createEtchedBorder(new Color(102, 102, 255), Color.white));
						}
						jt[0].setBorder(BorderFactory.createEtchedBorder(new Color(255, 0, 0), Color.white));		
					}
					//없을 시
					else {
					//비번이 재비번이랑 같거나 비어있지 않은 경우
					if (jt[1].getText().equals(jt[2].getText()) && !(jt[1].getText().equals(""))) {
//							if((jt[1].getText().length()>=6)&&
						
						boolean ck = false;
						boolean chack = false;
						boolean numck = false;
						String s = jt[1].getText();
						char [] can = new char[s.length()];
						for (int i = 0; i < can.length; i++) {
							can[i] = s.charAt(i);
							for(int j=33; j<=64;j++) {
								char a = (char)j;
								if(j>=48&&j<=57) {
									if(can[i]==a)
									numck=true;
								}
								else {
								if(can[i]==a) {
									ck=true;
								}
								}
							}
							for(int j=91; j<=96;j++) {
								char a = (char)j;
								if(can[i]==a) {
									ck=true;
								}
							}
							for(int j=123; j<=126;j++) {
								char a = (char)j;
								if(can[i]==a) {
									ck=true;
								}
							}
							for(int j=65; j<=90; j++) {
								char a = (char)j;
								if(can[i]==a)
									chack=true;
							}
							for(int j=97; j<=122; j++) {
								char a = (char)j;
								if(can[i]==a)
									chack=true;
							}
						}
						//비밀번호가 6자리 이상 , ck==true라면;
						if((jt[1].getText().length()>=6)&&ck==true&&numck==true&&chack==true) {
							//폰 번호가 안 비어있는데 이름이 없다면
						if (jt[3].getText().equals("")) {
							System.out.println("이름 x");
							JOptionPane.showMessageDialog(null, "이름을 입력하지 않았습니다. 다시 입력해주세요.", "Message",
									JOptionPane.ERROR_MESSAGE);
							for (int i = 0; i < jt.length; i++) {
								jt[i].setBorder(BorderFactory.createEtchedBorder(new Color(102, 102, 255), Color.white));
							}
							jt[3].setBorder(BorderFactory.createEtchedBorder(new Color(255, 0, 0), Color.white));

						} 
						//폰 번호가 안 비어있는데 이름이 잇다면
						else {
							if(jt[5].getText().equals("")) {
								JOptionPane.showMessageDialog(null, "핸든폰을 입력하지 않았습니다. 다시 입력해주세요.", "Message",
										JOptionPane.ERROR_MESSAGE);
								for (int i = 0; i < jt.length; i++) {
									jt[i].setBorder(BorderFactory.createEtchedBorder(new Color(102, 102, 255), Color.white));
								}
								jt[5].setBorder(BorderFactory.createEtchedBorder(new Color(255, 0, 0), Color.white));
							}
							else {								
								try {
									boolean phck = true;
									String numchk = jt[5].getText();
									char[] phoneck = new char[numchk.length()];
									System.out.println(numchk.length());
									for (int i = 0; i < phoneck.length; i++) {
										phoneck[i]=numchk.charAt(i);
									for(int j=48;j<=57;j++) {
										char a = (char)j;
										if(phoneck[i]==a) {
											phck=true;
										}
									}
									if(phck==false)
										throw new Exception();
									phck=false;
								}
								//이메일이 없다면
							if (jt[4].getText().equals("")) {
								String sql2 = "insert into REGIST (ID,PW,USERNAME,PHONE) values('" + jt[0].getText()
										+ "','" + jt[1].getText() + "','" + jt[3].getText() + "','" + jt[5].getText() + "')";
								System.out.println(sql2);
								db.JDBC.executeQuery(sql2);
								dispose();
								new login("로그인화면", 400, 400);

							} 
							//이메일이 입력되어있다면
							else {
								String sql2 = "insert into REGIST (ID,PW,USERNAME,EMAIL,PHONE) values('"
										+ jt[0].getText() + "','" + jt[1].getText() + "','" + jt[3].getText()
										+ "','" + jt[4].getText() + "','" + jt[5].getText() + "')";
								db.JDBC.executeQuery(sql2);
								System.out.println(sql2);
								dispose();
								new login("로그인화면", 400, 400);

							}
							for (int i = 0; i < jt.length; i++) {
								jt[i].setText("");
							}
					}catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "핸드폰 번호에 숫자만 입력해주세요.", "Message",
								JOptionPane.ERROR_MESSAGE);
						for (int i = 0; i < jt.length; i++) {
							jt[i].setBorder(BorderFactory.createEtchedBorder(new Color(102, 102, 255), Color.white));
						}
						jt[5].setBorder(BorderFactory.createEtchedBorder(new Color(255, 0, 0), Color.white));
						}
					}
						
				}
		}
						else {
							System.out.println("비번너무 없음x");
							JOptionPane.showMessageDialog(null, "비밀번호가 조건과 일치하지 않습니다. 다시 입력해주세요.", "Message",
									JOptionPane.ERROR_MESSAGE);
						
						}

				}
					else if (jt[1].getText().equals("")) {
						System.out.println("비번입력x");
						JOptionPane.showMessageDialog(null, "비밀번호를 입력하지 않았습니다. 다시 입력해주세요.", "Message",
								JOptionPane.ERROR_MESSAGE);
						for (int i = 0; i < jt.length; i++) {
							jt[i].setBorder(BorderFactory.createEtchedBorder(new Color(102, 102, 255), Color.white));
						}
						jt[1].setBorder(BorderFactory.createEtchedBorder(new Color(255, 0, 0), Color.white));
					} else {
						System.out.println("비번입력 o 하지만 다름");
						JOptionPane.showMessageDialog(null, "비밀번호가 같지 않습니다. 다시 입력해주세요.", "Message",
								JOptionPane.ERROR_MESSAGE);
							for (int i = 0; i < jt.length; i++) {
							jt[i].setBorder(BorderFactory.createEtchedBorder(new Color(102, 102, 255), Color.white));
						}
						jt[1].setBorder(BorderFactory.createEtchedBorder(new Color(255, 0, 0), Color.white));
						jt[2].setBorder(BorderFactory.createEtchedBorder(new Color(255, 0, 0), Color.white));

					}
				}//ID가 없을 시 else
				}//try
					catch (Exception a) {
					}
		
		}//else
	}//if obj
		if (obj == Cancle) {
			dispose();
			new login("로그인화면", 400, 400);
		}//cancle

	}//마지막
}
