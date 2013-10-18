<%@ page language="java" import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page language="java" import="com.infotech.hibernate.Login" %>
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
  		<br><br><br><br>
			<div align="center"> 
		<% Object a=session.getAttribute("ascId"); %>
			<% if(a!=null){ 
			int b=Integer.parseInt(a.toString());;%>	
				<%  Login lg=null; 
    		 		List<Login> list1 = (List<Login>) request.getAttribute("loginlist"); 
    			%>
&nbsp;&nbsp;&nbsp;&nbsp;<h4><font color="aa0000"><u>Telecom OSS Asset Tracking - Delete User(S)</u></font></h4>
    			<table align="center" cellpadding="1" cellspacing="5" border="0">
				
				    <html:form action="/DelUser" method="post" onsubmit="return validateDelForm(this);">
				    <html:javascript formName="DelForm" />
				       	
				       		 <%	Iterator<Login> it = list1.iterator();
					while(it.hasNext()) {
					lg = it.next();   if(lg.getAscid()>0){
						if(lg.getAscid()!=b){
				%>
		       		<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td align="left"><html:checkbox name="DelForm" property="ascId" value="<%=Integer.toString(lg.getAscid())%>"><%=lg.getAscid()%>
				</html:checkbox><% } }} %>	
       				</td><td></td></tr>
       						<tr><td></td></tr>
							<tr><td colspan="2"><html:submit value="Delete" onclick="return confirmSubmit()"/>	
							<html:reset>Reset</html:reset>
							<html:cancel value="Cancel"/></td></tr>
						
									
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
