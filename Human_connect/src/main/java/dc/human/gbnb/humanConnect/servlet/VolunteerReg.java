//
//package dc.human.gbnb.humanConnect.servlet;
//
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import dc.human.gbnb.humanConnect.dao.CenterRegDAO;
//import dc.human.gbnb.humanConnect.dao.VolunteerDetailDAO;
//import dc.human.gbnb.humanConnect.dto.VolunteerDetailDTO;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@WebServlet("/volunteerReg")
//public class VolunteerReg extends HttpServlet {
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doHandle(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doHandle(request, response);
//	}
//
//	private void doHandle(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//
//
//		//
//		String vTitle = request.getParameter("vTitle");
//		String vStartDate = request.getParameter("vStartDate");
//		String vEndDate = request.getParameter("vEndDate");
//		String vStartTime = request.getParameter("vStartTime");
//		String vLastTime = request.getParameter("vLastTime");
//		String vRStartDate = request.getParameter("vRStartDate");
//		String vREndDate = request.getParameter("vREndDate");
//		String vWorkingDay = request.getParameter("vWorkingDay");
//		int vServiceCode = Integer.parseInt(request.getParameter("vServiceCode"));
//		int vRegAmnt = Integer.parseInt(request.getParameter("vRegAmnt"));
//		int vreg_amnt = Integer.parseInt(request.getParameter("vreg_amnt"));
//		String vreg_upload_file_path = request.getParameter("vreg_upload_file_path");
//		String vreg_info = request.getParameter("vreg_info");
//		
//		
//		VolunteerDetailDTO volunteerDetailDTO = new VolunteerDetailDTO();
//		
//
//		volunteerDetailDTO.setvStartDate(vStartDate);
//		volunteerDetailDTO.setvEndDate(vEndDate);
//		volunteerDetailDTO.setvStartTime(vStartTime);
//		volunteerDetailDTO.setvLastTime(vLastTime);
//		volunteerDetailDTO.setVreg_amnt(vreg_amnt);
//		volunteerDetailDTO.setVreg_upload_file_path(vreg_upload_file_path);
//		volunteerDetailDTO.setVreg_info(vreg_info);
//		
//		VolunteerDetailDAO dao = new VolunteerDetailDAO();
//		dao.addVolunteerDetail(volunteerDetailDTO);
//		
//
//		}
//	}
