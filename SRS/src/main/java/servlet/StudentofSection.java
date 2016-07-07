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
import model.TranscriptEntry;
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
		List<TranscriptEntry> tstSsn=new ArrayList<TranscriptEntry>();
		List<Student> enolledStudent=new ArrayList<Student>();
		
		String ssn= (String) request.getSession().getAttribute("ssn");
		ScheduleOfClasses professorClass=service.getProfessorScheduleOfClasses(ssn);
		
			tstSsn=service.getStudentSsnfromTranscript(professorClass);
		
		
		
			enolledStudent=service.getStudentsOfProfessor(tstSsn);
		
		
		if(enolledStudent.size()==0){
			request.setAttribute("falseResult", "没有学生选课的信息！");
			request.getRequestDispatcher(page).forward(request, response);
		}else{
			request.setAttribute("resultStudent",enolledStudent);//注意
			request.setAttribute("resultTranscriptEntry",tstSsn);
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
