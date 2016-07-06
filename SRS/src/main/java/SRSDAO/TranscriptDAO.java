package SRSDAO;


import java.util.List;

import model.ScheduleOfClasses;
import model.Section;
import model.Transcript;

public interface TranscriptDAO {

	String getStudentSsnfromTranscript(Section s);

	Transcript getTranscript(String ssn);

	void deleteTranscript(String[] drops, String ssn);

	List<String> getTranscript(String ssn, ScheduleOfClasses scs);

}
