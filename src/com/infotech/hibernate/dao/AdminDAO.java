package com.infotech.hibernate.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.infotech.hibernate.Assetdetails;
import com.infotech.hibernate.Assettype;
import com.infotech.hibernate.Location;
import com.infotech.hibernate.Login;
import com.infotech.hibernate.Role;

public interface AdminDAO {
	
	public boolean addUser(int ascId,String ascName, String password, 
			String emailId, String verticalName, int roleId);
	
	public void delUser(int[] ascId);
	
	public void addAsset(int assetTypeID,int ascId, int locationId, 
			String model,String computername,String ipAddress,
			String monitorTrackingNumber,String cpuTrackingNumber,
			int ram, int ramId, int hardDisk,String otherAssets);
	
	public List<Login> getLoginList();
	
	public List<Assettype> getAssettypeList();
	
	public List<Location> getLocationList();
	
	public List<Role> getRoleList();
	
	public boolean changePassword(int ascid,String password1,String password2,String password3);
	
	public void addLocation(String floor,String block,String phase,String area,String city);
	
	public List<Login>  retriveUserForgetPassword(int ascid, String strEmail) throws DataAccessException,java.sql.SQLException;
	
}