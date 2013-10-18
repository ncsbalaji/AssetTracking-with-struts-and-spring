<%@ page language="java" import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page language="java" import="com.infotech.hibernate.Login" %>
<%@ page language="java" import="com.infotech.hibernate.Assetdetails" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0//EN"> 
<html>
	<head><link rel="stylesheet" type="text/css" href="style.css"/>
		<title>Welcome to Infotech Asset Tracking</title>
		<script type="text/javascript">
			window.history.forward(-1);
		</script>
	</head>

  <body>
  	<%@include file="/pages/Header.jsp"%>
  		<br><br><br><br>
			<div align="center">
			<%try{ %> 
		<% Object a=session.getAttribute("ascId"); %>
			<% if(a!=null){ %>	
				<%  Login lg=null; 
    		 		List<Login> list1 = (List<Login>) request.getAttribute("loginlist"); 
    				Assetdetails ad=null; 
    		 		List<Assetdetails> list2 = (List<Assetdetails>) request.getAttribute("TempAssetDetails"); 
    			%>
				<h4><font color="aa0000"><u>Telecom OSS Asset Tracking - Assign Asset to User</u></font></h4>
    			
				
				    <html:form action="/AssignAsset" method="post" onsubmit="return validateAssignAssetForm(this);">
				    	<html:javascript formName="AssignAssetForm" />
				    	<table align="center" border="1">
				    <tr><td align="left">Associate Id:</td><td align="left"><html:select name="AssignAssetForm" property="ascId" value="">
      				<html:option value="">--select--</html:option>
				       	
				       		 <%	Iterator<Login> it = list1.iterator();
					while(it.hasNext()) {
					lg = it.next();   if(lg.getAscid()>0){
				%>
		       		
		       		<html:option value="<%=Integer.toString(lg.getAscid())%>"><%=lg.getAscid()%></html:option>
				<% } } %>	
				</html:select>									   </td></tr>
				</table><br>
				<table align="center">
					<tr><th><u><font size="4" color="aa0000">Assets</font></u></th></tr>
				</table><br>
				<table align="center" border="1">
				<tr><th>Choose</th>
				<th>Asset Type</th>
				<th>Desktop/Laptop Model</th>
				<th>Computer/Laptop Name</th>
				<th>IP Address</th>
				<th>Monitor Tracking Number</th>
				<th>CPU/Laptop Tracking Number</th>
				<th>Ram</th>
				<th>HardDisk</th>
				<th>Other Assets</th></tr>
				<%	Iterator<Assetdetails> it = list2.iterator();
				while(it.hasNext()) {
				ad = it.next(); %>
				<tr><td><html:radio name="AssignAssetForm" property="assetId" value="<%=Integer.toString(ad.getAssetid())%>">
					<%int ram=ad.getRam();%>
					<td><%=ad.getAssettype().getAssettypename()%></td>
					<td><%= ad.getModel()%></td>
					<td><%= ad.getCompname()%></td>
					<td><%= ad.getIpaddress()%></td>
					<td><%= ad.getMonitortrackingnumber()%></td>
					<td><%= ad.getTrackingnumber()%></td>
					<td><%=ram %>
					<% if(ram<10){ %>GB<% } 
					else{ %> MB <% } %></td>
					<td><%= ad.getHarddisk()%></td>
					<td><%= ad.getOtherassets()%></td>
					</html:radio>
				</td></tr>
				<%}%></table><br>
       				<table>
       						<tr><td></td></tr>
							<tr><td colspan="2"><html:submit value="Assign"/>	
							<html:reset>Reset</html:reset>
							<html:cancel value="Cancel"/></td></tr>
						</table>
									
					</html:form>
				
      
    
    <%  } 
	   else { 
	  	response.sendRedirect("Login.jsp");
	   } %>
	   
	   <%   }
        catch (Exception e){
            out.println("An exception occurred: " + e.getMessage());
        }
    %>
			</div>
		<%@include file="/pages/Footer.jsp"%>
  </body>
</html>
