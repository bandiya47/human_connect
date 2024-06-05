
package dc.human.gbnb.humanConnect.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


import dc.human.gbnb.humanConnect.dto.VolunteerDetailDTO;

public class VolunteerDetailDAO {
   

//
  
   private PreparedStatement pstmt;
   private Connection con;
   private DataSource dataFactory;
   
   public void addVolunteerDetail(VolunteerDetailDTO volunteerDetailDTO) {
      try {
    	  Class.forName("oracle.jdbc.OracleDriver");
    	  con=DriverManager.getConnection(
	               "jdbc:oracle:thin:@192.168.0.38/xe",
	               "c##gbnb",
	               "gbnb"
	               );


         String vStartDate = volunteerDetailDTO.getvStartDate();
         String vEndDate = volunteerDetailDTO.getvEndDate();
         String vStartTime = volunteerDetailDTO.getvStartTime();
         String vLastTime = volunteerDetailDTO.getvLastTime();     
         int vreg_amnt = volunteerDetailDTO.getVreg_amnt();
         String getVreg_upload_file_path = volunteerDetailDTO.getVreg_upload_file_path();
         String vreg_info = volunteerDetailDTO.getVreg_info();
         
         
         
         String query = "insert into volunteer_reg";
         query += " (VREG_START_TIME, VREG_END_TIME, VREG_START_DATE, VREG_END_DATE, VREG_AMNT, VREG_UPLOAD_FILE_PATH, VREG_INFO)";
         query += " values(?,?,?,?,?,?,?)";
         System.out.println("prepareStatement: "+query);
         pstmt = con.prepareStatement(query);
         pstmt.setString(1, vStartTime);
         pstmt.setString(2, vLastTime);
         pstmt.setString(3, vStartDate);
         pstmt.setString(4, vEndDate);
         pstmt.setInt(5, vreg_amnt);
         pstmt.setString(6, getVreg_upload_file_path);
         pstmt.setString(7, vreg_info);

         pstmt.executeUpdate();
         pstmt.close();
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
}