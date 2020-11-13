package server.tools;

import java.io.*;
import java.net.Socket;

import school.common.FileInfo;

public class ServerFileUploadThread extends Thread {
    public ServerFileUploadThread(Socket socket){
        this.socket = socket;
    }
    public void run() {
        try {
            ois = new ObjectInputStream(socket.getInputStream());
            Object object = ois.readObject();
            FileInfo fileInfo = (FileInfo)object;
            
            String dir = "/Users/zhaowanyu/Desktop/file/Server/" + fileInfo.getFilename() + fileInfo.getSuffix();
            System.out.println(dir);
            File file = new File(dir);
            String name = file.getName();
            long size = file.length();
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeLong(size);
            dos.writeUTF(name);
            dos.flush();
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
            long writeSize = 0;
            while(true) {
                bos.write(bis.read());
                writeSize++;
                if(writeSize > size) {
                    break;
                }
            }
            System.out.println("已上传文件" + name + ",文件大小为" + size);
            bos.flush();
            bos.close();
            bis.close();
            dos.close();
        } catch(IOException e) {
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    private Socket socket;
    private ObjectInputStream ois;
}
