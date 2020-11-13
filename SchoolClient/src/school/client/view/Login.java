package school.client.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Login extends JFrame implements LogConstants{
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		new Login();
	}
	
	public Login() {
		setTitle("班级管理系统-登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(APPLICATION_WIDTH, APPLICATION_HEIGHT));
		
		loginPanel = new JPanel();
		loginPanel.setLayout(null);
		loginPanel.setPreferredSize(new Dimension(APPLICATION_WIDTH, APPLICATION_HEIGHT));
		loginPanel.setBackground(Color.white);
		
		icon = new ImageIcon("src/school/client/view/sd_logo.jpg");
	    welcomeLabel = new JLabel("欢迎登录", icon, SwingConstants.CENTER);
		welcomeLabel.setFont(new Font(WELCOME_FONT_NAME, Font.PLAIN, WELCOME_FONT_SIZE));
		welcomeLabel.setBounds(0, 0, APPLICATION_WIDTH, TOP_LEFT_MARGIN);
		
		loginPanel.add(welcomeLabel);
		center = new LogCenterPanel(this);
		center.setBounds(TOP_LEFT_MARGIN, TOP_LEFT_MARGIN, CENTER_WIDTH, CENTER_HEIGHT);
		loginPanel.add(center);
		
		getContentPane().add(loginPanel);
		pack();
		setVisible(true);
	}
	ImageIcon icon;
	JLabel welcomeLabel;
	JPanel loginPanel;
	LogCenterPanel center;
}
