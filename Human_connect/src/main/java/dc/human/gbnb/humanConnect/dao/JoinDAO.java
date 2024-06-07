package dc.human.gbnb.humanConnect.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import dc.human.gbnb.humanConnect.dto.JoinDTO;

public class JoinDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public JoinDAO(){
		 try {
		        Class.forName("oracle.jdbc.driver.OracleDriver");

		        conn = DriverManager.getConnection(
		                "jdbc:oracle:thin:@192.168.0.38:1521/xe",
		                "c##gbnb",
		                "gbnb"
		        );

		        conn.setAutoCommit(false);
		        
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		   }

    // 유저 ID 중복 여부를 확인하는 메서드
//    public boolean isU_IdDuplicate(String U_Id) {
//        String sql = "SELECT U_ID FROM volunteer_user WHERE U_ID = ?";
//        
//        try (Connection conn = getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            
//            pstmt.setString(1, U_Id);
//            try (ResultSet rs = pstmt.executeQuery()) {
//                return rs.next();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
	public void insertUser(JoinDTO join) {
        try {
        	String u_Name = join.getU_Name();
        	String u_Sex = join.getU_Sex();
        	String u_Bdate = join.getU_Bdate();
        	String u_Id = join.getU_Id();
			String u_Pwd = join.getU_Pwd();
			String u_Addr1 = join.getU_Addr1();
			String u_Phone = join.getU_Phone();
			String u_Email = join.getU_Email();
        	String sql = "INSERT INTO volunteer_user (U_ID, U_NAME, U_SEX, U_BDATE, U_PWD, U_ADDR1, U_EMAIL, U_PHONE ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            pstmt = conn.prepareStatement(sql); 
            
            pstmt.setString(1, join.getU_Id());
            pstmt.setString(2, join.getU_Name());
            pstmt.setString(3, join.getU_Sex());
            pstmt.setString(4, join.getU_Bdate());
            pstmt.setString(5, join.getU_Pwd());
            pstmt.setString(6, join.getU_Addr1());
            pstmt.setString(7, join.getU_Email());
            pstmt.setString(8, join.getU_Phone());
            pstmt.executeUpdate();
            
            conn.commit();
            System.out.println("추가됨");

        } catch (Exception e) {
        	try {
        		if(conn != null) {
        			conn.rollback();
        		}
        	} catch (SQLException se) {
            se.printStackTrace();
        	}
        	e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
//    public boolean isIdDuplicated(String userId) {
//        String SQL = "SELECT U_ID FROM volunteer_user WHERE U_ID = ?";
//        try {
//            pstmt = conn.prepareStatement(SQL);
//            pstmt.setString(1, userId);
//            rs = pstmt.executeQuery();
//            if (rs.next()) {
//                return true;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
}
}