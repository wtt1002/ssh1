package web.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import service.CourseService;
import service.HomeworkService;
import service.TeacherService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.Course;
import domain.Homework;
import domain.HomeworkInfo;
import domain.Teacher;

public class HomeworkAction extends ActionSupport implements ModelDriven<Homework> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Homework homework = new Homework();
	
	public Homework getHomework() {
		return homework;
	}

	public void setHomework(Homework homework) {
		this.homework = homework;
	}

	@Override
	public Homework getModel() {
		// TODO Auto-generated method stub
		return homework;
	}
	private TeacherService teacherService;
	private CourseService courseService;
	private HomeworkService homeworkService;
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public void setHomeworkService(HomeworkService homeworkService) {
		this.homeworkService = homeworkService;
	}

	public String add(){
		String teacherId = homework.getTeacherId();
		System.out.println("teacherId:"+teacherId);
		String courseId = homework.getCourseId();
		System.out.println("courseId:"+courseId);
		Teacher teacher = teacherService.findById(teacherId);
		Course course = courseService.findByCourseId(courseId);
		homework.setTeacher(teacher);
		homework.setCourse(course);
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		Date currentTime = new Date();
		long date = System.currentTimeMillis();
		String dateString = String.valueOf(date);
		System.out.println(dateString);
		homework.setHomeworkId(dateString);
		homeworkService.addHomework(homework);
		return NONE;
	}

}
