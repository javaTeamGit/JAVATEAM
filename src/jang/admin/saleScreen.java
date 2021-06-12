package jang.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
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

public class saleScreen extends JFrame{
	//매출 확인 스크린
	
	private JTable table;
	private DefaultTableModel model;
	private Container c;
	private JTextField tfName, tfKor, tfEng, tfMath;
	private JButton btnAdd, btnRemove;
	private JPanel panNorth, panCenter;
	
	public saleScreen(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		c = getContentPane();
		c.setBackground(Color.white);
		
		String header[] = {"번호", "아이디", "결제 가격", "결제 날짜"};
		
		model = new DefaultTableModel(null , header);	//리모콘 역할
		
		ResultSet rs = db.JDBC.getResultSet("SELECT * FROM SALES");
		//SALES 읽어와서 순서대로 jtable에 넣기
		try {
			int i = 0;
			while(rs.next()) {
				model.addRow(new Object[] {i++ , rs.getString("WAY"), rs.getString("PRICE"), rs.getString("TIME")});
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		table = new JTable(model);	//리모컨을 사용하는 TV역할
		//JScrollPane으로 객체 생성
		JScrollPane sc = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sc.setBackground(Color.white);

		c.add(sc);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		db.JDBC.init();
		new saleScreen("매출 확인", 700, 400);
	}
}
