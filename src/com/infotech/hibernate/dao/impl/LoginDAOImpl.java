package com.infotech.hibernate.dao.impl;

import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.infotech.hibernate.Assettype;
import com.infotech.hibernate.Login;
import com.infotech.hibernate.Role;
import com.infotech.hibernate.dao.LoginDAO;

public class LoginDAOImpl extends HibernateDaoSupport implements LoginDAO{
	
	
	public boolean getAscIdList(int ascId){
		
		Login l=null;
		String hqlQuery = null;
		boolean valid = false;
		hqlQuery = " from Login";
		List<Login> list = getHibernateTemplate().find(hqlQuery);	
		
		Iterator<Login> it = list.iterator();
		while(it.hasNext()) {
		l = it.next();
		if(l.getAscid()==ascId){
			System.out.println("get ascidlist true");
			return true;
		}else {
			valid= false;
		}
		}System.out.println("get ascidlist false"+valid);
		return valid;
		
		
		
	}

	public boolean loadUser(int ascId, String pwd) {
		if (this.getHibernateTemplate() != null)System.out.println("#################################################");
		
		Login loggin = (Login) this.getHibernateTemplate().load(Login.class, ascId);		
		String pwd1 = encryptPassword(pwd);		
		if (pwd1.equals(loggin.getPassword())) {
			return true;
		}
		return false;
	}
	
	public int getRole(int ascId){
		Login loggin = (Login) this.getHibernateTemplate().load(Login.class, ascId);
		int roleId=loggin.getRole().getRoleid();
		return roleId;
	}
	
	public String encryptPassword(String password)
	{
		String hqlQuery = null;
		Login lg=new Login();
		byte[] unencodedPassword = password.getBytes();
		MessageDigest md = null;
		try {
		md = MessageDigest.getInstance("MD5");
		} catch (Exception e) {}
		md.reset();
		md.update(unencodedPassword);
		byte[] encodedPassword = md.digest();
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < encodedPassword.length; i++) {
		if (((int) encodedPassword[i] & 0xff) < 0x10) {
		buf.append("0");
		}
		buf.append(Long.toString((int) encodedPassword[i] & 0xff, 16));
		}
		String pwd=buf.toString(); 
		return pwd;
	}
}
