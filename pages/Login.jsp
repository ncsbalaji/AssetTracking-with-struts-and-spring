<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@page import="java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0//EN"> 
<html>
	<head><link rel="stylesheet" type="text/css" href="style.css"/>
		<title>Welcome to Infotech Asset Tracking</title>
		
		
	</head>
	<body>

		
	 <%try{ %> 
			<%@include file="/pages/LoginHeader.jsp"%>
			<div align="center">
			<% session.removeValue("ascId"); %>
				<br><br><br><br><br><br><br><br><br><br>
				<img src="pages/Laptop.jpg" alt="Laptop" width="200" height="200" />
				<br><br>
				<html:form action="/AssetSelection" method="post" onsubmit="return validateLoginForm(this);">
					<html:javascript formName="LoginForm" />
				
				<table align="center">
                <tr>
                    <td align="left">
                        Associate Id:
                    </td>
                    <td align="left">
                        <html:text name="LoginForm" property="ascId" value="" size="15"/>
                    </td>
                </tr><bean:write name="LoginForm" property="error"></bean:write>
                <tr>
                    <td align="left">
                        Password:
                    </td>
                    <td align="left">
                        <html:password name="LoginForm" property="password" value="" size="16"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                       &nbsp;&nbsp; <html:submit value="Login" /></td> 
					<td><a href="pages/ForgotPassword.jsp"><font color="red">&#8594;Forgot Password</font></a>
                    </td>
                </tr>
               
            </table>
			
				</html:form>
			</div>
		<%@include file="/pages/Footer.jsp"%>
			<%   }
        catch (Exception e){
            out.println("An exception occurred: " + e.getMessage());
        }
    %>
	</body>
</html>



