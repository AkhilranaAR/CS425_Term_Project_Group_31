package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

// Code database URL
//	static final String DB_URL = "jdbc:mysql://www.papademas.net:3307/510labs?autoReconnect=true&useSSL=false";
// Database credentials
//	static final String USER = "fp510", PASS = "510";
	
	static final String DB_URL = "jdbc:postgresql://localhost/library_management";
	static final String USER = "potgres", PASS = "Kv_83769250";

	public Connection connect() throws SQLException {
		System.out.println("Connecting...");
		return DriverManager.getConnection(DB_URL, USER, PASS);

	}
}