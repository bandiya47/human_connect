package dc.human.gbnb.humanConnect.servlet;

import java.io.IOException;

import dc.human.gbnb.humanConnect.dao.JoinDAO;
import dc.human.gbnb.humanConnect.dto.JoinDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String u_Id = request.getParameter("u_Id");

//        JoinDAO joinDAO = new JoinDAO();
//        boolean isDuplicate = JoinDAO.isU_IdDuplicate(u_Id);

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String action = request.getParameter("joinDAO");
        
//        if ("join".equals(action)) {
        String u_Name = request.getParameter("u_Name");	
        String u_Sex = request.getParameter("u_Sex");
        String u_Bdate = request.getParameter("u_Bdate");
        String u_Id = request.getParameter("u_Id");
        String u_Pwd = request.getParameter("u_Pwd");
        String u_Addr1 = request.getParameter("u_Addr1");
        String u_Phone = request.getParameter("u_Phone");
        String u_Email = request.getParameter("u_Email");
        
        JoinDTO jdto=new JoinDTO();
        jdto.setU_Name(u_Name);
        jdto.setU_Sex(u_Sex);
        jdto.setU_Bdate(u_Bdate);
        jdto.setU_Id(u_Id);
        jdto.setU_Pwd(u_Pwd);
        jdto.setU_Addr1(u_Addr1);
        jdto.setU_Phone(u_Phone);
        jdto.setU_Email(u_Email);
		
		JoinDAO joinDAO = new JoinDAO();
		joinDAO.insertUser(jdto);
		
		response.sendRedirect("index.jsp");
    	}
//    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}