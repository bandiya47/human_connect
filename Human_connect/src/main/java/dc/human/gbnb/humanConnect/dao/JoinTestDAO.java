package dc.human.gbnb.humanConnect.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import dc.human.gbnb.humanConnect.dto.JoinTestDTO;
public class JoinTestDAO {

	 private Connection conn;

	 public JoinTestDAO(JoinTestDTO joinTestDTO) {
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
	 
	 public void JoinTestDAO(JoinTestDTO jdto) {
		 try {
			 String uId = jdto.getU_id();
			 String uName = jdto.getU_name();
			 String uPwd = jdto.getU_pwd();
			 String uEmail = jdto.getU_email();
			 String sql = "INSERT INTO VOLUNTEER_USER(U_ID,U_NAME,U_PWD,U_EMAIL) VALUES(?,?,?,?)";
			 PreparedStatement pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1,uId);
			 pstmt.setString(2, uName);
			 pstmt.setString(3, uPwd);
			 pstmt.setString(4, uEmail);
			 
			 int row = pstmt.executeUpdate();
	            System.out.println("변경된 행의 수: " + row);

		 } catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 
	 }
	
	
	
	
	
}
