package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import domain.Clazz;
import domain.Course;
import domain.Homework;
import domain.PageBean;
import domain.Teacher;

public class CourseDaoImpl extends HibernateDaoSupport implements CourseDao {

	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(course);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("持久层打印未成功");
		}
	}

	@Override
	public void delCourse(Course course) {
		// TODO Auto-generated method stub
		Course del_course=this.getHibernateTemplate().get(Course.class,course.getUID());
		this.getHibernateTemplate().delete(del_course);
	}

	@Override
	public void saveCourse(Course course) {
		// TODO Auto-generated method stub

		this.getHibernateTemplate().update(course);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Course findByCourseId(String courseId) {
		// TODO Auto-generated method stub
		String hql="from Course where courseId=?";
		List<Course> courses=null;
		try {
			courses=(List<Course>) this.getHibernateTemplate().find(hql, courseId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库查询失败。。。。。");
			e.printStackTrace();
		}
		if (courses.size()>0) {
			return courses.get(0);
		}
		return null;
	}

	@Override
	public List<Course> findByTeacherId(String teacherId) {
		// TODO Auto-generated method stub
		String hql="from Course where teacherId=?";
		List<Course> courses = new ArrayList<>();
		try {
			courses=(List<Course>) this.getHibernateTemplate().find(hql, teacherId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库查询失败。。。。。");
			e.printStackTrace();
		}
		return courses;
	}

	@Override
	public PageBean<Course> findByPage(Integer pageCode, Integer pageSize,
			DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		PageBean<Course> page = new PageBean<Course>();
		page.setPageCode(pageCode);
		page.setPageSize(pageSize);
		
		// 先查询总记录数	select count(*)
		criteria.setProjection(Projections.rowCount());
		List<Number> list = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria);
		if(list != null && list.size() > 0){
			int totalCount = list.get(0).intValue();
			System.out.println("持久层获得");
			// 总的记录数
			page.setTotalCount(totalCount);
		}
		
		// 强调：把select count(*) 先清空，变成  select * ...
		criteria.setProjection(null);
		
		// 提供分页的查询
		List<Course> beanList = (List<Course>) this.getHibernateTemplate().findByCriteria(criteria, (pageCode-1)*pageSize, pageSize);
		if (beanList == null || beanList.size() <= 0) {
			System.out.println("持久层获取失败");
		}
		// 分页查询数据，每页显示的数据  使用limit
		page.setBeanList(beanList);
		
		return page;
	}

}
