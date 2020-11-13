package school.client.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import school.client.tools.ManageChatArea;
import school.client.util.ImageUtil;
import school.common.SchoolClass;
import school.common.User;

public class ListPanel extends JPanel implements PanelConstants{
	public ListPanel(User student, ChatPanel hostPanel) throws IOException {
		this.student = student;
		this.hostPanel = hostPanel;
		stuClass = student.getStuClass();
		stuNum = stuClass.getStuNum();
		User[] classmates = stuClass.getClassmates();
		
		System.out.println(student);
		
		setLayout(new GridLayout(stuNum, 1));
		
		Image img = ImageIO.read(new File("src/profileImage/0.jpg"));
		ImageIcon classProfile = ImageUtil.getRoundImageIcon(img);
		classProfile.setImage(classProfile.getImage().getScaledInstance(HEAD_WIDTH - 2, HEAD_WIDTH - 2, Image.SCALE_DEFAULT));
		JLabel classProfileLabel = new JLabel(classProfile);
		classProfileLabel.setPreferredSize(new Dimension(HEAD_WIDTH, HEAD_WIDTH));
	
		classPanel = new JPanel();
		classPanel.setLayout(new BoxLayout(classPanel, BoxLayout.X_AXIS));
		classPanel.setBackground(ALICE_BLUE);
		classPanel.setPreferredSize(CHAT_LIST_SIZE);
		JLabel classLabel = new JLabel(stuClass.getClassID());
		classLabel.setFont(new Font("", Font.PLAIN, 15));
		classLabel.addMouseListener(new LabelListener());
		classPanel.add(classProfileLabel);
		classPanel.add(classLabel);
		add(classPanel);
		clickedPanel = classPanel;
		clickedPanel1 = classPanel;
		hm.put(classLabel, classPanel);
		
	//	System.out.println(stuNum - 1);
		classmateLabels = new JLabel[stuNum - 1];
		positionLabels = new JLabel[stuNum - 1]; 
		classmatePanels = new JPanel[stuNum - 1];
		panels = new JPanel[stuNum - 1];
		icons = new ImageIcon[stuNum - 1];
		iconLabels = new JLabel[stuNum - 1];
		
		for (int i = 0; i < stuNum - 1; i++) {
			Image image = ImageIO.read(new File("src/profileImage/" + classmates[i].getProfile()));
			icons[i] = ImageUtil.getRoundImageIcon(image);
			icons[i].setImage(icons[i].getImage().getScaledInstance(HEAD_WIDTH - 5, HEAD_WIDTH - 5, Image.SCALE_DEFAULT));
			iconLabels[i] = new JLabel(icons[i]);
			iconLabels[i].setPreferredSize(new Dimension(HEAD_WIDTH, HEAD_WIDTH));
			
			panels[i] = new JPanel();
			panels[i].setLayout(new BoxLayout(panels[i], BoxLayout.X_AXIS));
			panels[i].setBackground(Color.white);
			panels[i].setPreferredSize(CHAT_LIST_SIZE);
			classmatePanels[i] = new JPanel();
			classmatePanels[i].setLayout(new BoxLayout(classmatePanels[i], BoxLayout.Y_AXIS));
			classmatePanels[i].setBackground(Color.white);
			classmatePanels[i].setPreferredSize(CLASSMATE_MESSAGE_SIZE);
			classmateLabels[i] = new JLabel(classmates[i].getStuName());
			classmateLabels[i].setFont(new Font("", Font.PLAIN, 15));
			positionLabels[i] = new JLabel(classmates[i].getPositon());
			if(classmates[i].getPositon().equals("同学")) {
				positionLabels[i].setForeground(Color.lightGray);
			} else {
				positionLabels[i].setForeground(DODGER_BLUE);
			}
			positionLabels[i].setFont(new Font("", Font.PLAIN, 12));
			classmateLabels[i].addMouseListener(new LabelListener());
			hm.put(classmateLabels[i], classmatePanels[i]);
			hm1.put(classmatePanels[i], panels[i]);
			classmatePanels[i].add(classmateLabels[i]);
			classmatePanels[i].add(positionLabels[i]);
			panels[i].add(iconLabels[i]);
			panels[i].add(classmatePanels[i]);
			panels[i].add(Box.createRigidArea(new Dimension(15, 0)));
			
			add(panels[i]);
		}
	}

	private class LabelListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			String chatNo = ((JLabel)e.getSource()).getText();
			ChatArea chatArea;
			if(stuClass.getClassID() == chatNo) {
				chatArea = ManageChatArea.getChatArea(chatNo);
				//ManageChatArea.addChatArea(chatNo, chatArea);
			} else {
				if(ManageChatArea.getChatArea(student.getStuName() + " " + chatNo) == null) {
					chatArea = new ChatArea(student.getStuName(), chatNo);
					ManageChatArea.addChatArea(student.getStuName() + " " + chatNo, chatArea);
				} else {
					chatArea = ManageChatArea.getChatArea(student.getStuName() + " " + chatNo);
				}
			}
			if(e.getClickCount() == 1) {
				hostPanel.setChatArea(chatArea, chatNo);
				clickedPanel.setBackground(Color.white);
				clickedPanel1.setBackground(Color.white);
				JLabel label = (JLabel)e.getSource();
				clickedPanel = (JPanel)hm.get(label);
				clickedPanel1 = (JPanel)hm1.get(clickedPanel);
				clickedPanel.setBackground(ALICE_BLUE);
				clickedPanel1.setBackground(ALICE_BLUE);
				
			}
			if(e.getClickCount() == 2) {
				ChatWindow chatwindow;
				new ChatWindow(chatArea);
			}
			
		}
	
		public void mousePressed(MouseEvent e) {}
	
		public void mouseReleased(MouseEvent e) {}
	
		public void mouseEntered(MouseEvent e) {
			JLabel label = (JLabel)e.getSource();
			label.setForeground(DODGER_BLUE);
		}
	
		public void mouseExited(MouseEvent e) {
			JLabel label = (JLabel)e.getSource();
			label.setForeground(Color.black);
		}
	}
	
	private int stuNum;
	private JLabel[] classmateLabels, positionLabels, iconLabels;
	private JPanel classPanel, classmatePanels[], clickedPanel, clickedPanel1, panels[];
	private User student;
	private ChatPanel hostPanel;
	private SchoolClass stuClass;
	private static HashMap hm = new HashMap<JLabel, JPanel>(), hm1 = new HashMap<JPanel, JPanel>();
	private ImageIcon[] icons;
	
}
