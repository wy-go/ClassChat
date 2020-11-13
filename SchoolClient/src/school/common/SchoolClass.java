package school.common;

public class SchoolClass implements java.io.Serializable {
	public SchoolClass(String classID) {
		this.classID = classID;
 	}
	
	public String getClassID() {
		return classID;
	}
	public void setClassID(String classID) {
		this.classID = classID;
	}
	public int getStuNum() {
		return stuNum;
	}
	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}
	
	public User[] getClassmates() {
		return classmates;
	}
	
	public void setClassmates(User[] classmates) {
		this.classmates = classmates;
	}
	public String toString() {
		return (classID + stuNum);
	}
	private String classID;
	private User classmates[];
	private int stuNum;
}
