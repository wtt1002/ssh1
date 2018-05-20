package service;

import org.springframework.transaction.annotation.Transactional;

import dao.ClazzDao;
import dao.ManagerDao;
import dao.StudentDao;
import dao.TeacherDao;
import domain.Clazz;
import domain.Manager;
import domain.Student;
import domain.Teacher;

@Transactional
public class ManagerServiceImpl implements ManagerService {

	private ManagerDao managerDao;
	private TeacherService teacherService;
	private ClazzService clazzService;
	private StudentService studentService;


	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public void setClazzService(ClazzService clazzService) {
		this.clazzService = clazzService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@Override
	public void addManager(Manager manager) {
		// TODO Auto-generated method stub
		System.out.println("业务层保存管理员。。。");
		managerDao.save(manager);
	}

	@Override
	public void addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		System.out.println("业务层添加教师。。。");
		teacherService.addTeacher(teacher);
	}

	@Override
	public void delTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		System.out.println("业务层删除教师。。。");
		teacherService.delTeacher(teacher);
	}

	@Override
	public void saveTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		System.out.println("业务层保存教师。。。");
		teacherService.saveTeacher(teacher);
	}

	@Override
	public Teacher findByTeacherId(String teacherId) {
		return teacherService.findById(teacherId);
	}
	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		System.out.println("业务层添加学生。。。");
		studentService.addStudent(student);
	}

	@Override
	public void delStudent(Student student) {
		// TODO Auto-generated method stub
		System.out.println("业务层删除学生。。。");
		studentService.delStudent(student);
	}

	@Override
	public void saveStudent(Student student) {
		// TODO Auto-generated method stub
		System.out.println("业务层保存学生。。。");
		studentService.saveStudent(student);
	}
	
	@Override
	public Student findByStudentId(String studentId) {
		// TODO Auto-generated method stub
		return studentService.findById(studentId);
	}

	@Override
	public void addClazz(Clazz clazz) {
		// TODO Auto-generated method stub
		System.out.println("业务层添加班级");
		clazzService.addClazz(clazz);
	}

	@Override
	public void delClazz(Clazz clazz) {
		// TODO Auto-generated method stub
		System.out.println("业务层删除班级");
		clazzService.delClazz(clazz);
	}

	@Override
	public void saveClazz(Clazz clazz) {
		// TODO Auto-generated method stub
		System.out.println("业务层保存班级");
		clazzService.saveClazz(clazz);
	}

	@Override
	public Clazz findByClazzId(String clazzId) {
		// TODO Auto-generated method stub
		return clazzService.findById(clazzId);
	}

	@Override
	public Manager managerLogin(Manager manager) {
		
		return managerDao.managerLogin(manager.getManagerId(), manager.getPassword());
		// TODO Auto-generated method stub
		
		
	}






}
