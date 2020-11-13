package school.client.view;

import java.awt.Dimension;

import javax.swing.JFrame;

public class ChatWindow extends JFrame implements WindowConstants{
	public ChatWindow(ChatArea chatArea) {
		setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		setTitle(chatArea.getClassmateName());
		
		getContentPane().add(chatArea);
		pack();
		setVisible(true);
	}
}
