package school.server.model;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import server.tools.ServerFileDownloadThread;
import server.tools.ServerFileUploadThread;

public class ServerDownloadFile extends Thread{
	public void run() {
		try {
			System.out.println("文件服务器启动");
            ServerSocket serverSocket = new ServerSocket(8808);
            while(true) {
                System.out.println("文件下载服务器");
                Socket socket = serverSocket.accept();
                Thread thread = new ServerFileDownloadThread(socket);
                thread.start();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
	}
}
