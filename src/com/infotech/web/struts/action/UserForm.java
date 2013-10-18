package com.infotech.web.struts.action;

import org.apache.struts.action.*;

public class UserForm  extends ActionForm{

	private int ascId=0;
	private String ascName = null;
	private String password = null;
	private String emailId = null;
	private String verticalName = null;
	private int roleId = 0;
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getAscId() {
		return ascId;
	}
	public void setAscId(int ascId) {
		this.ascId = ascId;
	}
	public String getAscName() {
		return ascName;
	}
	public void setAscName(String ascName) {
		this.ascName = ascName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getVerticalName() {
		return verticalName;
	}
	public void setVerticalName(String verticalName) {
		this.verticalName = verticalName;
	}
	
}