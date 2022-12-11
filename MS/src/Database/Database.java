package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
//	static final String DB_URL = "jdbc:mysql://www.papademas.net:3307/510fp?autoReconnect=true&useSSL=false";
//	static final String USER = "fp510", PASS = "510";
	static final String DB_URL = "jdbc:postgresql://localhost/library_management";
	static final String USER = "postgres", PASS = "Kv_83769250";
	
	public static Connection connectDB() {
		try {
//			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("db connected");
			Connection connect = DriverManager.getConnection(DB_URL, USER, PASS);
			return connect;
			
		}catch(Exception e) {
			e.printStackTrace();
			return  null;
		}
	}
}