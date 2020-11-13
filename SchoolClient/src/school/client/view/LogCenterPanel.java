package school.client.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import school.client.model.ClientUser;
import school.client.tools.ManageMainPage;
import school.client.tools.ManageStudent;
import school.common.User;

public class LogCenterPanel extends JPanel implements LogConstants{
	public LogCenterPanel(JFrame parentFrame) {
		parent = parentFrame;
		
		setLayout(null);
		setPreferredSize(new Dimension(CENTER_WIDTH, CENTER_HEIGHT));
		setBackground(Color.white);
		setBorder(BorderFactory.createLineBorder(Color.lightGray, BORDER_THICKNESS));
		
		user = new ImageIcon("src/school/client/view/user.jpg");
		user.setImage(user.getImage().getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_DEFAULT));
		lock = new ImageIcon("src/school/client/view/lock.jpg");
		lock.setImage(lock.getImage().getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_DEFAULT));
		
		logLabel = new JLabel("登录账号");
		logLabel.setFont(new Font("STFangsong", Font.PLAIN, 17));
		logLabel.setForeground(Color.black);
		logLabel.setBounds(330, 30, 100, COMPONENT_HEIGHT);
		IDLabel = new JLabel("学号", user, SwingConstants.CENTER);
		IDLabel.setFont(new Font("",Font.PLAIN, COMPONEMT_FONT_SIZE));
		IDLabel.setForeground(Color.gray);
		IDLabel.setBounds(CENTER_WIDTH / 2, TEXT_TOP_MARGIN_ONE, ID_PASSWORD_LABEL_WIDTH, COMPONENT_HEIGHT);
		passwordLabel = new JLabel("密码", lock, SwingConstants.CENTER);
		passwordLabel.setFont(new Font("",Font.PLAIN, COMPONEMT_FONT_SIZE));
		passwordLabel.setForeground(Color.gray);
		passwordLabel.setBounds(CENTER_WIDTH / 2, TEXT_TOP_MARGIN_TWO, ID_PASSWORD_LABEL_WIDTH, COMPONENT_HEIGHT);
		headlineLabel = new JLabel("    大学班级内部事务管理系统");
		headlineLabel.setFont(new Font("", Font.BOLD, 20));
		headlineLabel.setForeground(Color.white);
		headlineLabel.setBounds(BORDER_THICKNESS, BORDER_THICKNESS, CENTER_WIDTH / 2 - BORDER_THICKNESS,
				CENTER_HEIGHT - 2 * BORDER_THICKNESS);
		headlineLabel.setOpaque(true);
		headlineLabel.setBackground(SHANDA_RED);
	    prompt = new JLabel("");
		prompt.setFont(new Font("STFangsong", Font.PLAIN, 13));
		prompt.setBounds(TEXT_LEFT_MARGIN, 70, 100, 20);
		prompt.setForeground(Color.red);
		
		register = new JButton("注   册");
		register.setFont(new Font("", Font.PLAIN, COMPONEMT_FONT_SIZE));
		register.setBounds(TEXT_LEFT_MARGIN, 230, BUTTON_WIDTH, COMPONENT_HEIGHT);
		register.addActionListener(new regisListener());
		login = new JButton("登   录");
		login.setFont(new Font("", Font.PLAIN, COMPONEMT_FONT_SIZE));
		login.setBounds(TEXT_LEFT_MARGIN + TEXT_FIELD_SIZE - BUTTON_WIDTH, 230, BUTTON_WIDTH, COMPONENT_HEIGHT);
		login.addActionListener(new LogListener());
		
		stuID = new JTextField();
		stuID.setBounds(TEXT_LEFT_MARGIN, TEXT_TOP_MARGIN_ONE, TEXT_FIELD_SIZE, COMPONENT_HEIGHT);
		
		password = new JPasswordField();
		password.setBounds(TEXT_LEFT_MARGIN, TEXT_TOP_MARGIN_TWO, TEXT_FIELD_SIZE, COMPONENT_HEIGHT);
		
		add(logLabel);
		add(IDLabel);
		add(stuID);
		add(passwordLabel);
		add(password);
		add(headlineLabel);
		add(login);
		add(register);
		add(prompt);
	}

		private class LogListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				if(event.getSource() == login) {
					ClientUser user = new ClientUser();
					User student = new User();
					student.setStudentID(stuID.getText().trim());
					student.setPassword(new String(password.getPassword()));
					ManageStudent.addStudent(student.getStudentID(), student);
					if(user.checkUser(student)) {
						try {
							parent.dispose();
							MainPage mainPage = new MainPage(student);
							ManageMainPage.addMainPage(student.getStuName(), mainPage);
							
						} catch(Exception e) {
							e.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(LogCenterPanel.this, "用户名密码错误");
						prompt.setText("用户名密码错误.");
						return;
					} 
				}
			}
		}
		private class regisListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				new RegisterFrame();
			}
		}
		
		private JLabel logLabel, IDLabel, passwordLabel, headlineLabel, prompt;
		private JButton login, register;
		private JTextField stuID;
		private JPasswordField password;
		private ImageIcon user, lock;
		private JFrame parent;
		
}
