package server.tools;

import java.io.ObjectOutputStream;
import java.util.HashMap;

public interface ManageOOS {
public static HashMap hm = new HashMap<String, ObjectOutputStream>();
	
	public static void addOOS(String stuName, ObjectOutputStream oos) {
		hm.put(stuName, oos);
	}
	public static ObjectOutputStream getOOS(String stuName) {
		return (ObjectOutputStream)hm.get(stuName);
	}
	
}
