package school.server.db;

import java.sql.ResultSet;

public class Search {
	
	public String getClassID(String stuName) {
		String sql;
		ResultSet rs;
		SqlHelper sp = null;
		try {
			
			sql = "select classID from ClassManager.student where studentName = ?";
			String paras[] = {stuName};
			sp = new SqlHelper();
			rs = sp.query(sql, paras);
			if(rs.next()){
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sp.close();
		}
		return null;
	}
	
	public String[] getClassmateNames(String classID) {
		String sql;
		ResultSet rs;
		SqlHelper sp = null;
		try {
			sql = "select studentName from ClassManager.student where classID = ?";
			String paras[] = {classID};
			sp = new SqlHelper();
			rs = sp.query(sql, paras);
			int stuNum = getClassmateNum(classID);
			int i = 0;
			String[] names = new String[stuNum];
			while(rs.next()) {
				names[i++] = rs.getString(1);
			}
			return names;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sp.close();
		}
		return null;
	}
	
	public int getClassmateNum(String classID) {
		String sql;
		ResultSet rs;
		SqlHelper sp = null;
		try {
			sql = "select studentNum from ClassManager.class where classID = ?";
			String paras[] = {classID};
			sp = new SqlHelper();
			rs = sp.query(sql, paras);
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sp.close();
		}
		return 0;
	}
	
    public int getNoticedNum(String announceID) {
	    	String sql;
		ResultSet rs;
		SqlHelper sp = null;
		int readNum = 0;
		try {
			sql = "select studentName from ClassManager.stuAnnounce where announceID = ? and noticed = ?"; 
			String paras[] = {announceID, "1"};
			sp = new SqlHelper();
			rs = sp.query(sql, paras);
			for(;rs.next(); readNum++, rs.getString(1));
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sp.close();
		}
		return readNum;
	}
	

}
