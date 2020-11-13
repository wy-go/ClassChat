package school.client.model;

import java.io.IOException;
import java.io.ObjectOutputStream;

import school.client.tools.ClientConServerThread;
import school.client.tools.ManageClientConServerThread;
import school.common.*;

public class ClientUser {
	
	public boolean checkUser(User u) {
		return new ClientConServer().sendLoginInfoToServer(u);
	}
	public String regisUser(User u) {
		return new ClientConServer().sendRegisInfoToServer(u);
	}
}
