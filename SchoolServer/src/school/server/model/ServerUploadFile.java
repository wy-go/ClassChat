package school.server.model;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import server.tools.ServerFileDownloadThread;
import server.tools.ServerFileUploadThread;

public class ServerUploadFile extends Thread {
	public void run() {
		 try {
	        ServerSocket serverSocket = new ServerSocket(8000);
	        while(true) {
	            System.out.println("这里是文件上传服务器");
	            Socket socket = serverSocket.accept();
	            Thread thread = new ServerFileUploadThread(socket);
	            thread.start();
	        }
	     } catch(IOException e){
	         e.printStackTrace();
	     }
	}
	
}
