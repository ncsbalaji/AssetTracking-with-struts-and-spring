package com.infotech.hibernate.dao.impl;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.infotech.hibernate.Assetdetails;
import com.infotech.hibernate.Assettype;
import com.infotech.hibernate.Location;
import com.infotech.hibernate.Login;
import com.infotech.hibernate.Role;
import com.infotech.hibernate.dao.AssetDetailsDAO;

public class AssetDetailsDAOImpl extends HibernateDaoSupport implements AssetDetailsDAO {	
	
	public List<Assetdetails> getAssetdetails(int assetTypeID, int assetID) throws SQLException  {
		System.out.println("stared action in DesktopDAOImpl getAssetdetails1 method dddddddddddddddddd");
		String hqlQuery = null;
		System.out.println(assetTypeID+" "+assetID);
		if (assetTypeID == -1 && assetID == -1) { /* This condition is to retrieve all AssetDetails irrespective of asset type */
			hqlQuery = " from Assetdetails";
		} else if (assetTypeID != -1 && assetID == -1) { /* This condition is to retrieve AssetDetails respective to the provided asset type */
			System.out.println("6");
			hqlQuery = " from Assetdetails where assettypeid = " + assetTypeID;
			System.out.println("7");
		} else if (assetTypeID == -1 && assetID != -1) { /* This condition is to retrieve AssetDetails for the specific asset ID*/
			System.out.println("3");
			hqlQuery = " from Assetdetails where assetid = " + assetID;
			System.out.println("4");
		}		
		System.out.println("out1");
		@SuppressWarnings("unchecked")
		List<Assetdetails> list = getHibernateTemplate().find(hqlQuery);	
		System.out.println("out2");
		return list;
		
		
	} 
	
	public List<Assetdetails> getTempAssetdetails() throws SQLException{
		
		int ascId = -1;
		System.out.println("$2");
		String hqlQuery = " from Assetdetails where ascId = " + ascId;
		
		System.out.println("$3");
		List<Assetdetails> list = getHibernateTemplate().find(hqlQuery);	
		System.out.println("$4");
		
		return list;
		
		
	}
	
	public List<Login> getNoAssetAscIdList() throws SQLException{
			
		//String hqlQuery = "from Login where not exists (select ascid from Assetdetails where Login.ascid = Assetdetails.ascid)";
		String hqlQuery = "from Login";
		System.out.println("$5");
		List<Login> list = getHibernateTemplate().find(hqlQuery);
		System.out.println("$6");
		return list;
		}
	
	public List<Login> getNoAssetAscIdList1() throws SQLException{
		/*System.out.println("getNoAssetAscIdList1");
		Login loggin = null;
		Login loggin1 = null;
		Login loggin2 = null;
		List<Login> list=null;
		List<Login> list1=null;
		List<Login> list2=null;
		List<Assetdetails> alist = null;
		String hqlQuery = null;
		String hqlQuery1 = null;
		String hqlQuery2 = null;
			hqlQuery = " from Login";
			list = getHibernateTemplate().find(hqlQuery);
			
		Iterator<Login> it = list.iterator();
		while(it.hasNext()) {
			loggin = it.next(); 
			
			int ascId=loggin.getAscid();
			try{
				hqlQuery1 = " from Assetdetails where ascId = " + ascId;
				System.out.println("ab"+loggin.getAscid());
				list1 = getHibernateTemplate().find(hqlQuery1);
				System.out.println("ab"+list1);
			}catch(Exception e){
				e.printStackTrace();
			
			}
			if(list1==null){
				System.out.println("cd"+ascId);
				hqlQuery2 = " from Login where ascId = " + ascId;
				list1=getHibernateTemplate().find(hqlQuery2);
				Iterator<Login> it1 = list1.iterator();
				while(it.hasNext()) {
					loggin = it.next(); 
					
					loggin1.setAscid(loggin.getAscid());
					loggin1.setAscname(loggin.getAscname());
										
				list2.add(loggin1);
				System.out.println("ef"+loggin.getAscid());
			}
		}
		}*/
		String hqlQuery = "from Login where not exists (select ascid from Assetdetails where Login.ascid = Assetdetails.ascid)";
		System.out.println("$5a");
		List<Login> list = null;
		System.out.println(list);
		try{
		list = getHibernateTemplate().find(hqlQuery);
		System.out.println("$6a");
		System.out.println(list);
		}
		catch(Exception e){
		e.printStackTrace();
		}
		System.out.println(list);
		return list; 
		
		}
	
	public void updateAsset(int assetTypeID,int assetID,int ascId,String ascName,int locationId,String model,String computername,String ipAddress,String monitorTrackingNumber,String cpuTrackingNumber,int ram,int hardDisk,String otherAssets){
			
			System.out.println("in assetdaoimpl-updateasset");
			String hqlQuery = " from Assetdetails where ascId = " + ascId;
			Assetdetails ad1=null;	
			List<Assetdetails> assetDetails  = getHibernateTemplate().find(hqlQuery);
			int assetID1=0;
			Iterator<Assetdetails> it = assetDetails.iterator();
			while(it.hasNext()) {
				ad1 = it.next();
				System.out.println("$7");
				assetID1=ad1.getAssetid();
				System.out.println("$8");
			}
				
		 if(assetTypeID==1){
				Assetdetails ad= new Assetdetails();
				Login lg=new Login();
				Location lc=new Location();
				Assettype at = new Assettype();
				
//				lc.setLocationid(2);
//				
//				lg.setLocation(lc);
//				
//		    	Login loggin = (Login) this.getHibernateTemplate().load(Login.class, ascId);
//				lg.setAscid(ascId);
//				lg.setAscname(loggin.getAscname());
//				lg.setPassword(loggin.getPassword());
//		    	lg.setEmailid(loggin.getEmailid());
//				lg.setRole(loggin.getRole());
//		    	lg.setLocation(lc);
//				lg.setDomainname(loggin.getDomainname());
//				this.getHibernateTemplate().saveOrUpdate(lg);
				
				
				
				
				lg.setAscid(ascId);
				
				
				        
				at.setAssettypeid(assetTypeID);
				
				
				ad.setAssetid(assetID1);
				ad.setAssettype(at);
				ad.setLogin(lg);
				ad.setCompname(computername);
				ad.setIpaddress(ipAddress);
				ad.setModel(model);
				ad.setMonitortrackingnumber(monitorTrackingNumber);
				ad.setTrackingnumber(cpuTrackingNumber);
				ad.setRam(ram);
				ad.setHarddisk(hardDisk);
				ad.setOtherassets(otherAssets);
				
				lc.setLocationid(locationId);				
				ad.setLocation(lc);
			
			//	hqlQuery = " from Assetdetails where assetId = " + ad.getAssetid();
				this.getHibernateTemplate().saveOrUpdate(ad); 
				
				System.out.println("in updatedaoimpl1");
				
			}
				
				if(assetTypeID==2){
					System.out.println("$9");
					Assetdetails ad= new Assetdetails();
					Login lg=new Login();
					Location lc=new Location();
					Assettype at = new Assettype();
					
					/*lc.setLocationid(2);
					
					lg.setLocation(lc);
					
					Login loggin = (Login) this.getHibernateTemplate().load(Login.class, ascId);
					lg.setAscid(ascId);
					lg.setAscname(loggin.getAscname());
					lg.setPassword(loggin.getPassword());
					lg.setEmailid(loggin.getEmailid());
					lg.setRole(loggin.getRole());
					lg.setLocation(lc);
					lg.setDomainname(loggin.getDomainname());
					this.getHibernateTemplate().saveOrUpdate(lg);*/
					
					
					
					
					lg.setAscid(ascId);
					
					
					        
					at.setAssettypeid(assetTypeID);
					
					System.out.println("$10");
					ad.setAssetid(assetID1);
					System.out.println("$11");
					ad.setAssettype(at);
					ad.setLogin(lg);
					ad.setCompname(computername);
					ad.setIpaddress(ipAddress);
					ad.setModel(model);
					ad.setMonitortrackingnumber(monitorTrackingNumber);
					ad.setTrackingnumber(cpuTrackingNumber);
					ad.setRam(ram);
					ad.setHarddisk(hardDisk);
					ad.setOtherassets(otherAssets);
					
					lc.setLocationid(locationId);
					ad.setLocation(lc);
				
				//	hqlQuery = " from Assetdetails where assetId = " + ad.getAssetid();
					this.getHibernateTemplate().saveOrUpdate(ad);
				}
				
		}
		
		/*public void deleteAsset(int assetID){
			
			String hqlQuery = null;
			Assetdetails ad= (Assetdetails) this.getHibernateTemplate().load(Assetdetails.class, assetID);
			int ascid=ad.getLogin().getAscid();
			Login lg=new Login();
			
			hqlQuery = " from Assetdetails where assetId = " + ad.getAssetid();
			this.getHibernateTemplate().delete(ad);
			this.getHibernateTemplate().delete(lg);
			
		}*/
		public void deleteAsset(int ascId){
			
			System.out.println("in assetdaoimpl-deleteAsset");
			String hqlQuery = " from Assetdetails where ascId = " + ascId;
			Assetdetails ad1=null;	
			List<Assetdetails> assetDetails  = getHibernateTemplate().find(hqlQuery);
			int assetID1=0;
			Iterator<Assetdetails> it = assetDetails.iterator();
			while(it.hasNext()) {
				ad1 = it.next();
				System.out.println("$7");
				assetID1=ad1.getAssetid();
				System.out.println(assetID1+"$8");
			}
			
					System.out.println("e");
				    Login lg=new Login();
					Assetdetails ad= new Assetdetails();
					ad.setAssetid(assetID1);
					this.getHibernateTemplate().delete(ad);  
				//	this.getHibernateTemplate().delete(lg);
					System.out.println("f");
		}
		
		public void assignAsset(int assetId,int ascId){
			
			Assetdetails ad= new Assetdetails();
			Login lg=new Login();
			Location lc=new Location();
			Assettype at = new Assettype();
			
			Assetdetails ad1 = (Assetdetails) this.getHibernateTemplate().load(Assetdetails.class, assetId);
			
			lg.setAscid(ascId);
			ad.setLogin(lg);
			
			at.setAssettypeid(ad1.getAssettype().getAssettypeid());
			ad.setAssettype(at);
			
			lc.setLocationid(ad1.getLocation().getLocationid());
			ad.setLocation(lc);
			
			ad.setAssetid(assetId);
			ad.setIpaddress(ad1.getIpaddress());
			ad.setCompname(ad1.getCompname());
			ad.setModel(ad1.getModel());
			ad.setTrackingnumber(ad1.getTrackingnumber());
			ad.setMonitortrackingnumber(ad1.getMonitortrackingnumber());
			ad.setRam(ad1.getRam());
			ad.setHarddisk(ad1.getHarddisk());
			ad.setOtherassets(ad1.getOtherassets());
			
			System.out.println("assign asset of assetdetailsdaoimpl");
						
			this.getHibernateTemplate().saveOrUpdate(ad);
			
		}

		
		

	/*public ArrayList<Assetdetails> getAssetdetails(final int a) {
		// TODO Auto-generated method stub
		HibernateCallback callback = new HibernateCallback() {
            public Object doInHibernate(Session session) 
                throws HibernateException,SQLException {
                return session.load(Assetdetails.class,a);
            }
        };        
        return (ArrayList<Assetdetails>)getHibernateTemplate().execute(callback);
  
	
	}*/

}
