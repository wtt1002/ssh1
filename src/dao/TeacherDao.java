package dao;

import domain.Teacher;

public interface TeacherDao {

	public void save(Teacher teacher);
	public void delete(Teacher teacher);
	public void update(Teacher teacher);
	public Teacher findById(String teacherId);
}
