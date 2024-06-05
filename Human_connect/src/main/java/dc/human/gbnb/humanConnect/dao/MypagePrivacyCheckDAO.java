package dc.human.gbnb.humanConnect.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dc.human.gbnb.humanConnect.dto.MypagePrivacyCheckDTO;
import dc.human.gbnb.humanConnect.dto.MypagePrivacyEditDTO;
public class MypagePrivacyCheckDAO {
	private Connection conn;

		public MypagePrivacyCheckDAO() {
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

	public MypagePrivacyCheckDTO getUserDetails(String userId) {
		MypagePrivacyCheckDTO user = null;
		try {
			String sql = "SELECT U_NAME, U_ID, U_PWD, U_EMAIL, U_PHONE, U_ADDR FROM VOLUNTEER_USER WHERE U_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			ResultSet rs = pstmt.executeQuery();
			System.out.println(sql);
			if (rs.next()) {
				user = new MypagePrivacyCheckDTO();
				user.setName(rs.getString("U_NAME"));
				user.setId(rs.getString("U_ID"));
				user.setPw(rs.getString("U_PWD"));
				user.setEmail(rs.getString("U_EMAIL"));
				user.setPhone(rs.getString("U_PHONE"));
				user.setAddr(rs.getString("U_ADDR"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public static void main(String[] args) {
	}
}