package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ScheduleOfClasses;
import model.Section;
import model.Student;

import service.WebService;





/**
 * Servlet implementation class GuitarSearch
 */
@WebServlet("/StudentofSection")
public class StudentofSection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentofSection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String page="false.jsp";
		WebService service = new WebService();
		List<String> tstSsn=new ArrayList<String>();
		List<Student> enolledStudent=new ArrayList<Student>();
		
		String ssn= (String) request.getSession().getAttribute("ssn");
		ScheduleOfClasses professorClass=service.getProfessorScheduleOfClasses(ssn);
		for (Section s : professorClass.getSectionsOffered().values()) {
			tstSsn.add(service.getStudentSsnfromTranscript(s));
		}
		
		for(int i=0;i<tstSsn.size();i++){
			enolledStudent.add(service.getStudent(tstSsn.get(i)));
		}
		
		if(enolledStudent.size()==0){
			request.getRequestDispatcher(page).forward(request, response);
		}else{
			request.setAttribute("resultStudent",enolledStudent);//зЂвт
			request.setAttribute("resultSectons",professorClass.getSectionsOffered());
			request.getRequestDispatcher("studentChoose.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
