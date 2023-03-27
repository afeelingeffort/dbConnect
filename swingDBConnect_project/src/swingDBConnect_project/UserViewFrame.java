package swingDBConnect_project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UserViewFrame extends JFrame implements ActionListener {

	private UserController userController = new UserController();
	private JPanel jPanel = new JPanel();

	private JButton insertBtn = new JButton("데이터 삽입");
	private JButton selectBtn = new JButton("데이터 조회");
	private JButton deleteBtn = new JButton("데이터 삭제");
	private JButton updateBtn = new JButton("데이터 수정");

	private JTextField textField = new JTextField(100);
	private JTextArea textArea = new JTextArea();
	private JLabel textLabel = new JLabel("가계부 데이터 ");

	public UserViewFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	// 인스턴스화
	private void initData() {
		setSize(800, 800);

		jPanel.add(textLabel);
		jPanel.add(textField);

		jPanel.add(insertBtn);
		jPanel.add(selectBtn);
		jPanel.add(deleteBtn);
		jPanel.add(updateBtn);

		jPanel.add(textArea);
	}

	//add, 크기 설정, 위치 설정
	private void setInitLayout() {
		jPanel.setLayout(null);

		add(jPanel);
		textLabel.setBounds(40, 20, 100, 30);
		textField.setBounds(130, 20, 413, 30);
		textArea.setBounds(40, 65, 500, 650);

		insertBtn.setBounds(550, 100, 130, 50);
		selectBtn.setBounds(550, 200, 130, 50);
		deleteBtn.setBounds(550, 300, 130, 50);
		updateBtn.setBounds(550, 400, 130, 50);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();

		if (textField.getText().equals("") && btn != selectBtn) {
			System.out.println("값이 없습니다.");
			return;
		}

		String str = textField.getText();

		if (btn == insertBtn) {
			UserDTO userDTO = new UserDTO(5453152, "2022-03-01", 100000, 10123, 1234, str);
			int result = userController.requestInsertByDTO(userDTO);
			System.out.println(result);

		} else if (btn == selectBtn) {
			textArea.setText("");
			ArrayList<UserDTO> userDTO = userController.requestSelect();

			for (int i = 0; i < userDTO.size(); i++) {
				textArea.append(userDTO.get(i).getId() + "\n");
				textArea.append(userDTO.get(i).getInputDate() + "\n");
				textArea.append(userDTO.get(i).getUserMoney() + "\n");
				textArea.append(userDTO.get(i).getUserDeposit() + "\n");
				textArea.append(userDTO.get(i).getUserWithdraw() + "\n");
				textArea.append(userDTO.get(i).getUserMemo() + "\n");
			}
		} else if (btn == deleteBtn) {
			try {
				int i = Integer.parseInt(str);
				int result = userController.requestDeleteById(i);
				System.out.println(result);
			} catch (Exception e2) {
				System.out.println("문자열은 삭제가 안돼요");
			}
		}
	}

	private void addEventListener() {
//		UserDTO userDTO = new UserDTO();

		// 삽입
		insertBtn.addActionListener(this);

		// 조회
		selectBtn.addActionListener(this);

		// 삭제
		deleteBtn.addActionListener(this);

		updateBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				int result = userController.requestUpdate(userDTO.getId(), userDTO.getInputDate(),
//						userDTO.getUserMoney(), userDTO.getUserDeposit());
//				System.out.println(result);
//
//				textArea.setText(getName());
			}
		});
	}

	public static void main(String[] args) {
		new UserViewFrame();
	} // end of main

} // end of class
