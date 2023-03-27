package swingDBConnect_project;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserLoginFrame extends JFrame{

	private JPanel panel = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	
	private JButton loginBtn = new JButton("로그인");
	private JButton joinBtn = new JButton("회원가입");
	
	private JLabel label1 = new JLabel("아이디");
	private JLabel label2 = new JLabel("패스워드");
	
	private TextField idField = new TextField();
	private TextField pwField = new TextField();
	
	public UserLoginFrame() {
		initData();
		setInitData();
		addEventListener();
	}


	private void initData() {
		setSize(800, 800);
		
		label1.setSize(10, 30);
		label2.setSize(10, 30);
		
	}

	private void setInitData() {
		panel.setLayout(new FlowLayout());
		// 그리드 레이아웃 가로, 세로, 넓이, 높이
		panel2.setLayout(new GridLayout(2, 2, 1, 5));
		
		panel3.add(loginBtn);
		panel3.add(joinBtn);

		add(idField);
		add(pwField);
		
		add(label1);
		add(label2);
		
		add(panel);
		add(panel2);
		add(panel3);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
	}

	private void addEventListener() {

	}
	
	public static void main(String[] args) {
		new UserLoginFrame();
	}
}
