package web.action;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import service.CourseService;
import service.HomeworkService;
import service.TeacherService;
import utils.UploadUtils;

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

	private File arrangeWork;
	private String arrangeWorkFileName;
	private String arrangeWorkContentType;
	
	public void setArrangeWork(File arrangeWork) {
		this.arrangeWork = arrangeWork;
	}

	public void setArrangeWorkFileName(String arrangeWorkFileName) {
		this.arrangeWorkFileName = arrangeWorkFileName;
	}

	public void setArrangeWorkContentType(String arrangeWorkContentType) {
		this.arrangeWorkContentType = arrangeWorkContentType;
	}

	public String add() throws IOException{
		if (arrangeWorkFileName != null) {
			System.out.println("文件名："+arrangeWorkFileName);
			String uuidName = UploadUtils.getUUIDName(arrangeWorkFileName);
			String path = "E:\\apache-tomcat-7.0.82\\webapps\\upload\\";
			File file = new File(path+uuidName);
			FileUtils.copyFile(arrangeWork, file);
			homework.setFilePath(path+uuidName);
		}
		String teacherId = homework.getTeacherId();
		System.out.println("teacherId:"+teacherId);
		String courseId = homework.getCourseId();
		System.out.println("courseId:"+courseId);
		Teacher teacher = teacherService.findById(teacherId);
		Course course = courseService.findByCourseId(courseId);
		homework.setTeacher(teacher);
		homework.setCourse(course);
		long date = System.currentTimeMillis();
		String dateString = String.valueOf(date);
		System.out.println(dateString);
		homework.setHomeworkId(dateString);
		homeworkService.addHomework(homework);
		return NONE;
	}

}
