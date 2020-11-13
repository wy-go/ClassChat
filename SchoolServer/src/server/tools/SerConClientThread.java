package server.tools;

import java.net.*;
import java.sql.ResultSet;
import java.util.HashMap;

import javax.swing.text.html.HTMLDocument.Iterator;

import school.common.Message;
import school.common.MessageType;
import school.common.User;
import school.server.db.Search;
import school.server.db.SqlHelper;
import school.server.model.ServerUser;

import java.io.*;

public class SerConClientThread extends Thread {
	public Socket s;
	public SerConClientThread(Socket s) {
		this.s = s;
	}
	public void run() {
		while(true) {
			try {
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				Message m = (Message)ois.readObject();
				if(m.getMesType().equals(MessageType.COMMON_MESSAGE)) {
					System.out.println("<-COMMON_MESSAGE");
					SerConClientThread sc = ManageClientThread.getClientThread(m.getGetter());
					if(sc != null) {
						ObjectOutputStream oos = new ObjectOutputStream(sc.s.getOutputStream());
						oos.writeObject(m);
						oos.flush();
						oos.reset();
					} else {
			 			String sql = "select studentName from ClassManager.student where classID = ? and studentName != ?";
			 			SqlHelper sp = new SqlHelper();
			 			String[] paras = {m.getGetter(), m.getSender()};
			 			ResultSet rs = sp.query(sql, paras);
			 			String classmateName;
			  			while(rs.next()){
							classmateName = rs.getString(1);
							SerConClientThread sc1 = ManageClientThread.getClientThread(classmateName);
							if(sc1 != null) {
								ObjectOutputStream oos = new ObjectOutputStream(sc1.s.getOutputStream());
								oos.writeObject(m);
								oos.flush();
								oos.reset();
							}
						}
					}
					
				}
					
					else 	if(m.getMesType().equals(MessageType.READ_ANNOUNCEMENT)) {
						System.out.println("<-READ_ANNOUNCEMENT");
						ServerUser su = new ServerUser();
						Message announcementMessage = new Message();
						User student = new User();
						student.setStuName(m.getSender());
						
						if(su.getNewAnnouncements(student) != null) {
							announcementMessage.setMesType(MessageType.ANNOUNCEMENT);
							System.out.println("->ANNOUNCEMENT");
							announcementMessage.setContent(su.getNewAnnouncements(student));
							SerConClientThread sc = ManageClientThread.getClientThread(student.getStuName());
							ManageOOS.getOOS(student.getStuName()).writeObject(announcementMessage);
							ManageOOS.getOOS(student.getStuName()).flush();
							ManageOOS.getOOS(student.getStuName()).reset();
						}
					}	
				
				
				
					else 	if(m.getMesType().equals(MessageType.GET_ANNOUNCEMENT)) {
					System.out.println("<-GET_ANNOUNCEMENT");
					ServerUser su = new ServerUser();
					Message announcementMessage = new Message();
					User student = new User();
					student.setStuName(m.getSender());
					
					if(su.getAnnouncements(student) != null) {
						announcementMessage.setMesType(MessageType.READ_ANNOUNCEMENT);
						System.out.println("->READ_ANNOUNCEMENT");
						announcementMessage.setGetter(student.getStuName());
						announcementMessage.setContent(su.getAnnouncements(student));
						SerConClientThread sc = ManageClientThread.getClientThread(student.getStuName());
						ObjectOutputStream oos = ManageOOS.getOOS(student.getStuName());
						ManageOOS.getOOS(student.getStuName()).flush();
						ManageOOS.getOOS(student.getStuName()).reset();
					}
					
				} 
				
				else 	if(m.getMesType().equals(MessageType.READ_ANNOUNCEMENT)) {
					System.out.println("<-READ_ANNOUNCEMENT");
					ServerUser su = new ServerUser();
					Message announcementMessage = new Message();
					User student = new User();
					student.setStuName(m.getSender());
					
					if(su.getNewAnnouncements(student) != null) {
						announcementMessage.setMesType(MessageType.ANNOUNCEMENT);
						System.out.println("->ANNOUNCEMENT");
						announcementMessage.setContent(su.getNewAnnouncements(student));
						SerConClientThread sc = ManageClientThread.getClientThread(student.getStuName());
						ObjectOutputStream oos = ManageOOS.getOOS(student.getStuName());
						ManageOOS.getOOS(student.getStuName()).writeObject(announcementMessage);
						ManageOOS.getOOS(student.getStuName()).flush();
						ManageOOS.getOOS(student.getStuName()).flush();
					}
				}
			
				else if(m.getMesType().equals(MessageType.NULL)){
					User student = new User();
					student.setStuName(m.getSender());
					SerConClientThread sc = ManageClientThread.getClientThread(student.getStuName());
					ManageOOS.getOOS(student.getStuName()).writeObject(m);
					ManageOOS.getOOS(student.getStuName()).flush();
					ManageOOS.getOOS(student.getStuName()).reset();
					System.out.println("空");
				} else {
					
				}
				
			} catch(Exception e) {
				e.printStackTrace();
				
			} 	
		}
	}
}
