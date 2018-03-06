package service;

import domain.StudentInfo;

public interface StudentInfoService {

	public void addStuInfo(StudentInfo studentInfo);
	public void delStuInfo(StudentInfo studentInfo);
	public void saveStuInfo(StudentInfo studentInfo);
	public StudentInfo findByStudentInfoId(String studentInfoId);
	public StudentInfo findByStudentId(String studentId);
	
}
