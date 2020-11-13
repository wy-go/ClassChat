package school.server.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import school.server.model.ServerConClient;
import school.server.model.ServerDownloadFile;
import school.server.model.ServerUploadFile;

public class ServerFrame extends JFrame implements ActionListener{
	
	public static void main(String[] args){
		new ServerFrame();
	}
	
	public ServerFrame() {
		setTitle("班级管理系统-服务器");
		setPreferredSize(new Dimension(860, 640));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		serverPanel = new JPanel();
		serverPanel.setPreferredSize(new Dimension(500, 400));
		startButton = new JButton("启动服务器");
		startButton.addActionListener(this);
		stopButton = new JButton("关闭服务器");
		stopButton.addActionListener(this);
		serverPanel.add(startButton);
		serverPanel.add(stopButton);
		
		getContentPane().add(serverPanel);
		pack();
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startButton) {
			Thread t1 = new ServerConClient();
			t1.start();
			Thread t2 = new ServerDownloadFile();
		    t2.start();
		    System.out.println("1");
		    Thread t3 = new ServerUploadFile();
		    t3.start();
		    System.out.println("2");
		} else if(e.getSource() == stopButton){
			System.exit(0);
		}
	}

	JPanel serverPanel;
	JButton startButton, stopButton;

}
