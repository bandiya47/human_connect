package dc.human.gbnb.humanConnect.servlet;

import java.io.IOException;
import dc.human.gbnb.humanConnect.dao.JoinTestDAO;
import dc.human.gbnb.humanConnect.dto.JoinTestDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/joinTest")
public class JoinTestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 클라이언트가 GET 요청을 보낼 때 JoinTest.jsp로 포워드합니다.
        request.getRequestDispatcher("joinTest.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String u_id = request.getParameter("uId");
        String u_name = request.getParameter("uName");
        String u_pwd = request.getParameter("uPwd");
        String u_email = request.getParameter("uEmail");

        JoinTestDTO jdto = new JoinTestDTO();
        jdto.setU_id(u_id);
        jdto.setU_name(u_name);
        jdto.setU_pwd(u_pwd);
        jdto.setU_email(u_email);

        JoinTestDAO dao = new JoinTestDAO();
        dao.insertUserInfo(jdto);


        response.sendRedirect("login");
    }
}