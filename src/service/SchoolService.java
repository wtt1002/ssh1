package service;

import domain.School;
import java.util.List;
public interface SchoolService{

	public List<School> getAllSchools();
	public List<School> findByStartYear(int startYear);
	public void addSchool(School school);
	public void delSchool(School school);
	public void saveSchool(School school);
}
