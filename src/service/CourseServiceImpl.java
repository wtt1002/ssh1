package service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import dao.CourseDao;
import domain.Clazz;
import domain.Course;
import domain.PageBean;
@Transactional
public class CourseServiceImpl implements CourseService {

	private CourseDao courseDao;
	
	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub

		courseDao.addCourse(course);
	}

	@Override
	public void delCourse(Course course) {
		// TODO Auto-generated method stub

		courseDao.delCourse(course);
	}

	@Override
	public void saveCourse(Course course) {
		// TODO Auto-generated method stub

		courseDao.saveCourse(course);
	}

	@Override
	public Course findByCourseId(String courseId) {
		// TODO Auto-generated method stub
		return courseDao.findByCourseId(courseId);
	}

	@Override
	public List<Course> findByTeacherId(String teacherId) {
		// TODO Auto-generated method stub
		return courseDao.findByTeacherId(teacherId);
	}

	@Override
	public PageBean<Course> findByPage(Integer pageCode, Integer pageSize,
			DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return courseDao.findByPage(pageCode,pageSize,criteria);
	}

}
