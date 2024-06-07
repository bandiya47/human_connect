package dc.human.gbnb.humanConnect.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dc.human.gbnb.humanConnect.dto.VolunteerRegListDTO;

public class VolunteerRegListDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public VolunteerRegListDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con =DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.42:1521/xe", "c##tableJava", "tableJava");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	public List<VolunteerRegListDTO> getRegList() {
		List<VolunteerRegListDTO> regList = new ArrayList<>();
		try {
			String query = "SELECT V_TITLE,SERVICE_CODE,V_START_DATE,V_END_DATE,V_WORKING_DAY from volunteer ";

			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				VolunteerRegListDTO dto = new VolunteerRegListDTO();
				dto.setvTitle(rs.getString("vTitle"));
				switch(rs.getString("serviceCode")) {
					case "1" : dto.setServiceCode("청소/배식");
									break;
					case "2" : dto.setServiceCode("산책");
									break;
					case "3" : dto.setServiceCode("목욕");
									break;
					case "4" : dto.setServiceCode("사진");
									break;
					case "5" : dto.setServiceCode("미용");
									break;
					case "6" : dto.setServiceCode("이동");
									break;
					case "7" : dto.setServiceCode("의료");
									break;
				}
				dto.setvStartDate(rs.getString("vStartDate"));
				dto.setvEndDate(rs.getString("vEndDate"));
				dto.setvWorkingDay(rs.getString("vWorkingDay"));

				regList.add(dto);

			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return regList;
	}

}
