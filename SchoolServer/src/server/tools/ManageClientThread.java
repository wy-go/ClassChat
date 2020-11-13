package server.tools;

import java.util.HashMap;
import java.util.Iterator;

public class ManageClientThread {
	public static HashMap hm = new HashMap<String, SerConClientThread>();
	
	public static void addClientThread(String stuName, SerConClientThread ct) {
		hm.put(stuName, ct);
	}
	public static SerConClientThread getClientThread(String stuName) {
		return (SerConClientThread)hm.get(stuName);
	}
	
}
