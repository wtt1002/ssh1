package domain;

import java.util.HashSet;
import java.util.Set;


public class Course {

	private Integer UID;
	private String courseId;
	private String courseName;
	private String teacherId;
	private Integer credit;
	private Teacher teacher;
	private Set<Homework> homeworks =new HashSet<Homework>();
	public Integer getUID() {
		return UID;
	}
	public void setUID(Integer uID) {
		UID = uID;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Set<Homework> getHomeworks() {
		return homeworks;
	}
	public void setHomeworks(Set<Homework> homeworks) {
		this.homeworks = homeworks;
	}
	
}
