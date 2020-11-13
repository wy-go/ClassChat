package school.client.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import school.client.model.ClientUser;
import school.common.Announce;
import school.common.User;

public class AnnouncePanel extends JPanel {
	private HashMap hm = new HashMap<String, Announce>();
	private void addAnnounce(String announceTitle, Announce announce) {
		hm.put(announceTitle, announce);
	}
	private Announce getAnnounce(String announceTitle) {
		return (Announce)hm.get(announceTitle);
	}

	
	public AnnouncePanel(Announce[] announces) {
		announceNum = announces.length;
		AnnouncePan[] announce = new AnnouncePan[announceNum];
		
		setLayout(new GridLayout(announceNum, 1));
		for(int i = 0; i < announceNum; i++) {
			addAnnounce(announces[i].getTitle(), announces[i]);
			announce[i] = new AnnouncePan(announces[i]);
			add(announce[i]);
		}
		a++;
	}
	
	private class AnnouncePan extends JPanel implements MouseListener, PanelConstants{
		public AnnouncePan(Announce announce) {
			setPreferredSize(new Dimension(PANEL_WIDTH, SMALL_PANEL_HEIGHT));
			setBackground(Color.white);
			setBorder(new LineBorder(WHITE_SMOKE));
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			titleLabel = new JLabel(announce.getTitle());
			titleLabel.setFont(new Font("", Font.PLAIN, 16));
			titleLabel.addMouseListener(this);
			message = announce.getPublisher() + " 发表于 " + announce.getTime();
			messageLabel = new JLabel(message);
			numLabel = new JLabel(announce.getReadNum() + "人已读");
			numLabel.setForeground(DODGER_BLUE);
			add(titleLabel);
			add(Box.createHorizontalGlue());
			add(messageLabel);
			add(Box.createRigidArea(new Dimension(10, 0)));
			add(numLabel);
		}
		
		public void mouseClicked(MouseEvent e) {
			new AnnounceFrame(getAnnounce(((JLabel)e.getSource()).getText()), true);
		}
		
		public void mousePressed(MouseEvent e) {}
		
		public void mouseReleased(MouseEvent e) {}
		
		public void mouseEntered(MouseEvent e) {
			setBackground(WHITE_SMOKE);
		}
		
		public void mouseExited(MouseEvent e) {
			setBackground(Color.white);
		}
		private JLabel titleLabel, messageLabel, numLabel;
		private String message;
	}
	private int announceNum;
	public static int a = 0;
}
