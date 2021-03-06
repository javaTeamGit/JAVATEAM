package park.log;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import hwang.mainScreen;

public class PRecord extends JFrame implements MouseListener {
	private JLabel jl1;
	private DefaultTableModel model;
	private JTable userTable;
	private Vector<String> row;
	private Image newimg;
	private String strId;
	private Vector<String> column;
	public PRecord(String title,int width,int height) {
		setTitle(title);
		strId=title;
		setSize(width, height);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.setBackground(Color.white);
		JPanel jp1 = new JPanel();
		jp1.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
		jp1.setBackground(Color.white);
		jp1.setPreferredSize(new Dimension(700, 50));
		ImageIcon img = new ImageIcon("image/aro2.png");
		Image setImg = img.getImage();
		Image setImg2 = setImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon cImge = new ImageIcon(setImg2);
		jl1 = new JLabel(cImge);
		jl1.addMouseListener(this);
		jp1.add(jl1);
		
		
		JPanel jp2 = new JPanel();
		jp2.setLayout(new GridLayout(0,1));
		column = new Vector<>();
		column.add("ID");
		column.add("좌석");
		column.add("입실시간");
		column.add("퇴실시간");
		column.add("잔여시간");
		model = new DefaultTableModel(column,0);
		row = new Vector<String>();
		lookSum(row);
		model.addRow(row);
		JTable jt = new JTable(model);
		
		JScrollPane jst = new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JTableHeader header = jt.getTableHeader();
		header.setForeground(Color.white);
		ImageIcon img3 = new ImageIcon("image/lib.jpg");
		newimg = img3.getImage();
		//das
		header.setBackground(new Color(0, 0, 255, 190));
		jst.getViewport().setBackground(Color.white);
		jp2.add(jst);
		add(jp1,BorderLayout.NORTH);
		add(jp2,BorderLayout.CENTER);
		setVisible(true);
	}
	public static void main(String[] args) {
		JFrame j = new JFrame();
		db.JDBC.init();
		//끝!
		new PRecord("xptmxm123",700,500);
	}
	private void lookSum(Vector<String> row) {
		String sql = "SELECT * FROM TIME WHERE CUSTID='"+strId+"'";
		String sql2 = "SELECT * FROM FIXEDSEAT WHERE CUSTID='"+strId+"'";
		System.out.println(sql);
		System.out.println(sql2);
		ResultSet rs = db.JDBC.getResultSet(sql);
		
		String id ="";
		int index =1;
		try {
			while(rs.next()) {
				for (int i = 1; i <=5; i++) {
					 id = rs.getString(i);
					 row.add(id);
						System.out.println(id);
				}
				index++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs2 = db.JDBC.getResultSet(sql2);
		
		 id ="";
		 index =1;
		try {
			while(rs2.next()) {
				column.clear();
				column.add("CUSTID");
				column.add("SEATID");
				column.add("ENDDAYS");
				for (int i = 1; i <=3; i++) {
					 id = rs2.getString(i);
					 row.add(id);
						System.out.println(id);
				}
				index++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		Object obj = e.getSource();
		if(obj==jl1) {
			dispose();	
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
