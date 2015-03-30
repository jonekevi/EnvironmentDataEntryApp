package org.jones.webdev;

public class Environment {
	
	private String os;
	private String osVersion;
	private String notes;
	private int envId;
	
	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getEnvId() {
		return envId;
	}

	public void setEnvId(int envId) {
		this.envId = envId;
	}


	
	public Environment(String os, String osVer, String notes, int envId) {
		this.os = os;
		this.osVersion = osVer;
		this.notes = notes;
		this.envId = envId;
	};
	
}
