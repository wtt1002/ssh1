package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import domain.StudentInfo;

public class StudentInfoDaoImpl extends HibernateDaoSupport implements StudentInfoDao {

	@Override
	public void addStuInfo(StudentInfo studentInfo) {
		// TODO Auto-generated method stub

		this.getHibernateTemplate().save(studentInfo);
	}

	@Override
	public void delStuInfo(StudentInfo studentInfo) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(studentInfo);
	}

	@Override
	public void saveStuInfo(StudentInfo studentInfo) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(studentInfo);
	}

	@Override
	public StudentInfo findByStudentId(String studentId) {
		// TODO Auto-generated method stub
		String hql="from StudentInfo where studentId=?";
		List<StudentInfo> studentInfos = null;
		try {
			studentInfos=(List<StudentInfo>) this.getHibernateTemplate().find(hql, studentId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库查询出错。。。。。");
			e.printStackTrace();
		}
		if (studentInfos.size()>0) {
			return studentInfos.get(0);
		}
		return null;
	}

	@Override
	public StudentInfo findByStudentInfoId(String studentInfoId) {
		// TODO Auto-generated method stub
		return null;
	}

}
