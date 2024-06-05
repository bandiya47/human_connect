package dc.human.gbnb.humanConnect.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dc.human.gbnb.humanConnect.dto.UserDTO;

public class UserDAO {
    private Connection conn;

    public UserDAO() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@192.168.0.38/xe",
                "c##gbnb",
                "gbnb"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String validateUser(String userId, String password) {
        String volunteerQuery = "SELECT * FROM volunteer_user WHERE U_ID = ? AND U_PWD = ?";
        String centerQuery = "SELECT * FROM center_mng_table WHERE C_ID = ? AND C_PWD = ?";
        
        try (PreparedStatement volunteerPstmt = conn.prepareStatement(volunteerQuery)) {
            volunteerPstmt.setString(1, userId);
            volunteerPstmt.setString(2, password);
            ResultSet rs = volunteerPstmt.executeQuery();
            
            if (rs.next()) {
                return "volunteer_user";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try (PreparedStatement centerPstmt = conn.prepareStatement(centerQuery)) {
            centerPstmt.setString(1, userId);
            centerPstmt.setString(2, password);
            ResultSet rs = centerPstmt.executeQuery();
            
            if (rs.next()) {
                return "center_mng_table";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }

    public UserDTO getUserDetails(String userId, String tableName) {
        String query = "";
        if ("volunteer_user".equals(tableName)) {
            query = "SELECT * FROM volunteer_user WHERE U_ID = ?";
        } else if ("center_mng_table".equals(tableName)) {
            query = "SELECT * FROM center_mng_table WHERE C_ID = ?";
        }
        
        UserDTO user = null;
        
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                user = new UserDTO();
                user.setUserId(rs.getString("U_ID"));
                user.setName(rs.getString("U_NAME"));
                user.setPassword(rs.getString("U_PWD"));
                user.setAddr(rs.getString("U_ADDR1"));
                user.setEmail(rs.getString("U_EMAIL"));
                user.setPhone(rs.getString("U_PHONE"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return user;
    }
}