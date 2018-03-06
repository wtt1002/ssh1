package web.action;

import service.ManagerService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.Manager;

public class ManagerAction extends ActionSupport implements ModelDriven<Manager> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Manager manager=new Manager();
	@Override
	public Manager getModel() {
		// TODO Auto-generated method stub
		return manager;
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

}
