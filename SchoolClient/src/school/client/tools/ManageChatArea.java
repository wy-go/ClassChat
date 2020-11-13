package school.client.tools;

import java.util.*;

import school.client.view.ChatArea;

public class ManageChatArea {
	private static HashMap hm = new HashMap<String, ChatArea>();
	public static void addChatArea(String studentAndClassmate, ChatArea chatArea) {
		hm.put(studentAndClassmate, chatArea);
	}
	public static ChatArea getChatArea(String studentAndClassmate) {
		return (ChatArea)hm.get(studentAndClassmate);
	}
}
