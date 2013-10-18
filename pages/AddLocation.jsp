<%@ page language="java" import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
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
  	<%@include file="/pages/Header.jsp"%><%Object a=session.getAttribute("ascId"); %> 
			<% if(a!=null){ %>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
			<div align="center">
				<table align="center" cellpadding="1" cellspacing="5">
				    <html:form action="/AddLocation" method="post" onsubmit="return validateLocationForm(this);">
				    <html:javascript formName="LocationForm" />
				      	
				       <tr><td colspan="2"><h4><font color="aa0000"><u>Telecom OSS Asset Tracking - Add Location</u></font></h4></td></tr><br>
				       						       		
				       		<tr><td align="left">Floor : </td><td align="left"><html:text name="LocationForm" property="floor" value="" />                         </td></tr>  <br>
							<tr><td align="left">Block : </td><td align="left"><html:text name="LocationForm" property="block" value="" />                         </td></tr>  <br>
							<tr><td align="left">Phase : </td><td align="left"><html:text name="LocationForm" property="phase" value="" />                         </td></tr>  <br>
							<tr><td align="left">Area : </td><td align="left"><html:text name="LocationForm" property="area" value="" />                   </td></tr>  <br>
							<tr><td align="left">City : </td><td align="left"><html:text name="LocationForm" property="city" value="" /> 					</td></tr>
							<tr><td> </td></tr>
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
