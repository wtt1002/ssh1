package web.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import service.SchoolService;
import utils.FastJsonUtil;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.School;

public class SchoolAction extends ActionSupport implements ModelDriven<School> {

	School school = new School();
	@Override
	public School getModel() {
		// TODO Auto-generated method stub
		return school;
	}

	SchoolService schoolService;
	public void setSchoolService(SchoolService schoolService) {
		this.schoolService = schoolService;
	}
	
	public String getSchoolNames(){
		List<School> list= schoolService.getAllSchools();
		//必须得new，否则会空指针
		List<String> schoolNames = new ArrayList<>();
		for ( School s : list) {
			schoolNames.add(s.getSchoolName().toString());
		}
		//使用fastjson，将list转换为json
		String jsonString = FastJsonUtil.toJSONString(schoolNames);
		System.out.println("json数据："+jsonString);
		//将json写到浏览器
		HttpServletResponse response = ServletActionContext.getResponse();
		//输出
		FastJsonUtil.write_json(response, jsonString);
		return NONE;
	}
}
