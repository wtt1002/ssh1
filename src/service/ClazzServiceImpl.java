package service;

import org.springframework.transaction.annotation.Transactional;

import dao.ClazzDao;
import domain.Clazz;

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

}
