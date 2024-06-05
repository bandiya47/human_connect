package dc.human.gbnb.humanConnect.servlet;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dc.human.gbnb.humanConnect.dao.volunteerListDAO;
import dc.human.gbnb.humanConnect.dto.VolunteerDTO;

@WebServlet("/volunteerList")
public class volunteerListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		
		
		volunteerListDAO dao = new volunteerListDAO();
		List<VolunteerDTO> regList = dao.getRegList();
		
		request.setAttribute("regList", regList);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/volunteerList.jsp");
		dispatcher.forward(request, response);
		
	}
}