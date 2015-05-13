package org.jones.webdev.action;

import java.sql.*;
import java.util.Properties;
import java.util.List;
import java.util.ArrayList;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.jones.webdev.Environment;

import com.opensymphony.xwork2.ActionSupport;

public class ViewTableAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String USER = "root";
	private final String PASS = "5407758sub";
	private final int port = 3306;
	private final String serverName = "localhost";
	private final String dbName = "jiveapp";
	private final String tableName = "environment";
	private List<Environment> environments = new ArrayList<Environment>();
	
	public List<Environment> getEnvironments() {
		return environments;
	}

	public void setEnvironments(List<Environment> environments) {
		this.environments = environments;
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
	@SkipValidation
	public String execute() {
		Connection conn = null;
		Statement stmt = null;
		String query = 
				"select os, os_version, notes, env_id " +
				"from " + dbName + "."+ tableName;
	
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
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				environments.add(new Environment(rs.getString("os"),rs.getString("os_version"), rs.getString("notes"), rs.getInt("env_id")));
			}		
		} catch (SQLException e ) {
			System.out.println("Error: Could not retrieve data");
			e.printStackTrace();
			return "failure";
		} 
		
		return "success"; 
	}
}
