package service;

import org.springframework.transaction.annotation.Transactional;

import dao.StudentDao;
import domain.Student;

@Transactional
public class StudentServiceImpl implements StudentService {

	StudentDao studentDao;
	
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub

		studentDao.save(student);
	}

	@Override
	public void delStudent(Student student) {
		// TODO Auto-generated method stub

		studentDao.delete(student);
	}

	@Override
	public void saveStudent(Student student) {
		// TODO Auto-generated method stub

		studentDao.update(student);
	}

	@Override
	public Student findById(String studentId) {
		// TODO Auto-generated method stub
		return studentDao.findById(studentId);
	}

}
