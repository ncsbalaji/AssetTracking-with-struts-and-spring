
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0//EN"> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
	<head><link rel="stylesheet" type="text/css" href="css/style.css"/>
		<title>Welcome to Infotech Asset Tracking</title>
		

	</head>
	<body> <%try{ %> 
	<table border="0" width="100%" cellpadding="0" cellspacing="0"> 
<tr>
						     
  </tr>
 
          <tr>
				<td align="center" bgcolor="Green" width="25%">
 
					
					<a href="pages\Details.jsp"> Home</a>
					
					</td>
 
 					<% int roleId1=Integer.parseInt(session.getAttribute("roleid").toString()); %>
 					<%if(roleId1==1){ %>
                    <td bgcolor="Green" align="center" width="25%">
                    
 						
						 
                        <html:link page="/Admin.do?method=addUser"><font color="white">Add User</font></html:link>
                       
					</td>
					<% } %>
					
					<td bgcolor="Green" align="center" width="25%">
					
					<html:link page="/Admin.do?method=addAsset">Add Asset</html:link>
					
					</td>
					
					<td bgcolor="Green" align="center" width="25%">
 						
						 
                        <html:link page="/Admin.do?method=changePassword"><font color="white">Change Password</font></html:link>
                       
					</td>
                 
 
				   
 
					<td width="25%" align="center" bgcolor="Green">
 
                       
											
						<html:link page="/Login.jsp"><font color="white">Logout</font></html:link>
                        
					</td>
 
									
				   			
           </tr>
			
<tr> <td colspan="4">&nbsp;</td></tr>
</table>
	<%   }
        catch (Exception e){
            out.println("An exception occurred: " + e.getMessage());
        }
    %>
	</body>
</html>



