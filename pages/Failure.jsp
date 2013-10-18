<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html>
     <body>
        Wrong
		Username and password are different.<bean:write name="LoginForm" property="ascId"></bean:write>
		<bean:write name="LoginForm" property="error1"></bean:write>
      </body>
</html>
