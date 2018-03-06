package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import domain.Student;

public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		System.out.println("持久层保存学生。。。");
		this.getHibernateTemplate().save(student);
	}

	@Override
	public void delete(Student student) {
		// TODO Auto-generated method stub
		System.out.println("持久层删除学生。。。");
		Student del_Student=this.getHibernateTemplate().get(Student.class, student.getUID());
		this.getHibernateTemplate().delete(del_Student);
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(student);
	}

	@Override
	public Student findById(String studentId) {
		// TODO Auto-generated method stub
		String hql="from Student where studentId=?";
		List<Student> students = null;
		try {
			students=(List<Student>) this.getHibernateTemplate().find(hql, studentId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库查询失败。。。。。");
			e.printStackTrace();
		}
		if(students.size()>0)
		{
			return students.get(0);
					
		}
		return null;
	}
	
}
