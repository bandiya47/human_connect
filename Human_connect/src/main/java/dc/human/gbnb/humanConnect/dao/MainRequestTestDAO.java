package dc.human.gbnb.humanConnect.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dc.human.gbnb.humanConnect.dto.TestDTO;

public class MainRequestTestDAO {

    private static final String DB_URL = "jdbc:oracle:thin:@192.168.0.38/xe";
    private static final String DB_USER = "c##gbnb";
    private static final String DB_PASSWORD = "gbnb";

    public MainRequestTestDAO() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws Exception {
        System.out.println("Attempting to connect to the database...");
        Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        System.out.println("Connected to the database.");
        return con;
    }

    public List<TestDTO> getVolList() {
        List<TestDTO> list = new ArrayList<>();
        String query = "SELECT V_NO ,V_TITLE FROM VOLUNTEER";

        try (Connection con = getConnection(); 
             PreparedStatement pstmt = con.prepareStatement(query); 
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
            	TestDTO dto = new TestDTO();
				dto.setV_no(rs.getInt("v_no"));
				dto.setV_title(rs.getString("v_title"));
            	
                list.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}