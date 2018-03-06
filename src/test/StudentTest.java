package test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import domain.Homework;
import domain.HomeworkInfo;
import domain.Student;
import service.HomeworkInfoService;
import service.HomeworkService;
import service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentTest {

	@Resource(name="homeworkInfoService")
	private HomeworkInfoService homeworkInfoService;
	@Resource(name="studentService")
	private StudentService studentService;
	@Resource(name="homeworkService")
	private HomeworkService homeworkService;
	
	@Test
	public void student_homeworkInfo()
	{
		Student student=studentService.findById("2017282110250");
		Homework homework=homeworkService.findByHomeworkId("2017101");
		HomeworkInfo homeworkInfo=new HomeworkInfo();
		homeworkInfo.setStudentId("2017282110250");
		homeworkInfo.setHomeworkId("2017101");
		homeworkInfo.setHworkInfoId("2017282110250201710101");
		homeworkInfo.setStudent(student);
		homeworkInfo.setHomework(homework);
		homeworkInfo.setChecked(false);
		homeworkInfo.setAddress("wwww.123.com");
		homeworkInfoService.addHomeworkInfo(homeworkInfo);
		
	}
}
