package dao;

import domain.Clazz;

public interface ClazzDao {

	public void addClazz(Clazz clazz);
	public void delClazz(Clazz clazz);
	public void saveClazz(Clazz clazz);
	public Clazz findById(String clazzId);
}
