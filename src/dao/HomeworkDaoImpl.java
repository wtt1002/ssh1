package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import domain.Homework;

public class HomeworkDaoImpl extends HibernateDaoSupport implements HomeworkDao {

	@Override
	public void addHomework(Homework homework) {
		// TODO Auto-generated method stub

		this.getHibernateTemplate().save(homework);
		
	}

	@Override
	public void delHomework(Homework homework) {
		// TODO Auto-generated method stub
		Homework del_homework=this.getHibernateTemplate().get(Homework.class,homework.getUID());
		this.getHibernateTemplate().delete(del_homework);
	}

	@Override
	public void saveHomework(Homework homework) {
		// TODO Auto-generated method stub

		this.getHibernateTemplate().update(homework);
	}

	@Override
	public Homework findByHomeworkId(String homeworkId) {
		// TODO Auto-generated method stub
		String hql="from Homework where homeworkId=?";
		List<Homework> homeworks=null;
		try {
			homeworks=(List<Homework>) this.getHibernateTemplate().find(hql, homeworkId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库查询失败。。。。。");
			e.printStackTrace();
		}
		if (homeworks.size()>0) {
			return homeworks.get(0);
		}
		return null;
				
	}

	@Override
	public List<Homework> findByTeacherId(String teacherId) {
		// TODO Auto-generated method stub
		String hql="from Homework where teacherId=?";
		List<Homework> homeworks = null;
		try {
			homeworks=(List<Homework>) this.getHibernateTemplate().find(hql, teacherId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库查询失败。。。。。");
			e.printStackTrace();
		}
		return homeworks;
	}

	@Override
	public List<Homework> findByCourseId(String courseId) {
		// TODO Auto-generated method stub
		String hql="from Homework where courseId=?";
		List<Homework> homeworks = null;
		try {
			homeworks=(List<Homework>) this.getHibernateTemplate().find(hql, courseId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库查询失败。。。。。");
			e.printStackTrace();
		}
		return homeworks;
	}


}
