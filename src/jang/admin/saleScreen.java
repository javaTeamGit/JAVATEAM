package jang.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import park.log.login;

public class saleScreen extends JFrame implements ActionListener{
	//매출 확인 스크린
	
	private JTable table;
	private DefaultTableModel model;
	private Container c;
	private JPanel panSouth, panCenter;
	private JButton btnLogout;
	
	public saleScreen(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		c = getContentPane();
		c.setBackground(Color.white);
		
		panCenter = new JPanel();
		panCenter.setLayout(new BorderLayout());
		
		String header[] = {"번호", "결제수단", "결제 가격", "결제 날짜", "아이디"};
		
		model = new DefaultTableModel(null , header);	//리모콘 역할
		
		ResultSet rs = db.JDBC.getResultSet("SELECT * FROM SALES");
		//SALES 읽어와서 순서대로 jtable에 넣기
		try {
			int i = 0;
			while(rs.next()) {
				model.addRow(new Object[] {i++ , rs.getString("WAY"), rs.getString("PRICE"), rs.getString("TIME"), rs.getString("ID")});
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		table = new JTable(model);	//리모컨을 사용하는 TV역할
		//JScrollPane으로 객체 생성
		JScrollPane sc = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		//로그아웃
		panSouth = new JPanel();
		
		btnLogout = new JButton("로그아웃");
		btnLogout.setPreferredSize(new Dimension(340, 40));
		btnLogout.setBackground(new Color(0, 0, 255, 190));
		btnLogout.setForeground(Color.white);
		btnLogout.addActionListener(this);

		c.add(panCenter, BorderLayout.CENTER);
		c.add(panSouth, BorderLayout.SOUTH);
		panCenter.add(sc);
		panSouth.add(btnLogout);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		db.JDBC.init();
		new saleScreen("매출 확인", 700, 400);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btnLogout) {
			new adminLogin("관리자 로그인화면",400,400);
			dispose();
		}
	}
}
