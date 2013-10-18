package com.infotech.hibernate.dao;

import java.sql.SQLException;
import java.util.*;

import com.infotech.hibernate.Assetdetails;
import com.infotech.hibernate.Login;

public interface AssetDetailsDAO {	
	
	public List<Assetdetails> getAssetdetails(int assetTypeID, int assetID) throws SQLException;
	
	public List<Assetdetails> getTempAssetdetails() throws SQLException;
	
	public void updateAsset(int assetTypeID,int assetID,int ascId,String ascName,int locationId,String model,String computername,String ipAddress,String monitorTrackingNumber,String cpuTrackingNumber,int ram,int hardDisk,String otherAssets);
	
	public void deleteAsset(int ascId);
	
	public void assignAsset(int assetId,int ascId);
	
	public List<Login> getNoAssetAscIdList() throws SQLException;

	public List<Login> getNoAssetAscIdList1() throws SQLException;

}

	