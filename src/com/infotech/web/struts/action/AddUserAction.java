package com.infotech.web.struts.action;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.infotech.hibernate.Role;
import com.infotech.hibernate.dao.AdminDAO;
import com.infotech.services.ServiceFinder;

public class AddUserAction extends Action{

	 public ActionForward execute(
			    ActionMapping mapping,
			    ActionForm form,
			    HttpServletRequest request,
			    HttpServletResponse response) throws Exception{
		 
		 AdminDAO adminDAO = (AdminDAO) ServiceFinder.getContext(request).getBean("AdminDAO");
		 UserForm userForm = (UserForm) form;
		 ActionMessages errors = new ActionMessages();
		 
		 int a=Integer.parseInt(request.getParameter("a"));
		 if(isCancelled(request)){
			 return mapping.findForward("cancel");
		 }
		 else{
		 int ascId=userForm.getAscId();
		 String ascName=userForm.getAscName();
		 String password=userForm.getPassword();
		 String emailId=userForm.getEmailId();
		 String verticalName=userForm.getVerticalName();
		 int roleId=userForm.getRoleId();
		 
		 boolean val=adminDAO.addUser(ascId,ascName,password,emailId,verticalName,roleId);
		 if(val){ 
		 return mapping.findForward("add");
		 }
		 else{
			 errors.add("invalid",new ActionMessage("error.ascID.exist"));
	           saveErrors(request,errors);
			 List<Role> roleList = adminDAO.getRoleList();
			 request.setAttribute("rolelist", roleList);
			 return mapping.findForward("reload");
		 }
		 
	 }
  }
}