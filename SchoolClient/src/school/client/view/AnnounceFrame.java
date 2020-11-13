package school.client.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import school.common.Announce;

public class AnnounceFrame extends JFrame implements ActionListener, PublishConstants {
	public AnnounceFrame(Announce announce, boolean read) {
	this.read = read;	
		
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setPreferredSize(new Dimension(PAGE_WIDTH, PAGE_HEIGHT));
	setTitle(announce.getPublisher() + " 发布于 " + announce.getTime() + " " + announce.getReadNum() + "人已读");
	
	Container container = this.getContentPane();
	container.setBackground(Color.white);
	container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
	
	titleLabel = new JLabel(announce.getTitle());
	titleLabel.setFont(new Font("", Font.PLAIN, 15));
	titlePanel = new JPanel();
	titlePanel.setPreferredSize(new Dimension(PAGE_WIDTH, 30));
	titlePanel.setBackground(Color.white);
	titlePanel.add(titleLabel);
	
	textArea = new JTextPane();
	textArea.setText(announce.getText());
	textPane = new JScrollPane(textArea);
	textPane.setPreferredSize(new Dimension(PAGE_WIDTH - 50, PAGE_HEIGHT - 100));
	confirmButton = new JButton("已 读");
	confirmButton.setForeground(DODGER_BLUE);
	confirmButton.setPreferredSize(new Dimension(50, 20));
	confirmButton.addActionListener(this);
	buttonPanel = new JPanel();
	buttonPanel.setPreferredSize(new Dimension(PAGE_WIDTH, 30));
	buttonPanel.setBackground(Color.white);
	buttonPanel.add(confirmButton);

	container.add(titlePanel);
	container.add(textPane);
	if(!read) {
		container.add(buttonPanel);
	}
	pack();

	setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		this.dispose();
	}
	private JLabel titleLabel;
	private JTextPane textArea;
	private JScrollPane textPane;
	private JButton confirmButton;
	private JPanel titlePanel, buttonPanel;
	private boolean read;
}
