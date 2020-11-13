package school.server.model;

import java.net.*;
import java.io.*;

import school.common.Announce;
import school.common.Message;
import school.common.MessageType;
import school.common.User;
import server.tools.ManageClientThread;
import server.tools.ManageOOS;
import server.tools.SerAnnounceThread;
import server.tools.SerConClientThread;
import server.tools.SerGetAnnounceThread;
import server.tools.SerReadAnnounceThread;

public class ServerConClient extends Thread{
	
	public void run() {
		try {
			ServerSocket ss = new ServerSocket(9999);
			while(true) {
				Socket s = ss.accept();
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				User student = (User)ois.readObject();
				Message m = new Message();
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
				ServerUser user = new ServerUser();
				if(user.checkUser(student) == 1) {
					m.setMesType(MessageType.LOGIN_SUCCEED);
					System.out.println("->LOGIN_SUCCEED");
					oos.writeObject(m);
					oos.writeObject(student);
					

					/*ServerUser su = new ServerUser();
					System.out.println("这里应该输出公告");
					Message announcementMessage = new Message();
					announcementMessage.setMesType(MessageType.ANNOUNCEMENT);
					if(su.getAnnouncements(student) != null) {
						announcementMessage.setContent(su.getAnnouncements(student));
						oos.writeObject(announcementMessage);
					}
					*/
					
				
			
					
					SerConClientThread scct = new SerConClientThread(s);
					System.out.println("0");
					ManageClientThread.addClientThread(student.getStuName(), scct);
					SerConClientThread sc = ManageClientThread.getClientThread(student.getStuName());
					ObjectOutputStream oost = new ObjectOutputStream(sc.s.getOutputStream());
					ManageOOS.addOOS(student.getStuName(), oost);
					scct.start();
					
					/*SerAnnounceThread sat = new SerAnnounceThread(s);
					sat.start();
					
					SerGetAnnounceThread sgat = new SerGetAnnounceThread(s);
					sgat.start();
					
					SerReadAnnounceThread srat = new SerReadAnnounceThread(s);
					srat.start();
					*/
					
				} else if(user.checkUser(student) == 2) {
					m.setMesType(MessageType.REGISTER_ONCE);
					System.out.println("->REGISTER_ONCE");
					oos.writeObject(m);
					s.close();	
				} else if(user.checkUser(student) == 3) {
					m.setMesType(MessageType.REGISTER_SUCCEED);
					System.out.println("->REGISTER_SUCCEED");
					oos.writeObject(m);
					s.close();	
				} else {
					m.setMesType(MessageType.LOGIN_FAIL);
					System.out.println("->LOGIN_FAIL");
					oos.writeObject(m);
					s.close();
				}
			}
			
			} catch(Exception e) {
				e.printStackTrace();
				
			} finally {
		
			}
	}
}
