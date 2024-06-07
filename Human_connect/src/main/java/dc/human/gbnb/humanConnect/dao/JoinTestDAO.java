package dc.human.gbnb.humanConnect.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dc.human.gbnb.humConnect.common.DBConnection;
import dc.human.gbnb.humanConnect.dto.JoinTestDTO;

public class JoinTestDAO {

    public void insertUserInfo(JoinTestDTO jdto) {
        String sql = "INSERT INTO VOLUNTEER_USER(U_ID,U_NAME,U_PWD,U_EMAIL) VALUES(?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, jdto.getU_id());
            pstmt.setString(2, jdto.getU_name());
            pstmt.setString(3, jdto.getU_pwd());
            pstmt.setString(4, jdto.getU_email());

            int row = pstmt.executeUpdate();
            System.out.println("변경된 행의 수: " + row);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}