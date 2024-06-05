package dc.human.gbnb.humanConnect.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import dc.human.gbnb.humanConnect.dao.CenterRegDAO;
import dc.human.gbnb.humanConnect.dto.CenterRegDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/centerReg")
public class CenterRegServlet extends HttpServlet {
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


		
		String vTitle = request.getParameter("vTitle");
		String vStartDate = request.getParameter("vStartDate");
		String vEndDate = request.getParameter("vEndDate");
		String vStartTime = request.getParameter("vStartTime");
		String vLastTime = request.getParameter("vLastTime");
		String vRStartDate = request.getParameter("vRStartDate");
		String vREndDate = request.getParameter("vREndDate");
		String vWorkingDay = request.getParameter("vWorkingDay1");
		vWorkingDay+= request.getParameter("vWorkingDay2");
		vWorkingDay+= request.getParameter("vWorkingDay3");
		vWorkingDay+= request.getParameter("vWorkingDay4");
		vWorkingDay+= request.getParameter("vWorkingDay5");
		vWorkingDay+= request.getParameter("vWorkingDay6");
		vWorkingDay+= request.getParameter("vWorkingDay7");
		int vServiceCode = Integer.parseInt(request.getParameter("vServiceCode"));
		int vRegAmnt = Integer.parseInt(request.getParameter("vRegAmnt"));
		String vUploadFilePath =request.getParameter("vUploadFilePath");
		String vInfo = request.getParameter("vInfo");
		
		

		
		request.setAttribute("vTitle", vTitle);	
		request.setAttribute("vStartDate", vStartDate);
		request.setAttribute("vEndDate", vEndDate);
		request.setAttribute("vStartTime", vStartTime);
		request.setAttribute("vLastTime", vLastTime);
		request.setAttribute("vRStartDate", vRStartDate);
		request.setAttribute("vREndDate", vREndDate);
		request.setAttribute("vWorkingDay", vWorkingDay);
		request.setAttribute("vServiceCode", vServiceCode);
		request.setAttribute("vRegAmnt", vRegAmnt);
		request.setAttribute("vUploadFilePath", vUploadFilePath);
		request.setAttribute("vInfo", vInfo);
		
		request.getRequestDispatcher("/centerRegCheck.jsp").forward(request, response);
		

		}
	}