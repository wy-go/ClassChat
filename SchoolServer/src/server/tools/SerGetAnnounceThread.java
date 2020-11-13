package server.tools;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import school.common.Message;
import school.common.MessageType;
import school.common.User;
import school.server.model.ServerUser;

public class SerGetAnnounceThread extends Thread{
Socket s;
public SerGetAnnounceThread(Socket s) {
	this.s = s;
}
public void run() {
	while(true) {
		try {
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			Message m = (Message)ois.readObject();
			if(m.getMesType().equals(MessageType.GET_ANNOUNCEMENT)) {
				System.out.println("<-GET_ANNOUNCEMENT");
				ServerUser su = new ServerUser();
				Message announcementMessage = new Message();
				User student = new User();
				student.setStuName(m.getSender());
				SerConClientThread sc = ManageClientThread.getClientThread(student.getStuName());
				ObjectOutputStream oos = new ObjectOutputStream(sc.s.getOutputStream());
				if(su.getAnnouncements(student) != null) {
					announcementMessage.setMesType(MessageType.READ_ANNOUNCEMENT);
					System.out.println("->READ_ANNOUNCEMENT");
					announcementMessage.setGetter(student.getStuName());
					announcementMessage.setContent(su.getAnnouncements(student));
					oos.writeObject(announcementMessage);
				}
				
			} 
		} catch(Exception e) {
			e.printStackTrace();
			
		} 	
	}
}
}