package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Section;
import model.Transcript;
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
		String ssn= (String) request.getSession().getAttribute("ssn");
		List<Section> st=service.getSections(ssn);
		Transcript tst=service.getTranscript(st);
		
		if(tst.hashCode()==0){
			request.getRequestDispatcher(page).forward(request, response);
		}else{
			request.setAttribute("result",tst.getTranscriptEntries());
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
