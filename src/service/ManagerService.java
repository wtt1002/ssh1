package service;

import domain.Clazz;
import domain.Manager;
import domain.Student;
import domain.Teacher;

public interface ManagerService {

	//管理员操作
	public void addManager(Manager manager);
	public Manager managerLogin(Manager manager);
	//教师操作
	public void addTeacher(Teacher teacher);
	public void delTeacher(Teacher teacher);
	public void saveTeacher(Teacher teacher);
	public Teacher findByTeacherId(String teacherId);
	//学生操作
	public void addStudent(Student student);
	public void delStudent(Student student);
	public void saveStudent(Student student);
	public Student findByStudentId(String studentId);
	//班级操作
	public void addClazz(Clazz clazz);
	public void delClazz(Clazz clazz);
	public void saveClazz(Clazz clazz);
	public Clazz findByClazzId(String clazzId);
}
