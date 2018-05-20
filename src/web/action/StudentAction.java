package web.action;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import service.ClazzService;
import service.StudentService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import domain.Clazz;
import domain.PageBean;
import domain.Student;

public class StudentAction extends ActionSupport implements ModelDriven<Student> {

	 Student student = new Student();
	@Override
	public Student getModel() {
		// TODO Auto-generated method stub
		return student;
	}

	private StudentService studentService;
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	private ClazzService clazzService;
	public void setClazzService(ClazzService clazzService) {
		this.clazzService = clazzService;
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
		String clazzId = student.getClazzId();
		System.out.println("页面传回的clazzId的值：==="+clazzId);
		Clazz clazz = clazzService.findById(clazzId);
		if (clazz == null) {
			System.out.println("没有检索到clazz");
		}else {
			System.out.println("检索到的clazz不为空");
		}
		student.setClazz(clazz);
		studentService.addStudent(student);
		return NONE;
		
	}
	public String delete(){
		Student stu_del = studentService.findById(student.getStudentId());
		if (stu_del != null) {
			try {
				studentService.delStudent(stu_del);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "error";
			}
		}
		return "delete";
	}
	
	public String list(){
		DetachedCriteria criteria = DetachedCriteria.forClass(Student.class);
		String schoolName = student.getSchoolName();
		if (schoolName != null && !schoolName.trim().isEmpty()) {
			criteria.add(Restrictions.eq("schoolName", schoolName));
		}
		Integer rollYear = student.getRollYear();
		if (rollYear != null) {
			criteria.add(Restrictions.eq("rollYear", rollYear));
		}
		String clazzId = student.getClazzId();
		if (clazzId != null && !clazzId.trim().isEmpty()) {
			criteria.add(Restrictions.eq("clazzId", clazzId));
		}
		String studentId = student.getStudentId();
		if (studentId != null && !studentId.trim().isEmpty()) {
			criteria.add(Restrictions.eq("studentId", studentId));
		}
		String studentName = student.getStudentName();
		if (studentName != null && !studentId.trim().isEmpty()) {
			criteria.add(Restrictions.eq("studentName", studentName));
		}
		
		
		//查询
		PageBean<Student> page = studentService.findByPage(pageCode,pageSize,criteria);
		//压入值栈
		ValueStack vs = ActionContext.getContext().getValueStack();
		
		// 栈顶是map<"page",page对象>
		vs.set("page", page);
		return "page";
	}
	
	public String initUpdate(){
		student = studentService.findById(student.getStudentId());
		return "initUpdate";
		
	}
	public String update(){
		studentService.saveStudent(student);
		return NONE;
		
	}
	
}
