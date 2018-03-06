package service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.HomeworkDao;
import domain.Homework;
@Transactional
public class HomeworkServiceImpl implements HomeworkService {

	HomeworkDao homeworkDao;
	
	public void setHomeworkDao(HomeworkDao homeworkDao) {
		this.homeworkDao = homeworkDao;
	}

	@Override
	public void addHomework(Homework homework) {
		// TODO Auto-generated method stub
		homeworkDao.addHomework(homework);
	}

	@Override
	public void delHomework(Homework homework) {
		// TODO Auto-generated method stub

		homeworkDao.delHomework(homework);
	}

	@Override
	public void saveHomework(Homework homework) {
		// TODO Auto-generated method stub

		homeworkDao.saveHomework(homework);
	}

	@Override
	public Homework findByHomeworkId(String homeworkId) {
		// TODO Auto-generated method stub
		return homeworkDao.findByHomeworkId(homeworkId);
		
	}

	@Override
	public List<Homework> findByTeacherId(String teacherId) {
		// TODO Auto-generated method stub
		return homeworkDao.findByTeacherId(teacherId);
	}

	@Override
	public List<Homework>findByCourseId(String courseId) {
		// TODO Auto-generated method stub
		return homeworkDao.findByCourseId(courseId);
	}

}
