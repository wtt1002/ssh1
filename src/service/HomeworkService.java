package service;

import java.util.List;

import domain.Homework;

public interface HomeworkService {

	public void addHomework(Homework homework);
	public void delHomework(Homework homework);
	public void saveHomework(Homework homework);
	public Homework findByHomeworkId(String homeworkId);
	public List<Homework> findByTeacherId(String teacherId);
	public List<Homework> findByCourseId(String courseId);
}
