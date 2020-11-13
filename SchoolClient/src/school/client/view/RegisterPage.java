package school.client.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterPage extends JFrame{
	public RegisterPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(PAGE_WIDTH, PAGE_HEIGHT));
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
	
		titleLab = new JLabel("用户注册");
		titleLab.setFont(new Font("", Font.PLAIN, 17));
		nameLab = new JLabel("姓名");
		stuIDLab = new JLabel("学号");
		passwordLab = new JLabel("密码");
		passConfirmLab = new JLabel("确认密码");
		nameField = new JTextField();
		stuIDField = new JTextField();
		passwordField = new JPasswordField();
		passConfirmField = new JPasswordField();
		confirmButton = new JButton("确定");
		confirmButton.addActionListener(new ButtonListener());
		
		titleLab.setBounds((PAGE_WIDTH - TITLE_WIDTH) / 2, TITLE_VERTICAL_MARGIN, TITLE_WIDTH, COMPONENT_HEIGHT);
		nameLab.setBounds(LEFT_MARGIN, 2 * TITLE_VERTICAL_MARGIN + COMPONENT_HEIGHT, LABEL_WIDTH, COMPONENT_HEIGHT);
		nameField.setBounds(LEFT_MARGIN + LABEL_WIDTH, 2 * TITLE_VERTICAL_MARGIN + COMPONENT_HEIGHT, FIELD_WIDTH, COMPONENT_HEIGHT);
		stuIDLab.setBounds(LEFT_MARGIN,  + 2 * TITLE_VERTICAL_MARGIN + 2 * COMPONENT_HEIGHT + VERTICAL_MARGIN, LABEL_WIDTH, 
				COMPONENT_HEIGHT);
		stuIDField.setBounds(LEFT_MARGIN + LABEL_WIDTH, 2 * TITLE_VERTICAL_MARGIN + 2 * COMPONENT_HEIGHT + VERTICAL_MARGIN, 
				FIELD_WIDTH, COMPONENT_HEIGHT);
		passwordLab.setBounds(LEFT_MARGIN, 2 * TITLE_VERTICAL_MARGIN + 3 * COMPONENT_HEIGHT + 2 * VERTICAL_MARGIN, LABEL_WIDTH, 
				COMPONENT_HEIGHT);
		passwordField.setBounds(LEFT_MARGIN + LABEL_WIDTH, 2 * TITLE_VERTICAL_MARGIN + 3 * COMPONENT_HEIGHT + 2 * VERTICAL_MARGIN, 
				FIELD_WIDTH, COMPONENT_HEIGHT);
		passConfirmLab.setBounds(LEFT_MARGIN, 2 * TITLE_VERTICAL_MARGIN + 4 * COMPONENT_HEIGHT + 3 * VERTICAL_MARGIN, LABEL_WIDTH, 
				COMPONENT_HEIGHT);
		passConfirmField.setBounds(LEFT_MARGIN + LABEL_WIDTH, 2 * TITLE_VERTICAL_MARGIN + 4 * COMPONENT_HEIGHT + 3 * VERTICAL_MARGIN,
				FIELD_WIDTH, COMPONENT_HEIGHT);
		confirmButton.setBounds(LEFT_MARGIN - 2, 2 * TITLE_VERTICAL_MARGIN + 5 * COMPONENT_HEIGHT + 4 * VERTICAL_MARGIN, LABEL_WIDTH 
				+ FIELD_WIDTH + 2, COMPONENT_HEIGHT + 13);
		pane.setBackground(Color.white);
		pane.add(titleLab);
		pane.add(nameLab);
		pane.add(nameField);
		pane.add(stuIDLab);
		pane.add(stuIDField);
		pane.add(passwordLab);
		pane.add(passwordField);
		pane.add(passConfirmLab);
		pane.add(passConfirmField);
		pane.add(confirmButton);
		pack();
		setVisible(true);
	}
	private final int PAGE_WIDTH = 280, PAGE_HEIGHT = 360, TITLE_VERTICAL_MARGIN = 38, TITLE_WIDTH = 70,VERTICAL_MARGIN = 20,
			LABEL_WIDTH = 55, FIELD_WIDTH = 178, COMPONENT_HEIGHT = 20, LEFT_MARGIN = (PAGE_WIDTH - LABEL_WIDTH - FIELD_WIDTH) / 2;
	private JLabel titleLab, nameLab, stuIDLab, passwordLab, passConfirmLab;
	private JTextField nameField, stuIDField;
	private JPasswordField passwordField, passConfirmField;
	private JButton confirmButton;
	private Container pane = this.getContentPane();
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
	
}
