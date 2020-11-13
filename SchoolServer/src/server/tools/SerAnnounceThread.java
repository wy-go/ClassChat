package server.tools;


import java.net.*;


import school.common.Message;
import school.common.MessageType;
import school.server.db.Search;
import school.server.model.ServerUser;

import java.io.*;

public class SerAnnounceThread extends Thread{
	Socket s;
	public SerAnnounceThread(Socket s) {
		this.s = s;
	}
	public void run() {
		while(true) {
			try {
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				Message m = (Message)ois.readObject();
				if(m.getMesType().equals(MessageType.ANNOUNCEMENT)) {
					System.out.println("<-ANNOUNCEMENT");
					ServerUser su = new ServerUser();
					su.importAnnounce(m);
					Search sch = new Search();
					String classID = sch.getClassID(m.getSender());
					int stuNum = sch.getClassmateNum(classID);
					String[] students = sch.getClassmateNames(classID);
					su.createStuAnnounce(m.getSender() + m.getTime(), students);
					for(int i = 0; i < stuNum; i++) {
						SerConClientThread sc = ManageClientThread.getClientThread(students[i]);
						if(sc != null) {
							ObjectOutputStream oos = new ObjectOutputStream(sc.s.getOutputStream());
							oos.writeObject(m);
						} else {
							su.setStuUnannounced(students[i]);
						}
					}	
				} else {
					
				}
			} catch(Exception e) {
				e.printStackTrace();
				
			} 	
		}
	}
}
