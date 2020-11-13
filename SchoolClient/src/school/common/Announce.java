package school.common;

public class Announce implements java.io.Serializable {
	public Announce(String title, String text, String publisher, String time, int readNum) {
		super();
		this.title = title;
		this.text = text;
		this.publisher = publisher;
		this.time = time;
		this.readNum = readNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getReadNum() {
		return readNum;
	}
	
	public void setReadNum(int readNum) {
		this.readNum = readNum;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String toString() {
		return "Announcement:" + "\n" + title + "\n" + text + "\n" + time + "publisher" + "\n" + readNum;
		
	}
	private String title, text, time, publisher;
	private int readNum;
 }
