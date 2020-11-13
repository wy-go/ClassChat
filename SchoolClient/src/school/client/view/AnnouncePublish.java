package school.client.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import school.client.tools.ManageClientConServerThread;
import school.common.Announce;
import school.common.Message;
import school.common.MessageType;
import school.common.User;

public class AnnouncePublish extends JFrame implements PublishConstants{
	public AnnouncePublish(User stu) {
		publisher = stu;
			
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(PAGE_WIDTH, PAGE_HEIGHT));
		setTitle("发布公告");
		
		titleLabel = new JLabel("标题（必填）");
		titleLabel.setBounds(30, 20, 90, 30);
		titleLabel.setFont(new Font("", Font.PLAIN, 15));
		titleLabel.setForeground(Color.gray);
		titleField = new JTextField();
		titleField.setBounds(28, 55, 464, 30);
		titleField.setFont(new Font("", Font.PLAIN, 30));
		bodyLabel = new JLabel("正文（必填）");
		bodyLabel.setBounds(30, 90, 90, 30);
		bodyLabel.setFont(new Font("", Font.PLAIN, 15));
		bodyLabel.setForeground(Color.gray);
		bodyArea = new JTextArea();
		bodyArea.setFont(new Font("", Font.PLAIN, 16));
		bodyPane = new JScrollPane(bodyArea);
		bodyPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		bodyPane.setBounds(30, 125, 460, 245);
		cancelButton = new JButton("取消");
		cancelButton.setFont(new Font("", Font.PLAIN, 14));
		cancelButton.setBounds(137, 392, 120, 40);
		cancelButton.addActionListener(new ButtonListener());
		publishButton = new JButton("发布");
		publishButton.setFont(new Font("", Font.PLAIN, 14));
		publishButton.setBounds(263, 392, 120, 40);
		publishButton.addActionListener(new ButtonListener());
		
		announcePanel = new JPanel();
		announcePanel.setLayout(null);
		announcePanel.add(titleLabel);
		announcePanel.add(titleField);
		announcePanel.add(bodyLabel);
		announcePanel.add(bodyPane);
		announcePanel.add(cancelButton);
		announcePanel.add(publishButton);
		
		getContentPane().add(announcePanel);
		pack();
		setVisible(true);
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == publishButton) {
				Message m = new Message();
				m.setMesType(MessageType.ANNOUNCEMENT);
				m.setSender(publisher.getStuName());
				Date date = new Date();
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss" );
		        String time =sdf.format(date);
				m.setTime(time);
				Announce announce = new Announce(titleField.getText(), bodyArea.getText(), m.getSender(),
						m.getTime(), 0);
				Announce[] transAnnounce = new Announce[1];
				transAnnounce[0] = announce;
				m.setContent(transAnnounce);
				try {
					ObjectOutputStream oos = new ObjectOutputStream
					(ManageClientConServerThread.getClientConServerThread(publisher.getStuName()).getS().getOutputStream());
					oos.writeObject(m);
					oos.flush();
				} catch(IOException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(AnnouncePublish.this, "发布成功");
			}
			AnnouncePublish.this.dispose();
		}
	}
	
	private JTextField titleField;
	private JTextArea bodyArea;
	private JLabel titleLabel, bodyLabel;
	private JButton cancelButton, publishButton;
	private JPanel announcePanel;
	private JScrollPane bodyPane;
	private User publisher;
}
