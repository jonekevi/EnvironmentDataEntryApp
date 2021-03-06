package org.jones.webdev.action;
import java.sql.*;
import com.opensymphony.xwork2.ActionSupport;
import org.jones.webdev.*;

public class DataEntryAction extends ActionSupport {
	
	/*
	 * Submits data from form to MySQL server
	 */
	
	private static final long serialVersionUID = 8679439511665909535L;
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


	public String skipData() throws Exception{
		return SUCCESS;
	}
	public String submit() throws Exception{
		Connection conn = null;
		Statement stmt = null;
		Jdbc connector = new Jdbc();
		conn = connector.getConn();
		
		try{
			String str = 
					"INSERT INTO " + this.tableName + " (os,os_version,notes)"+ " VALUES " + 
					"('" + this.os + "','" + this.osVer + "','" + this.notes + "');";
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
