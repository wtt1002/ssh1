package web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import service.ClazzService;
import utils.FastJsonUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import domain.Clazz;
import domain.PageBean;

public class ClazzAction extends ActionSupport implements ModelDriven<Clazz>{

	//模型驱动，必须手动实例化一个对象，并在getmodel中返回该对象
	Clazz clazz = new Clazz();
	@Override
	public Clazz getModel() {
		// TODO Auto-generated method stub
		return clazz;
	}
	//替代工厂方式：注入方式1，struts控制customerservice
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
		System.out.println("web层添加班级。。。。。");
		clazzService.addClazz(clazz);
		return NONE;
		
	}
	public String list(){
		System.out.println("Web层打印班级");
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Clazz.class);
		String schoolName = clazz.getSchoolName();
		if (schoolName != null && !schoolName.trim().isEmpty()) {
			criteria.add(Restrictions.eq("schoolName", schoolName));
		}
		
		Integer rollYear = clazz.getRollYear();
		if (rollYear != null) {
			criteria.add(Restrictions.eq("rollYear", rollYear));
		}
		
		String clazzNum = clazz.getClazzNum();
		if (clazzNum != null && !clazzNum.trim().isEmpty()) {
			criteria.add(Restrictions.eq("clazzNum", clazzNum));
		}
		
		
		//查询
		PageBean<Clazz> page = clazzService.findByPage(pageCode,pageSize,criteria);
		//压入值栈
		ValueStack vs = ActionContext.getContext().getValueStack();
		
		// 栈顶是map<"page",page对象>
		vs.set("page", page);
		return "page";
	}
	public String listSchools(){
		List<String> schoolNames = clazzService.findSchools();
		//使用fastjson，将list转换为json
		String jsonString = FastJsonUtil.toJSONString(schoolNames);
		System.out.println(jsonString);
		//将json写到浏览器
		HttpServletResponse response = ServletActionContext.getResponse();
		//输出
		FastJsonUtil.write_json(response, jsonString);
		return NONE;
	}
	public String getYearBySchool(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String schoolName = request.getParameter("schoolName");
		List<Integer> list = clazzService.getYearBySchool(schoolName);
		System.out.println("我获取到schoolName" + schoolName);
		//使用fastjson，将list转换为json
		String jsonString = FastJsonUtil.toJSONString(list);
		//将json写到浏览器
		HttpServletResponse response = ServletActionContext.getResponse();
		//输出
		FastJsonUtil.write_json(response, jsonString);
		return NONE;
		
	}
	public String getClazzBySchoolAndYear(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String schoolName = request.getParameter("schoolName");
		String rollYearStr = request.getParameter("rollYear");
		Integer rollYear = Integer.parseInt(rollYearStr);
		System.out.println("我进来了，我得到的参数"+schoolName+"..."+rollYear+"..."+rollYearStr);
		List<Clazz> list = clazzService.getClazzBySchoolAndYear(schoolName,rollYear);
		System.out.println("获取到list"+list.size());
		//使用fastjson，将list转换为json
		String jsonString = FastJsonUtil.toJSONString(list);
		//将json写到浏览器
		HttpServletResponse response = ServletActionContext.getResponse();
		//输出
		FastJsonUtil.write_json(response, jsonString);
		return NONE;
		
	}
	public String delete(){
		System.out.println("web层传来的clazzId========"+clazz.getClazzId());
		 Clazz clazz_del = clazzService.findById(clazz.getClazzId());
		if (clazz_del != null) {
		System.out.println("待删除的clazz不为空========"+clazz_del.getClazzId());
			try {
				clazzService.delClazz(clazz_del);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "error";
				
			}
		}
		return "delete";
		
	}
	
	public String initUpdate(){
		clazz = clazzService.findById(clazz.getClazzId());
		return "initUpdate";
		
	}
	
	public String update(){
		clazzService.saveClazz(clazz);
		return NONE;
		
	}

}
