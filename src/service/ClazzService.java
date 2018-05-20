package service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.Clazz;
import domain.PageBean;

public interface ClazzService {

	public Clazz findById(String clazzId);
	public void addClazz(Clazz clazz);
	public void delClazz(Clazz clazz);
	public void saveClazz(Clazz clazz);
	public List<Clazz> findClazzs(Clazz clazz);
	public List<String> findSchools();
	public PageBean<Clazz> findByPage(Integer pageCode, Integer pageSize,
			DetachedCriteria criteria);
	public List<Integer> getYearBySchool(String schoolName);
	public List<Clazz> getClazzBySchoolAndYear(String schoolName,
			Integer rollYear);
}
