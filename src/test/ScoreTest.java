package test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.CourseService;
import service.ManagerService;
import service.ScoreService;
import domain.Course;
import domain.Score;
import domain.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ScoreTest {
	@Resource(name="courseService")
	private CourseService courseService;
	@Resource(name="managerService")
	private ManagerService managerService;
	@Resource(name="scoreService")
	private ScoreService scoreService;
	
	
	@Test
	public void addScore(){
		Student student = managerService.findByStudentId("2017282110250");
		Course course = courseService.findByCourseId("20170911");
		Score score = new Score();
		score.setStudent(student);
		score.setCourse(course);
		scoreService.addScore(score);
//		Student student = managerService.findByStudentId("2016302240170");
//		Course course = courseService.findByCourseId("20170911");
//		Score score = new Score();
//		score.setStudent(student);
//		score.setCourse(course);
//		scoreService.addScore(score);
//		Student student = managerService.findByStudentId("2017282110250");
//		Course course = courseService.findByCourseId("20170912");
//		Score score = new Score();
//		score.setStudent(student);
//		score.setCourse(course);
//		scoreService.addScore(score);
		
	}
}
