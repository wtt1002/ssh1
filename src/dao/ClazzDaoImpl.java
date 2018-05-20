package dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import domain.Clazz;
import domain.PageBean;

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
		System.out.println("持久层======clazz的uid"+clazz.getUID());
		this.getHibernateTemplate().delete(del_clazz);
		this.getHibernateTemplate().flush();
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
		String hql="from Clazz where clazzId=?";
		List<Clazz> list = new ArrayList<Clazz>();
		try {
			 list=(List<Clazz>) this.getHibernateTemplate().find(hql, clazzId);
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

	@Override
	public List<Clazz> findClazzs(Clazz clazz) {
		// TODO Auto-generated method stub
		String hql = "from Clazz where schoolName=?";
		//String hql = "from Clazz where schoolName=? and rollYear=? and clazzNum=?";
		List<Clazz> list = new ArrayList<Clazz>();
		if (clazz.getSchoolName() == null) {
			
		}
		try {
			list = (List<Clazz>) this.getHibernateTemplate().find(hql, clazz.getSchoolName());
			//list = (List<Clazz>) this.getHibernateTemplate().find(hql, "*","*");
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库查询异常。。。。。");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<String> findSchools() {
		// TODO Auto-generated method stub
		String hql = "from Clazz";
		List<Clazz> schoolList = new ArrayList<Clazz>();
		List<String> schoolNames = new ArrayList<String>();
		Set<String> nameSet = new HashSet<>();
		System.out.println("未进入try");
		try {
			System.out.println("进入try");
			schoolList = (List<Clazz>) this.getHibernateTemplate().find(hql);
		} catch (Exception e) {
			System.out.println("findschool数据库查询异常。。。。。");
			// TODO: handle exception
		}
		if (schoolList == null) {
			System.out.println("schoollist为空");
		}else {
			for (int i = 0; i < schoolList.size(); i++) {
				String name = schoolList.get(i).getSchoolName();
				if (schoolList.get(i).getSchoolName() != null) {
					nameSet.add(name);
				}
			}
			schoolNames.addAll(nameSet);
		}
		//schoolNames.add("jsjjj");
		return schoolNames;
		}

	@Override
	public PageBean<Clazz> findByPage(Integer pageCode, Integer pageSize,
			DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		PageBean<Clazz> page = new PageBean<Clazz>();
		page.setPageCode(pageCode);
		page.setPageSize(pageSize);
		
		// 先查询总记录数	select count(*)
		criteria.setProjection(Projections.rowCount());
		List<Number> list = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria);
		if(list != null && list.size() > 0){
			int totalCount = list.get(0).intValue();
			// 总的记录数
			page.setTotalCount(totalCount);
		}
		
		// 强调：把select count(*) 先清空，变成  select * ...
		criteria.setProjection(null);
		
		// 提供分页的查询
		List<Clazz> beanList = (List<Clazz>) this.getHibernateTemplate().findByCriteria(criteria, (pageCode-1)*pageSize, pageSize);
		// 分页查询数据，每页显示的数据  使用limit
		page.setBeanList(beanList);
		
		return page;
	}

	@Override
	public List<Integer> getYearBySchool(String schoolName) {
		// TODO Auto-generated method stub
		String hql = "from Clazz where schoolName = ?";
		List<Integer> years = new ArrayList<>();
		List<Clazz> list = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		try {
			list = (List<Clazz>) this.getHibernateTemplate().find(hql, schoolName);
		} catch (DataAccessException e) {
			System.out.println("数据库查询失败。。。。。");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (list != null && list .size() > 0) {
			for (Clazz clazz : list) {
				set.add(clazz.getRollYear());
			}
		}
		years.addAll(set);
		return years;
	}

	@Override
	public List<Clazz> getClazzBySchoolAndYear(String schoolName,Integer rollYear) {
		// TODO Auto-generated method stub
		String hql = "from Clazz where schoolName=? and rollYear=?";
		//String hql = "from Clazz where schoolName=? and rollYear=? and clazzNum=?";
		List<Clazz> list = new ArrayList<Clazz>();
		try {
			list = (List<Clazz>) this.getHibernateTemplate().find(hql, schoolName,rollYear);
			//list = (List<Clazz>) this.getHibernateTemplate().find(hql, "*","*");
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库查询异常。。。。。");
			e.printStackTrace();
		}
		return list;
	}


}
