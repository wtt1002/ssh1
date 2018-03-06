package service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.TeacherDao;
import domain.Homework;
import domain.Student;
import domain.Teacher;
@Transactional
public class TeacherServiceImpl implements TeacherService {

	TeacherDao teacherDao;
	HomeworkService homeworkService;
	StudentService studentService;
	
	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}
	
	public void setHomeworkService(HomeworkService homeworkService) {
		this.homeworkService = homeworkService;
	}
	
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@Override
	public Teacher findById(String teacherId) {
		// TODO Auto-generated method stub
		if(teacherDao.findById(teacherId)==null)
		{
			System.out.println("服务层：查询为空。。。。。");
		}
		//System.out.println("我在服务层");
		return teacherDao.findById(teacherId);
		
	}

	@Override
	public void addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		teacherDao.save(teacher);
	}

	@Override
	public void delTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		teacherDao.delete(teacher);
	}

	@Override
	public void saveTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		teacherDao.update(teacher);
	}
	@Override
	public List<Student> findStuByCourseId(String courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findStuByStudentId(String studentId) {
		// TODO Auto-generated method stub
		return studentService.findById(studentId);
	}

	@Override
	public void addHomework(Homework homework) {
		// TODO Auto-generated method stub
		homeworkService.addHomework(homework);
	}

	@Override
	public void delHomework(Homework homework) {
		// TODO Auto-generated method stub

		homeworkService.delHomework(homework);
	}

	@Override
	public void updateHomework(Homework homework) {
		// TODO Auto-generated method stub

		homeworkService.saveHomework(homework);
	}



}
