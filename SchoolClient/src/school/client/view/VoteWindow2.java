package school.client.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VoteWindow2 extends JFrame implements WindowConstants {
	public VoteWindow2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		setTitle("投票详情");
		
		messagePanel = new JPanel();
		messagePanel.setBackground(Color.white);
		messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.X_AXIS));
		nameLabel = new JLabel("发布人");
		timeLabel = new JLabel("发布时间");
		timeLabel.setForeground(Color.gray);
		messagePanel.add(nameLabel);
		messagePanel.add(Box.createHorizontalGlue());
		messagePanel.add(timeLabel);
		
		titlePanel = new JPanel();
		titlePanel.setBackground(Color.white);
		titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
		titleLabel = new JLabel("投票标题");
		titleLabel.setFont(new Font("", Font.PLAIN, 15));
		titlePanel.add(titleLabel);
		titlePanel.add(Box.createHorizontalGlue());
		
		numPanel = new JPanel();
		numPanel.setBackground(Color.white);
		numPanel.setLayout(new BoxLayout(numPanel, BoxLayout.X_AXIS));
		if(isRadio) {
			typeLabel = new JLabel("单选");
			
		} else {
			
		}
		
		typeLabel.setForeground(Color.gray);
		numLabel = new JLabel("共" + voteNum + "票");
		numLabel.setForeground(Color.gray);
		numPanel.add(typeLabel);
		numPanel.add(Box.createHorizontalGlue());
		numPanel.add(numLabel);
		
		
		
		getContentPane().add(numPanel);
		pack();
		setVisible(true);
		
	}
	
	private boolean isRadio;
	private int voteNum, optionNum = 4;
	private JLabel nameLabel, timeLabel, titleLabel, typeLabel, numLabel;
	private JButton voteButton;
	private JPanel messagePanel, titlePanel, numPanel, optionPanel;
}
