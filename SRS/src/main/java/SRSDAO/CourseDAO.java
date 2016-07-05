package SRSDAO;

import java.util.List;

import model.Course;

public interface CourseDAO {

	void updateCourses(String[] changes, String[] changeNos, String[] changeNames, String[] changeCredits);

	void deleteCourses(String[] deletes);

	void addCourse(Course add1);

	List<Course> getCourses();

}
