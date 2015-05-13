package org.jones.webdev.action;
import com.opensymphony.xwork2.ActionSupport;
public class GetLoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String user;
	private static String password;
	private static String port;
	public static String getUser() {
		return user;
	}

	public static void setUser(String user) {
		GetLoginAction.user = user;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		GetLoginAction.password = password;
	}
	
	
	public static String getPort() {
		return port;
	}

	public static void setPort(String port) {
		GetLoginAction.port = port;
	}

	public String execute() 
	{
		return SUCCESS;
	}

}
