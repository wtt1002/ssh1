package dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import domain.Manager;

public class ManagerDaoImpl extends HibernateDaoSupport implements ManagerDao {

	@Override
	public void save(Manager manager) {
		// TODO Auto-generated method stub
		System.out.println("持久层保存管理员。。。");
		this.getHibernateTemplate().save(manager);
	}

}
