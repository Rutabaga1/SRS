package service;

import java.util.HashMap;
import java.util.List;

import SRSDAO.*;
import model.Person;
import model.Professor;
import model.ScheduleOfClasses;
import model.Section;
import model.Student;
import model.Transcript;
import model.Course;

//import java.util.List;


public class WebService {
	private CourseDAO courseDAO=DataFactory.createCourseDAO();
	private ProfessorDAO professorDAO=DataFactory.createProfessorDAO();
	private SectionDAO sectionDAO=DataFactory.createSectionDAO();
	private StudentDAO studentDAO=DataFactory.createStudentDAO();
	private TranscriptDAO transcriptDAO=DataFactory.createTranscriptDAO();

	public Person signIn(Person admin) {
		// TODO Auto-generated method stub
		return professorDAO.signIn(admin);
	}

	public ScheduleOfClasses getScheduleOfClasses(String semester) {
		// TODO Auto-generated method stub
		return sectionDAO.getScheduleofClasses(semester);
	}

	public Transcript getTranscript(String ssn, HashMap<String, Section> hashMap) {
		// TODO Auto-generated method stub
		return transcriptDAO.getTranscript(ssn,hashMap);
	}

	public void deleteTranscript(String[] drops) {
		// TODO Auto-generated method stub
		transcriptDAO.deleteTranscript(drops);
	}

	public ScheduleOfClasses getScheduleOfClasses(String[] selects) {
		// TODO Auto-generated method stub
		return sectionDAO.getScheduleofClasses(selects);
	}

	public Student getStudent(String ssn) {
		// TODO Auto-generated method stub
		return studentDAO.getStudent(ssn);
	}

	public Transcript getTranscript(String ssn) {
		// TODO Auto-generated method stub
		return transcriptDAO.getTranscript(ssn);
	}

	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseDAO.getCourses();
	}

	public List<Professor> getProfessors() {
		// TODO Auto-generated method stub
		return professorDAO.getProfessors();
	}

	public void addProfessor(Professor add1) {
		// TODO Auto-generated method stub
		professorDAO.addProfessor(add1);
	}

	public void addCourse(Course add1) {
		// TODO Auto-generated method stub
		courseDAO.addCourse(add1);
	}

	public void deleteTeachers(String[] deletes) {
		// TODO Auto-generated method stub
		professorDAO.deleteTeachers(deletes);
	}

	public void deleteCourses(String[] deletes) {
		// TODO Auto-generated method stub
		courseDAO.deleteCourses(deletes);
	}

	public List<Section> getSections(String ssn) {
		// TODO Auto-generated method stub
		return sectionDAO.getSections(ssn);
	}

	public Transcript getTranscript(List<Section> st) {
		// TODO Auto-generated method stub
		return transcriptDAO.getTranscript(st);
	}

	public void updateTeachers(String[] changes, String[] changeNos, String[] changeNames, String[] changeDepartments) {
		// TODO Auto-generated method stub
		professorDAO.updateTeachers(changes,changeNos,changeNames,changeDepartments);
	}

	public void updateCourses(String[] changes, String[] changeNos, String[] changeNames, String[] changeCredits) {
		// TODO Auto-generated method stub
		courseDAO.updateCourses(changes,changeNos,changeNames,changeCredits);
	}
	
    
}
