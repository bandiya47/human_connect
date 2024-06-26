package dc.human.gbnb.humanConnect.servlet;

import java.io.IOException;
import java.util.List;

import dc.human.gbnb.humanConnect.dao.VolunteerListDAO;
import dc.human.gbnb.humanConnect.dto.VolunteerDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/volunteerList")
public class VolunteerListServlet extends HttpServlet {
	
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		VolunteerListDAO dao = new VolunteerListDAO();
		List<VolunteerDTO> volunteerList = dao.volunteerList();
		
		request.setAttribute("volunteerList", volunteerList);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/volunteerList.jsp");
		dispatcher.forward(request, response);
		

		}

}