package SRSDAO;

import java.util.List;

import model.Course;

public interface CourseDAO {

	void updateCourses(Course ud, String changeCredits);

	void deleteCourses(String[] deletes);

	void addCourse(Course add1, String addPres);

	List<Course> getCourses();

}
