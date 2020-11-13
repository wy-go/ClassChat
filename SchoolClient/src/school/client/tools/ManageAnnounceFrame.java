package school.client.tools;

import java.util.HashMap;

import school.client.view.AnnounceFrame;
import school.client.view.ChatArea;
	public class ManageAnnounceFrame {
		private static HashMap hm = new HashMap<String, AnnounceFrame>();
		public static void addAnnounceFrame(String announceID, AnnounceFrame announceWindow) {
			hm.put(announceID, announceWindow);
		}
		public static AnnounceFrame getAnnounceFrame(String announceID) {
			return (AnnounceFrame)hm.get(announceID);
		}

}
