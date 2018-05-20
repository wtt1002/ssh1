package domain;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;


public class Clazz {

	private Integer UID;
	private String schoolName;
	private Integer rollYear;
	private String clazzNum;
	private String clazzId;
	private String clazzName;
	private String managerName;
	@JSONField(serialize = false)
	private Set<Student> students=new HashSet<Student>();
	public Integer getUID() {
		return UID;
	}
	public void setUID(Integer uID) {
		UID = uID;
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
	public String getClazzNum() {
		return clazzNum;
	}
	public void setClazzNum(String clazzNum) {
		this.clazzNum = clazzNum;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getClazzId() {
		return clazzId;
	}
	public void setClazzId(String clazzId) {
		this.clazzId = clazzId;
	}
	public String getClazzName() {
		return clazzName;
	}
	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
}
