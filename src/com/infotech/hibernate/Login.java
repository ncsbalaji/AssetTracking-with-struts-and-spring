package com.infotech.hibernate;

// Generated Feb 1, 2011 2:27:00 PM by Hibernate Tools 3.2.4.GA

import java.util.HashSet;
import java.util.Set;

/**
 * Login generated by hbm2java
 */
public class Login implements java.io.Serializable {

	private int ascid;
	private Role role;
	private String ascname;
	private String password;
	private String emailid;
	private String verticalname;
	
	private Set<Assetdetails> assetdetails = new HashSet<Assetdetails>(0);
	

	public Login() {
	}

	public Login(int ascid) {
		this.ascid = ascid;
	}

	public Login(int ascid, Role role, String ascname,
			String password, String emailid, String verticalname,
			Set<Assetdetails> assetdetails) {
		this.ascid = ascid;
		this.role = role;
		this.ascname = ascname;
		this.password = password;
		this.emailid = emailid;
		this.verticalname = verticalname;
		this.assetdetails = assetdetails;
	}

	public int getAscid() {
		return this.ascid;
	}

	public void setAscid(int ascid) {
		this.ascid = ascid;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getAscname() {
		return this.ascname;
	}

	public void setAscname(String ascname) {
		this.ascname = ascname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailid() {
		return this.emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getVerticalname() {
		return verticalname;
	}

	public void setVerticalname(String verticalname) {
		this.verticalname = verticalname;
	}

	
	

	public Set<Assetdetails> getAssetdetails() {
		return this.assetdetails;
	}

	public void setAssetdetails(Set<Assetdetails> assetdetails) {
		this.assetdetails = assetdetails;
	}
}
