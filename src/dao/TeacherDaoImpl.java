package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

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

}
