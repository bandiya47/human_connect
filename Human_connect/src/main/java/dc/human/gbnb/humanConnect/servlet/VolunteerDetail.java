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

@WebServlet("/volunteerDetail")
public class VolunteerDetail extends HttpServlet {
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


		int v_no = Integer.parseInt(request.getParameter("v_no"));
		

		
		
		CenterRegDTO CenterRegDTO = new CenterRegDTO();

		
		CenterRegDTO.setV_no(v_no);
		
		
		CenterRegDAO dao = new CenterRegDAO();

		dao.listCenterReg(CenterRegDTO);

		System.out.println(CenterRegDTO.getvEndDate());
		
		request.setAttribute("vTitle", CenterRegDTO.getvTitle());	
		request.setAttribute("vStartDate", CenterRegDTO.getvStartDate());
		request.setAttribute("vEndDate", CenterRegDTO.getvEndDate());
		request.setAttribute("vStartTime", CenterRegDTO.getvStartTime());
		request.setAttribute("vLastTime", CenterRegDTO.getvLastTime());
		request.setAttribute("vRStartDate", CenterRegDTO.getvRStartDate());
		request.setAttribute("vREndDate", CenterRegDTO.getvREndDate());
		request.setAttribute("vWorkingDay", CenterRegDTO.getvWorkingDay());
		request.setAttribute("vServiceCode", CenterRegDTO.getvServiceCode());
		request.setAttribute("vMaxAmnt", CenterRegDTO.getvMaxAmnt());
		request.setAttribute("vRegAmnt", CenterRegDTO.getvRegAmnt());
		request.setAttribute("vUploadFilePath", CenterRegDTO.getvUploadFilePath());
		request.setAttribute("vInfo", CenterRegDTO.getvInfo());
		
		request.getRequestDispatcher("/volunteerDetail.jsp").forward(request, response);
		

		}
	}