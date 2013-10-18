<%@ page language="java" import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page language="java" import="com.infotech.hibernate.Assetdetails" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0//EN"> 
<html>
	<head><link rel="stylesheet" type="text/css" href="style.css"/>
		<title>Welcome to Infotech Asset Tracking</title>
		<script type="text/javascript" src="myscript.js">
		<script type="text/javascript">
			window.history.forward(-1);
		</script>
	</head>
  <body> <%try{ %> 
  	<%@include file="/pages/Header.jsp"%>
  		<% Object a=session.getAttribute("ascId"); %>
		<% if(a!=null){ %>	
		<% Assetdetails assetDetail = (Assetdetails) request.getAttribute("assetDetail"); %>
	    <%int assettypeid=assetDetail.getAssettype().getAssettypeid(); %>
      	<div align="center"><br><br><br><br><br><br><br><br>
      	<% if(assettypeid==1){   %>   
      	<html:form action="/Delete" method="post" >
    	<table align="center" cellpadding="1" cellspacing="5" border="0">
    		<tr><td colspan="6"><h4><font color="aa0000"><u>Telecom OSS Asset Tracking - Delete Desktop Asset</u></font></h4></td></tr>
       		<tr><td align="left">Associate Id:</td><td align="left"><html:text name="UpdateForm" size="30" property="ascId" value="<%=Integer.toString(assetDetail.getLogin().getAscid())%>" readonly="true"/>    </td></tr>   
			<tr><td align="left">Associate Name:</td><td align="left"><html:text name="UpdateForm" size="30" property="ascName" value="<%=assetDetail.getLogin().getAscname() %>" readonly="true"/>               </td></tr> 
			<tr><td align="left">Location:</td><td align="left"><html:text name="UpdateForm" size="30" property="locationName" value="<%=assetDetail.getLocation().getLocationname()%>" />            			 </td></tr>  
			<tr><td align="left">Desktop Model:</td><td align="left"><html:text name="UpdateForm" size="30" property="model" value="<%=assetDetail.getModel()%>" />                                               </td></tr>  
			<tr><td align="left">Computer Name:</td><td align="left"><html:text name="UpdateForm" size="30" property="computername" value="<%=assetDetail.getCompname()%>" />									 </td></tr>  
			<tr><td align="left">IP Address:</td><td align="left"><html:text name="UpdateForm" size="30" property="ipAddress" value="<%=assetDetail.getIpaddress()%>" />										 </td></tr>  
			<tr><td align="left">Monitor Tracking Number:</td><td align="left"><html:text name="UpdateForm" size="30" property="monitorTrackingNumber" value="<%=assetDetail.getMonitortrackingnumber()%>" />	 </td></tr>  
			<tr><td align="left">CPU Tracking Number:</td><td align="left"><html:text name="UpdateForm" size="30" property="cpuTrackingNumber" value="<%=assetDetail.getTrackingnumber()%>" />					 </td></tr>  
			<tr><td align="left">RAM:</td><td align="left"><html:text name="UpdateForm" size="30" property="ram" value="<%=Integer.toString(assetDetail.getRam())%>" />											 </td></tr>  
			<tr><td align="left">HARD DISK:</td><td align="left"><html:text name="UpdateForm" size="30" property="hardDisk" value="<%=Integer.toString(assetDetail.getHarddisk())%>" />							 </td></tr>  
			<tr><td align="left">Other Assets:</td><td align="left"><html:text name="UpdateForm" size="30" property="otherAssets" value="<%=assetDetail.getOtherassets()%>" />									 </td></tr>  
			<tr><td colspan="2">
			<input type="hidden" name="ab" value="1"/>
			<html:submit  value="Delete" onclick="return confirmSubmit()"/>
			<html:cancel value="Cancel" /></td></tr></table>
		</html:form>
	<%
	}
	%>
	
	<% if(assettypeid==2){     %>  
      	<html:form action="/Delete" method="post">
       	<table> 
       	<%int y=2; %>
       	    <%request.setAttribute("assetTypeID",2); %>
       		<tr><td colspan="6"><h4><font color="aa0000"><u>Telecom OSS Asset Tracking - Delete Laptop Asset</u></font></h4></td></tr>
       		<tr><td align="left">Associate Id:</td><td align="left"><html:text name="UpdateForm" size="30" property="ascId" value="<%=Integer.toString(assetDetail.getLogin().getAscid())%>" readonly="true"/>    </td></tr>
			<tr><td align="left">Associate Name:</td><td align="left"><html:text name="UpdateForm" size="30" property="ascName" value="<%=assetDetail.getLogin().getAscname() %>" readonly="true"/>               </td></tr>
			<tr><td align="left">Location:</td><td align="left"><html:text name="UpdateForm" size="30" property="locationName" value="<%=assetDetail.getLocation().getLocationname()%>" />             			 </td></tr> 
			<tr><td align="left">Desktop Model:</td><td align="left"><html:text name="UpdateForm" size="30" property="model" value="<%=assetDetail.getModel()%>" />                                               </td></tr> 
			<tr><td align="left">Computer Name:</td><td align="left"><html:text name="UpdateForm" size="30" property="computername" value="<%=assetDetail.getCompname()%>" />									 </td></tr> 
			<tr><td align="left">IP Address:</td><td align="left"><html:text name="UpdateForm" size="30" property="ipAddress" value="<%=assetDetail.getIpaddress()%>" />										 </td></tr> 
			<tr><td align="left">Monitor Tracking Number:</td><td align="left"><html:text name="UpdateForm" size="30" property="monitorTrackingNumber" value="<%=assetDetail.getMonitortrackingnumber()%>" />	 </td></tr>  
			<tr><td align="left">CPU Tracking Number:</td><td align="left"><html:text name="UpdateForm" size="30" property="cpuTrackingNumber" value="<%=assetDetail.getTrackingnumber()%>" />					 </td></tr>  
			<tr><td align="left">RAM:</td><td align="left"><html:text name="UpdateForm" size="30" property="ram" value="<%=Integer.toString(assetDetail.getRam())%>" />											 </td></tr> 	
			<tr><td align="left">HARD DISK:</td><td align="left"><html:text name="UpdateForm" size="30" property="hardDisk" value="<%=Integer.toString(assetDetail.getHarddisk())%>" />							 </td></tr> 
			<tr><td align="left">Other Assets:</td><td align="left"><html:text name="UpdateForm" size="30" property="otherAssets" value="<%=assetDetail.getOtherassets()%>" />									 </td></tr>  
			<tr><td colspan="2">
			<input type="hidden" name="ab" value="2"/>
			<html:submit  value="Delete" onclick="return confirmSubmit()"/>
			<html:cancel value="Cancel" /></td></tr></table>
		</html:form>
	<%
	}  %>

    <%  } 
	   else { 
	  	response.sendRedirect("Login.jsp");
	   } %>
			</div><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		<%@include file="/pages/Footer.jsp"%>
		 <%   }
        catch (Exception e){
            out.println("An exception occurred: " + e.getMessage());
        }
    %>
		
  </body>
</html>
