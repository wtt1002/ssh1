package web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import service.TeacherService;
import utils.FastJsonUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import domain.PageBean;
import domain.Teacher;

public class TeacherAction extends ActionSupport implements ModelDriven<Teacher> {

	final static String PAGE = "page";
	Teacher teacher = new Teacher();
	@Override
	public Teacher getModel() {
		// TODO Auto-generated method stub
		return teacher;
	}

	TeacherService teacherService;
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
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
		teacherService.addTeacher(teacher);
		return NONE;
		
	}
	public String delete() {
		Teacher teacher_del = teacherService.findById(teacher.getTeacherId());
		if (teacher_del != null) {
			try {
				teacherService.delTeacher(teacher_del);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "error";
			}
		}
		return "delete";
		
	}
	public String listSchools(){
		List<String> schoolNames = teacherService.findSchools();
		//使用fastjson，将list转换为json
		String jsonString = FastJsonUtil.toJSONString(schoolNames);
		System.out.println(jsonString);
		//将json写到浏览器
		HttpServletResponse response = ServletActionContext.getResponse();
		//输出
		FastJsonUtil.write_json(response, jsonString);
		return NONE;
	}
	
	public String list(){
		//离线查询
		DetachedCriteria criteria = DetachedCriteria.forClass(Teacher.class);
		//拼凑离线查询条件
		//拼接学院名称
		String schoolName = teacher.getSchoolName();
		if (schoolName != null && !schoolName.trim().isEmpty()) {
			criteria.add(Restrictions.eq("schoolName", schoolName));
		}
		//拼接入校时间
		Integer rollYear =  teacher.getRollYear();
		if (rollYear != null) {
			criteria.add(Restrictions.eq("rollYear", rollYear));
		}
		//拼接教师姓名
		String teacherName = teacher.getTeacherName();
		if (teacherName != null && !teacherName.trim().isEmpty()) {
			criteria.add(Restrictions.eq("teacherName", teacherName));
		}
		//拼接教师性别
		String gender = teacher.getGender();
		if (gender != null && !gender.trim().isEmpty()) {
			criteria.add(Restrictions.eq("gender",gender));
		}
		//拼接教师ID
		String teacherId = teacher.getTeacherId();
		if (teacherId != null && !teacherId.trim().isEmpty()) {
			criteria.add(Restrictions.eq("teacherId", teacherId));
		}
		//查询
		PageBean<Teacher> page = teacherService.findByPage(pageCode,pageSize,criteria);
		//压入值栈
		ValueStack vs =  ActionContext.getContext().getValueStack();
		vs.set("page", page);
		return PAGE;
		
	}
	public String getTeacherBySchool(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String schoolName = request.getParameter("schoolName");
		List<Teacher> list = teacherService.getTeacherBySchool(schoolName);
		
		String jsonString = FastJsonUtil.toJSONString(list);
		System.out.println(jsonString);
		//将json写到浏览器
		HttpServletResponse response = ServletActionContext.getResponse();
		//输出
		FastJsonUtil.write_json(response, jsonString);
		return NONE;
		
	}
	
	public String initUpdate(){
		teacher = teacherService.findById(teacher.getTeacherId());
		return "initUpdate";
		
	}
	public String update(){
		teacherService.saveTeacher(teacher);
		return NONE;
	}
}
