package server.tools;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ServerFileDownloadThread extends Thread {
	
    public ServerFileDownloadThread(Socket socket) {
        this.socket = socket;
    }
    
    public void run(){
        //新建文件的流，将文件写进指定的文件夹中
        try{
          
            dis = new DataInputStream(socket.getInputStream());
            long size = dis.readLong();
            String fileName = dis.readUTF();
            System.out.println("文件大小为:" + size + ", 文件名为:" + fileName);

            String dir ="/Users/zhaowanyu/Desktop/file/Server/";
            File dest = new File(dir + fileName);
            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
            
            long readSize = 0;
            while(true) {
                if(readSize > size) {
                    break;
                }
                int data = bis.read();
                bos.write(data);
                readSize++;
            }
            System.out.println("上传完毕");
            bos.flush();
            bos.close();
            bis.close();
            dis.close();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
    private Socket socket;
    private DataInputStream dis;

}
