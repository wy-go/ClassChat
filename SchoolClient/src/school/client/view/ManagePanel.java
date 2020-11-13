package school.client.view;

import java.awt.ScrollPane;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import school.common.User;

public class ManagePanel extends JTabbedPane {
	public ManagePanel(User admin) {
		addTab("记录", new RecordPanel(admin));
		addTab("公告", new SetAnnouncePanel(admin));
		addTab("投票", new SetVotePanel(admin));
	}
}
