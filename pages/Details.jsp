<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0//EN"> 
<html>
	<head><link rel="stylesheet" type="text/css" href="style.css"/>
		<title>Welcome to Infotech Asset Tracking</title>
			<script type="text/javascript">
				window.history.forward(-1);
			</script>

		
	</head>
	<body background="pages/a.jpg"> <%try{ %> 
			<% Object a=session.getAttribute("ascId"); %>
			<% if(a!=null){ %>
			<%@include file="/pages/Header.jsp"%>
			<div align="center">
			<br><br><br><br><br><br>
		<h4><font color="aa0000"><u>Telecom OSS Asset Tracking - Select Asset Type</u></font></h4>
					<html:form action="/AssetDetails" method="post">					
						<input type="hidden" name="ab" value="1"/>
						<html:submit  value="Desktop" />
					</html:form>
					<html:form action="/AssetDetails" method="post">
						<input type="hidden" name="ab" value="2"/>
						<html:submit  value=" Laptop " />
					</html:form>
					<html:form action="/AssetDetails" method="post">
						<input type="hidden" name="ab" value="-1"/>
						<html:submit  value="    All    " />
					</html:form>
					
				</div>
			
	 
	   
	   		
	   		
	    
	  <%  } 
	  	
	   else { 
	  	response.sendRedirect("Login.jsp");
	   } %>
			<%@include file="/pages/Footer.jsp"%>
	     <%   }
        catch (Exception e){
            out.println("An exception occurred: " + e.getMessage());
        }
    %>

    </body>
</html>