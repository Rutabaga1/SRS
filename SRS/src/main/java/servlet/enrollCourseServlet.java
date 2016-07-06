package servlet;


import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EnrollmentStatus;
import model.ScheduleOfClasses;
import service.WebService;



/*import com.google.gson.Gson;

import service.dto.AjaxResult;*/

/**
 * Servlet implementation class enrollCourseServlet
 */
@WebServlet("/enrollCourseServlet")
public class enrollCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public enrollCourseServlet() {
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
		
		/*String userSSn=request.getParameter("userName");
		String userPassword=request.getParameter("userPassword");
		String auto=request.getParameter("auto");
		String kind=request.getParameter("kind");*/
		String page="enrollCourse.jsp";
		WebService service = new WebService();
		String ssn= (String) request.getSession().getAttribute("ssn");
		List<EnrollmentStatus> result=new ArrayList<EnrollmentStatus>();
		
		String[] selects=request.getParameterValues("select");
		String[] drops=request.getParameterValues("drop");
		
		service.deleteTranscript(drops,ssn);//อหัก
		
		ScheduleOfClasses scs=service.getScheduleOfClasses(selects);
		for(String key : scs.getSectionsOffered().keySet()){
			EnrollmentStatus enroll=scs.getSectionsOffered().get(key).enroll(service.getStudent(ssn));
			result.add(enroll);
			/*if(scs.getSectionsOffered().get(key).){
				
			}*/
		}
		
		if(result.isEmpty()){
			request.getRequestDispatcher(page).forward(request, response);
		}else{
			request.setAttribute("result", result);
			request.getRequestDispatcher("false.jsp").forward(request, response);
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
