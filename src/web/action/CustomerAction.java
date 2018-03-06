package web.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import service.CustomerService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.Customer;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//模型驱动，必须手动实例化一个对象，并在getmodel中返回该对象
	private Customer customer=new Customer();
	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}
	//替代工厂方式：注入方式1，struts控制customerservice
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}


	public String add()
	{
		System.out.println("web层保存用户。。。。。。");
		System.out.println(customer.toString());
		
		//工厂方式
//		WebApplicationContext context=WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
//		CustomerService cService=(CustomerService) context.getBean("customerService");
//		cService.save(customer);
		
		//非工厂方式
		customerService.save(customer);
		return NONE;
	}


}
