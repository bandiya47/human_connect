
package dc.human.gbnb.humanConnect.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dc.human.gbnb.humanConnect.dto.TestDTO;
import dc.human.gbnb.humanConnect.dto.VolunteerDetailDTO;

public class TestDAO {
   

//
  //
   private PreparedStatement pstmt;
   private Connection conn;
   private DataSource dataFactory;
   
	public List<TestDTO> volunteerList() {
		List<TestDTO> volList = new ArrayList<>();
		
		try {

	    	  Class.forName("oracle.jdbc.OracleDriver");
	    	  conn=DriverManager.getConnection(
		               "jdbc:oracle:thin:@192.168.0.38/xe",
		               "c##gbnb",
		               "gbnb"
		               );

			
			String sql = "SELECT v_no, c_id, v_title, v_start_date, v_end_date, v_start_time, v_last_time, v_rstart_date, v_rend_date, service_code, v_max_amnt, v_reg_amnt, v_state  FROM volunteer";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				TestDTO dto = new TestDTO();
				dto.setV_no(rs.getInt("v_no"));
				dto.setC_id(rs.getString("c_id"));
				dto.setV_start_date(rs.getString("v_start_date"));
				dto.setV_end_date(rs.getString("v_end_date"));
				dto.setV_start_time(rs.getString("v_start_time"));
				dto.setV_last_time(rs.getString("v_last_time"));
				dto.setV_rstart_date(rs.getString("v_rstart_date"));
				dto.setV_rend_date(rs.getString("v_rend_date"));
				dto.setService_code(rs.getInt("service_code"));
				dto.setV_max_amnt(rs.getInt("v_max_amnt"));
				dto.setV_reg_amnt(rs.getInt("v_reg_amnt"));
				dto.setV_state(rs.getInt("v_state"));
				
				
				
				
				volList.add(dto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return volList;
	}
}