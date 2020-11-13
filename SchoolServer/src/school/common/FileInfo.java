package school.common;

import java.io.Serializable;

public class FileInfo implements Serializable {
    private String fileName, suffix, fileSender;
    private long length;

    public FileInfo(String fileSender, String fileName, String suffix, long length){
        this.fileName = fileName;
        this.length = length;
        this.suffix = suffix;
        this.fileSender = fileSender;
    }

    public String getFilename() {
        return fileName;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getfilesender() {
        return fileSender;
    }

    public long getLength() {
        return length;
    }

}
