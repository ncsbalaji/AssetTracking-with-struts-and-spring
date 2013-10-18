<%@ page language="java" import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
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
  		<br><br>
			<div align="center">
			<%try{ %>
			<% Object a=session.getAttribute("ascId"); %>
			<% if(a!=null){%>
			<% int b=Integer.parseInt(a.toString()); 
			out.println(b);%> 
			
			<% int roleId=Integer.parseInt(session.getAttribute("roleid").toString());out.println(roleId);out.println("..");%>	
    		<%  Assetdetails ads=new Assetdetails(); out.println(ads);out.println("t1");
    	
    	List<Assetdetails> list = (List<Assetdetails>) request.getAttribute("aDDetails");
    	out.println(request.getAttribute("aDDetails"));out.println("t2");
    	
    	%>   
    	<% int assettypeid=Integer.parseInt(request.getParameter("ab"));
    	out.println("..");
    	out.println(assettypeid);%> 
    	
    	<% if(assettypeid==1){   %>
				<font color="#0080c0"><h4>Telecom OSS Asset Tracking - Desktop</h4></font>
    	<table border="1">
    		<tr>
    			<th>Associate ID</th>
    			<th>Associate Name</th>
    			<th>Location</th>
    			<th>Desktop Model</th>
    			<th>Computer Name</th>
    			<th>IP Address</th>
    			<th>Monitor Tracking Number</th>
    			<th>CPU Tracking Number</th>
    			<th>RAM</th>
    			<th>Hard Disk</th>
    			<th>Other Assets</th>
    			<th>Update</th>
    			<th>Delete</th>
    		</tr>
    <%	Iterator<Assetdetails> it = list.iterator();
			while(it.hasNext()) {
				ads = it.next(); 
				if(ads.getLogin().getAscid()>0){
	%>		<html:form action="/UpdateDelete" method="post">
				<tr>
					<%int ram=ads.getRam();%>
					<%int ascid=ads.getLogin().getAscid(); %>
					<td><%= ads.getLogin().getAscid()%></td>
					<td><%= ads.getLogin().getAscname()%></td>
					<td><%= ads.getLocation().getLocationname() %></td>
					<td><%= ads.getModel()%></td>
					<td><%= ads.getCompname()%></td>
					<td><%= ads.getIpaddress()%></td>
					<td><%= ads.getMonitortrackingnumber()%></td>
					<td><%= ads.getTrackingnumber()%></td>
					<td><%=ram %>
					<% if(ram<10){ %>GB<% } 
					else{ %> MB <% } %></td>
					<td><%= ads.getHarddisk()%></td>
					<td><%= ads.getOtherassets()%></td>										
					
    	
				   <%if(roleId==1){ %>
						<td><input type="hidden" id="assetid" name="updateAssetID" value="<%= ads.getAssetid()%>"/>
						<html:submit  property="method" value="update">update</html:submit></td>
						<td><input type="hidden" id="assetid" name="deleteAssetID" value="<%= ads.getAssetid()%>"/>
					    <html:submit  property="method" value="delete">delete</html:submit></td>
	    		   <% }
				   else if(b==ascid){ %>
					  <td><input type="hidden" id="assetid" name="updateAssetID" value="<%= ads.getAssetid()%>"/>
		  			  <html:submit  property="method" >update</html:submit></td>
				   <%} 
				   else{
				   }%>
				
					
					
					
				</tr> </html:form>
				
	               <%		}	} %> 
	    </table>
	    <% } %>
	
	
	<% if(assettypeid==2){   %>
				<font color="#0080c0"><h4>Telecom OSS Asset Tracking - Laptop</h4></font>
    	<table border="1">
    		<tr>
    			<th>Associate ID</th>
    			<th>Associate Name</th>
    			<th>Location</th>
    			<th>Desktop Model</th>
    			<th>Computer Name</th>
    			<th>IP Address</th>
    			<th>Monitor Tracking Number</th>
    			<th>Laptop Tracking Number</th>
    			<th>RAM</th>
    			<th>Hard Disk</th>
    			<th>Other Assets</th>
    			<th>Update</th>
    			<th>Delete</th>
    		</tr>
    <%	Iterator<Assetdetails> it = list.iterator();
			while(it.hasNext()) {
				ads = it.next(); 
				if(ads.getLogin().getAscid()>0){
	%>		<html:form action="/UpdateDelete">
				<tr>
					<%int ram=ads.getRam();%>
					<%int ascid=ads.getLogin().getAscid(); %>
					<td><%= ads.getLogin().getAscid()%></td>
					<td><%= ads.getLogin().getAscname()%></td>
					<td><%= ads.getLocation().getLocationname() %></td>
					<td><%= ads.getModel()%></td>
					<td><%= ads.getCompname()%></td>
					<td><%= ads.getIpaddress()%></td>
					<td><%= ads.getMonitortrackingnumber()%></td>
					<td><%= ads.getTrackingnumber()%></td>
					<td><%=ram %>
					<% if(ram<10){ %>GB<% } 
					else{ %> MB <% } %></td>
					<td><%= ads.getHarddisk()%></td>
					<td><%= ads.getOtherassets()%></td>										
					
   					<%if(roleId==1){ %>
						<td><input type="hidden" id="assetid" name="updateAssetID" value="<%= ads.getAssetid()%>"/>
						<html:submit  property="method" >update</html:submit></td>
						<td><input type="hidden" id="assetid" name="deleteAssetID" value="<%= ads.getAssetid()%>"/>
					    <html:submit  property="method" >delete</html:submit></td>
	    		   <% }
				   else if(b==ascid){ %>
					  <td><input type="hidden" id="assetid" name="updateAssetID" value="<%= ads.getAssetid()%>"/>
		  			  <html:submit  property="method" >update</html:submit></td>
				   <%} 
				   else{
				   }%>
					
				</tr> </html:form>
	<%		}	} %> 
	</table>
	<% } %>
	
	<% if (assettypeid==-1) {   %>
				<font color="#0080c0"><h4>Telecom OSS Asset Tracking - Desktop and Laptop</h4></font>
    	<table border="1">
    		<tr>
    			<th>Associate ID</th>
    			<th>Associate Name</th>
    			<th>Location</th>
    			<th>Desktop Model</th>
    			<th>Computer Name</th>
    			<th>IP Address</th>
    			<th>Monitor Tracking Number</th>
    			<th>CPU Tracking Number</th>
    			<th>RAM</th>
    			<th>Hard Disk</th>
    			<th>Other Assets</th>
    			<th>AssetType</th>
    			<th>Update</th>
    			<th>Delete</th>
    			
    		</tr>
    <%	Iterator<Assetdetails> it = list.iterator();
			while(it.hasNext()) {
				ads = it.next(); 
				if(ads.getLogin().getAscid()>0){
	%>		<html:form action="/UpdateDelete">
				<tr>
					<%int ram=ads.getRam();%>
					<%int ascid=ads.getLogin().getAscid(); %>
					<td><%= ads.getLogin().getAscid()%></td>
					<td><%= ads.getLogin().getAscname()%></td>
					<td><%= ads.getLocation().getLocationname() %></td>
					<td><%= ads.getModel()%></td>
					<td><%= ads.getCompname()%></td>
					<td><%= ads.getIpaddress()%></td>
					<td><%= ads.getMonitortrackingnumber()%></td>
					<td><%= ads.getTrackingnumber()%></td>
					<td><%=ram %>
					<% if(ram<10){ %>GB<% } 
					else{ %> MB <% } %></td>
					<td><%= ads.getHarddisk()%></td>
					<td><%= ads.getOtherassets()%></td>
					<td><%= ads.getAssettype().getAssettypename()%></td>										
					
					<%if(roleId==1){ %>
						<td><input type="hidden" id="assetid" name="updateAssetID" value="<%= ads.getAssetid()%>"/>
						<html:submit  property="method" >update</html:submit></td>
						<td><input type="hidden" id="assetid" name="deleteAssetID" value="<%= ads.getAssetid()%>"/>
					    <html:submit  property="method" >delete</html:submit></td>
	    		   <% }
				   else if(b==ascid){ %>
					  <td><input type="hidden" id="assetid" name="updateAssetID" value="<%= ads.getAssetid()%>"/>
		  			  <html:submit  property="method" >update</html:submit></td>
				   <%} 
				   else{
				   }%>
					
					
				</tr> </html:form>
	<%		}	} %> 
	</table>
	<% } %>
			
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
