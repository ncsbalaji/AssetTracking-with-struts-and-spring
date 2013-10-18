<%@ page language="java" import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page language="java" import="com.infotech.hibernate.Role" %>
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
  		<div align="center"> 
		<% Object a=session.getAttribute("ascId"); %>
			<% if(a!=null){ %>	
			 
			<%  Role r=null; 
    			List<Role> list = (List<Role>) request.getAttribute("rolelist");
    		%> 
    		<table align="center" cellpadding="1" cellspacing="5">
    		
				    <html:form action="/AddUser" method="post" onsubmit="return validateUserForm(this);">
				    	<html:javascript formName="UserForm" />
				       	    <tr><td colspan="2"><h4><font color="aa0000"><u>Telecom OSS Asset Tracking - Add User</u></font></h4></td></tr><br>
				       		<tr><td align="left">Associate Id:</td><td align="left"><html:text name="UserForm" property="ascId" value=""/>                   </td><td align="center" colspan="2"><font color="red"><html:errors/></font></td></tr>  <br> 
							<tr><td align="left">Associate Name:</td><td align="left"><html:text name="UserForm" property="ascName" value=""/>               </td></tr>  <br>
							<tr><td align="left">Password:</td><td align="left"><html:password name="UserForm" property="password" value="" size="21"/>                    </td></tr>  <br>
							<tr><td align="left">Email Id:</td><td align="left"><html:text name="UserForm" property="emailId" value=""/>                     </td></tr>  <br>
							<tr><td align="left">Vertical name:</td><td align="left"><html:text name="UserForm" property="verticalName" value=""/>               </td></tr>  <br>
							<tr><td align="left">Role:</td><td align="left"><html:select name="UserForm" property="roleId" value="">
							<html:option value="">--select--</html:option>
							
							
		       			 <%	Iterator<Role> it = list.iterator();
							while(it.hasNext()) {
							r = it.next(); 
						%>
				       		<html:option value="<%=Integer.toString(r.getRoleid())%>"><%=r.getRolename()%></html:option>
						<% } %>	
		       			</html:select>									   </td></tr>
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
