package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import domain.School;
/**
 * 20180405
 * @author 王婷婷
 *
 */
public class SchoolDaoImpl extends HibernateDaoSupport implements SchoolDao {
	@Override
	public List<School> getAllSchools() {
		// TODO Auto-generated method stub
		String hql = "from School";
		List<School> list = new ArrayList<School>();
		try {
			list = (List<School>) this.getHibernateTemplate().find(hql);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库查询异常。。。。。");
			e.printStackTrace();
		}
		if (list == null || list.size()==0) {
			System.out.println("list为空");
		}
		return list;
	}

	@Override
	public List<School> findByStartYear(int startYear) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addSchool(School school) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delSchool(School school) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveSchool(School school) {
		// TODO Auto-generated method stub

	}

}
