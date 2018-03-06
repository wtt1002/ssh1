package service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.HomeworkDao;
import dao.HomeworkInfoDao;
import domain.HomeworkInfo;

@Transactional
public class HomeworkInfoServiceImpl implements HomeworkInfoService{

	private HomeworkInfoDao homeworkInfoDao;
	public void setHomeworkInfoDao(HomeworkInfoDao homeworkInfoDao) {
		this.homeworkInfoDao = homeworkInfoDao;
	}

	@Override
	public void addHomeworkInfo(HomeworkInfo homeworkInfo) {
		// TODO Auto-generated method stub
		homeworkInfoDao.addHomeworkInfo(homeworkInfo);
	}

	@Override
	public void delHomeworkInfo(HomeworkInfo homeworkInfo) {
		// TODO Auto-generated method stub
		homeworkInfoDao.delHomeworkInfo(homeworkInfo);
	}

	@Override
	public void saveHomeworkInfo(HomeworkInfo homeworkInfo) {
		// TODO Auto-generated method stub
		homeworkInfoDao.saveHomeworkInfo(homeworkInfo);
	}

	@Override
	public List<HomeworkInfo> findByStudentId(String studentId) {
		// TODO Auto-generated method stub
		return homeworkInfoDao.findByStudentId(studentId);
	}

	@Override
	public List<HomeworkInfo> findByHomeworkId(String homeworkId) {
		// TODO Auto-generated method stub
		 return homeworkInfoDao.findByHomeworkId(homeworkId);
		
	}

	@Override
	public HomeworkInfo findByHomeworkInfoId(String homeworkInfoId) {
		// TODO Auto-generated method stub
		return homeworkInfoDao.findByHomeworkInfoId(homeworkInfoId);
	}

}
