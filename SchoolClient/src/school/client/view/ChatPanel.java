package school.client.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import school.client.tools.ManageChatArea;
import school.common.User;

public class ChatPanel extends JPanel implements PanelConstants {
	public ChatPanel(User student) throws IOException {
		setLayout(new BorderLayout());
		
		listPanel = new ListPanel(student, this);
		classPane = new JScrollPane(listPanel);
		classPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(classPane, BorderLayout.WEST);
		String classNo = student.getStuClass().getClassID();
		chatArea = new ChatArea(student.getStuName(), classNo);
		ManageChatArea.addChatArea(classNo, chatArea);
		container = new JPanel(card);
		container.add(chatArea, classNo);
		add(container);
	}
	
	public ListPanel getList() {
		return listPanel;
	}
	
	public void setChatArea(ChatArea area, String chatNo) {
		chatArea = area;
		container.add(chatArea, chatNo);
		card.show(container, chatNo);
	}
	
	private ListPanel listPanel;
	private JScrollPane classPane;
	private ChatArea chatArea;
	private CardLayout card = new CardLayout();
	private JPanel container;
	
}
