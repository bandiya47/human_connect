package dc.human.gbnb.humanConnect.servlet;

import java.io.IOException;
import java.util.List;

import dc.human.gbnb.humanConnect.dao.MainRequestTestDAO;
import dc.human.gbnb.humanConnect.dao.UserDAO;
import dc.human.gbnb.humanConnect.dto.TestDTO;
import dc.human.gbnb.humanConnect.dto.UserDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        
        UserDAO dao = new UserDAO();
        String userTable = dao.validateUser(userId, password);
        
        if (userTable != null) {
            HttpSession session = request.getSession();
            UserDTO user = dao.getUserDetails(userId, userTable);
            session.setAttribute("user", user);
            if ("volunteer_user".equals(userTable)) {
                MainRequestTestDAO rdao = new MainRequestTestDAO();            
                List<TestDTO> volList = rdao.getVolList();      
                request.setAttribute("volList", volList);
                RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
                dispatcher.forward(request, response);
                
            } else if ("center_mng_table".equals(userTable)) {
                response.sendRedirect("centerMain");
            }
        } else {
            response.sendRedirect("login.jsp?error=1");
        }
    }
}