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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;

import school.client.model.ClientUser;
import school.common.Message;
import school.common.MessageType;
import school.common.User;

public class RegisterFrame extends JFrame implements ActionListener {
	public RegisterFrame() {
		setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
		this.setPreferredSize(new Dimension(400, 580));
		
		namePane = new JTextPane();
		namePane.setBounds(50, 50, 300, 20);
		nameLabel = new JLabel("姓名");
		nameLabel.setBounds(50, 20, 50, 20);
		nameLabel.setForeground(Color.gray);
		
		IDPane = new JTextPane();
		IDPane.setBounds(50, 110, 300, 20);
		IDLabel = new JLabel("学号");
		IDLabel.setBounds(50, 80, 50, 20);
		IDLabel.setForeground(Color.gray);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(50, 170, 300, 20);
		passwordLabel = new JLabel("密码");
		passwordLabel.setBounds(50, 140, 50, 20);
		passwordLabel.setForeground(Color.gray);
		
		confirmField = new JPasswordField();
		confirmField.setBounds(50, 230, 300, 20);
		confirmLabel = new JLabel("确认密码");
		confirmLabel.setBounds(50, 200, 100, 20);
		confirmLabel.setForeground(Color.gray);
		
		profileLabel = new JLabel("头 像");
	    profileLabel.setForeground(Color.gray);
	    profileLabel.setBounds(50, 260, 50, 20);
		
	    imageLabel = new JLabel();
        imagePanel = new JPanel();
        imagePanel.add(imageLabel);
        imagePanel.setBackground(Color.white);

        PicList imageList = new PicList(imageLabel);

        sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, imageList, imagePanel);
        sp.setOneTouchExpandable (true);
        sp.setBounds(50, 290, 300, 200);
        
		regisButton = new JButton("注 册");
		regisButton.setForeground(new Color(30, 144, 255));
		regisButton.setBounds(100, 510, 200, 25);
		regisButton.addActionListener(this);

        Container container = this.getContentPane();
        container.setLayout(null);
        container.add (namePane);
        container.add (nameLabel);
        container.add (IDPane);
        container.add (IDLabel);
        container.add (passwordField);
        container.add (passwordLabel);
        container.add (confirmField);
        container.add (confirmLabel);
        container.add (profileLabel);
        container.add (sp);
        container.add(regisButton);
        
        pack();
        setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		String pass = new String(passwordField.getPassword());
		String conPass = new String(confirmField.getPassword());
		if(!pass.equals(conPass)) {
			JOptionPane.showMessageDialog(this, "密码不一致");
			return;
		}
		ClientUser user = new ClientUser();
		User student = new User();
		student.setStuName(namePane.getText());
		student.setStudentID(IDPane.getText().trim());
		student.setPassword(pass);
		student.setProfile(sp.getName());
		if(user.regisUser(student).equals("1")) {
			JOptionPane.showMessageDialog(this, "注册成功");
			this.dispose();
		} else if(user.regisUser(student).equals("2")) {
			JOptionPane.showMessageDialog(this, "该用户已注册");
		} else {
			JOptionPane.showMessageDialog(this, "用户名密码错误");
		}
	}
	private JTextPane namePane, IDPane; 
	private JPasswordField passwordField, confirmField;
	private JButton regisButton;
	private JLabel nameLabel, IDLabel, passwordLabel, confirmLabel, profileLabel, imageLabel;
	private JPanel imagePanel;
	private JSplitPane sp ;
}
