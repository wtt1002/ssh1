package dao;

import java.util.List;

import domain.School;

public interface SchoolDao {

	public List<School> getAllSchools();
	public List<School> findByStartYear(int startYear);
	public void addSchool(School school);
	public void delSchool(School school);
	public void saveSchool(School school);
}
