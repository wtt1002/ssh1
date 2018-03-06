package service;

import java.util.List;

import domain.HomeworkInfo;

public interface HomeworkInfoService {

	public void addHomeworkInfo(HomeworkInfo homeworkInfo);
	public void delHomeworkInfo(HomeworkInfo homeworkInfo);
	public void saveHomeworkInfo(HomeworkInfo homeworkInfo);
	public List<HomeworkInfo> findByStudentId(String studentId);
	//public HomeworkInfo findByCourseId(String courseId);
	public List<HomeworkInfo> findByHomeworkId(String homeworkId);
	public HomeworkInfo findByHomeworkInfoId(String homeworkInfoId);
}
