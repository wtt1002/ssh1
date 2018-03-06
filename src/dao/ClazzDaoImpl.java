package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import domain.Clazz;

public class ClazzDaoImpl extends HibernateDaoSupport implements ClazzDao{

	@Override
	public void addClazz(Clazz clazz) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(clazz);
	}

	@Override
	public void delClazz(Clazz clazz) {
		// TODO Auto-generated method stub
		Clazz del_clazz=this.getHibernateTemplate().get(Clazz.class, clazz.getUID());
		this.getHibernateTemplate().delete(del_clazz);
	}

	@Override
	public void saveClazz(Clazz clazz) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(clazz);
	}

	@Override
	public Clazz findById(String clazzId) {
		// TODO Auto-generated method stub
		//Clazz clazz = null;
		List<Clazz> list = null;
		try {
			 list=(List<Clazz>) this.getHibernateTemplate().find("from Clazz where clazzId=?", clazzId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库查询异常。。。。。");
			e.printStackTrace();
		}
		if (list.size()>0) {
			return list.get(0);
		}
		return null;
	}


}
