package dao;

import domain.Student;

public interface StudentDao {

	public void save(Student student);
	public void delete(Student student);
	public void update(Student student);
	public Student findById(String studentId);
}
