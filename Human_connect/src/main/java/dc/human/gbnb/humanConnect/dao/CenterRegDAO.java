package dc.human.gbnb.humanConnect.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dc.human.gbnb.humanConnect.dto.CenterRegDTO;
import dc.human.gbnb.humanConnect.dto.VolunteerDetailDTO;

public class CenterRegDAO {
   

//
      
   private PreparedStatement pstmt;
   private Connection con;
   private DataSource dataFactory;
   
   public void addCenterReg(CenterRegDTO centerRegDTO) {
      try {
    	  Class.forName("oracle.jdbc.OracleDriver");
    	  con=DriverManager.getConnection(
	               "jdbc:oracle:thin:@192.168.0.38/xe",
	               "c##gbnb",
	               "gbnb"
	               );

         String vTitle = centerRegDTO.getvTitle();
         String vStartDate = centerRegDTO.getvStartDate();
         String vEndDate = centerRegDTO.getvEndDate();
         String vStartTime = centerRegDTO.getvStartTime();
         String vLastTime = centerRegDTO.getvLastTime();
         String vRStartDate = centerRegDTO.getvRStartDate();
         String vREndDate = centerRegDTO.getvREndDate();
         String vWorkingDay = centerRegDTO.getvWorkingDay();
         int vServiceCode = centerRegDTO.getvServiceCode();         
         int vRegAmnt = centerRegDTO.getvRegAmnt();
         String vUploadFilePath = centerRegDTO.getvUploadFilePath();
         String vInfo = centerRegDTO.getvInfo();
         
         
         
         String query = "insert into volunteer";
         query += " (V_TITLE, V_START_DATE, V_END_DATE, V_START_TIME, V_LAST_TIME, V_RSTART_DATE, V_REND_DATE, V_WORKING_DAY, SERVICE_CODE, V_MAX_AMNT, V_REG_AMNT, V_STATE, V_UPLOAD_FILE_PATH, V_INFO)";
         query += " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         System.out.println("prepareStatement: "+query);
         pstmt = con.prepareStatement(query);
         pstmt.setString(1, vTitle);
         pstmt.setString(2, vStartDate);
         pstmt.setString(3, vEndDate);
         pstmt.setString(4, vStartTime);
         pstmt.setString(5, vLastTime);
         pstmt.setString(6, vRStartDate);
         pstmt.setString(7, vREndDate);
         pstmt.setString(8, vWorkingDay);
         pstmt.setInt(9, vServiceCode);
         pstmt.setInt(10, 0);
         pstmt.setInt(11, vRegAmnt);
         pstmt.setInt(12, 1);
         pstmt.setString(13, vUploadFilePath);
         pstmt.setString(14, vInfo);
         
         pstmt.executeUpdate();
         pstmt.close();
      }catch(Exception e) {
         e.printStackTrace();
      }
   }

   
   public void listCenterReg(CenterRegDTO centerRegDTO) {
      List list = new ArrayList();
      try {

    	  Class.forName("oracle.jdbc.OracleDriver");
    	  con=DriverManager.getConnection(
	               "jdbc:oracle:thin:@192.168.0.38/xe",
	               "c##gbnb",
	               "gbnb"
	               );
    	 int v_no = centerRegDTO.getV_no();
    	 
  
    	 
    	 
         String query = "select V_TITLE, V_START_DATE, V_END_DATE, V_START_TIME, V_LAST_TIME, V_RSTART_DATE, V_REND_DATE, V_WORKING_DAY, SERVICE_CODE, V_MAX_AMNT, V_REG_AMNT, V_UPLOAD_FILE_PATH, V_INFO from volunteer where V_No = ? ";
         System.out.println("prepareStatement: "+query);
         pstmt = con.prepareStatement(query);
         pstmt.setInt(1, v_no);
         
         
         ResultSet rs = pstmt.executeQuery();
         rs.next();
            String V_TITLE = rs.getString("V_TITLE");
            String V_START_DATE = rs.getString("V_START_DATE");
            String V_END_DATE = rs.getString("V_END_DATE");
            String V_START_TIME = rs.getString("V_START_TIME");
            String V_LAST_TIME = rs.getString("V_LAST_TIME");
            String V_RSTART_DATE = rs.getString("V_RSTART_DATE");
            String V_REND_DATE = rs.getString("V_REND_DATE");
            String V_WORKING_DAY = rs.getString("V_WORKING_DAY");
            int SERVICE_CODE = rs.getInt("SERVICE_CODE");
            int V_MAX_AMNT = rs.getInt("V_MAX_AMNT");
            int V_REG_AMNT = rs.getInt("V_REG_AMNT");
            String V_UPLOAD_FILE_PATH = rs.getString("V_UPLOAD_FILE_PATH");
            String V_INFO = rs.getString("V_INFO");
            
            
            
            System.out.println(V_START_DATE);
            

            centerRegDTO.setvTitle(V_TITLE);
            centerRegDTO.setvStartDate(V_START_DATE);
            centerRegDTO.setvEndDate(V_END_DATE);
            centerRegDTO.setvStartTime(V_START_TIME);
            centerRegDTO.setvLastTime(V_LAST_TIME);            
            centerRegDTO.setvRStartDate(V_RSTART_DATE);
            centerRegDTO.setvREndDate(V_REND_DATE);
            centerRegDTO.setvWorkingDay(V_WORKING_DAY);
            centerRegDTO.setvServiceCode(SERVICE_CODE);            
            centerRegDTO.setvMaxAmnt(V_MAX_AMNT);
            centerRegDTO.setvRegAmnt(V_REG_AMNT);
            centerRegDTO.setvUploadFilePath(V_UPLOAD_FILE_PATH);
            centerRegDTO.setvInfo(V_INFO);
            
            System.out.println(centerRegDTO.getvEndDate());
            
        
         rs.close();
         pstmt.close();
         con.close();
         } catch (Exception e) {
            e.printStackTrace();
         }
 
   }

   }
