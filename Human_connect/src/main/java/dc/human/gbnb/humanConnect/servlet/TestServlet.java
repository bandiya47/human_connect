package dc.human.gbnb.humanConnect.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dc.human.gbnb.humanConnect.dao.CenterRegDAO;
import dc.human.gbnb.humanConnect.dao.TestDAO;
import dc.human.gbnb.humanConnect.dto.CenterRegDTO;
import dc.human.gbnb.humanConnect.dto.TestDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
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




		TestDAO dao = new TestDAO();
		List<TestDTO> volunteerList = dao.volunteerList();
		
		request.setAttribute("volunteerList", volunteerList);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Test.jsp");
		dispatcher.forward(request, response);
		

		}
	}