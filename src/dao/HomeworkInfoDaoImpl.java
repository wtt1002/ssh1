package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import domain.HomeworkInfo;

public class HomeworkInfoDaoImpl extends HibernateDaoSupport implements HomeworkInfoDao {

	@Override
	public void addHomeworkInfo(HomeworkInfo homeworkInfo) {
		// TODO Auto-generated method stub

		this.getHibernateTemplate().save(homeworkInfo);
	}

	@Override
	public void delHomeworkInfo(HomeworkInfo homeworkInfo) {
		// TODO Auto-generated method stub

		this.getHibernateTemplate().delete(homeworkInfo);
	}

	@Override
	public void saveHomeworkInfo(HomeworkInfo homeworkInfo) {
		// TODO Auto-generated method stub

		this.getHibernateTemplate().update(homeworkInfo);
	}

	@Override
	public List<HomeworkInfo> findByStudentId(String studentId) {
		// TODO Auto-generated method stub
		String hql="from HomeworkInfo where studentId=?";
		List<HomeworkInfo> homeworkInfos=null;
		try {
			homeworkInfos=(List<HomeworkInfo>) this.getHibernateTemplate().find(hql, studentId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库查询失败。。。。。");
			e.printStackTrace();
		}
		return homeworkInfos;
	}

	@Override
	public List<HomeworkInfo> findByHomeworkId(String homeworkId) {
		// TODO Auto-generated method stub
		String hql="from HomeworkInfo where homeworkId=?";
		List<HomeworkInfo> homeworkInfos=null;
		try {
			homeworkInfos=(List<HomeworkInfo>) this.getHibernateTemplate().find(hql, homeworkId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库查询失败。。。。。");
			e.printStackTrace();
		}
		return homeworkInfos;
	}

	@Override
	public HomeworkInfo findByHomeworkInfoId(String homeworkInfoId) {
		// TODO Auto-generated method stub
		
		String hql="from HomeworkInfo where hworkInfoId=?";
		List<HomeworkInfo> homeworkInfos=null;
		try {
			homeworkInfos=(List<HomeworkInfo>) this.getHibernateTemplate().find(hql, homeworkInfoId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库查询失败。。。。。");
			e.printStackTrace();
		}
		if(homeworkInfos.size()>0)return homeworkInfos.get(0);
		return null;
	}

}
