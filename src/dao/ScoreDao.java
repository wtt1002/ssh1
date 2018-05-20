package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.PageBean;
import domain.Score;
import domain.Student;

public interface ScoreDao {

	public void addScore(Score score);
	public void delScore(Score score);
	public void saveScore(Score score);
	public List<Score> findByStudentId(String studentId);
	public List<Score> findByCoursetId(String courseId);
	public PageBean<Student> findByCoursetIdPage(Integer pageCode,
			Integer pageSize, DetachedCriteria criteria);
}
