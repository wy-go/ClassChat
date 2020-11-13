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
import javax.swing.SwingConstants;

import school.client.tools.Refresh;
import school.common.User;

public class SetAnnouncePanel extends JPanel implements MouseListener, PanelConstants{
	public SetAnnouncePanel(User stu) {
		admin = stu;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	
		addLabel = new JLabel("    + 发布公告    ");
		addLabel.setOpaque(true);
		addLabel.setBackground(DODGER_BLUE);
		addLabel.setForeground(Color.white);
		addLabel.setFont(new Font("", Font.PLAIN, 16));
		addLabel.addMouseListener(this);
		addPanel = new JPanel();
		addPanel.setPreferredSize(new Dimension(120, 35));
		addPanel.setBackground(DODGER_BLUE);
		addPanel.add(addLabel);
		clearLabel = new JLabel("清 空");
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
		toolPanel.add(addPanel);
		toolPanel.add(Box.createRigidArea(new Dimension(580, 0)));
		toolPanel.add(Box.createHorizontalGlue());
		toolPanel.add(clearPanel);
		
		add(toolPanel);
		Refresh refresh = new Refresh(stu);
		refresh.refreshAnnounce();
		add(new JScrollPane(announcePanel));
		
	}
	
	public void setAnnouncePanel(AnnouncePanel announcePanel) {
		this.announcePanel = announcePanel;
	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == addLabel) {
			new AnnouncePublish(admin);
			
		} else if(e.getSource() == clearLabel) {
		}
	}
	
	public void mousePressed(MouseEvent e) {}
	
	public void mouseReleased(MouseEvent e) {}
	
	public void mouseEntered(MouseEvent e) {}
	
	public void mouseExited(MouseEvent e) {}
	
	private JLabel addLabel, clearLabel;
	private JPanel toolPanel, addPanel, clearPanel;
	private User admin;
	private AnnouncePanel announcePanel;
}
