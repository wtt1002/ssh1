package service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import dao.ClazzDao;
import domain.Clazz;
import domain.PageBean;

@Transactional
public class ClazzServiceImpl implements ClazzService {

	private ClazzDao clazzDao;
	
	public void setClazzDao(ClazzDao clazzDao) {
		this.clazzDao = clazzDao;
	}

	@Override
	public Clazz findById(String clazzId) {
		// TODO Auto-generated method stub
		Clazz clazz = null;
		try {
			clazz=clazzDao.findById(clazzId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("服务层：数据库查询异常。。。。。");
			e.printStackTrace();
		}
		
		return clazz;
	}

	@Override
	public void addClazz(Clazz clazz) {
		// TODO Auto-generated method stub
		clazzDao.addClazz(clazz);
	}

	@Override
	public void delClazz(Clazz clazz) {
		// TODO Auto-generated method stub
		clazzDao.delClazz(clazz);
	}

	@Override
	public void saveClazz(Clazz clazz) {
		// TODO Auto-generated method stub
		clazzDao.saveClazz(clazz);
	}

	@Override
	public List<Clazz> findClazzs(Clazz clazz) {
		// TODO Auto-generated method stub
		
		return clazzDao.findClazzs(clazz);
	}

	@Override
	public List<String> findSchools() {
		// TODO Auto-generated method stub
		return clazzDao.findSchools();
	}

	@Override
	public PageBean<Clazz> findByPage(Integer pageCode, Integer pageSize,
			DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		
		return clazzDao.findByPage(pageCode,pageSize,criteria);
	}

	@Override
	public List<Integer> getYearBySchool(String schoolName) {
		// TODO Auto-generated method stub
		return clazzDao.getYearBySchool(schoolName);
	}

	@Override
	public List<Clazz> getClazzBySchoolAndYear(String schoolName,
			Integer rollYear) {
		// TODO Auto-generated method stub
		return clazzDao.getClazzBySchoolAndYear(schoolName,rollYear);
	}

}
