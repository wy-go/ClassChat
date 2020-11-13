package school.client.model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import school.client.tools.ClientConServerThread;
import school.client.tools.ManageClientConServerThread;
import school.client.tools.ManageStudent;
import school.common.*;

public class ClientConServer {
	public Socket s;
	public boolean sendLoginInfoToServer(Object o) {
		boolean b = false;
		try {
			s = new Socket("127.0.0.1", 9999);
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			Message m = (Message)ois.readObject();
			if(m.getMesType().equals(MessageType.LOGIN_SUCCEED)) {
				b = true;
				User readUser = (User)ois.readObject();
				User student = ManageStudent.getStudent(readUser.getStudentID());
				student.setPositon(readUser.getPositon());
				student.setStuClass(readUser.getStuClass());
				student.setStuName(readUser.getStuName());
				student.setProfile(readUser.getProfile());
				ClientConServerThread ccst = new ClientConServerThread(s);
				ccst.start();
				ManageClientConServerThread.addClientConServerThread(((User)o).getStuName(), ccst);
				
			} 
		} catch(Exception e) {
				e.printStackTrace();
		} finally {
				
		}
		return b;
	}
	
	public String sendRegisInfoToServer(Object o) {
		String b = "1";
		try {
			s = new Socket("127.0.0.1", 9999);
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			Message m = (Message)ois.readObject();
			if(m.getMesType().equals(MessageType.REGISTER_SUCCEED)) {
				User readUser = (User)ois.readObject();
				User student = ManageStudent.getStudent(readUser.getStudentID());
				student.setPositon(readUser.getPositon());
				student.setStuClass(readUser.getStuClass());
				student.setStuName(readUser.getStuName());
				student.setProfile(readUser.getProfile());
				ClientConServerThread ccst = new ClientConServerThread(s);
				ccst.start();
				ManageClientConServerThread.addClientConServerThread(((User)o).getStuName(), ccst);
			} else if(m.getMesType().equals(MessageType.REGISTER_ONCE)) {
				b = "2";
			} else {
				b = "3";
			}
		} catch(Exception e) {
				e.printStackTrace();
		} finally {
				
		}
		return b;
	}
	
	public void sendInfoToServer(Object o) {
		try {
			Socket s = new Socket("127.0.0.1", 9999);
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
		}
	}
}
