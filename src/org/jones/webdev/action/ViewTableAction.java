package org.jones.webdev.action;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.jones.webdev.Environment;

import com.opensymphony.xwork2.ActionSupport;
import org.jones.webdev.*;
public class ViewTableAction extends ActionSupport{
	
	/*
	 * Retrieves data from MySQL server and displays it using the display tag library for struts2. 
	 * http://www.displaytag.org/1.2/
	 */
	private static final long serialVersionUID = 1L;
	private final String dbName = "jiveapp";
	private final String tableName = "environment";
	private List<Environment> environments = new ArrayList<Environment>();
	
	public List<Environment> getEnvironments() {
		return environments;
	}

	public void setEnvironments(List<Environment> environments) {
		this.environments = environments;
	}

	@SkipValidation
	public String execute() {
		Connection conn = null;
		Jdbc connector = new Jdbc();
		Statement stmt = null;
		String query = 
				"select os, os_version, notes, env_id " +
				"from " + dbName + "."+ tableName;
	
		conn = connector.getConn();
		
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
