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

@WebServlet("/centerRegCheck")
public class CenterRegCheckServlet extends HttpServlet {
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
		PrintWriter out = response.getWriter();


		String vTitle = request.getParameter("vTitle");
		String vStartDate = request.getParameter("vStartDate");
		String vEndDate = request.getParameter("vEndDate");
		String vStartTime = request.getParameter("vStartTime");
		String vLastTime = request.getParameter("vLastTime");
		String vRStartDate = request.getParameter("vRStartDate");
		String vREndDate = request.getParameter("vREndDate");
		String vWorkingDay = request.getParameter("vWorkingDay");
		int vServiceCode = Integer.parseInt(request.getParameter("vServiceCode"));
		int vRegAmnt = Integer.parseInt(request.getParameter("vRegAmnt"));
		String vUploadFilePath = request.getParameter("vUploadFilePath");
		String vInfo = request.getParameter("vInfo");
		
		
		CenterRegDTO CenterRegDTO = new CenterRegDTO();
		
		CenterRegDTO.setvTitle(vTitle);
		CenterRegDTO.setvStartDate(vStartDate);
		CenterRegDTO.setvEndDate(vEndDate);
		CenterRegDTO.setvStartTime(vStartTime);
		CenterRegDTO.setvLastTime(vLastTime);
		CenterRegDTO.setvRStartDate(vRStartDate);
		CenterRegDTO.setvREndDate(vREndDate);
		CenterRegDTO.setvWorkingDay(vWorkingDay);
		CenterRegDTO.setvServiceCode(vServiceCode);
		CenterRegDTO.setvRegAmnt(vRegAmnt);
		CenterRegDTO.setvUploadFilePath(vUploadFilePath);
		CenterRegDTO.setvInfo(vInfo);
		
		CenterRegDAO dao = new CenterRegDAO();
		dao.addCenterReg(CenterRegDTO);

		}
	}