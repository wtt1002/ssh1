package service;

import org.hibernate.criterion.DetachedCriteria;

import domain.PageBean;
import domain.Student;

public interface StudentService {

	public void addStudent(Student student);
	public void delStudent(Student student);
	public void saveStudent(Student student);
	public Student findById(String studentId);
	public PageBean<Student> findByPage(Integer pageCode, Integer pageSize,
			DetachedCriteria criteria);
	public Student studentLogin(Student student);
}
