package service;

import domain.Clazz;

public interface ClazzService {

	public Clazz findById(String clazzId);
	public void addClazz(Clazz clazz);
	public void delClazz(Clazz clazz);
	public void saveClazz(Clazz clazz);
}
