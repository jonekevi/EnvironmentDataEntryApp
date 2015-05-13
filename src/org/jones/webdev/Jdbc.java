package org.jones.webdev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.jones.webdev.action.*;
public class Jdbc {
	/*
	 * Please enter MySQL User, Pass, and Port below
	 */
	private String USER = "kevin";
	private String PASS = "pass";
	private int port = 3306;
	
	private final String serverName = "localhost";
	private final String dbName = "jiveapp";
	
	public Connection getConn(){
		Connection conn = null;
		Properties connProp = new Properties();
		connProp.put("user", this.USER);
		connProp.put("password", this.PASS);
		System.out.println("Connecting...");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://"+this.serverName+":" +this.port + "/" + this.dbName,connProp);
			System.out.println("Connected to database");
		} catch(SQLException e){
			System.out.println("Error: Could not connect to database");
			e.printStackTrace();
			return null;
		} catch(Exception e){
			System.out.println("Class.forName failed");
		}
		return conn;
	}
	
	
}
