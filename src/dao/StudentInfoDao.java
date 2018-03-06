package dao;

import domain.StudentInfo;

public interface StudentInfoDao {

	public void addStuInfo(StudentInfo studentInfo);
	public void delStuInfo(StudentInfo studentInfo);
	public void saveStuInfo(StudentInfo studentInfo);
	public StudentInfo findByStudentInfoId(String studentInfoId);
	public StudentInfo findByStudentId(String studentId);
}
