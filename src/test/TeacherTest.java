package test;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.HomeworkInfoService;
import service.HomeworkService;
import service.ManagerService;
import service.StudentService;
import service.TeacherService;
import domain.Homework;
import domain.HomeworkInfo;
import domain.Teacher;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TeacherTest {

	@Resource(name="teacherService")
	private TeacherService teacherService;
	@Resource(name="managerService")
	private ManagerService managerService;
	@Resource(name="homeworkInfoService")
	private HomeworkInfoService homeworkInfoService;
	@Resource(name="homeworkService")
	private HomeworkService homeworkService;
	@Test
	public void addTeacher()
	{
		Teacher teacher=new Teacher();
		teacher.setTeacherId("20170001");
		teacher.setTeacherName("张三");
		teacher.setGender("男");
		teacher.setPassword("123456");
		managerService.addTeacher(teacher);
		//在管理员处操作测试
	}
	@Test
	public void findById()
	{
		Teacher teacher=teacherService.findById("20170001");
		System.out.println(teacher.getTeacherName().toString());
	}
	@Test
	public void teacher_homework()
	{
		Teacher teacher=managerService.findByTeacherId("20170001");
		Homework homework=new Homework();
		homework.setHomeworkId("2017101");
		homework.setDescription("语文作业");
		Timestamp ts1 = new Timestamp(System.currentTimeMillis());
		Timestamp ts2 = Timestamp.valueOf("2018-12-31 22:22:22"); 
		homework.setReleaseDate(ts1);
		homework.setDeadlineDate(ts2);
		homework.setTeacher(teacher);
		teacherService.addHomework(homework);
		
		
	}
	
	@Test
	public void teacher_homeworkInfo()
	{
		HomeworkInfo homeworkInfo=homeworkInfoService.findByHomeworkInfoId("2017282110250201710101");
		homeworkInfo.setScore(88.3f);
		homeworkInfoService.saveHomeworkInfo(homeworkInfo);
	}
}
