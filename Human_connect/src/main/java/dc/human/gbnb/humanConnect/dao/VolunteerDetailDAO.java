
<<<<<<< HEAD
//package dc.human.gbnb.humanConnect.dao;
//
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.sql.DataSource;
//
//import dc.human.gbnb.humanConnect.dto.volunteerDetailDTO;
//import dc.human.gbnb.humanConnect.dto.VolunteerDetailDTO;
//
//public class VolunteerDetailDAO {
//   
////   private static final String driver = "oracle.jdbc.driver.OracleDriver";
//
//      
//   private PreparedStatement pstmt;
//   private Connection con;
//   private DataSource dataFactory;
//   
//   public void addCenterReg(VolunteerDetailDTO volunteerDetailDTO) {

=======
>>>>>>> refs/remotes/origin/master
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
<<<<<<< HEAD
}
   
//   public void delMember(String id) {

//      try {
//    	  Class.forName("oracle.jdbc.OracleDriver");
//    	  con=DriverManager.getConnection(
//	               "jdbc:oracle:thin:@192.168.0.38/xe",
//	               "c##gbnb",
//	               "gbnb"
//	               );
//
//         String vTitle = volunteerDetailDTO.getvTitle();
//         String vStartDate = volunteerDetailDTO.getvStartDate();
//         String vEndDate = volunteerDetailDTO.getvEndDate();
//         String vStartTime = volunteerDetailDTO.getvStartTime();
//         String vLastTime = volunteerDetailDTO.getvLastTime();
//         String vRStartDate = volunteerDetailDTO.getvRStartDate();
//         String vREndDate = volunteerDetailDTO.getvREndDate();
//         String vWorkingDay = volunteerDetailDTO.getvWorkingDay();
//         int vServiceCode = volunteerDetailDTO.getvServiceCode();         
//         int vRegAmnt = volunteerDetailDTO.getvRegAmnt();
//         String vUploadFilePath = volunteerDetailDTO.getvUploadFilePath();
//         String vInfo = volunteerDetailDTO.getvInfo();
//         
//         
//         
//         String query = "insert into volunteer";
//         query += " (V_TITLE, V_START_DATE, V_END_DATE, V_START_TIME, V_LAST_TIME, V_RSTART_DATE, V_REND_DATE, V_WORKING_DAY, SERVICE_CODE, V_MAX_AMNT, V_REG_AMNT, V_STATE, V_UPLOAD_FILE_PATH, V_INFO)";
//         query += " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//         System.out.println("prepareStatement: "+query);
//         pstmt = con.prepareStatement(query);
//         pstmt.setString(1, vTitle);
//         pstmt.setString(2, vStartDate);
//         pstmt.setString(3, vEndDate);
//         pstmt.setString(4, vStartTime);
//         pstmt.setString(5, vLastTime);
//         pstmt.setString(6, vRStartDate);
//         pstmt.setString(7, vREndDate);
//         pstmt.setString(8, vWorkingDay);
//         pstmt.setInt(9, vServiceCode);
//         pstmt.setInt(10, 0);
//         pstmt.setInt(11, vRegAmnt);
//         pstmt.setInt(12, 1);
//         pstmt.setString(13, vUploadFilePath);
//         pstmt.setString(14, vInfo);
//         
//         pstmt.executeUpdate();
//         pstmt.close();
//      }catch(Exception e) {
//         e.printStackTrace();
//      }
//   }
//
//   
////   public void delMember(String id) {
////      try {
////         con = dataFactory.getConnection();
////         String query = "delete from t_member"+" where id=?";
////         System.out.println("prepareStatement: "+query);
////         pstmt = con.prepareStatement(query);
////         pstmt.setString(1, id);
////         pstmt.executeUpdate();
////         pstmt.close();
////         
////      }catch(Exception e) {
////         e.printStackTrace();
////      }
////   }
////   
////   public CenterRegDAO() {
////      try {
////         Context ctx = new InitialContext();
////         Context envContext = (Context) ctx.lookup("java:/comp/env");
////         dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
////      }catch(Exception e) {
////         e.printStackTrace();
////      }
////   }
////   
//   public void listCenterReg(VolunteerDetailDTO volunteerDetailDTO) {
//      List list = new ArrayList();
//      try {

////         connDB();
//    	  Class.forName("oracle.jdbc.OracleDriver");
//    	  con=DriverManager.getConnection(
//	               "jdbc:oracle:thin:@192.168.0.38/xe",
//	               "c##gbnb",
//	               "gbnb"
//	               );
//    	 String vTitle = volunteerDetailDTO.getvTitle();
//    	 
//    	 System.out.println(vTitle);
//    	 
//    	 
//         String query = "select V_TITLE, V_START_DATE, V_END_DATE, V_START_TIME, V_LAST_TIME, V_RSTART_DATE, V_REND_DATE, V_WORKING_DAY, SERVICE_CODE, V_MAX_AMNT, V_REG_AMNT, V_UPLOAD_FILE_PATH, V_INFO from volunteer where V_TITLE = ? ";
//         System.out.println("prepareStatement: "+query);

//         Context ctx = new InitialContext();
//         Context envContext = (Context) ctx.lookup("java:/comp/env");
//         dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
//      }catch(Exception e) {
//         e.printStackTrace();
//      }
//   }
//   
//   public void listCenterReg(VolunteerDetailDTO volunteerDetailDTO) {
//      List list = new ArrayList();
//      try {
////         connDB();
//    	  Class.forName("oracle.jdbc.OracleDriver");
//    	  con=DriverManager.getConnection(
//	               "jdbc:oracle:thin:@192.168.0.38/xe",
//	               "c##gbnb",
//	               "gbnb"
//	               );
//    	 String vTitle = volunteerDetailDTO.getvTitle();
//    	 
//    	 System.out.println(vTitle);
//    	 
//    	 
//         String query = "select V_TITLE, V_START_DATE, V_END_DATE, V_START_TIME, V_LAST_TIME, V_RSTART_DATE, V_REND_DATE, V_WORKING_DAY, SERVICE_CODE, V_MAX_AMNT, V_REG_AMNT, V_UPLOAD_FILE_PATH, V_INFO from volunteer where V_TITLE = ? ";
//         System.out.println("prepareStatement: "+query);
//         pstmt = con.prepareStatement(query);
//         pstmt.setString(1, vTitle);
//         
//         
//         ResultSet rs = pstmt.executeQuery();
//         rs.next();
//            String V_TITLE = rs.getString("V_TITLE");
//            String V_START_DATE = rs.getString("V_START_DATE");
//            String V_END_DATE = rs.getString("V_END_DATE");
//            String V_START_TIME = rs.getString("V_START_TIME");
//            String V_LAST_TIME = rs.getString("V_LAST_TIME");
//            String V_RSTART_DATE = rs.getString("V_RSTART_DATE");
//            String V_REND_DATE = rs.getString("V_REND_DATE");
//            String V_WORKING_DAY = rs.getString("V_WORKING_DAY");
//            int SERVICE_CODE = rs.getInt("SERVICE_CODE");
//            int V_MAX_AMNT = rs.getInt("V_MAX_AMNT");
//            int V_REG_AMNT = rs.getInt("V_REG_AMNT");
//            String V_UPLOAD_FILE_PATH = rs.getString("V_UPLOAD_FILE_PATH");
//            String V_INFO = rs.getString("V_INFO");
//            
//            
//            
//            System.out.println(V_START_DATE);
//            
//
//            volunteerDetailDTO.setvTitle(V_TITLE);
//            volunteerDetailDTO.setvStartDate(V_START_DATE);
//            volunteerDetailDTO.setvEndDate(V_END_DATE);
//            volunteerDetailDTO.setvStartTime(V_START_TIME);
//            volunteerDetailDTO.setvLastTime(V_LAST_TIME);            
//            volunteerDetailDTO.setvRStartDate(V_RSTART_DATE);
//            volunteerDetailDTO.setvREndDate(V_REND_DATE);
//            volunteerDetailDTO.setvWorkingDay(V_WORKING_DAY);
//            volunteerDetailDTO.setvServiceCode(SERVICE_CODE);            
//            volunteerDetailDTO.setvMaxAmnt(V_MAX_AMNT);
//            volunteerDetailDTO.setvRegAmnt(V_REG_AMNT);
//            volunteerDetailDTO.setvUploadFilePath(V_UPLOAD_FILE_PATH);
//            volunteerDetailDTO.setvInfo(V_INFO);
//            
//            System.out.println(volunteerDetailDTO.getvEndDate());
//            
//        
//         rs.close();
//         pstmt.close();
//         con.close();
//         } catch (Exception e) {
//            e.printStackTrace();
//         }
// 
//   }
//   
//   public boolean isExisted(volunteerDetailDTO volunteerDetailDTO) {
//      boolean result = false;
//      String id = volunteerDetailDTO.getId();
//      String pwd = volunteerDetailDTO.getPwd();
//      try {
//         con = dataFactory.getConnection();
//         String query ="select decode(count(*),1,'true','false') as result from t_member";
//         query += " where id=? and pwd=?";
//         System.out.println(query);

//         pstmt = con.prepareStatement(query);
//         pstmt.setString(1, vTitle);
//         
//         
//         ResultSet rs = pstmt.executeQuery();
//         rs.next();
//            String V_TITLE = rs.getString("V_TITLE");
//            String V_START_DATE = rs.getString("V_START_DATE");
//            String V_END_DATE = rs.getString("V_END_DATE");
//            String V_START_TIME = rs.getString("V_START_TIME");
//            String V_LAST_TIME = rs.getString("V_LAST_TIME");
//            String V_RSTART_DATE = rs.getString("V_RSTART_DATE");
//            String V_REND_DATE = rs.getString("V_REND_DATE");
//            String V_WORKING_DAY = rs.getString("V_WORKING_DAY");
//            int SERVICE_CODE = rs.getInt("SERVICE_CODE");
//            int V_MAX_AMNT = rs.getInt("V_MAX_AMNT");
//            int V_REG_AMNT = rs.getInt("V_REG_AMNT");
//            String V_UPLOAD_FILE_PATH = rs.getString("V_UPLOAD_FILE_PATH");
//            String V_INFO = rs.getString("V_INFO");
//            
//            
//            
//            System.out.println(V_START_DATE);
//            
//
//            volunteerDetailDTO.setvTitle(V_TITLE);
//            volunteerDetailDTO.setvStartDate(V_START_DATE);
//            volunteerDetailDTO.setvEndDate(V_END_DATE);
//            volunteerDetailDTO.setvStartTime(V_START_TIME);
//            volunteerDetailDTO.setvLastTime(V_LAST_TIME);            
//            volunteerDetailDTO.setvRStartDate(V_RSTART_DATE);
//            volunteerDetailDTO.setvREndDate(V_REND_DATE);
//            volunteerDetailDTO.setvWorkingDay(V_WORKING_DAY);
//            volunteerDetailDTO.setvServiceCode(SERVICE_CODE);            
//            volunteerDetailDTO.setvMaxAmnt(V_MAX_AMNT);
//            volunteerDetailDTO.setvRegAmnt(V_REG_AMNT);
//            volunteerDetailDTO.setvUploadFilePath(V_UPLOAD_FILE_PATH);
//            volunteerDetailDTO.setvInfo(V_INFO);
//            
//            System.out.println(volunteerDetailDTO.getvEndDate());
//            
//        
//         rs.close();
//         pstmt.close();
//         con.close();
//         } catch (Exception e) {
//            e.printStackTrace();
//         }
// 
//   }
////   
////   public boolean isExisted(volunteerDetailDTO volunteerDetailDTO) {
////      boolean result = false;
////      String id = volunteerDetailDTO.getId();
////      String pwd = volunteerDetailDTO.getPwd();
////      try {
////         con = dataFactory.getConnection();
////         String query ="select decode(count(*),1,'true','false') as result from t_member";
////         query += " where id=? and pwd=?";
////         System.out.println(query);
////         pstmt = con.prepareStatement(query);
////         pstmt.setString(1, id);
////         pstmt.setString(2, pwd);
////         ResultSet rs = pstmt.executeQuery();
////         rs.next();
////         result = Boolean.parseBoolean(rs.getString("result"));
////         System.out.println("result="+result);
////
////               
////      }catch (Exception e) {
////         e.printStackTrace();
////      }
////      return result;
////   }
//   
////   private void connDB() {
////      try {
////         Class.forName(driver);
////         System.out.println("Oracle 드라이버 로딩 성공");
////         con = DriverManager.getConnection(url, user, pwd);
////         System.out.println("Connection 생성 성공");
////      } catch (Exception e) {
////         e.printStackTrace();
////      }
////   }
//   }
=======
}
>>>>>>> refs/remotes/origin/master
