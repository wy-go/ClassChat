package school.client.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import school.common.User;

public class RecordPanel extends JPanel implements MouseListener, PanelConstants{
	public RecordPanel(User stu) {
		admin = stu;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		clearLabel = new JLabel("清    空");
		clearLabel.setOpaque(true);
		clearLabel.setBackground(DODGER_BLUE);
		clearLabel.setForeground(Color.white);
		clearLabel.setFont(new Font("", Font.PLAIN, 16));
		clearPanel = new JPanel();
		clearPanel.setPreferredSize(new Dimension(90, 35));
		clearPanel.setBackground(DODGER_BLUE);
		clearPanel.add(clearLabel);
		toolPanel = new JPanel();
		toolPanel.setPreferredSize(new Dimension(800, 35));
		toolPanel.setLayout(new BoxLayout(toolPanel, BoxLayout.X_AXIS));
		toolPanel.add(clearPanel);
		toolPanel.add(Box.createRigidArea(new Dimension(622, 0)));
		toolPanel.add(Box.createHorizontalGlue());
		
		add(toolPanel);
		add(new JScrollPane(new VotePanel()));
		
			
		}
		public void mouseClicked(MouseEvent e) {}
		
		public void mousePressed(MouseEvent e) {}
		
		public void mouseReleased(MouseEvent e) {}
		
		public void mouseEntered(MouseEvent e) {}
		
		public void mouseExited(MouseEvent e) {}
		
		private JLabel clearLabel;
		private JPanel toolPanel, clearPanel;
		private User admin;
}
