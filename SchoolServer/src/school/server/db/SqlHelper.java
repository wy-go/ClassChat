package school.server.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlHelper {
	
	public static void main(String[] args) {
		new SqlHelper();
	}
	
    String driverName = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/ClassManager";
    String dbpwd = "231750My";
    String user = "root";
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection ct = null;
	
	public SqlHelper() {
		try {
			Class.forName(driverName);
			ct = DriverManager.getConnection(url, user, dbpwd);
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public ResultSet query(String sql,String[] paras){
		try {
			ps = ct.prepareStatement(sql);
			for(int i = 0; i < paras.length; i++){
				ps.setString(i+1, paras[i]);
			}
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public void update(String sql,String[] paras){
		try {
			ps = ct.prepareStatement(sql);
			for(int i = 0; i < paras.length; i++){
				ps.setString(i+1, paras[i]);
			}
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(ct != null) {
				ct.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
