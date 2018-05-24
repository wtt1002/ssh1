package domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class Homework {

	private Integer UID;
	private String homeworkId;
	private String homeworkName;
	private String hworkInfoId;
	private String teacherId;
	private String courseId;
	private Timestamp releaseDate;
	private Timestamp deadlineDate;
	private String description;
	private Teacher teacher;
	//private HworkInfo hworkInfo;
	//private Teacher teacher;
	private Course course;
	
	private String filePath;
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	private Set<HomeworkInfo> homeworkInfos =new HashSet<HomeworkInfo>();
	
	public Integer getUID() {
		return UID;
	}
	public void setUID(Integer uID) {
		UID = uID;
	}

	public String getHomeworkId() {
		return homeworkId;
	}
	public void setHomeworkId(String homeworkId) {
		this.homeworkId = homeworkId;
	}
	
	public String getHomeworkName() {
		return homeworkName;
	}
	public void setHomeworkName(String homeworkName) {
		this.homeworkName = homeworkName;
	}
	public String getHworkInfoId() {
		return hworkInfoId;
	}
	public void setHworkInfoId(String hworkInfoId) {
		this.hworkInfoId = hworkInfoId;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public Timestamp getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Timestamp releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Timestamp getDeadlineDate() {
		return deadlineDate;
	}
	public void setDeadlineDate(Timestamp deadlineDate) {
		this.deadlineDate = deadlineDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Set<HomeworkInfo> getHomeworkInfos() {
		return homeworkInfos;
	}
	public void setHomeworkInfos(Set<HomeworkInfo> homeworkInfos) {
		this.homeworkInfos = homeworkInfos;
	}
	
}
