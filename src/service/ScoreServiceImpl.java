package service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import dao.CourseDao;
import dao.ScoreDao;
import domain.PageBean;
import domain.Score;
import domain.Student;

@Transactional
public class ScoreServiceImpl implements ScoreService {

	private ScoreDao scoreDao;
	

	public void setScoreDao(ScoreDao scoreDao) {
		this.scoreDao = scoreDao;
	}

	@Override
	public void addScore(Score score) {
		// TODO Auto-generated method stub
		System.out.println("service层添加score");
		scoreDao.addScore(score);
	}

	@Override
	public void delScore(Score score) {
		// TODO Auto-generated method stub
		scoreDao.delScore(score);
	}

	@Override
	public void saveScore(Score score) {
		// TODO Auto-generated method stub
		scoreDao.saveScore(score);
	}

	@Override
	public List<Score> findByStudentId(String studentId) {
		// TODO Auto-generated method stub
		return scoreDao.findByStudentId(studentId);
	}

	@Override
	public List<Score> findByCoursetId(String courseId) {
		// TODO Auto-generated method stub
		return scoreDao.findByCoursetId(courseId);
	}

	@Override
	public PageBean<Student> findByCoursetIdPage(Integer pageCode,
			Integer pageSize, DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return scoreDao.findByCoursetIdPage(pageCode,pageSize,criteria);
	}

}
