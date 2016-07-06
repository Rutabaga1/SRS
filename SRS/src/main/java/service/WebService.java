package service;


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

	public Person signInProfessor(Person admin) {
		// TODO Auto-generated method stub
		return professorDAO.signInProfessor(admin);
	}
	
	public Person signInStudent(Person admin) {
		// TODO Auto-generated method stub
		return studentDAO.signInStudent(admin);
	}

	public ScheduleOfClasses getScheduleOfClasses(String semester) {
		// TODO Auto-generated method stub
		return sectionDAO.getScheduleofClasses(semester);
	}

	public List<String> getTranscript(String ssn, ScheduleOfClasses scs) {
		// TODO Auto-generated method stub
		return transcriptDAO.getTranscript(ssn,scs);
	}

	public void deleteTranscript(String[] drops, String ssn) {
		// TODO Auto-generated method stub
		transcriptDAO.deleteTranscript(drops,ssn);
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

	public void addCourse(Course add1, String addPres) {
		// TODO Auto-generated method stub
		courseDAO.addCourse(add1,addPres);
	}

	public void deleteTeachers(String[] deletes) {
		// TODO Auto-generated method stub
		professorDAO.deleteTeachers(deletes);
	}

	public void deleteCourses(String[] deletes) {
		// TODO Auto-generated method stub
		courseDAO.deleteCourses(deletes);
	}

	public ScheduleOfClasses getProfessorScheduleOfClasses(String ssn) {
		// TODO Auto-generated method stub
		return sectionDAO.getProfessorScheduleOfClasses(ssn);
	}

	public String getStudentSsnfromTranscript(Section s) {
		// TODO Auto-generated method stub
		return transcriptDAO.getStudentSsnfromTranscript(s);
	}

	public void updateTeachers(Professor ud) {
		// TODO Auto-generated method stub
		professorDAO.updateTeachers(ud);
	}

	public void updateCourses(Course ud, String changeCredits) {
		// TODO Auto-generated method stub
		courseDAO.updateCourses(ud,changeCredits);
	}
	
    
}
