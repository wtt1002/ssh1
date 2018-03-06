package domain;

import java.util.HashSet;
import java.util.Set;


public class Clazz {

	private Integer UID;
	private String clazzId;
	private String clazzName;
	private Set<Student> students=new HashSet<Student>();
	public Integer getUID() {
		return UID;
	}
	public void setUID(Integer uID) {
		UID = uID;
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
