package school.common;

public class User implements java.io.Serializable{
	public User() {
		
	}
	
 	public User(String studentID, String stuName, String position, String profile) {
		super();
		this.studentID = studentID;
		this.stuName = stuName;
		this.position = position;
		this.profile = profile;
	}

	public String getStudentID() {
		return studentID;
	}
	
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public SchoolClass getStuClass() {
		return schoolClass;
	}
	
	public void setStuClass(SchoolClass schoolClass) {
		this.schoolClass = schoolClass;
	}
	
	public String getPositon() {
		return position;
	}
	
	public void setPositon(String position) {
		this.position = position;
	}
	
	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	public String toString() {
		String str = studentID + password + stuName + position + profile;
		return str;
	}
	
	private String studentID, password, stuName, position, profile;
	private SchoolClass schoolClass;
	
}
