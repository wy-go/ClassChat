package school.client.tools;

import java.util.HashMap;

import school.common.User;

public class ManageStudent {
	private static HashMap hm = new HashMap<String, User>();
	public static void addStudent(String studentID, User student) {
		hm.put(studentID, student);
	}
	public static User getStudent(String studentID) {
		return (User)hm.get(studentID);
	}

}
