<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="css/style1.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

</head>
<body>
<div id="main">
<%try{ %>
<% int roleId1=Integer.parseInt(session.getAttribute("roleid").toString()); %>
<% if(roleId1==1){ %>
<ul id="css3menu1" class="topmenu">
		<li class="topfirst"><html:link  page="/pages/Details.jsp" title="Home">Home</html:link></li>
			<li class="topmenu"><a href="#" title="CRUD"><span>CRUD</span></a>
			<ul>
				<li><a href="#" title="Add"><span>Add  &#8250;</span></a>
					<ul>
						<li><html:link  page="/Admin.do?method=addUser" title="Add User">Add User</html:link></li>
						<li><html:link  page="/Admin.do?method=addAsset" title="Add Asset">Add Asset</html:link></li>
						<li><html:link  page="/Admin.do?method=addLocation" title="Add Location">Add Location</html:link></li>
					</ul>
				</li>
					
				<li><a href="#" title="Delete"><span>Delete  &#8250;</span></a>
					<ul>
						<li><html:link  page="/Admin.do?method=deleteUser" title="Delete User">Delete User</html:link></li>
					</ul>
				</li>
				<li><a href="#" title="Assign"><span>Assign  &#8250;</span></a>
					<ul>
						<li><html:link page="/Admin.do?method=assignAsset" title="Assign Asset">Assign Asset</html:link></li>
				</ul>
			</li>
			<li><a href="#" title="Assets"><span>Assets &#8250;</span></a>
					<ul>
						<li><html:link page="/Admin.do?method=unassignAssets" title="Unassigned Assets">Unassigned Assets</html:link></li>
				</ul>
			</li>
			</ul>

	</li>
	<li class="topmenu"><html:link page="/Admin.do?method=changePassword" title="ChangePassword">Change Password</html:link></li>
	<li class="toplast"><html:link  page="/pages/Login.jsp" title="Logout">Logout</html:link></li>
	
</ul>

<%} 
 else { %>
<ul id="css3menu1" class="topmenu">



	<li class="topfirst"><html:link  page="/pages/Details.jsp" title="Home">Home</html:link></li>
	<li class="topmenu"><a href="#" title="CRUD"><span>CRUD</span></a>
	<ul>
		<li><a href="#" title="Add"><span>Add  &#8250;</span></a>
			<ul>
				<li><html:link  page="/Admin.do?method=addAsset" >Add Asset</html:link></li>
			</ul>
		</li>
			
		
	</ul>

	</li>
	<li class="topmenu"><html:link page="/Admin.do?method=changePassword" title="ChangePassword">Change Password</html:link></li>
	<li class="toplast"><html:link  page="/pages/Login.jsp" title="Logout">Logout</html:link></li>
	
</ul>
<% } %>
<div align="right">
<% Object aid1=session.getAttribute("ascId"); %>
   	
   	
   <% int roleId3=Integer.parseInt(session.getAttribute("roleid").toString()); %>
   <% if(roleId3==1){ %>
   <font color="aa0000">Welcome <%=aid1 %>, Logged in as Admin</font>
   <% }
   else{ %>
   <font color="aa0000">Welcome <%=aid1 %>, Logged in as User</font>
   <% } %></div>
<%   }
        catch (Exception e){
            out.println("An exception occurred: " + e.getMessage());
        }
    %>
</div>
</body>
</html>