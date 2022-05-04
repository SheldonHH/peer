package com.example.demo;

import com.example.demo.p4p.util.P4PParameters;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class DemoApplication {
	private final static String url = "jdbc:postgresql://localhost:5432/peer1";
	private final static String user = "peer1";
	private final static String password = "password";
	public static Connection connect() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	public static void main(String[] args) {
		truncateVPersonandPersonRC();
		P4PParameters.initialize(512,true);
		SpringApplication.run(DemoApplication.class, args);
	}

	public static void truncateVPersonandPersonRC(){
		String SQL = "TRUNCATE TABLE V_PERSON_DATA; TRUNCATE TABLE person_rc; Truncate Table hashlist;";
		try (Connection conn = connect();
			 PreparedStatement pstmt = conn.prepareStatement(SQL,
					 Statement.RETURN_GENERATED_KEYS)) {
			int affectedRows = pstmt.executeUpdate();
			if (affectedRows > 0) {
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					System.out.println(rs);
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}


}
