package com.infotech.web.struts.action;

import java.util.ArrayList;
import java.sql.* ;
public class ActorData {
	
	private int ascid;
	private String ascname;
	private String emailid;
	private String verticalname;
	private String rolename;
	private String ipaddress;
	private String assetname;
	
	
	private int ascId;
	private String ascName;
	private String emailId;
	private String verticalName;
	private String roleName;
	private String ipAddress;
	private String assetName;
	
	ArrayList actorList = new ArrayList();
    
    public ActorData()
    {
    }
    public ActorData(int ascId, String ascName , String emailId , String verticalName , String roleName , String ipAddress , String assetName)
    {
        
        this.ascId = ascId;
        this.ascName = ascName;
        this.emailId = emailId;
        this.verticalName = verticalName;
        this.roleName = roleName;
        this.ipAddress = ipAddress;
        this.assetName = assetName;
    }

    @SuppressWarnings("unchecked")
	public ArrayList loadData()
    {
    	try
        {
         // Load the database driver
         Class.forName( "org.postgresql.Driver" ) ;

         Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3308/ex1","root","root" ) ;
         Statement stmt = conn.createStatement() ;

         ResultSet rs = stmt.executeQuery( "SELECT login.* , role.rolename , assetdetails.ipaddress , assetdetails.assettypeid , assettype.assettypename , assettype.assettypeid FROM login,role,assetdetails,assettype where login.ascid != -1 and login.roleid=role.roleid and login.ascid = assetdetails.ascid and assetdetails.assettypeid = assettype.assettypeid ;" ) ;
        
         // Loop through the result set
         while( rs.next() )
         {
        	
        	ascid= rs.getInt("ascid");
        	ascname=rs.getString("ascname");
        	emailid=rs.getString("emailid");
        	verticalname=rs.getString("verticalname");
        	rolename=rs.getString("rolename");
        	ipaddress=rs.getString("ipaddress");
        	assetname=rs.getString("assettypename");
        	actorList.add(new ActorData(ascid,ascname,emailid,verticalname,rolename,ipaddress,assetname));

         }
        }
    
    catch(Exception e)
    {
    	e.printStackTrace();
    }
		return actorList;
	
    }
    public int getascId() {
        return ascId;
    }
  
    public String getascName(){
    	return ascName;
    }
    public String getemailId(){
    	return emailId;
    }
    public String getverticalName(){
    	return verticalName;
    }
    public String getroleName(){
    	return roleName;
    }
    public String getipAddress(){
    	return ipAddress;
    }
    public String getassetName()
    {
		return assetName;
    	
    }

}

