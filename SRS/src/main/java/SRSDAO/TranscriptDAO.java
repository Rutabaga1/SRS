package SRSDAO;

import java.util.HashMap;
import java.util.List;

import model.Section;
import model.Transcript;

public interface TranscriptDAO {

	Transcript getTranscript(List<Section> st);

	Transcript getTranscript(String ssn);

	void deleteTranscript(String[] drops);

	Transcript getTranscript(String ssn, HashMap<String, Section> hashMap);

}
