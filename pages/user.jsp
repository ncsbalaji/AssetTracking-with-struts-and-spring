
<%@ page language="java" import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Details</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
    <%@include file="/pages/Header.jsp"%>
			<div align="center" style="text-decoration: underline;">
			
			
			
     
    	
    	 <display:table id="data" name="sessionScope.PrintForm.actorList" requestURI="/printAction.do" pagesize="20" export="true" >
           <display:caption>ASSET TRACKING</display:caption>
           <display:column property="ascId" title="Asc Id" sortable="true" />
            <display:column property="ascName" title="Asc Name" sortable="true" />
            <display:column property="emailId" title="Email Id" sortable="true" />
			 <display:column property="verticalName" title="Vertical Name" sortable="true" />
			 <display:column property="assetName" title="Vertical Name" sortable="true" />
			 <display:column property="roleName" title="Role Name" sortable="true" />
			 <display:column property="ipAddress" title="ipaddress" sortable="true" />
			 
			 
			 
            <display:setProperty name="export.excel.filename" value="ActorDetails.xls"/>
            <display:setProperty name="export.pdf.filename" value="ActorDetails.pdf"/>
            <display:setProperty name="export.pdf" value="true" />
        </display:table>
        
        </div>
        <%@include file="/pages/Footer.jsp"%>
    </body>
</html>
