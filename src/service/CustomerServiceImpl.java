package service;

import org.springframework.transaction.annotation.Transactional;

import dao.CustomerDao;
import dao.CustomerDaoImpl;
import domain.Customer;
@Transactional
public class CustomerServiceImpl implements CustomerService {

	
	private CustomerDaoImpl customerDao;
	public void setCustomerDao(CustomerDaoImpl customerDao) {
		this.customerDao = customerDao;
	}


	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub

		System.out.println("业务层保存客户。。。");
		customerDao.save(customer);
		

	}
}
