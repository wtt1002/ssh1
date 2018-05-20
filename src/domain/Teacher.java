package domain;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

public class Teacher {

	private Integer UID;
	private String teacherId;
	private String teacherName;
	private String gender;
	private String password;
	private String schoolName;
	private Integer rollYear;
	private String managerName;
	
	@JSONField(serialize = false)
	private Set<Homework> homeworks=new HashSet<Homework>();
	
	@JSONField(serialize = false)
	private Set<Course> courses=new HashSet<Course>();
	
	
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public Integer getRollYear() {
		return rollYear;
	}
	public void setRollYear(Integer rollYear) {
		this.rollYear = rollYear;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	public Set<Homework> getHomeworks() {
		return homeworks;
	}
	public void setHomeworks(Set<Homework> homeworks) {
		this.homeworks = homeworks;
	}
	public Integer getUID() {
		return UID;
	}
	public void setUID(Integer uID) {
		UID = uID;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
