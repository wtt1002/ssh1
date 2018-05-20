package domain;

import java.util.HashSet;
import java.util.Set;

public class Student {

	private Integer UID;
	private String studentId;
	private String password;
	private String studentName;
	private String schoolName;
	private Integer rollYear;
	private String clazzId;
	private String sInfo;
	private String managerName;
	private Clazz clazz;
	private Set<HomeworkInfo> homeworkInfos=new HashSet<HomeworkInfo>();
	private StudentInfo studentInfo;
	private Set<Score> scores=new HashSet<Score>();

	
	
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public Integer getRollYear() {
		return rollYear;
	}
	public void setRollYear(Integer rollYear) {
		this.rollYear = rollYear;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public Set<Score> getScores() {
		return scores;
	}
	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}
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
