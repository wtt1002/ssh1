package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import domain.Clazz;
import domain.PageBean;
import domain.Score;
import domain.Student;

public class ScoreDaoImpl extends HibernateDaoSupport implements ScoreDao {

	@Override
	public void addScore(Score score) {
		// TODO Auto-generated method stub
		if (score == null) {
			System.out.println("score为空");
		}
		System.out.println("dao层添加score"+score.getStudent().getStudentName());
		try {
			this.getHibernateTemplate().save(score);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("持久层保存score");
		}
	}

	@Override
	public void delScore(Score score) {
		// TODO Auto-generated method stub

		Score del_score=this.getHibernateTemplate().get(Score.class, score.getUID());
		this.getHibernateTemplate().delete(del_score);
	}

	@Override
	public void saveScore(Score score) {
		// TODO Auto-generated method stub

		this.getHibernateTemplate().update(score);
	}

	@Override
	public List<Score> findByStudentId(String studentId) {
		
		// TODO Auto-generated method stub
		String hql="from Score where studentId=?";
		List<Score> scores = null;
		try {
			 scores=(List<Score>) this.getHibernateTemplate().find(hql, studentId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库查询异常。。。。。");
			e.printStackTrace();
		}
		return scores;
	}

	@Override
	public List<Score> findByCoursetId(String courseId) {
		// TODO Auto-generated method stub
		String hql="from Score where courseId=?";
		List<Score> scores = null;
		try {
			 scores=(List<Score>) this.getHibernateTemplate().find(hql, courseId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库查询异常。。。。。");
			e.printStackTrace();
		}
		return scores;
	}

	@Override
	public PageBean<Student> findByCoursetIdPage(Integer pageCode,
			Integer pageSize, DetachedCriteria criteria) {
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
		List<Score> scores = (List<Score>) this.getHibernateTemplate().findByCriteria(criteria, (pageCode-1)*pageSize, pageSize);
		List<Student> studentList = new ArrayList<>();
		// 分页查询数据，每页显示的数据  使用limit
		for (Score score : scores) {
			studentList.add(score.getStudent());
		}
		page.setBeanList(studentList);
		
		return page;
	}

}
