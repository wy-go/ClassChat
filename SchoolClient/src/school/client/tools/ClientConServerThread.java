package school.client.tools;

import java.io.*;
import java.net.*;

import javax.swing.text.BadLocationException;

import school.client.view.AnnounceFrame;
import school.client.view.AnnouncePanel;
import school.client.view.ChatArea;
import school.client.view.ChatPanel;
import school.client.view.ListPanel;
import school.common.Announce;
import school.common.Message;
import school.common.MessageType;
import school.common.User;

public class ClientConServerThread extends Thread{
	public ClientConServerThread(Socket s) {
		this.s = s;
	}
	public Socket getS() {
		return s;
	}
	public void setS(Socket s) {
		this.s = s;
	}
	
	public void run() {
		while(true) {
			try {
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				Message m = (Message)ois.readObject();
				if(m.getMesType().equals(MessageType.COMMON_MESSAGE)) {
					System.out.println("<-COMMON_MESSAGE");
					if(Character.isDigit(m.getGetter().charAt(0))) {
						ChatArea chatArea = ManageChatArea.getChatArea(m.getGetter());
						chatArea.appendView(m);
					} else {
						ChatArea chatArea;
			            if(ManageChatArea.getChatArea(m.getGetter() + " " + m.getSender()) == null) {
			            		chatArea = new ChatArea(m.getGetter(), m.getSender());
			            		ManageChatArea.addChatArea(m.getGetter() + " " + m.getSender(), chatArea);
			            } else {
			            		chatArea = ManageChatArea.getChatArea(m.getGetter() + " " + m.getSender());
			            }
						chatArea.appendView(m);
					}
				} else if(m.getMesType().equals(MessageType.ANNOUNCEMENT)){
					System.out.println("<-ANNOUNCEMENT");
					Announce[] announces = (Announce[])m.getContent();
					for(int i = 0; i < announces.length; i++) {
						AnnounceFrame announceFrame = new AnnounceFrame(announces[i], false);
						ManageAnnounceFrame.addAnnounceFrame(m.getSender() + m.getTime(), announceFrame); 
					}
					//System.out.println((Announce)m.getContent());
					
				} else if(m.getMesType().equals(MessageType.READ_ANNOUNCEMENT)){
					System.out.println("<-READ_ANNOUNCEMENT");
					Announce[] announces = (Announce[])m.getContent();
					ManageMainPage.getMainPage(m.getGetter()).setAnnouncePanel(new AnnouncePanel(announces));
				} else {
					System.out.println("出错了");
				}
			
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	private Socket s;
}
