package school.client.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OptionPanel extends JPanel implements MouseListener, WindowConstants {
	public OptionPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		for(int i = 0; i < optionNum; i++) {
			option[i] = new Option("选项名", 0);
			add(option[i]);
		}
	}
	
	public void mouseClicked(MouseEvent e) {}
	
    public void mousePressed(MouseEvent e) {}
		
	public void mouseReleased(MouseEvent e) {}
		
	public void mouseEntered(MouseEvent e) {}
		
	public void mouseExited(MouseEvent e) {}
	
	private class Option extends JPanel implements MouseListener {
		public Option(String content, int votedNum) {
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setPreferredSize(new Dimension(WINDOW_WIDTH, OPTION_HEIGHT));
			setBackground(WHITE_SMOKE);
			
			contentLabel = new JLabel(content);
			contentLabel.setForeground(Color.gray);
			contentLabel.setFont(new Font("", Font.PLAIN, 16));
			contentLabel.addMouseListener(this);
			votedNumLabel = new JLabel(votedNum + "票");
			votedNumLabel.setForeground(Color.gray);
			
			add(contentLabel);
			add(Box.createHorizontalGlue());
			add(votedNumLabel);
			
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
		private Boolean checked = false;
		private JLabel contentLabel, votedNumLabel, checkedNumLabel, checkedLabel; 
		private JPanel westPanel;
			
		}
	
	
	private int optionNum = 10;
	private Option[] option = new Option[optionNum];
	
	
 }
