package service;

import java.util.List;

import domain.Homework;
import domain.Student;
import domain.Teacher;

public interface TeacherService {

	//自身信息维护
	public Teacher findById(String teacherId);
	//public void saveTeacherInfo(Teacher teacher);
	public void addTeacher(Teacher teacher);
	public void delTeacher(Teacher teacher);
	public void saveTeacher(Teacher teacher);
	
	//学生管理
	public List<Student> findStuByCourseId(String courseId);
	public Student findStuByStudentId(String studentId);
	
	//获取学生详细信息
	
	//课程作业管理
	public void addHomework(Homework homework);
	public void delHomework(Homework homework);
	public void updateHomework(Homework homework);
	
	//获取作业信息批改
	
}
