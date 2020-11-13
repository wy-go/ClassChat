package school.common;

import javax.swing.text.StyledDocument;

public class Message implements java.io.Serializable{
private String mesType, sender, getter, time;
private StyledDocument doc;
private Object[] content;
	
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getGetter() {
		return getter;
	}
	public void setGetter(String getter) {
		this.getter = getter;
	}
	public StyledDocument getDoc() {
		return doc;
	}
	public void setDoc(StyledDocument doc) {
		this.doc = doc;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMesType() {
		return mesType;
	}
	public void setMesType(String mesType) {
		this.mesType = mesType;
	}

	public Object getContent() {
	return content;
	}
	public void setContent(Object[] content) {
		this.content = content;
	}
	
}
