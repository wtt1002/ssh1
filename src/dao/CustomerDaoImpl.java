package dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub

		System.out.println("持久层保存客户。。。。");
		this.getHibernateTemplate().save(customer);
	}

}
