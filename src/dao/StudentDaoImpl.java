package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import domain.Clazz;
import domain.PageBean;
import domain.Student;
import domain.Teacher;

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

	@Override
	public PageBean<Student> findByPage(Integer pageCode, Integer pageSize,
			DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		PageBean<Student> page = new PageBean<Student>();
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
		List<Student> beanList = (List<Student>) this.getHibernateTemplate().findByCriteria(criteria, (pageCode-1)*pageSize, pageSize);
		// 分页查询数据，每页显示的数据  使用limit
		page.setBeanList(beanList);
		
		return page;
	}

	@Override
	public Student studentLogin(String studentId, String password) {
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
			if (students.get(0).getPassword().equals(password)) {
				return students.get(0);
			}
					
		}
		return null;
	}
	
}
