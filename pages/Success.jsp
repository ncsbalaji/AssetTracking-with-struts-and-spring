<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0//EN"> 
<html>
	<head><link rel="stylesheet" type="text/css" href="style.css"/>
		<title>Welcome to Infotech Asset Tracking</title>
	</head>
	<body>
			<%@include file="/pages/Header.jsp"%>
			<div align="center">
			<br><br><br><br><br><br><br><br><br><br>
					<html:form action="/Login" method="post">
						<html:submit value="Desktop" /><html:submit value="Laptop" /><html:submit value="All" />
					</html:form>
				</div>
		<%@include file="/pages/Footer.jsp"%>
	   Welcome <bean:write name="LoginForm" property="ascId"></bean:write>
	  
    </body>
</html>