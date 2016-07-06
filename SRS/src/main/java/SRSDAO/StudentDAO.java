package SRSDAO;

import model.Person;
import model.Student;

public interface StudentDAO {

	Student getStudent(String ssn);

	Person signInStudent(Person admin);
}
