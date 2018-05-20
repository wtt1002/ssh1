package web.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import service.CourseService;
import service.TeacherService;
import utils.FastJsonUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import domain.Clazz;
import domain.Course;
import domain.PageBean;
import domain.School;
import domain.Teacher;

public class CourseAction extends ActionSupport implements ModelDriven<Course>{

	Course course = new Course();
	@Override
	public Course getModel() {
		// TODO Auto-generated method stub
		return course;
	}

	CourseService courseService;
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	TeacherService teacherService;
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	String teacherId;
	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	// 属性驱动的方式
	// 当前页，默认值就是1  
	private Integer pageCode = 1;
	public void setPageCode(Integer pageCode) {
		if(pageCode == null){
			pageCode = 1;
		}
		this.pageCode = pageCode;
	}
	
	// 每页显示的数据的条数
	private Integer pageSize = 5;
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public String add(){
		System.out.println("web层添加班级。。。。。");
		String teacherId = course.getTeacherId();
		Teacher teacher = teacherService.findById(teacherId);
		course.setTeacher(teacher);
		courseService.addCourse(course);
		return NONE;
		
	}
	public String delete(){
		Course course_del = courseService.findByCourseId(course.getCourseId());
		if (course_del != null) {
			try {
				courseService.delCourse(course_del);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "error";
			}
		}
		return "delete";
	}
	public String list(){
		System.out.println("Web层打印课程");
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Course.class);
		String schoolName = course.getSchoolName();
		if (schoolName != null && !schoolName.trim().isEmpty()) {
			System.out.println("要查询的schoolName为：====="+schoolName);
			criteria.add(Restrictions.eq("schoolName", schoolName));
		}
	
		String courseName = course.getCourseName();
		if (courseName != null && !courseName.trim().isEmpty()) {
			System.out.println("要查询的courseName为：====="+courseName);
			criteria.add(Restrictions.like("courseName",courseName,MatchMode.ANYWHERE));
			
		}
		System.out.println("封装就绪。。。。。。");
		//查询
		PageBean<Course> page = courseService.findByPage(pageCode,pageSize,criteria);
		//System.out.println("page:===="+page.getBeanList().get(0).getCourseName());
		System.out.println("page:====");
		if (page == null || page.getBeanList().size() == 0) {
			System.out.println("page 为空");
		}
		//压入值栈
		ValueStack vs = ActionContext.getContext().getValueStack();
		// 栈顶是map<"page",page对象>
		vs.set("page", page);
		return "page";
		
	}
	
	public String listByTeacher(){
		System.out.println("Web层打印课程listByTeacher()");
		String teacherId = ServletActionContext.getRequest().getParameter("teacherId");
		//String teacherId = ServletActionContext.getRequest().getParameter("teacherid");
		
		//String teacherId ="20130002";
		System.out.println("要查询的teacherId为：====="+teacherId);
		DetachedCriteria criteria = DetachedCriteria.forClass(Course.class);
		//String schoolName = course.getSchoolName();
		if (teacherId != null && !teacherId.trim().isEmpty()) {
			System.out.println("要查询的teacherId为：====="+teacherId);
			criteria.add(Restrictions.eq("teacherId", teacherId));
		}else {
			System.out.println("teacherId为空");
		}
		System.out.println("封装就绪。。。。。。");
		//查询
		PageBean<Course> page = courseService.findByPage(pageCode,pageSize,criteria);
		//System.out.println("page:===="+page.getBeanList().get(0).getCourseName());
		System.out.println("page:====");
		if (page == null || page.getBeanList().size() == 0) {
			System.out.println("page 为空");
		}else {
			System.out.println(page.toString());
		}
		//压入值栈
		ValueStack vs = ActionContext.getContext().getValueStack();
		
		// 栈顶是map<"page",page对象>
		vs.set("page", page);
		return "page";
		
	}
	/**
	 * 根据教师id查找所有课程
	 * @return
	 */
	public String coursesByTeacher(){
		teacherId = ServletActionContext.getRequest().getParameter("teacherId");
		List<Course> list = courseService.findByTeacherId(teacherId);
		System.out.println(teacherId);
		//使用fastjson，将list转换为json
		String jsonString = FastJsonUtil.toJSONString(list);
		System.out.println("json数据："+jsonString);
		//将json写到浏览器
		HttpServletResponse response = ServletActionContext.getResponse();
		//输出
		FastJsonUtil.write_json(response, jsonString);
		return NONE;
		
	}
	
	
	public String initUpdate(){
		//teacher = teacherService.findById(teacher.getTeacherId());
		course = courseService.findByCourseId(course.getCourseId());
		return "initUpdate";
		
	}
	public String update(){
		//String courseId = course.getTeacherId();
		courseService.saveCourse(course);
		return NONE;
	}
}
