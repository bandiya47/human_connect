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
//		dao.listCenterReg(CenterRegDTO);
		
//		request.setAttribute("vTitle", CenterRegDTO.getvTitle());	
//		request.setAttribute("vStartDate", CenterRegDTO.getvStartDate());
//		request.setAttribute("vEndDate", CenterRegDTO.getvEndDate());
//		request.setAttribute("vStartTime", CenterRegDTO.getvStartTime());
//		request.setAttribute("vLastTime", CenterRegDTO.getvLastTime());
//		request.setAttribute("vRStartDate", CenterRegDTO.getvRStartDate());
//		request.setAttribute("vREndDate", CenterRegDTO.getvREndDate());
//		request.setAttribute("vWorkingDay", CenterRegDTO.getvWorkingDay());
//		request.setAttribute("vServiceCode", CenterRegDTO.getvServiceCode());
//		request.setAttribute("vRegAmnt", CenterRegDTO.getvRegAmnt());
//		request.setAttribute("vUploadFilePath", CenterRegDTO.getvUploadFilePath());
//		request.setAttribute("vInfo", CenterRegDTO.getvInfo());
		
		
		
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