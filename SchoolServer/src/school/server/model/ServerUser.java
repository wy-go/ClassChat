package school.server.model;

import java.sql.ResultSet;
import java.util.ArrayList;

import school.common.Announce;
import school.common.Message;
import school.common.SchoolClass;
import school.common.User;
import school.server.db.Search;
import school.server.db.SqlHelper;

public class ServerUser {
	public int checkUser(User student) { 
		int c = 0;
		String position = "", stuName, classID;
		SchoolClass stuClass;
		String sql;
		ResultSet rs;
		SqlHelper sp = null;
		String dbPass = "";
		
		try {
			sql = "select password from ClassManager.student where studentID = ?";
			String paras[] = {student.getStudentID()};
			sp = new SqlHelper();
			rs = sp.query(sql, paras);
			if(rs.next()){
				dbPass = rs.getString(1);
			}
		}catch(Exception e) {
        		e.printStackTrace();
		}
			
		if(student.getStuName() == null) {
			try {
				
				sql = "select position from ClassManager.student where studentID = ? and password = ?";
				String paras[] = {student.getStudentID(), student.getPassword()};
				sp = new SqlHelper();
				rs = sp.query(sql, paras);
				if(rs.next()){
					position = rs.getString(1);
					student.setPositon(position);
					//System.out.println(student.getPositon());
				}
				
				sql = "select studentName from ClassManager.student where studentID = ?";
				String paras1[] = {student.getStudentID()};
	 			rs = sp.query(sql, paras1);
	 			if(rs.next()){
					stuName = rs.getString(1);
					student.setStuName(stuName);
					//System.out.println(student.getStuName());
				}
	 			
	 			sql = "select classID from ClassManager.student where studentID = ?";
	 			rs = sp.query(sql, paras1);
	 			if(rs.next()){
					classID = rs.getString(1);
					stuClass = new SchoolClass(classID);
					student.setStuClass(stuClass);
					//System.out.println(student.getStuClass().getClassID());
				}
	 			
	 			sql = "select studentNum from ClassManager.class where classID = ?";
	 			String[] paras2 = {student.getStuClass().getClassID()};
	 			rs = sp.query(sql, paras2);
	 			if(rs.next()){
					student.getStuClass().setStuNum(rs.getInt(1)); 
					//System.out.println(student.getStuClass().getStuNum());
				}
	 			
	  			sql = "select profile from ClassManager.student where studentID = ?";
	  			rs = sp.query(sql, paras1);
	  			if(rs.next()){
					student.setProfile(rs.getString(1));
					//System.out.println(student.getProfile());
				}
	  			
	  			sql = "select studentID, studentName, position, profile from ClassManager.student where classID = ? and studentName != ?";
	 			String[] paras3 = {student.getStuClass().getClassID(), student.getStuName()};
	  			rs = sp.query(sql, paras3);
	 			User[] classmates = new User[student.getStuClass().getStuNum() - 1];
	 			int i = 0;
	  			while(rs.next()){
					classmates[i++] = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				}
	  			student.getStuClass().setClassmates(classmates);
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				sp.close();
			}
			if(position != "") {
				c = 1;
			}
		} else {
			if(dbPass.equals("")) {
				c = 0;
			} else if(!(dbPass.equals("123456"))) {
				c = 2;
				System.out.println("啥");
			} else {
		        try {
			        	sql = "select position from ClassManager.student where studentID = ? and studentName = ? ";
						String paras[] = {student.getStudentID(), student.getStuName()};
						sp = new SqlHelper();
						rs = sp.query(sql, paras);
						if(rs.next()) {
							position = rs.getString(1);
							student.setPositon(position);
							//System.out.println(student.getPositon());
						}
						if(position != "") {
							c = 3;
							System.out.println("注册了");
							sql = "update ClassManager.student set password = ? and profile = ? where studentName = ?";
							String[] paras1 = {student.getPassword(), student.getProfile(), student.getStuName()};
							sp = new SqlHelper();
							sp.update(sql, paras1);
						}
		        } catch(Exception e) {
		        		e.printStackTrace();
		        } finally {
		        		sp.close();
		        		System.out.println("1");
		        }
		    }
		}
		return c;
	}
	
	public void importAnnounce(Message m) {
		Announce[] ans = (Announce[])m.getContent();
		Announce an = ans[0];
		String sql;
		SqlHelper sp = null;
		Search sc = new Search();
		try {
			sql = "insert into ClassManager.announce values(?, ?, ?, ?, ?, ?)";
			String classID = sc.getClassID(m.getSender());
			String[] paras = {m.getSender() + m.getTime(), an.getTitle(), an.getTitle(), 
					m.getTime(), m.getSender(), classID};
			sp = new SqlHelper();
			sp.update(sql, paras);
		} catch(Exception e) {
			e.printStackTrace();		
		} finally {
			sp.close();
	    }
}

	public void createStuAnnounce(String announceID, String[] studentNames) {
		String sql;
		SqlHelper sp = null;
		Search sc = new Search();
		try {
			sp = new SqlHelper();
			sql = "insert into ClassManager.stuAnnounce values(?, ?, ?)";
			for(int i = 0; i < studentNames.length; i++) {
				String[] paras = {announceID, studentNames[i], "1"};
				sp.update(sql, paras);
			}
		} catch(Exception e) {
			e.printStackTrace();		
		} finally {
			sp.close();
	    }
	}
 
	public void setStuUnannounced(String classmateName) {
		String sql;
		SqlHelper sp = null;
		try {
			sql = "update ClassManager.stuAnnounce set noticed = 0 where studentName = ?";
			String[] paras = {classmateName};
			sp = new SqlHelper();
			sp.update(sql, paras);
		} catch(Exception e) {
			e.printStackTrace();		
		} finally {
			sp.close();
	    }
	}

	public Announce[] getNewAnnouncements(User student) {
		String sql, sql1;
		SqlHelper sp = null;
		ResultSet rs, rs1;
		Search sc = new Search();
		ArrayList<Announce> announceList = new ArrayList<Announce>();
		Announce[] announces;
		try {
			sql = "select announceID from ClassManager.stuAnnounce where noticed = ? and studentName = ?";
			sp = new SqlHelper();
			String[] paras = {"0", student.getStuName()};
			rs = sp.query(sql, paras);
			int length = 0;
			while(rs.next()){
				length++;
				String announceID = rs.getString(1);
				sql = "select announceTitle, announceText, publisherName, announceTime from ClassManager.announce where announceID = ?";
				String[] paras1 = {announceID};
				rs1 = sp.query(sql, paras1);
				if(rs1.next()) {
					Announce announce = new Announce(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4), sc.getNoticedNum(announceID));
					announceList.add(announce);
				}
			}
			sql = "update ClassManager.stuAnnounce set noticed = 1 where studentName = ?";
			String[] paras2 = {student.getStuName()};
			sp.update(sql, paras2);
 			announces = new Announce[length];
			for(int i = 0; i < length; i++) {
				announces[i] = announceList.get(i);
				System.out.println(announces);
			}
			if(length > 0) {
				return announces;
			}
		} catch(Exception e) {
			e.printStackTrace();		
		} finally {
			sp.close();
	    }
		return null;
	}

	public Announce[] getAnnouncements(User student) {
		String sql;
		SqlHelper sp = null;
		ResultSet rs, rs1;
		Search sc = new Search();
		ArrayList<Announce> announceList = new ArrayList<Announce>();
		Announce[] announces;
		try {
			sql = "select announceID from ClassManager.stuAnnounce where studentName = ?";
			sp = new SqlHelper();
			String[] paras = {student.getStuName()};
			rs = sp.query(sql, paras);
			int length = 0;
			while(rs.next()){
				length++;
				String announceID = rs.getString(1);
				sql = "select announceTitle, announceText, publisherName, announceTime from ClassManager.announce where announceID = ?";
				String[] paras1 = {announceID};
				rs1 = sp.query(sql, paras1);
				if(rs1.next()) {
					Announce announce = new Announce(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4), sc.getNoticedNum(announceID));
					announceList.add(announce);
				}
			}
			announces = new Announce[length];
			for(int i = 0; i < length; i++) {
				announces[i] = announceList.get(i);
				System.out.println(announces);
			}
			if(length > 0) {
				return announces;
			}
		} catch(Exception e) {
			e.printStackTrace();		
		} finally {
			sp.close();
	    }
		
		return null;
	}
	
}
