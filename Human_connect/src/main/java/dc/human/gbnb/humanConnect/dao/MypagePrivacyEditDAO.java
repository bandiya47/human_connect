package dc.human.gbnb.humanConnect.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import dc.human.gbnb.humanConnect.dto.UserDTO;
import dc.human.gbnb.humanConnect.dto.MypagePrivacyEditDTO;

public class MypagePrivacyEditDAO {
	private Connection conn;
	public MypagePrivacyEditDAO() {
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			
			conn=DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.0.38/xe",
					"c##gbnb",
					"gbnb"
					);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void privacyEdit(MypagePrivacyEditDTO DTO) {
		String name=DTO.getName();
		String id=DTO.getId();
		String pw=DTO.getPw();
		String email=DTO.getEmail();
		String phone=DTO.getPhone();
		String addr=DTO.getAddr();
		
		try{
			System.out.println(id);
			String sql="UPDATE VOLUNTEER_USER "
					+ "SET U_PWD='"+pw+"', U_EMAIL='"+email+"' , U_PHONE='"+phone+"'"
					+ "WHERE U_ID='"+id+"'";
			
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.executeQuery();
			
			System.out.println("정보 변경됨.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
	}
	
}
