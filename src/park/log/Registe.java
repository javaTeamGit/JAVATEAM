package park.log;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Registe extends JFrame {
		public Registe(String title,int width,int height) {
			setTitle(title);
			setSize(width, height);
			setDefaultCloseOperation(3);
			setLocationRelativeTo(null);
			JPanel jp1 = new JPanel();
			JPanel jp2 = new JPanel();
			
			//jp1
			GridBagConstraints gbc = new GridBagConstraints();
			jp1.setLayout(new GridBagLayout());
			jp1.setBackground(Color.red);
			gbc.fill = GridBagConstraints.BOTH;
			JButton jl1 = new JButton(" 이름 ");
			JButton jl2 = new JButton(" 아이디 ");
			JButton jl3 = new JButton(" 비밀번호 ");
			JButton jl4 = new JButton(" 핸드폰번호 ");
			JButton jl5 = new JButton(" 이메일 ");
			gbc.gridx=0;
			gbc.gridy=0;
			jp1.add(jl1,gbc);
			gbc.weighty=0.2;
			gbc.gridy=1;
			jp1.add(jl2,gbc);
			gbc.weighty=0.2;
			gbc.gridy=2;
			jp1.add(jl3,gbc);
			gbc.weighty=0.2;
			gbc.gridy=3;
			jp1.add(jl4,gbc);
			gbc.weighty=0.2;
			gbc.gridy=4;
			jp1.add(jl5,gbc);
			gbc.weighty=0.2;
			
			
			
			add(jp1);
			add(jp2);
			setVisible(true);
		}
	public static void main(String[] args) {
		JFrame j = new JFrame();
		new Registe("회원가입",400,800);
	}

}
