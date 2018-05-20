package web.action;

import org.apache.struts2.ServletActionContext;

import service.ManagerService;
import service.StudentService;
import service.TeacherService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.Manager;
import domain.Student;
import domain.Teacher;

public class LoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ManagerService managerService;
	private TeacherService teacherService;
	private StudentService studentService;
	
	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	String userType;
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	String userId;
	String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login(){
		System.out.println("进入登录环节================");
		System.out.println(userType);
		System.out.println("userId"+userId);
		System.out.println("password"+password);
		System.out.println("userType:"+userType);
		//String userTYPE = userType;
		
		if (userType.equals("manager")) {
			Manager manager = new Manager();
			System.out.println("userId"+userId);
			System.out.println("password"+password);
			manager.setManagerId(userId);
			manager.setPassword(password);
			if (managerService.managerLogin(manager) != null) {
				System.out.println("是管理员");
				Manager existManager = managerService.managerLogin(manager);
				ServletActionContext.getRequest().getSession().setAttribute("userType", userType);
				ServletActionContext.getRequest().getSession().setAttribute("existManager", existManager);
				return "login_ok_m";
			};
			return "login";
		}else if (userType.equals("teacher")) {
			Teacher teacher = new Teacher();
			teacher.setTeacherId(userId);
			teacher.setPassword(password);
			if (teacherService.teacherLogin(teacher) != null) {
				System.out.println("是教师");
				Teacher existTeacher = teacherService.teacherLogin(teacher);
				ServletActionContext.getRequest().getSession().setAttribute("userType", userType);
				ServletActionContext.getRequest().getSession().setAttribute("existTeacher", existTeacher);
				return "login_ok_t";
			};
			return "login";
		}else if(userType.equals("student")) {
			Student student = new Student();
			student.setStudentId(userId);
			student.setPassword(password);
			if (studentService.studentLogin(student) != null) {
				System.out.println("是学生");
				Student existStudent = studentService.studentLogin(student);
				ServletActionContext.getRequest().getSession().setAttribute("userType", userType);
				ServletActionContext.getRequest().getSession().setAttribute("existStudent", existStudent);
				return "login_ok_s";
			}
			return "login";
		}else {
			return "login";
		}

		
	}



}
