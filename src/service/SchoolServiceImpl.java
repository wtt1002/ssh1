package service;

import java.util.List;

import dao.SchoolDao;
import domain.School;

public class SchoolServiceImpl implements SchoolService {

	private SchoolDao schoolDao;
	public void setSchoolDao(SchoolDao schoolDao) {
		this.schoolDao = schoolDao;
	}

	@Override
	public List<School> getAllSchools() {
		// TODO Auto-generated method stub
		return schoolDao.getAllSchools();
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
