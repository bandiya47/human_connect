package dc.human.gbnb.humanConnect.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dc.human.gbnb.humanConnect.dto.CenterMainDTO;

public class CenterMainDAO {    

    private static final String DB_URL = "jdbc:oracle:thin:@192.168.0.38/xe";
    private static final String DB_USER = "c##gbnb";
    private static final String DB_PASSWORD = "gbnb";

    public CenterMainDAO() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws Exception {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public List<CenterMainDTO> getRecruitmentList() {
        List<CenterMainDTO> list = new ArrayList<>();
        String query = "SELECT U.U_ID, U.U_NAME, U.U_PHONE, A.REG_RESULT, A.REJECT_RS FROM volunteer_user U, volunteer_reg R,ACCEPTION_RES A"
                + " WHERE R.u_id = U.u_id AND R.v_no = 0 AND U.U_ID = A.U_ID";

        try (Connection con = getConnection(); 
             PreparedStatement pstmt = con.prepareStatement(query); 
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                CenterMainDTO dto = new CenterMainDTO();
                dto.setUserId(rs.getString("U_ID"));
                dto.setName(rs.getString("U_NAME"));
                dto.setPhone(rs.getString("U_PHONE"));
                dto.setStatus(rs.getString("REG_RESULT"));
                dto.setRejectReason(rs.getString("REJECT_RS"));
                list.add(dto);
            }
            System.out.println("Recruitment List: " + list);  // Debugging statement
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<CenterMainDTO> getVolunteerList() {
        List<CenterMainDTO> list = new ArrayList<>();
        String query = "SELECT U.U_ID, U.U_NAME, U.U_PHONE, A.REG_RESULT, A.REJECT_RS FROM volunteer_user U, volunteer_reg R,ACCEPTION_RES A"
                + " WHERE R.u_id = U.u_id AND R.v_no = 1 AND U.U_ID = A.U_ID";

        try (Connection con = getConnection(); 
             PreparedStatement pstmt = con.prepareStatement(query); 
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                CenterMainDTO dto = new CenterMainDTO();
                dto.setUserId(rs.getString("U_ID"));
                dto.setName(rs.getString("U_NAME"));
                dto.setPhone(rs.getString("U_PHONE"));
                dto.setStatus(rs.getString("REG_RESULT"));
                dto.setRejectReason(rs.getString("REJECT_RS"));
                list.add(dto);
            }
            System.out.println("Volunteer List: " + list);  // Debugging statement
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<CenterMainDTO> getAdoptionList() {
        List<CenterMainDTO> list = new ArrayList<>();
        String query = "SELECT U.U_ID, U.U_NAME, U.U_PHONE FROM volunteer_user U, adopt_reg A"
                + " WHERE A.u_id = U.u_id";

        try (Connection con = getConnection(); 
             PreparedStatement pstmt = con.prepareStatement(query); 
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                CenterMainDTO dto = new CenterMainDTO();
                dto.setUserId(rs.getString("U_ID"));
                dto.setName(rs.getString("U_NAME"));
                dto.setPhone(rs.getString("U_PHONE"));
                list.add(dto);
            }
            System.out.println("Adoption List: " + list);  // Debugging statement
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void updateStatus(String userId, int status, String rejectReason) {
        String query = "UPDATE ACCEPTION_RES SET REG_RESULT = ?, REJECT_RS = ?, UPDATED_DATE = sysdate, UPDATED_ID = ?"
                + " WHERE U_ID = ?";

        try (Connection con = getConnection(); 
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, status);
            pstmt.setString(2, rejectReason);
            pstmt.setString(3, userId);
            pstmt.setString(4, userId);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getLatestRecruitmentTitle() {
        String title = "";
        String query = "SELECT V_TITLE FROM VOLUNTEER ORDER BY created_date DESC FETCH FIRST 1 ROWS ONLY";

        try (Connection con = getConnection(); 
             PreparedStatement pstmt = con.prepareStatement(query); 
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                title = rs.getString("V_TITLE");
            }
            System.out.println("Latest Recruitment Title: " + title);  // Debugging statement
        } catch (Exception e) {
            e.printStackTrace();
        }

        return title;
    }
}