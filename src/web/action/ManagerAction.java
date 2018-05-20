package web.action;

import org.apache.struts2.ServletActionContext;

import service.ManagerService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.Manager;

public class ManagerAction extends ActionSupport implements ModelDriven<Manager> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String LOGIN = "login";
	public static final String LOGIN_OK = "login_ok";
	
	Manager manager = new Manager();
	@Override
	public Manager getModel() {
		// TODO Auto-generated method stub
		return manager;
	}
	String userType;
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	private ManagerService managerService;
	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	
	public String add()
	{
		System.out.println("web层保存管理员。。。。。。");
		managerService.addManager(manager);
		return NONE;
	}
	
	public String login(){
		System.out.println("userType:"+userType);
		System.out.println("managerID=============="+manager.getManagerId());
		if (managerService.managerLogin(manager) == null) {
			return LOGIN;
		}else {
			System.out.println("是管理员");
			Manager existManager = managerService.managerLogin(manager);
			ServletActionContext.getRequest().getSession().setAttribute("existManager", existManager);
			return LOGIN_OK;
		}
	}
	

	
	public String exit(){
		ServletActionContext.getRequest().getSession().removeAttribute("existManager");
		return LOGIN;
	}

}
