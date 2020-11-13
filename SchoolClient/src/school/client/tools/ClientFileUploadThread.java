package school.client.tools;

import java.io.*;
import java.net.Socket;

public class ClientFileUploadThread extends Thread  {
    Socket socket;
    File file;
    public ClientFileUploadThread(Socket socket,File file){
        this.socket = socket;
        this.file = file;
    }
    public void run(){
        try{
            String name = file.getName();
            long size = file.length();
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeLong(size);
            dos.writeUTF(name);
            dos.flush();

            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
            long writeSize = 0;
            while(true){
                bos.write(bis.read());
                writeSize++;
                if(writeSize > size){
                    break;
                }
            }
            System.out.println("客户端已上传文件" + name + ", 文件大小为" + size);
            bos.flush();
            bos.close();
            bis.close();
            dos.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
