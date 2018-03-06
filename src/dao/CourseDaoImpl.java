package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import domain.Course;
import domain.Homework;
import domain.Teacher;

public class CourseDaoImpl extends HibernateDaoSupport implements CourseDao {

	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub

		this.getHibernateTemplate().save(course);
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
		List<Course> courses=null;
		try {
			courses=(List<Course>) this.getHibernateTemplate().find(hql, teacherId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库查询失败。。。。。");
			e.printStackTrace();
		}
		return courses;
	}

}
