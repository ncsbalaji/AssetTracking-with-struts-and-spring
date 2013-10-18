package com.infotech.web.struts.action;

import java.awt.Window;

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

import com.infotech.hibernate.dao.LoginDAO;
import com.infotech.services.ServiceFinder;

public class LoginAction  extends Action{

	 public ActionForward execute(
			    ActionMapping mapping,
			    ActionForm form,
			    HttpServletRequest request,
			    HttpServletResponse response) throws Exception{
			System.out.println("te2");
		 		System.out.println("valid1");
	       
		      //Retrieve the DAO Reference
		  	  LoginDAO loginDAO = (LoginDAO) ServiceFinder.getContext(request).getBean("LoginDao");
		  	  
		  	  HttpSession session = request.getSession();
		  	  // Create object of ActionMesssages
		      ActionMessages errors = new ActionMessages();
		  	  
		      System.out.println("valid2");
		      
		      LoginForm objForm = (LoginForm) form;
		      
		       
		      int ascId=objForm.getAscId();
		      	  
		      String password=objForm.getPassword();
		      
		      boolean valid= loginDAO.getAscIdList(ascId);
		      
		     
		      if(valid){
		    	  System.out.println("login action true");
		      int roleId=loginDAO.getRole(ascId);
		      
		      boolean loginStatus = loginDAO.loadUser(ascId,password);
		      
		      if(loginStatus==true) {
		    	  
		    	  session.setAttribute("ascId", request.getParameter("ascId"));
		    	  session.setAttribute("roleid",roleId);
		    	  System.out.println("hi:"+roleId);
		    	  
		    	  return mapping.findForward("success");
      		  }
		      else {
		    	  
		    	  objForm.setError1("Wrong Associate Id or password");	              	  
		    	  /*errors.add("login",new ActionMessage("error.login.invalid"));
		          saveErrors(request,errors);*/		      	   
		          return mapping.findForward("success");
		          
		     }	
		  }
		      else{
		    	  System.out.println("login action false");
		       	  objForm.setError("No Associate is present with that Associate Id");
		    	  return mapping.findForward("success");
		      }
	 }
}
