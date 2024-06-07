package dc.human.gbnb.humanConnect.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dc.human.gbnb.humConnect.common.DBConnection;
import dc.human.gbnb.humanConnect.dto.CenterMainDTO;

public class CenterMainDAO {    

    private static final String DB_URL = "jdbc:oracle:thin:@192.168.0.38/xe";
    private static final String DB_USER = "c##gbnb";
    private static final String DB_PASSWORD = "gbnb";

  
    public List<CenterMainDTO> getRecruitmentList(String centerId) {
        List<CenterMainDTO> list = new ArrayList<>();
        String query = "SELECT u.u_id, u.u_name, u.u_phone, a.reg_result, a.reject_rs "
                + "FROM volunteer_user U, acception_res A, volunteer_reg R, volunteer V, center_mng_table C "
                + "WHERE v.v_no = r.v_no AND c.c_id = v.c_id AND r.u_id = u.u_id AND u.u_id = a.u_id AND c.c_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, centerId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                CenterMainDTO dto = new CenterMainDTO();
                dto.setUserId(rs.getString("u_id"));
                dto.setName(rs.getString("u_name"));
                dto.setPhone(rs.getString("u_phone"));
                dto.setStatus(rs.getString("reg_result"));
                dto.setRejectReason(rs.getString("reject_rs"));
                list.add(dto);
            }
            System.out.println("Recruitment List: " + list);  // Debugging statement
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<CenterMainDTO> getVolunteerList(String centerId) {
        List<CenterMainDTO> list = new ArrayList<>();
        String query = "SELECT U.U_ID, U.U_NAME, U.U_PHONE, A.REG_RESULT, A.REJECT_RS "
        		+ "FROM volunteer_user U, volunteer_reg R,ACCEPTION_RES A "
        		+ "WHERE R.u_id = U.u_id AND R.v_type = 1 AND U.U_ID = A.U_ID AND R.C_ID = ?";
        System.out.println(centerId);
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, centerId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                CenterMainDTO dto = new CenterMainDTO();
                dto.setUserId(rs.getString("u_id"));
                dto.setName(rs.getString("u_name"));
                dto.setPhone(rs.getString("u_phone"));
                dto.setStatus(rs.getString("reg_result"));
                dto.setRejectReason(rs.getString("reject_rs"));
                list.add(dto);
            }
            System.out.println("Volunteer List: " + list); 
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<CenterMainDTO> getAdoptionList(String centerId) {
        List<CenterMainDTO> list = new ArrayList<>();
        String query = "SELECT U.U_ID, U.U_NAME, U.U_PHONE "
        		+ "FROM volunteer_user U "
        		+ "JOIN adopt_reg A ON A.u_id = U.u_id "
        		+ "JOIN center_mng_table C ON A.c_name = C.c_name "
        		+ "WHERE C.c_name = (SELECT c_name FROM center_mng_table WHERE c_id = ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, centerId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                CenterMainDTO dto = new CenterMainDTO();
                dto.setUserId(rs.getString("u_id"));
                dto.setName(rs.getString("u_name"));
                dto.setPhone(rs.getString("u_phone"));
                list.add(dto);
            }
            System.out.println("Adoption List: " + list); 
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void updateStatus(String userId, int status, String rejectReason) {
        String query = "UPDATE ACCEPTION_RES SET REG_RESULT = ?, REJECT_RS = ?, UPDATED_DATE = sysdate, UPDATED_ID = ? WHERE U_ID = ?";

        try (Connection con = DBConnection.getConnection();
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

    public String getLatestRecruitmentTitle(String centerId) {
        String title = "";
        String query = "SELECT V_TITLE FROM VOLUNTEER WHERE C_ID = ? ORDER BY created_date DESC FETCH FIRST 1 ROWS ONLY";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            
            pstmt.setString(1, centerId); 
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                title = rs.getString("V_TITLE");
            }
            rs.close();
            
            System.out.println("Latest Recruitment Title: " + title);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return title;
    }
}