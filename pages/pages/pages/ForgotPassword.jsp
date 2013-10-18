<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0//EN"> 
<html>
	<head><link rel="stylesheet" type="text/css" href="style.css"/>
		<title>Welcome to Infotech Asset Tracking</title>
	</head>
	<body> <%try{ %> 
		<%@include file="/pages/LoginHeader.jsp"%>
			<div align="center">
				<br><br><br><br><br><br><br><br><br><br>
				<img src="pages/Laptop.jpg" alt="Laptop" width="200" height="200" />
				<br><br><br><br><br><br>





				<font size="20" color="red">Under construction</font>
			</div>
		<%@include file="/pages/Footer.jsp"%>
		<%   }
        catch (Exception e){
            out.println("An exception occurred: " + e.getMessage());
        }
    %>

	</body>
</html>