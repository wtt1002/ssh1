package service;

import java.util.List;

import domain.Course;

public interface CourseService {

	public void addCourse(Course course);
	public void delCourse(Course course);
	public void saveCourse(Course course);
	public Course findByCourseId(String courseId);
	public List<Course> findByTeacherId(String teacherId);
	
}
