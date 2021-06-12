package jang;

import java.awt.BorderLayout;
import java.awt.Container;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class saleScreen extends JFrame{
	
	private JTable table;
	private DefaultTableModel model;
	private Container c;
	private JTextField tfName, tfKor, tfEng, tfMath;
	private JButton btnAdd, btnRemove;
	
	public saleScreen(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		c = getContentPane();
		
		String header[] = {"번호", "아이디", "결제 가격", "결제 날짜"};	//헤더부분은 1차원 배열
		
		model = new DefaultTableModel(null , header);	//리모콘 역할
		
		ResultSet rs = db.JDBC.getResultSet("SELECT * FROM SALES");
		
		//long time = System.currentTimeMillis();
		//SimpleDateFormat simpl = new SimpleDateFormat("yyyy년 MM월 dd일 aa hh시 mm분 ss초");
		//String s = simpl.format(time);
		try {
			while(rs.next()) {
				model.addRow(new Object[] {rs.getString("ORDER"), rs.getString("WAY"), rs.getString("PRICE"), rs.getString("TIME")});
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		table = new JTable(model);	//리모컨을 사용하는 TV역할
		//JScrollPane으로 객체 생성
		JScrollPane sc = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		c.add(sc);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new saleScreen("JTable 연습", 400, 300);
	}
}
