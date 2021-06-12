package park.log;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ID_PW extends JFrame implements ActionListener, MouseListener {

	private JButton idBtn;
	private JButton pwBtn;
	private JPanel jp3;
	private JPanel jp2;
	private JTextField jt1;
	private JTextField jt2;
	private JButton look1;
	private JTextField jt3;
	private JTextField jt4;
	private Component look2;

	public ID_PW(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.setBackground(Color.white);
		JPanel jp1 = new JPanel();
		//ID/PW 고르는 버튼
		jp1.setBackground(Color.white);
		jp1.setLayout(new GridLayout(1,0));
		idBtn = new JButton("ID");
		idBtn.setBackground(new Color(0, 0, 255, 190));
		idBtn.setForeground(Color.white);
		idBtn.addActionListener(this);
		pwBtn = new JButton("PW");
		pwBtn.setBackground(new Color(0, 0, 255, 190));
		pwBtn.setForeground(Color.white);
		pwBtn.addActionListener(this);
		jp1.add(idBtn);
		jp1.add(pwBtn);

		add(jp1,BorderLayout.NORTH);
		setPanel();
		setVisible(true);
	}

	public static void main(String[] args) {
		JFrame j = new JFrame();
		db.JDBC.init();
		new ID_PW("아이디/비번 찾기",350,200);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==idBtn) {
			jp3.setVisible(false);
			jp2.setVisible(true);
			
		}
		if(obj==pwBtn) {
			jp2.setVisible(false);
			add(jp3,BorderLayout.CENTER);
			jp3.setVisible(true);
		}
	}
	
	public void setPanel() {

		//id찾기창
		jp2 = new JPanel();
		jp2.setLayout(null);
		jp2.setBackground(Color.white);
		JLabel jl1 = new JLabel("<HTML><U>아이디 찾기</U></HTML>");
		jl1.setFont(new Font("HY견고딕", Font.BOLD, 15));
		jl1.setForeground(new Color(0, 0, 255, 190));
		jl1.setBounds(40, 20, 100, 40);;
		jp2.add(jl1);
		JLabel jl2 = new JLabel("이름 : ");
		jl2.setBounds(80,60, 40, 20);
		JLabel jl3 = new JLabel("핸드폰 번호 : ");
		jl3.setBounds(40,85, 100, 20);
		
		jt1 =new JTextField();
		jt1.setBounds(120,60, 100, 20);
		jt2 =new JTextField();
		jt2.setBounds(120,85, 100, 20);
		look1 = new JButton("찾기");
		look1.addMouseListener(this);
		look1.setBackground(new Color(0, 0, 255, 190));
		look1.setForeground(Color.white);
		look1.setBounds(230,60, 80, 47);
		jp2.add(jl2);
		jp2.add(jt1);
		jp2.add(jl3);
		jp2.add(jt2);
		jp2.add(look1);
		//pw찾기창
		jp3 = new JPanel();
		jp3.setLayout(null);
		jp3.setBackground(Color.white);;
		JLabel jl4 = new JLabel("<HTML><U>비밀번호 찾기</U></HTML>");
		jl4.setFont(new Font("HY견고딕", Font.BOLD, 15));
		jl4.setForeground(new Color(0, 0, 255, 190));
		jl4.setBounds(40, 20, 100, 40);;
		jp3.add(jl4);
		JLabel jl5 = new JLabel("아이디 : ");
		jl5.setBounds(67,60, 60, 20);
		JLabel jl6 = new JLabel("핸드폰 번호 : ");
		jl6.setBounds(40,85, 100, 20);
		
		jt3 =new JTextField();
		jt3.setBounds(120,60, 100, 20);
		jt4 =new JTextField();
		jt4.setBounds(120,85, 100, 20);
		look2 = new JButton("찾기");
		look2.addMouseListener(this);
		look2.setBackground(new Color(0, 0, 255, 190));
		look2.setForeground(Color.white);
		look2.setBounds(230,60, 80, 47);
		jp3.add(jl5);
		jp3.add(jt3);
		jp3.add(jl6);
		jp3.add(jt4);
		jp3.add(look2);
		
		add(jp2,BorderLayout.CENTER);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Object obj = e.getSource();
		if(obj==look1) {
			boolean check = checkID(jt1.getText(),jt2.getText());
			if(check) {
				JOptionPane a = new JOptionPane();
				a.showMessageDialog(null, "찾고계신 ID는"+lookid(jt1.getText())+"입니다.");
			}
			else {
				JOptionPane.showMessageDialog(null, "찾고계신 ID가 없습니다.", "Message",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if(obj==look2) {
			boolean check = checkPW(jt3.getText(),jt4.getText());
			if(check) {
				JOptionPane a = new JOptionPane();
				a.showMessageDialog(null, "찾고계신 PW는"+lookPw(jt3.getText())+"입니다.");
			}
			else {
				JOptionPane.showMessageDialog(null, "찾고계신 PW가 없습니다.", "Message",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	private String lookid(String name) {
		String sql = "SELECT ID FROM REGIST WHERE USERNAME= '"+name+"'";
		ResultSet rs = db.JDBC.getResultSet(sql);
		String id ="";
		int index =1;
		try {
			while(rs.next()) {
				 id = rs.getString(index);
				System.out.println(id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
		
	}

	private String lookPw(String name) {
		String sql = "SELECT PW FROM REGIST WHERE ID= '"+name+"'";
		ResultSet rs = db.JDBC.getResultSet(sql);
		String pw ="";
		int index =1;
		try {
			while(rs.next()) {
				 pw = rs.getString(index);
				System.out.println(pw);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pw;
		
	}
	private boolean checkID(String id, String pw2) {
		boolean check = false;
		String sql = "SELECT * FROM REGIST WHERE  USERNAME='"+id+"'"+" AND PHONE='"+pw2+"'";
		ResultSet rs = db.JDBC.getResultSet(sql);
		try {
			if(rs.next()) {
			check = true;
			}
			else {
				check=false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return check;
	}
	private boolean checkPW(String id, String pw2) {
		boolean check = false;
		String sql = "SELECT * FROM REGIST WHERE  ID='"+id+"'"+" AND PHONE='"+pw2+"'";
		ResultSet rs = db.JDBC.getResultSet(sql);
		try {
			if(rs.next()) {
			check = true;
			}
			else {
				check=false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return check;
	}
}
