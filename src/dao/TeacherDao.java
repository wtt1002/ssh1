package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.PageBean;
import domain.Teacher;

public interface TeacherDao {

	public void save(Teacher teacher);
	public void delete(Teacher teacher);
	public void update(Teacher teacher);
	public Teacher findById(String teacherId);
	public List<String> findSchools();
	public PageBean<Teacher> findByPage(Integer pageCode, Integer pageSize,
			DetachedCriteria criteria);
	public List<Teacher> getTeacherBySchool(String schoolName);
	public Teacher teacherLogin(String teacherId, String password);
}
