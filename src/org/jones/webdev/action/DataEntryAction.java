package org.jones.webdev.action;
import java.sql.*;
import java.util.Properties;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;


public class DataEntryAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8679439511665909535L;
	private final String USER = "root";
	private final String PASS = "5407758sub";
	private final int port = 3306;
	private final String serverName = "localhost";
	private final String dbName = "jiveapp";
	private final String tableName = "environment";
	
	private String os;
	private String notes;
	private String osVer;
	
	public String getOsVer() {
		return osVer;
	}



	public void setOsVer(String osVer) {
		this.osVer = osVer;
	}


	public String getNotes() {
		return notes;
	}



	public void setNotes(String notes) {
		this.notes = notes;
	}



	
	public String getOs() {
		return os;
	}



	public void setOs(String os) {
		this.os = os;
	}


	public Connection getConn() throws SQLException {
		Connection conn = null;
		Properties connProp = new Properties();
		connProp.put("user", this.USER);
		connProp.put("password", this.PASS);
		System.out.println("Connecting...");
		conn = DriverManager.getConnection("jdbc:mysql://"+this.serverName+":" +this.port + "/" + this.dbName,connProp);
	
		return conn;
	}
	public String skipData() throws Exception{
		System.out.println("Entering SkipData\n");
		return SUCCESS;
	}
	public String submit() throws Exception{
		Connection conn = null;
		Statement stmt = null;
		System.out.println("Entering Submit\n");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = this.getConn();
			System.out.println("Connected to database");
		} catch(SQLException e){
			System.out.println("Error: Could not connect to database");
			e.printStackTrace();
			return "failure";
		} catch(Exception e){
			System.out.println("Class.forName failed");
		}
		
		try{
			String str = 
					"INSERT INTO " + this.tableName + " (os,os_version,notes)"+ " VALUES " + 
					"('" + this.os + "','" + this.osVer + "','" + this.notes + "');";
			System.out.println(str);
			stmt = conn.createStatement();
			stmt.executeUpdate(str);
			if(stmt != null) {stmt.close();}
		} catch(SQLException e){
			System.out.println("Error: Could not update database");
			e.printStackTrace();
			return "failure";
		} 
		
		return SUCCESS;
		
	}
	public String execute(){
		return SUCCESS;
	}
}
