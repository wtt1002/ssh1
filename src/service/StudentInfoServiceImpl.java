package service;

import org.springframework.transaction.annotation.Transactional;

import dao.StudentInfoDao;
import domain.StudentInfo;

@Transactional
public class StudentInfoServiceImpl implements StudentInfoService {

	private StudentInfoDao studentInfoDao;
	
	public void setStudentInfoDao(StudentInfoDao studentInfoDao) {
		this.studentInfoDao = studentInfoDao;
	}

	@Override
	public void addStuInfo(StudentInfo studentInfo) {
		// TODO Auto-generated method stub

		studentInfoDao.addStuInfo(studentInfo);
	}

	@Override
	public void delStuInfo(StudentInfo studentInfo) {
		// TODO Auto-generated method stub

		studentInfoDao.delStuInfo(studentInfo);
	}

	@Override
	public void saveStuInfo(StudentInfo studentInfo) {
		// TODO Auto-generated method stub

		studentInfoDao.saveStuInfo(studentInfo);
	}

	@Override
	public StudentInfo findByStudentInfoId(String studentInfoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentInfo findByStudentId(String studentId) {
		// TODO Auto-generated method stub
		studentInfoDao.findByStudentId(studentId);
		return null;
	}

}
