package domain;

import java.util.HashSet;
import java.util.Set;

public class Student {

	private Integer UID;
	private String studentId;
	private String password;
	private String studentName;
	private String clazzId;
	private String sInfo;
	private Clazz clazz;
	private Set<HomeworkInfo> homeworkInfos=new HashSet<HomeworkInfo>();
	private StudentInfo studentInfo;

	
	public StudentInfo getStudentInfo() {
		return studentInfo;
	}
	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}
	public Integer getUID() {
		return UID;
	}
	public void setUID(Integer uID) {
		UID = uID;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getClazzId() {
		return clazzId;
	}
	public void setClazzId(String clazzId) {
		this.clazzId = clazzId;
	}
	public String getsInfo() {
		return sInfo;
	}
	public void setsInfo(String sInfo) {
		this.sInfo = sInfo;
	}
	public Clazz getClazz() {
		return clazz;
	}
	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}
	public Set<HomeworkInfo> getHomeworkInfos() {
		return homeworkInfos;
	}
	public void setHomeworkInfos(Set<HomeworkInfo> homeworkInfos) {
		this.homeworkInfos = homeworkInfos;
	}
	
	
	
}
