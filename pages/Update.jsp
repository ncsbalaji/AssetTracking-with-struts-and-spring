<%@ page language="java" import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page language="java" import="com.infotech.hibernate.Assetdetails" %>
<%@ page language="java" import="com.infotech.hibernate.Location" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0//EN"> 
<html>
	<head><link rel="stylesheet" type="text/css" href="style.css"/>
		<title>Welcome to Infotech Asset Tracking</title>
		<script type="text/javascript">
			window.history.forward(-1);
		</script>
		
	</head>
  
  <body>
   <%try{ %> <div align="center">
   	 <%@include file="/pages/Header.jsp"%>
	 <%Object a=session.getAttribute("ascId"); %> 
	 <% if(a!=null){ %>	 
	<% Assetdetails assetDetail = (Assetdetails) request.getAttribute("assetDetail"); %> 
	<%int assettypeid=assetDetail.getAssettype().getAssettypeid(); %> 
    <%  Location l=null;  
    	List<Location> list = (List<Location>) request.getAttribute("locationlist");  %> 
     <%String locationname=assetDetail.getLocation().getLocationname(); %>
     <%int ramsize=assetDetail.getRam();%>
     <% if(assettypeid==1){   %> 
	 <table align="center" cellpadding="1" cellspacing="5" border="0">
	     	<html:form action="/Update" method="post" onsubmit="return validateUpdateForm(this);">
				    <html:javascript formName="UpdateForm" />
      		<tr><td colspan="6"><h4><font color="aa0000"><u>Telecom OSS Asset Tracking - Update Desktop asset</u></font></h4></td></tr>
       		<tr><td align="left">Associate Id:</td><td align="left"><html:text name="UpdateForm" property="ascId" value="<%=Integer.toString(assetDetail.getLogin().getAscid())%>" readonly="true"/>    </td></tr>  <br> 
			<tr><td align="left">Location:</td><td align="left"><html:select name="UpdateForm" property="locationId" value="<%=Integer.toString(assetDetail.getLocation().getLocationid())%>">
					
       			 <%	Iterator<Location> it = list.iterator();
					while(it.hasNext()) {
					l = it.next();
				%>		
						<html:option value="<%=Integer.toString(l.getLocationid())%>"><%=l.getLocationname()%></html:option>
				<%  } %>	
       			</html:select>     </td></tr>  <br>	
       		<tr><td align="left">Desktop Model:</td><td align="left"><html:text name="UpdateForm" property="model" value="<%=assetDetail.getModel()%>" />                                                </td></tr>  <br>
			<tr><td align="left">Computer Name:</td><td align="left"><html:text name="UpdateForm" property="computername" value="<%=assetDetail.getCompname()%>" />									   </td></tr>  <br>
			<tr><td align="left">IP Address:</td><td align="left"><html:text name="UpdateForm" property="ipAddress" value="<%=assetDetail.getIpaddress()%>" />										   </td></tr>  <br>
			<tr><td align="left">Monitor Tracking Number:</td><td align="left"><html:text name="UpdateForm" property="monitorTrackingNumber" value="<%=assetDetail.getMonitortrackingnumber()%>" />	   </td></tr>  <br>
			<tr><td align="left">CPU Tracking Number:</td><td align="left"><html:text name="UpdateForm" property="cpuTrackingNumber" value="<%=assetDetail.getTrackingnumber()%>" />					   </td></tr>  <br>
			<%int ram=assetDetail.getRam();%>
			<tr><td align="left">RAM:</td><td align="left"><html:text name="UpdateForm" property="ram" value="<%=Integer.toString(assetDetail.getRam())%>" /><html:select name="UpdateForm" property="ramId">
    				<html:option value="1">GB</html:option>
    				<html:option value="2">MB</html:option>
				</html:select>												   </td></tr>  <br>	
			<tr><td align="left">HARD DISK:</td><td align="left"><html:text name="UpdateForm" property="hardDisk" value="<%=Integer.toString(assetDetail.getHarddisk())%>" />							   </td></tr>  <br>
			<tr><td align="left">Other Assets:</td><td align="left"><html:text name="UpdateForm" property="otherAssets" value="<%=assetDetail.getOtherassets()%>" />									   </td></tr>  
			<tr><td></td></tr>
			<tr><td colspan="2">
			<input type="hidden" name="ab" value="1"/>
			<html:submit  value="Submit" />
			<html:reset>Reset</html:reset>
			<html:cancel value="Cancel" /></td></tr>
			
	</html:form>
	</table>
	<%
	}
	%>
	<% if(assettypeid==2){     %>  
     <table border="0" align="center">	
       
       <html:form action="/Update" method="post" onsubmit="return validateUpdateForm(this);">
    		<html:javascript formName="UpdateForm" />
       	
       	
       	<%int y=2; %>
       	    <%request.setAttribute("assetTypeID",2); %>
       	    <%int ram=assetDetail.getRam();%>
       	   <tr><td colspan="6"><h4><font color="aa0000"><u>Telecom OSS Asset Tracking - Update Laptop Asset</u></font></h4></td></tr><br><br>
       	    <tr><td align="left">Associate Id:</td><td align="left"><html:text name="UpdateForm" property="ascId" value="<%=Integer.toString(assetDetail.getLogin().getAscid())%>" readonly="true" />    </td></tr>  <br> 
			<tr><td align="left">Location:</td><td align="left"><html:select name="UpdateForm" property="locationId" value="<%=Integer.toString(assetDetail.getLocation().getLocationid())%>">
					
       			 <%	Iterator<Location> it = list.iterator();
					while(it.hasNext()) {
					l = it.next();
				%>		
						<html:option value="<%=Integer.toString(l.getLocationid())%>"><%=l.getLocationname()%></html:option>
				<%  } %>	
       			</html:select>     </td></tr>  <br>	
       		<tr><td align="left">Desktop Model:</td><td align="left"><html:text name="UpdateForm" property="model" value="<%=assetDetail.getModel()%>" />                                                </td></tr>  <br>
			<tr><td align="left">Computer Name:</td><td align="left"><html:text name="UpdateForm" property="computername" value="<%=assetDetail.getCompname()%>" />									   </td></tr>  <br>
			<tr><td align="left">IP Address:</td><td align="left"><html:text name="UpdateForm" property="ipAddress" value="<%=assetDetail.getIpaddress()%>" />										   </td></tr>  <br>
			<tr><td align="left">Monitor Tracking Number:</td><td align="left"><html:text name="UpdateForm" property="monitorTrackingNumber" value="<%=assetDetail.getMonitortrackingnumber()%>" />	   </td></tr>  <br>
			<tr><td align="left">Laptop Tracking Number:</td><td align="left"><html:text name="UpdateForm" property="cpuTrackingNumber" value="<%=assetDetail.getTrackingnumber()%>" />					   </td></tr>  <br>
			
			<tr><td align="left">RAM:</td><td align="left"><html:text name="UpdateForm" property="ram" value="<%=Integer.toString(assetDetail.getRam())%>" /><html:select name="UpdateForm" property="ramId">
    				<html:option value="1">GB</html:option>
    				<html:option value="2">MB</html:option>
				</html:select>												   </td></tr>  <br>	
			<tr><td align="left">HARD DISK:</td><td align="left"><html:text name="UpdateForm" property="hardDisk" value="<%=Integer.toString(assetDetail.getHarddisk())%>" />							   </td></tr>  <br>
			<tr><td align="left">Other Assets:</td><td align="left"><html:text name="UpdateForm" property="otherAssets" value="<%=assetDetail.getOtherassets()%>" />									   </td></tr>  
			<tr><td></td></tr>
			<tr><td colspan="2">
			<input type="hidden" name="ab" value="2"/>
						<html:submit  value="Submit" />
			<html:reset>Reset</html:reset>
			
			<html:cancel value="Cancel" /></td></tr>
		
	</html:form>
	</table>
	<%
	}  %>

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
