package SRSDAO;

import java.util.List;

import model.ScheduleOfClasses;
import model.Section;

public interface SectionDAO {

	ScheduleOfClasses getScheduleofClasses(String[] selects);

	ScheduleOfClasses getScheduleofClasses(String semester);

	List<Section> getSections(String ssn);

}
