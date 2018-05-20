package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.Course;
import domain.PageBean;

public interface CourseDao {

	public void addCourse(Course course);
	public void delCourse(Course course);
	public void saveCourse(Course course);
	public Course findByCourseId(String courseId);
	public List<Course> findByTeacherId(String teacherId);
	public PageBean<Course> findByPage(Integer pageCode, Integer pageSize,
			DetachedCriteria criteria);
}
