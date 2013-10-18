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
  
  <body> <%try{ %> 
  	<%@include file="/pages/Header.jsp"%>
  		<br><br><br><br>
			<div align="center"> 
		<% Object a=session.getAttribute("ascId"); %>
			<% if(a!=null){ %>	
		<% String ascid=a.toString(); %>
	<table align="center" cellpadding="1" cellspacing="5">
    <html:form action="/ChangePassword" method="post" onsubmit="return validatePasswordForm(this);">
    <html:javascript formName="PasswordForm" />
    <tr><td colspan="2"><font color="#0080c0"><h4>Telecom OSS Asset Tracking - Change Password</h4></font></td></tr><br>
      		
       	
       		<tr>
       			<td align="left">
       				Associate Id:</td><td align="left"><html:text name="PasswordForm" property="ascid" value="<%=ascid %>" readonly="true"/>
       			</td>
       		</tr> 
			<tr>
				<td align="left">
					Current Password:</td><td align="left"><html:password name="PasswordForm" property="password1" value=""/>                                               </td>
				</tr>  
			<tr>
				<td align="left">
					New Password:</td><td align="left"><html:password name="PasswordForm" property="password2" value="" />
				</td>
			</tr>
			<tr>
				<td align="left">
					Confirm Password:</td><td align="left"><html:password name="PasswordForm" property="password3" value="" />
				</td>
			</tr>	
			<html:errors />	
			<tr><td></td></tr>										  
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
