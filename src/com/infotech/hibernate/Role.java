package com.infotech.hibernate;

// Generated Feb 1, 2011 2:27:00 PM by Hibernate Tools 3.2.4.GA

import java.util.HashSet;
import java.util.Set;

/**
 * Role generated by hbm2java
 */
public class Role implements java.io.Serializable {

	private int roleid;
	private String rolename;
	private Set<Login> login = new HashSet<Login>(0);
	
	public Role() {
	}

	public Role(int roleid) {
		this.roleid = roleid;
	}

	public Role(int roleid, String rolename, Set<Login> login) {
		this.roleid = roleid;
		this.rolename = rolename;
		this.login = login;		
	}

	public int getRoleid() {
		return this.roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Set<Login> getLogin() {
		return this.login;
	}

	public void setLogin(Set<Login> login) {
		this.login = login;
	}
}
