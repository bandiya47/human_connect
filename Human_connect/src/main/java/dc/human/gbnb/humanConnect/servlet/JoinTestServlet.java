package dc.human.gbnb.humanConnect.servlet;

import java.io.IOException;

import dc.human.gbnb.humanConnect.dao.JoinTestDAO;
import dc.human.gbnb.humanConnect.dto.JoinTestDTO;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/JoinTest")
public class JoinTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public JoinTestServlet() {
        // TODO Auto-generated constructor stub
    }


	public void init() throws ServletException {
		// TODO Auto-generated method stub
	}


	public void destroy() {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String u_id = request.getParameter("uId");
		String u_name = request.getParameter("uName");
		String u_pwd = request.getParameter("uPwd");
		String u_email = request.getParameter("uEmail");
		JoinTestDTO jdto = new JoinTestDTO();
		request.setAttribute("uId", u_id);
		request.setAttribute("u_name", u_name);
		request.setAttribute("u_pwd", u_pwd);
		request.setAttribute("u_email", u_email);
		
		
		
		
		
		 response.sendRedirect("JoinTest.jsp");
		
	}

}
