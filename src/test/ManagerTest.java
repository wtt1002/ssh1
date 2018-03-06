package test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.print.attribute.standard.Media;

import domain.Clazz;
import domain.Course;
import domain.Customer;
import domain.Manager;
import domain.Student;
import domain.StudentInfo;
import domain.Teacher;
import service.ClazzService;
import service.CourseService;
import service.CustomerService;
import service.CustomerServiceImpl;
import service.ManagerService;
import service.ManagerServiceImpl;
import service.StudentInfoService;
import service.StudentService;
import service.TeacherService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ManagerTest {

	@Resource(name="managerService")
	private ManagerService managerService;
	@Resource(name="clazzService")
	private ClazzService clazzService;
	@Resource(name="courseService")
	private CourseService courseService;
	@Resource(name="studentInfoService")
	private StudentInfoService studentInfoService;
	/**
	 * 测试
	 */
	@Test
	public void manager_teacher()
	{
		Teacher teacher=new Teacher();
		//teacher.setUID(1);
		teacher.setTeacherId("20170001");
		teacher.setTeacherName("李四");
		teacher.setPassword("123456");
		teacher.setGender("男");
		//managerService.saveTeacher(teacher);
		managerService.addTeacher(teacher);
		//managerService.delTeacher(teacher);
	}
	@Test
	public void manager_selectTeacher()
	{
		Teacher teacher=managerService.findByTeacherId("20170001");
		System.out.println(teacher.getTeacherName().toString());
	}

	@Test
	public void manager_clazz()
	{
		
		Clazz clazz=new Clazz();
		clazz.setClazzId("20172821107");
		clazz.setClazzName("计算机硕士7班");
		//clazz=managerService.findByClazzId("20172821106");
		//Set<Student> students = new HashSet<Student>();
		
		Student student=new Student();
		student.setClazz(clazz);
		student.setClazzId("20172821106");
		student.setStudentId("2017282110250");
		student.setStudentName("王婷婷");
		
		Student student2=new Student();
		student2.setClazz(clazz);
		student2.setClazzId("20172821106");
		student2.setStudentId("2017282110251");
		student2.setStudentName("芳芳");
		
		managerService.addStudent(student);
		managerService.addStudent(student2);
		clazz.getStudents().add(student);
		clazz.getStudents().add(student2);
		
		//clazz.setStudents(students);
		managerService.saveClazz(clazz);
		//managerService.addStudent(student);
		//managerService.addStudent(student2);
		//managerService.addClazz(clazz);
	}
	@Test
	public void manager_student()
	{
		Student student=new Student();
		Clazz clazz=new Clazz();
		clazz=clazzService.findById("201728211011");
		if(clazz==null)System.out.println("查询为空。。。。。。。。");
		student.setClazz(clazz);
		student.setClazzId("201728211011");
		student.setStudentId("2017282110250");
		student.setStudentName("王婷婷");
		managerService.addStudent(student);
	}
	
	@Test
	public void selectStuByClazzId()
	{
		Clazz clazz=managerService.findByClazzId("20172821107");
		if (clazz==null) {
			System.out.println("班级为空。。。。。");
		}else {
			for(Student  student:clazz.getStudents())
			{
				System.out.println(student.getStudentName());
			}
		}
	}
	
	@Test
	public void addCourse()
	{
		Course course=new Course();
		course.setCourseId("2018");
		course.setCourseName("数据结构");
		course.setCredit(4);
		course.setTeacher(managerService.findByTeacherId("20170001"));
		course.setTeacherId("20170001");
		//courseService.saveCourse(course);
		courseService.addCourse(course);
	}
	
	@Test
	public void addStudentInfo()
	{
		StudentInfo studentInfo=new StudentInfo();
		studentInfo.setStudent(managerService.findByStudentId("2017282110250"));
		studentInfo.setStudentId("2017282110250");
		studentInfoService.addStuInfo(studentInfo);
	}
	


}
