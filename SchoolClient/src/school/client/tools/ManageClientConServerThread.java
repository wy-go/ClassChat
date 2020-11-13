package school.client.tools;

import java.util.*;

public class ManageClientConServerThread {
	private static HashMap hm = new HashMap<String, ClientConServerThread>();
	public static void addClientConServerThread(String studentName, ClientConServerThread ccst) {
		hm.put(studentName, ccst);
	}
	public static ClientConServerThread getClientConServerThread(String studentName) {
		return (ClientConServerThread)hm.get(studentName);
	}
}
