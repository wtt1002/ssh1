package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import domain.Manager;

public class ManagerDaoImpl extends HibernateDaoSupport implements ManagerDao {

	@Override
	public void save(Manager manager) {
		// TODO Auto-generated method stub
		System.out.println("持久层保存管理员。。。");
		this.getHibernateTemplate().save(manager);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Manager managerLogin(String managerId, String password) {
		// TODO Auto-generated method stub
		String hql="from Manager where managerId=?";
		List<Manager> managers = null;
		try {
			managers=(List<Manager>) this.getHibernateTemplate().find(hql, managerId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库查询失败。。。。。");
			e.printStackTrace();
		}
		if(managers.size()>0)
		{
			if (managers.get(0).getPassword().equals(password)) {
				return managers.get(0);
			}
					
		}
		return null;
	}

}
