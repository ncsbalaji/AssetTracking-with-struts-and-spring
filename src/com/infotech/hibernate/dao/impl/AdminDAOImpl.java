package com.infotech.hibernate.dao.impl;

import java.security.MessageDigest;
import java.sql.SQLException;
import java.util.*;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.infotech.hibernate.Assetdetails;
import com.infotech.hibernate.Assettype;
import com.infotech.hibernate.Location;
import com.infotech.hibernate.Login;
import com.infotech.hibernate.Role;
import com.infotech.hibernate.dao.AdminDAO;

public class AdminDAOImpl extends HibernateDaoSupport implements AdminDAO {

	public boolean addUser(int ascId,String ascName, String password, 
				String emailId, String verticalName, int roleId) {
			
		System.out.println("in admindaoimpl-->adduser");
		Login loggin = null;
		try{
			loggin = (Login) this.getHibernateTemplate().load(Login.class, ascId);
		}catch(Exception e){
			e.printStackTrace();
		
		}
			if(loggin==null){
			Login lg=new Login();
			Role r=new Role();
			
			String pwd = encryptPassword(password);
			
			lg.setAscid(ascId);
			lg.setAscname(ascName);
			lg.setPassword(pwd);
			lg.setEmailid(emailId);
			r.setRoleid(roleId);
			lg.setRole(r);
			lg.setVerticalname(verticalName);
			
			this.getHibernateTemplate().save(lg);
			
			return true;
			}
			else{
				return false;
			}
			
		}

	public void delUser(int[] ascId) {
		
		int assetId=0;
		int ascid=0;
		
		String hqlQuery = null;
		
		Login lg=new Login();
		
		for(int i=0;i<ascId.length;i++){
			
			ascid=ascId[i];
			
			lg.setAscid(ascid);
			Assetdetails ad=new Assetdetails();
			
			hqlQuery = " from Assetdetails where ascid = " + ascid;
			
			@SuppressWarnings("unchecked")
			List<Assetdetails> list = getHibernateTemplate().find(hqlQuery);

			Iterator<Assetdetails> it = list.iterator();
			while(it.hasNext()) {
				ad = it.next(); 
				
				lg.setAscid(-1);
				ad.setLogin(lg);
				
			assetId=ad.getAssetid();
			ad.setAssetid(assetId);
			
			this.getHibernateTemplate().saveOrUpdate(ad);
			}
			lg.setAscid(ascid);
			ad.setLogin(lg);
			this.getHibernateTemplate().delete(lg);
			
		}
		
		
		
	}
	
	public void addAsset(int assetTypeID,int ascId, int locationId, String model,String computername,String ipAddress, String monitorTrackingNumber,String cpuTrackingNumber, int ram, int ramId, int hardDisk,String otherAssets){	
		
		Login lg=new Login();
		Assetdetails ad=new Assetdetails();
		Assettype at=new Assettype();
		Location lc=new Location();
		
		System.out.println("test2.1");
		at.setAssettypeid(assetTypeID);
		ad.setAssettype(at);
		
		System.out.println(assetTypeID);
		
		lg.setAscid(ascId);
		ad.setLogin(lg);
		
		lc.setLocationid(locationId);
		ad.setLocation(lc);
		
		ad.setCompname(computername);
		ad.setIpaddress(ipAddress);
		ad.setModel(model);
		ad.setMonitortrackingnumber(monitorTrackingNumber);
		ad.setTrackingnumber(cpuTrackingNumber);
		System.out.println("ram0"+ramId);
		if(ramId==1){
			ad.setRam(ram);
			System.out.println("ram1"+ram);
		}
		else{
			ad.setRam(ram);
			System.out.println("ram3"+ram);
		}
		
		ad.setHarddisk(hardDisk);
		ad.setOtherassets(otherAssets);
		
		System.out.println("test2.2");
		this.getHibernateTemplate().save(ad);
		System.out.println("test2.3");
	}
	
	@SuppressWarnings("unchecked")
	public List<Login> getLoginList(){
		String hqlQuery = null;
		System.out.println("test3");
		hqlQuery = " from Login";
		List<Login> list = getHibernateTemplate().find(hqlQuery);	
		System.out.println("test4");
		return list;
	}
	
	public List<Assettype> getAssettypeList(){
		
		String hqlQuery = null;
		hqlQuery = " from Assettype";
		@SuppressWarnings("unchecked")
		List<Assettype> list = getHibernateTemplate().find(hqlQuery);	
		return list;
		
	}
	
	public List<Location> getLocationList(){
		
		String hqlQuery = null;
		hqlQuery = " from Location";
		@SuppressWarnings("unchecked")
		List<Location> list = getHibernateTemplate().find(hqlQuery);	
		return list;
		
	}
	
	public String encryptPassword(String password)
	{
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

	public boolean changePassword(int ascid,String password1, String password2,
			String password3) {
		
		Login loggin = (Login) this.getHibernateTemplate().load(Login.class, ascid);
		String password4=loggin.getPassword();
		String password5=encryptPassword(password1);
		String password6=encryptPassword(password2);
		
		if (password4.equals(password5)&&password2.equals(password3)) {
			
			System.out.println(ascid);
			/*lg.setAscname(loggin.getAscname());
			
			
			
			lg.setAscid(ascid);
			lg.setPassword(password6);
			
			lg.setEmailid(loggin.getEmailid());
			lg.setRole(loggin.getRole());
			lg.setDomainname(loggin.getDomainname());
			
			lc.setLocationid(1);
			lg.setLocation(lc);	
			
			this.getHibernateTemplate().saveOrUpdate(lg);*/
			
			System.out.println("a");
			
			loggin.setPassword(password6);
			this.getHibernateTemplate().saveOrUpdate(loggin);
			

			System.out.println("b");
			
			return true;
		}
		else{
			System.out.println("c");	
		return false;
		}
		
	}
	
	public void addLocation(String floor,String block,String phase,String area,String city){
		
		Location lc=new Location();
		
		String location=city+"-"+area+"-"+phase+"-"+block+"-"+floor;
		
		lc.setLocationname(location);
		
		this.getHibernateTemplate().saveOrUpdate(lc);
		
	}
	
	public List<Role> getRoleList(){
		
		String hqlQuery = null;
		hqlQuery = " from Role";
		@SuppressWarnings("unchecked")
		List<Role> list = getHibernateTemplate().find(hqlQuery);	
		
		return list;
		
	}

	public List<Login> retriveUserForgetPassword(int ascid, String strEmail) throws DataAccessException,java.sql.SQLException{
		
		System.out.println("ascid="+ascid);
		System.out.println("AdminDAOImpl-->retriveUserForgetPassword-->start");
		String hqlQuery = null;
		hqlQuery = " from Login where ascId = " + ascid;
		List<Login> list = getHibernateTemplate().find(hqlQuery);	
		System.out.println("AdminDAOImpl-->retriveUserForgetPassword-->end");
		return list;
		
	}
	
}
