package school.client.view;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import school.client.tools.Refresh;
import school.client.util.ImageUtil;
import school.common.Announce;
import school.common.Message;
import school.common.User;

public class MainPage extends JFrame implements MainConstants{
	
	public MainPage(User student) throws FileNotFoundException, IOException, InterruptedException {
		refresh = new Refresh(student);
		this.student = student;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(APPLICATION_WIDTH, APPLICATION_HEIGHT));
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setTitle(student.getStuName() + "--" + student.getPositon());
		
		westPanel = new JPanel();
	    westPanel.setLayout(null);
		westPanel.setPreferredSize(new Dimension(WEST_WIDTH, APPLICATION_HEIGHT));
		westPanel.setBackground(Color.white);
		
		chat = new ImageIcon("src/school/client/view/chat.jpg");
		chat.setImage(chat.getImage().getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_DEFAULT));
		chatButton = new JButton(chat);
		chatButton.setBounds(0, 0, WEST_WIDTH, WEST_WIDTH);
		chatButton.setToolTipText("即时通信");
		chatButton.addMouseListener(new ButtonListener());
		
		announcement = new ImageIcon("src/school/client/view/announcement.jpg");
		announcement.setImage(announcement.getImage().getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_DEFAULT));
		announceButton = new JButton(announcement);
		announceButton.setBounds(0, WEST_WIDTH, WEST_WIDTH, WEST_WIDTH);
		announceButton.setToolTipText("班级公告");
		announceButton.addMouseListener(new ButtonListener());
		
		fileShare = new ImageIcon("src/school/client/view/fileShare.jpg");
		fileShare.setImage(fileShare.getImage().getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_DEFAULT));
		fileShareButton = new JButton(fileShare);
		fileShareButton.setBounds(0, WEST_WIDTH * 2, WEST_WIDTH, WEST_WIDTH);
		fileShareButton.setToolTipText("文件共享");
		fileShareButton.addMouseListener(new ButtonListener());
	    
		vote = new ImageIcon("src/school/client/view/paint.jpg");
		vote.setImage(vote.getImage().getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_DEFAULT));
		voteButton = new JButton(vote);
		voteButton.setBounds(0, WEST_WIDTH * 3, WEST_WIDTH, WEST_WIDTH);
		voteButton.setToolTipText("匿名投票");
		voteButton.addMouseListener(new ButtonListener());
		
		manage = new ImageIcon("src/school/client/view/manage.jpg");
		manage.setImage(manage.getImage().getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_DEFAULT));
		manageButton = new JButton(manage);
		manageButton.setBounds(0, WEST_WIDTH * 4, WEST_WIDTH, WEST_WIDTH);
		manageButton.setToolTipText("班级管理");
		manageButton.addMouseListener(new ButtonListener());
	
		//System.out.println(student);
		Image img = ImageIO.read(new File("src/profileImage/" + student.getProfile()));
		profile = ImageUtil.getRoundImageIcon(img);
		profile.setImage(profile.getImage().getScaledInstance(WEST_WIDTH - 10, WEST_WIDTH - 10, Image.SCALE_DEFAULT));
		profileLabel = new JLabel(profile);
		profileLabel.setBounds(3, APPLICATION_HEIGHT - WEST_WIDTH - 16, WEST_WIDTH - 6, WEST_WIDTH - 6);
		
		westPanel.add(chatButton);
		westPanel.add(announceButton);
		westPanel.add(fileShareButton);
		westPanel.add(voteButton);
		westPanel.add(profileLabel);
		if(!student.getPositon().equals("同学")) {
			westPanel.add(manageButton);
		} 
		
		mainContainer = new JPanel(card);
		
		chatPanel = new ChatPanel(student); 
		//announcePanel = new AnnouncePanel(announces);
		fileSharePanel = new FileSharePanel(student);
		votePanel = new VotePanel();
		managePanel = new ManagePanel(student);
		
	    mainContainer.add(chatPanel, "chat");
	    mainContainer.add(new JScrollPane(announcePanel), "announce");
	    mainContainer.add(fileSharePanel, "fileShare");
	    mainContainer.add(new JScrollPane(votePanel), "vote");
	    mainContainer.add(managePanel, "manage");
		
		Container main = getContentPane();
		main.add(westPanel, BorderLayout.WEST);
		main.add(mainContainer);
		pack();
		setVisible(true);
		}
	
	public ChatPanel getChatPanel() {
		return chatPanel;
	}
	public AnnouncePanel getAnnouncePanel() {
		return announcePanel;
	}
	public void setAnnouncePanel(AnnouncePanel announcePanel) {
		this.announcePanel = announcePanel;
	}
	
	
	private class ButtonListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount() == 1) {
				if(e.getSource() == chatButton) {
					card.show(mainContainer, "chat");
				} else if(e.getSource() == announceButton) {
					refresh.refreshAnnounce();
				} else if(e.getSource() == fileShareButton) {
					card.show(mainContainer, "fileShare");
				} else if(e.getSource() == voteButton) {
					card.show(mainContainer,  "vote");
				} else {
					card.show(mainContainer, "manage");
				}
			} else if(e.getClickCount() == 2) {
				if(e.getSource() == chatButton) {
					card.show(mainContainer, "chat");
				} else if(e.getSource() == announceButton) {
					refresh.getAnnounce();
					mainContainer.add(new JScrollPane(MainPage.this.announcePanel), (AnnouncePanel.a + ""));
					card.show(mainContainer, (AnnouncePanel.a + ""));
					System.out.println(AnnouncePanel.a + "");
					//refresh.nullRefresh();
					
				} else if(e.getSource() == fileShareButton) {
					card.show(mainContainer, "fileShare");
				} else if(e.getSource() == voteButton) {
					card.show(mainContainer,  "vote");
				} else {
					card.show(mainContainer, "manage");
				}
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	private ImageIcon chat, announcement, fileShare, vote, manage;
	private JButton chatButton, announceButton, fileShareButton, voteButton, manageButton;
	private JPanel westPanel, mainContainer, fileSharePanel, votePanel;
	private ChatPanel chatPanel;
	private AnnouncePanel announcePanel;
	private JTabbedPane managePanel;
	private CardLayout card = new CardLayout();
	private JLabel nullLabel = new JLabel(), profileLabel;
	private ImageIcon profile;
	private User student;
	private Refresh refresh;
}
