package com.infotech.web.struts.action;

import java.util.Iterator;
import java.util.List;

import com.infotech.web.struts.action.UserForgetPasswordForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionMessage;

import com.infotech.hibernate.Login;
import com.infotech.hibernate.dao.AdminDAO;
import com.infotech.hibernate.dao.LoginDAO;
import com.infotech.services.*;

public class UserForgetPasswordAction extends Action
{
  public ActionForward execute(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response) throws Exception{
	  
	  System.out.println("UserForgetPasswordAction-->start");
	  
	  //Retrieve the DAO Reference
	  AdminDAO adminDAO = (AdminDAO) ServiceFinder.getContext(request).getBean("AdminDAO");

//		Retrieve the DAO Reference
	  com.infotech.web.common.SendMail mailBean = (com.infotech.web.common.SendMail) ServiceFinder.getContext(request).getBean(roseindia.web.common.ProjectConstants.MAIL_BEAN);

	  
     //	Create object of ActionMesssages
      ActionMessages errors = new ActionMessages();
	  
      UserForgetPasswordForm forgetform = (UserForgetPasswordForm) form;
       
      Login log=null;
      String password;
      
	  int ascid=forgetform.getAscid();
	  String ascname;
	  String strEmailid=forgetform.getEmailid();
      String[] reciepent = new String[3];  
     
      List<Login> lg = adminDAO.retriveUserForgetPassword(ascid,strEmailid);
      
      Iterator<Login> it = lg.iterator();
		while(it.hasNext()) {
			log = it.next(); 
			System.out.println("UserForgetPasswordAction-->In iterator while");
		      password=log.getPassword();
		      ascname=log.getAscname();
      
		      reciepent[0]=log.getPassword();
				
		      reciepent[1]=log.getEmailid();
	 		
		      reciepent[2]=log.getAscname();
	   
	  
	   	   String subject="Your username & password "; 
		   String message="Hi,"+ascname;
		   message+="\n Your username is "+ascname+".";
		   message+="\n Your password is "+password+".";
		   message+="\n Please login to the web site with your ascid and password.";
		   message+="\n \n Thanks";
		   message+="\n \n \n Regards";
		   
		
		   // getting from emailid from allcooljobs.web.common.CollJobsConstants
		   
		   String from=com.infotech.web.common.ProjectConstants.FROM_MAIL;

		   try{
			   System.out.println("UserForgetPasswordAction-->In try");
			   mailBean.sendMail(reciepent,subject,message,from);
		   
		   }catch(Exception e){
				  System.out.println("Error in sending mail:"+e);
		   }
		}   
		System.out.println("UserForgetPasswordAction-->end");
		   return mapping.findForward("success");
       
      
	  
  }
}