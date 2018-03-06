package domain;

import java.sql.Timestamp;


public class StudentInfo {

	private Integer UID;
	private Timestamp enrollDate;
	private Timestamp bitrthday;
	private Character gender;
	private String phone;
	private String description;
	private String createMan;
	private String createClass;
	private Timestamp createDate;
	private String changeMan;
	private Timestamp changeDate;
	private String studentId;
	private Student student;
	public Integer getUID() {
		return UID;
	}
	public void setUID(Integer uID) {
		UID = uID;
	}
	public Timestamp getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Timestamp enrollDate) {
		this.enrollDate = enrollDate;
	}
	public Timestamp getBitrthday() {
		return bitrthday;
	}
	public void setBitrthday(Timestamp bitrthday) {
		this.bitrthday = bitrthday;
	}
	public Character getGender() {
		return gender;
	}
	public void setGender(Character gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreateMan() {
		return createMan;
	}
	public void setCreateMan(String createMan) {
		this.createMan = createMan;
	}
	public String getCreateClass() {
		return createClass;
	}
	public void setCreateClass(String createClass) {
		this.createClass = createClass;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public String getChangeMan() {
		return changeMan;
	}
	public void setChangeMan(String changeMan) {
		this.changeMan = changeMan;
	}
	public Timestamp getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(Timestamp changeDate) {
		this.changeDate = changeDate;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
}
