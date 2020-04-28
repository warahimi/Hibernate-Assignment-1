package com.JDBCconnectTest;
import java.sql.Connection;
import java.sql.DriverManager;

public class JDCBCconnectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String databaseURL = "jdbc:mysql://localhost:3306/hibernateassignments?allowPublicKeyRetrieval=true&useSSL=false";
		String userName = "hbstudent";
		String password = "hbstudent";
		
		try {
			System.out.println("Connectin to database through JDBC.....");
			Connection con = DriverManager.getConnection(databaseURL, userName, password);
			System.out.println("\nSucessfully connected.........");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
