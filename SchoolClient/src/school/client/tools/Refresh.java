package school.client.tools;

import java.io.IOException;

import java.io.ObjectOutputStream;

import school.common.Message;
import school.common.MessageType;
import school.common.User;
public class Refresh {
	public Refresh(User u) {
		this.u = u;
	}
	public void refreshAnnounce() {
		Message m = new Message();
		m.setSender(u.getStuName());
		m.setMesType(MessageType.READ_ANNOUNCEMENT);
		System.out.println("refreshAnnounce->READ_ANNOUNCEMENT");
		try {
			ObjectOutputStream oos = new ObjectOutputStream
			(ManageClientConServerThread.getClientConServerThread(u.getStuName()).getS().getOutputStream());
			oos.writeObject(m);
			oos.flush();
		
		} catch(IOException e1) {
			e1.printStackTrace();
		}
	}
	public void getAnnounce() {
		Message m = new Message();
		m.setSender(u.getStuName());
		m.setMesType(MessageType.GET_ANNOUNCEMENT);
		System.out.println("refreshAnnounce->GET_ANNOUNCEMENT");
		try {
			ObjectOutputStream oos = new ObjectOutputStream
			(ManageClientConServerThread.getClientConServerThread(u.getStuName()).getS().getOutputStream());
			oos.writeObject(m);
			oos.flush();
		
		} catch(IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void nullRefresh() {
		Message m = new Message();
		m.setSender(u.getStuName());
		m.setMesType(MessageType.NULL);
		System.out.println("nullRefresh->NULL");
		try {
			ObjectOutputStream oos = new ObjectOutputStream
			(ManageClientConServerThread.getClientConServerThread(u.getStuName()).getS().getOutputStream());
			oos.writeObject(m);
			oos.flush();
		
		} catch(IOException e1) {
			e1.printStackTrace();
		}
	}
	private User u;
}