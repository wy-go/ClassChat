package school.client.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class VotePanel extends JPanel implements PanelConstants{
	public VotePanel() {
		setLayout(new GridLayout(voteNum, 1));
		setBackground(Color.white);
		
		votes = new Vote[voteNum];
		for(int i = 0; i < voteNum; i++) {
			votes[i] = new Vote("投票标题", "time");
			add(votes[i]);
		}
	}
	
	private class Vote extends JPanel implements MouseListener{
		public Vote(String title, String time) {
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setPreferredSize(new Dimension(PANEL_WIDTH, SMALL_PANEL_HEIGHT));
			setBackground(Color.white);
			setBorder(new LineBorder(WHITE_SMOKE, 1));
			
			titleLabel = new JLabel(title);
			titleLabel.setFont(new Font("", Font.PLAIN, 16));
			titleLabel.addMouseListener(this);
			timeLabel = new JLabel(time);
			votedNumLabel = new JLabel(votedNum + "人已投");
			votedNumLabel.setForeground(DODGER_BLUE);
			if(voted) 
				votedLabel = new JLabel("已投，查看结果");
			else
				votedLabel = new JLabel("未投票");
			votedLabel.addMouseListener(this);
			
			westPanel = new JPanel();
			westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
			westPanel.setBackground(Color.white);
			westPanel.add(titleLabel);
			westPanel.add(Box.createVerticalGlue());
			westPanel.add(timeLabel);
			
			add(westPanel);
			add(Box.createHorizontalGlue());
			add(votedNumLabel);
			add(Box.createRigidArea(new Dimension(10, 0)));
			add(votedLabel);
		}
        public void mouseClicked(MouseEvent e) {}
		
		public void mousePressed(MouseEvent e) {}
		
		public void mouseReleased(MouseEvent e) {}
		
		public void mouseEntered(MouseEvent e) {
			setBackground(WHITE_SMOKE);
			westPanel.setBackground(WHITE_SMOKE);
		}
		
		public void mouseExited(MouseEvent e) {
			setBackground(Color.white);
			westPanel.setBackground(Color.white);
		}
		
		private int votedNum;
		private Boolean voted = false;
		private JLabel titleLabel, timeLabel, votedNumLabel, votedLabel;
		private JPanel westPanel;
		
	}
	private int voteNum = 20;
	private Vote[] votes;
	
 }
