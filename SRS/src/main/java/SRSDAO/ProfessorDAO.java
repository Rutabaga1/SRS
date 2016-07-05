package SRSDAO;

import java.util.List;

import model.Person;
import model.Professor;

public interface ProfessorDAO {

	void updateTeachers(String[] changes, String[] changeNos, String[] changeNames, String[] changeDepartments);

	void deleteTeachers(String[] deletes);

	void addProfessor(Professor add1);

	List<Professor> getProfessors();

	Person signIn(Person admin);

}
