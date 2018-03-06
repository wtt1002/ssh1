package service;

import domain.Student;

public interface StudentService {

	public void addStudent(Student student);
	public void delStudent(Student student);
	public void saveStudent(Student student);
	public Student findById(String studentId);
}
