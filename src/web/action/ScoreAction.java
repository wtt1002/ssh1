package web.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import service.ScoreService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import domain.Clazz;
import domain.PageBean;
import domain.Score;
import domain.Student;

public class ScoreAction extends ActionSupport{

//	Score score = new Score();
//	@Override
//	public Score getModel() {
//		// TODO Auto-generated method stub
//		return score;
//	}
	private ScoreService scoreService;
	
	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}

	private String courseId;
	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
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
	public String getStudentsByCourse(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String courseId = request.getParameter("courseId");
		System.out.println("courseId:"+courseId);
//		DetachedCriteria criteria = DetachedCriteria.forClass(Clazz.class);
//		String schoolName = clazz.getSchoolName();
//		if (schoolName != null && !schoolName.trim().isEmpty()) {
//			criteria.add(Restrictions.eq("schoolName", schoolName));
//		}
		DetachedCriteria criteria = DetachedCriteria.forClass(Score.class);
		if (courseId != null && !courseId.trim().isEmpty()) {
			criteria.add(Restrictions.eq("courseId",courseId));
		}
		PageBean<Student> scorePage = scoreService.findByCoursetIdPage(pageCode,pageSize,criteria);
		//压入值栈
		ValueStack vs = ActionContext.getContext().getValueStack();
		
		// 栈顶是map<"page",page对象>
		vs.set("page", scorePage);
		return "page_s";
	}
	
}
