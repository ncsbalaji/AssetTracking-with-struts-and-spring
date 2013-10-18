package com.infotech.web.struts.action;

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

import com.infotech.hibernate.dao.AdminDAO;
import com.infotech.services.ServiceFinder;

public class DelUserAction extends Action{

	 public ActionForward execute(
			    ActionMapping mapping,
			    ActionForm form,
			    HttpServletRequest request,
			    HttpServletResponse response) throws Exception{
		 
		 AdminDAO adminDAO = (AdminDAO) ServiceFinder.getContext(request).getBean("AdminDAO");
		 
		 if(isCancelled(request)){
			 return mapping.findForward("cancel");
		 }
		 else{
		 
		 DelForm delForm = (DelForm) form;
		 int ascid=0;
		 
		 int[] ascId=delForm.getAscId();
		 
		 for(int i=0;i<ascId.length;i++){
				
				ascid=ascId[i];
				System.out.println(ascid);
		 }
				
		 System.out.println("p1");
		 
		 adminDAO.delUser(ascId);
		 
		 System.out.println("p2");
		 
		 return mapping.findForward("del");
		 }
	 }
}