package domain;


public class HomeworkInfo {

	private Integer UID;
	private String hworkInfoId;
	private String homeworkId;
	private String studentId;
	private String description;
	private Float score;
	private String address;
	private Boolean checked;
	private String checkMan;
	private Student student;
	private Homework homework;
	public Integer getUID() {
		return UID;
	}
	public void setUID(Integer uID) {
		UID = uID;
	}
	public String getHworkInfoId() {
		return hworkInfoId;
	}
	public void setHworkInfoId(String hworkInfoId) {
		this.hworkInfoId = hworkInfoId;
	}
	public String getHomeworkId() {
		return homeworkId;
	}
	public void setHomeworkId(String homeworkId) {
		this.homeworkId = homeworkId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getScore() {
		return score;
	}
	public void setScore(Float score) {
		this.score = score;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public String getCheckMan() {
		return checkMan;
	}
	public void setCheckMan(String checkMan) {
		this.checkMan = checkMan;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Homework getHomework() {
		return homework;
	}
	public void setHomework(Homework homework) {
		this.homework = homework;
	}
	
}
