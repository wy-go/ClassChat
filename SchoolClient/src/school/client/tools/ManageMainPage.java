package school.client.tools;

import java.util.HashMap;

import school.client.view.MainPage;

public class ManageMainPage {
	private static HashMap hm = new HashMap<String, MainPage>();
	public static void addMainPage(String studentName, MainPage mainPage) {
		hm.put(studentName, mainPage);
	}
	public static MainPage getMainPage(String studentName) {
		return (MainPage)hm.get(studentName);
	}

}
