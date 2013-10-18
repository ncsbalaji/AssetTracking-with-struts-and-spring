package com.infotech.web.struts.action;

import javax.servlet.ServletRequest;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.infotech.hibernate.Assetdetails;
import com.infotech.hibernate.dao.AdminDAO;
import com.infotech.services.ServiceFinder;

public class ChangePasswordAction extends Action{

	 public ActionForward execute(
			    ActionMapping mapping,
			    ActionForm form,
			    HttpServletRequest request,
			    HttpServletResponse response) throws Exception{
		 
		 AdminDAO adminDAO = (AdminDAO) ServiceFinder.getContext(request).getBean("AdminDAO");
		 
		 PasswordForm passwordForm = (PasswordForm) form;
		 if(isCancelled(request)){
			 return mapping.findForward("cancel");
		 }
		 else{
		 int a=Integer.parseInt(request.getParameter("a"));
		 System.out.println("a "+a);
		 
		 if(a==1){
			 
		 int ascid=passwordForm.getAscid();
		 System.out.println(ascid);
		 String password1=passwordForm.getPassword1();
		 String password2=passwordForm.getPassword2();
		 String password3=passwordForm.getPassword3();
		 System.out.println("pa1");
		 System.out.println(password1);
		 boolean a1=adminDAO.changePassword(ascid,password1,password2,password3);
		 System.out.println("pa2");
		 
		 if(a1)
			 return mapping.findForward("true");
		 else
			 return mapping.findForward("false");
		 }
		 else{
			 return mapping.findForward("cancel");
		 }
		 }
	 }
	 }