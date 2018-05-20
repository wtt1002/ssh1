package dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import domain.Clazz;
import domain.Manager;
import domain.PageBean;
import domain.Teacher;

public class TeacherDaoImpl extends HibernateDaoSupport implements TeacherDao {

	@Override
	public void save(Teacher teacher) {
		// TODO Auto-generated method stub

		System.out.println("持久层保存教师。。。");
		this.getHibernateTemplate().save(teacher);
	}

	@Override
	public void delete(Teacher teacher) {
		// TODO Auto-generated method stub
		Teacher del_teacher=this.getHibernateTemplate().get(Teacher.class, teacher.getUID());
		this.getHibernateTemplate().delete(del_teacher);
		System.out.println("持久层删除教师。。。");
	}

	@Override
	public void update(Teacher teacher) {
		// TODO Auto-generated method stub
		System.out.println("持久层更新教师。。。");
		this.getHibernateTemplate().update(teacher);
	}

	@Override
	public Teacher findById(String teacherId) {
		// TODO Auto-generated method stub
		List<Teacher> teachers = null;
		String hql="from Teacher where teacherId=?";
		try {
			teachers=(List<Teacher>) this.getHibernateTemplate().find(hql, teacherId);
			//System.out.println("我在dao中查询");
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库查询失败。。。。。");
			e.printStackTrace();
		}
		if(teachers.size()>0)
		{
			return teachers.get(0);
		}
		return null;
	}

	@Override
	public List<String> findSchools() {
		// TODO Auto-generated method stub
		String hql = "from Teacher";
		List<Teacher> schoolList = new ArrayList<Teacher>();
		List<String> schoolNames = new ArrayList<String>();
		Set<String> nameSet = new HashSet<>();
		try {
			schoolList = (List<Teacher>) this.getHibernateTemplate().find(hql);
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
	public PageBean<Teacher> findByPage(Integer pageCode, Integer pageSize,
			DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		PageBean<Teacher> page = new PageBean<Teacher>();
		page.setPageCode(pageCode);
		page.setPageSize(pageSize);
		//查询记录总数目
		criteria.setProjection(Projections.rowCount());
		List<Number> list = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria);
		if (list != null && list.size() > 0) {
			int totalCount = list.get(0).intValue();
			page.setTotalCount(totalCount);
		}
		//把select count(*) 先清空，变成 select *
		criteria.setProjection(null);
		//分页查询
		List<Teacher> beanList = (List<Teacher>) this.getHibernateTemplate().findByCriteria(criteria, (pageCode - 1) * pageSize, pageSize);
		//分页查询数据，每页显示的数据，用limit
		page.setBeanList(beanList);
		return page;
	}

	@Override
	public List<Teacher> getTeacherBySchool(String schoolName) {
		// TODO Auto-generated method stub
		String hql = "from Teacher where schoolName = ?";
		List<Teacher> list = new ArrayList<Teacher>();
		try {
			list = (List<Teacher>) this.getHibernateTemplate().find(hql,schoolName);
		} catch (Exception e) {
			System.out.println("findschool数据库查询异常。。。。。");
			// TODO: handle exception
		}
		if (list == null || list.size() <= 0) {
			System.out.println("teacher list为空");
		}
		return list;
	}

	@Override
	public Teacher teacherLogin(String teacherId, String password) {
		// TODO Auto-generated method stub
		String hql="from Teacher where teacherId=?";
		List<Teacher> teachers = null;
		try {
			teachers=(List<Teacher>) this.getHibernateTemplate().find(hql, teacherId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库查询失败。。。。。");
			e.printStackTrace();
		}
		if(teachers.size()>0)
		{
			if (teachers.get(0).getPassword().equals(password)) {
				return teachers.get(0);
			}
			System.out.println("查询结果为0");
					
		}
		return null;
	}

}
