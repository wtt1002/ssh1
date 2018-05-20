package dao;

import org.hibernate.criterion.DetachedCriteria;

import domain.PageBean;
import domain.Student;

public interface StudentDao {

	public void save(Student student);
	public void delete(Student student);
	public void update(Student student);
	public Student findById(String studentId);
	public PageBean<Student> findByPage(Integer pageCode, Integer pageSize,
			DetachedCriteria criteria);
	public Student studentLogin(String studentId, String password);
}
