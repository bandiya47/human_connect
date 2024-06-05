package dc.human.gbnb.humanConnect.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import dc.human.gbnb.humanConnect.dao.CenterRegDAO;
import dc.human.gbnb.humanConnect.dao.VolunteerDetailDAO;
import dc.human.gbnb.humanConnect.dto.VolunteerDetailDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/volunteerReg")
public class volunteerReg extends HttpServlet {
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

//        Part part = request.getPart("vUploadFilePath");
//        String fileName = request.getParameter("vUploadFilePath");
//        if (!fileName.isEmpty()) {
//            part.write("C:\\Test\\"+fileName);
//        }
		
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
		int vreg_amnt = Integer.parseInt(request.getParameter("vreg_amnt"));
		String vreg_upload_file_path = request.getParameter("vreg_upload_file_path");
		String vreg_info = request.getParameter("vreg_info");
		
		
		VolunteerDetailDTO volunteerDetailDTO = new VolunteerDetailDTO();
		

		volunteerDetailDTO.setvStartDate(vStartDate);
		volunteerDetailDTO.setvEndDate(vEndDate);
		volunteerDetailDTO.setvStartTime(vStartTime);
		volunteerDetailDTO.setvLastTime(vLastTime);
		volunteerDetailDTO.setVreg_amnt(vreg_amnt);
		volunteerDetailDTO.setVreg_upload_file_path(vreg_upload_file_path);
		volunteerDetailDTO.setVreg_info(vreg_info);
		
		VolunteerDetailDAO dao = new VolunteerDetailDAO();
		dao.addVolunteerDetail(volunteerDetailDTO);
		
//		if (result) {
//			HttpSession session = request.getSession();
//			session.setAttribute("isLogon", true);
//			session.setAttribute("login.id",  user_id);
//			session.setAttribute("login.pwd", user_pwd);
//			out.print("<html><body>");
//			out.print("안녕하세요 " +user_id + "님!!!<br>");
//			out.print("<a href='show'>회원정보 보기</a>");
//			out.print("</body></html>");
//			} else {
//				out.print("<html><body><center>회원 아이디가 틀립니다.");
//				out.print("<a href='login3.html'>다시 로그인 하기</a>");
//				out.print("</body></html>");
//			}
		}
	}