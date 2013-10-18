<%@ page language="java" import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page language="java" import="com.infotech.hibernate.Login" %>
<%@ page language="java" import="com.infotech.hibernate.Assettype" %>                                                   
<%@ page language="java" import="com.infotech.hibernate.Location" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0//EN"> 
<html>
	<head><link rel="stylesheet" type="text/css" href="style.css"/>
		<title>Welcome to Infotech Asset Tracking</title>
		<script type="text/javascript">
			window.history.forward(-1);
	   </script>
	</head>
  <body><%try{ %> 
  	<%@include file="/pages/Header.jsp"%>
  		<% Object a=session.getAttribute("ascId"); %>
			<% if(a!=null){ %>	
			<% String ascid=a.toString(); %>
		<%  Login lg=null; 
    	 	List<Login> list1 = (List<Login>) request.getAttribute("loginlist"); 
    	%> 
    	<%  Assettype at=null; 
    		List<Assettype> list2 = (List<Assettype>) request.getAttribute("assettypelist"); 
    	%>
		<%  Location l=null; 
    		List<Location> list = (List<Location>) request.getAttribute("locationlist"); 
    	%> 
		<div align="center"> 
		<table align="center" cellpadding="1" cellspacing="5">
    <html:form action="/AddAsset" method="post" onsubmit="return validateAssetForm(this);">
    	<html:javascript formName="AssetForm" />
       	
      	 <tr><td colspan="2"><h4><font color="aa0000"><u>Telecom OSS Asset Tracking - Add Asset to User</u></font></h4></td></tr><br>
      		<tr><td align="left">AssetType:</td><td align="left"><html:select name="AssetForm" property="assettypeId" value="">
      			<html:option value="">--select--</html:option>
      			
       			<%	Iterator<Assettype> it = list2.iterator();
					while(it.hasNext()) {
					at = it.next(); 
				%>
		       		<html:option value="<%=Integer.toString(at.getAssettypeid())%>"><%=at.getAssettypename()%></html:option>
				<% } %>	
       			</html:select>									   </td></tr>
       			
       		<tr><td align="left">Associate Id:</td><td align="left"><html:select name="AssetForm" property="ascId" value="">
       			<html:option value="">--select--</html:option>
       			<%	Iterator<Login> it = list1.iterator();
					while(it.hasNext()) {
					lg = it.next();   if(lg.getAscid()>0){
				%>
		       		<html:option value="<%=Integer.toString(lg.getAscid())%>"><%=lg.getAscid()%></html:option>
				<% } } %>	
       			</html:select>									   </td></tr>
       		<tr><td align="left">Location:</td><td align="left"><html:select name="AssetForm" property="locationId" value="">
       			<html:option value="">--select--</html:option>
       			 <%	Iterator<Location> it = list.iterator();
					while(it.hasNext()) {
					l = it.next(); 
				 %>
		       		<html:option value="<%=Integer.toString(l.getLocationid())%>"><%=l.getLocationname()%></html:option>
				 <% } %>	
       			</html:select>									   </td></tr>
			<tr><td align="left">Desktop Model:</td><td align="left"><html:text name="AssetForm" property="model" value="" />                                                </td>
				</tr>  
			<tr><td align="left">Computer/Laptop Name:</td><td align="left"><html:text name="AssetForm" property="computername" value="" />									   </td></tr>
			<tr><td align="left">IP Address:</td><td align="left"><html:text name="AssetForm" property="ipAddress" value="" />										   </td></tr>  <br>
			<tr><td align="left">Monitor Tracking Number:</td><td align="left"><html:text name="AssetForm" property="monitorTrackingNumber" value="" />	   </td></tr>
			<tr><td align="left">CPU/Laptop Tracking Number:</td><td align="left"><html:text name="AssetForm" property="cpuTrackingNumber" value="" />					   </td></tr>
			<tr><td align="left">RAM:</td><td align="left"><html:text name="AssetForm" property="ram" value="" /><html:select name="AssetForm" property="ramId" value="">
					<html:option value="">--select--</html:option>
    				<html:option value="1">GB</html:option>
    				<html:option value="2">MB</html:option>
				</html:select>										   </td></tr>
			<tr><td align="left">HARD DISK:</td><td align="left"><html:text name="AssetForm" property="hardDisk" value="" />GB							   </td></tr>
			<tr><td align="left">Other Assets:</td><td align="left"><html:text name="AssetForm" property="otherAssets" value="" />									   </td></tr>  
			<tr><td colspan="2">
			<input type="hidden" name="a" value="1"/>
						<html:submit  value="Submit" />
			<html:reset>Reset</html:reset>
			
			<html:cancel value="Cancel" /></td></tr>
		
	</html:form>
	</table>
	
	
    <%  } 
	   else { 
	  	response.sendRedirect("Login.jsp");
	   } %>
			</div>
		<%@include file="/pages/Footer.jsp"%>
		<%   }
        catch (Exception e){
            out.println("An exception occurred: " + e.getMessage());
        }
    %>
  </body>
</html>
