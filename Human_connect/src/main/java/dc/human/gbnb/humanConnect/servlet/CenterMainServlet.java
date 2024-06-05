package dc.human.gbnb.humanConnect.servlet;

import java.io.IOException;
import java.util.List;

import dc.human.gbnb.humanConnect.dao.CenterMainDAO;
import dc.human.gbnb.humanConnect.dto.CenterMainDTO;
import dc.human.gbnb.humanConnect.dto.UserDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/centerMain")
public class CenterMainServlet extends HttpServlet {
    private CenterMainDAO dao = new CenterMainDAO();

    public CenterMainServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("user");

        if (user == null || user.getUserId() == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String centerId = user.getUserId(); // 로그인한 사용자의 C_ID

        List<CenterMainDTO> recruitmentList = dao.getRecruitmentList(centerId);
        List<CenterMainDTO> volunteerList = dao.getVolunteerList(centerId);
        List<CenterMainDTO> adoptionList = dao.getAdoptionList(centerId);

        request.setAttribute("recruitmentList", recruitmentList);
        request.setAttribute("volunteerList", volunteerList);
        request.setAttribute("adoptionList", adoptionList);

        String latestRecruitmentTitle = dao.getLatestRecruitmentTitle(centerId);
        request.setAttribute("latestRecruitmentTitle", latestRecruitmentTitle);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/centerMain.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String userId = request.getParameter("userId");

        if (action != null && userId != null) {
            if (action.equals("approve")) {
                dao.updateStatus(userId, 1, null);
            } else if (action.equals("reject")) {
                String rejectReason = request.getParameter("rejectReason");
                dao.updateStatus(userId, 2, rejectReason);
            } else if (action.equals("complete")) {
                dao.updateStatus(userId, 3, null);
            }
        }

        response.sendRedirect("centerMain");
    }
}