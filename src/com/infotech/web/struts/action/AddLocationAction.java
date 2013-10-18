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

public class AddLocationAction extends Action{

	 public ActionForward execute(
			    ActionMapping mapping,
			    ActionForm form,
			    HttpServletRequest request,
			    HttpServletResponse response) throws Exception{
		 
		 LocationForm locationForm = (LocationForm) form;
    	 
    	 AdminDAO adminDAO = (AdminDAO) ServiceFinder.getContext(request).getBean("AdminDAO");
    	 
    	 int a=Integer.parseInt(request.getParameter("a"));
		 		 
    	 if(isCancelled(request)){
			 return mapping.findForward("cancel");
		 }
		 else{
    	 String floor = locationForm.getFloor();
    //	 int locationId = assetForm.getLocationId();
         String block = locationForm.getBlock();
         String phase = locationForm.getPhase();
         String area = locationForm.getArea();
         String city = locationForm.getCity();
                  
         System.out.println("test9");
         System.out.println(block);
         System.out.println("test10");
         
		  
		adminDAO.addLocation(floor,block,phase,area,city);
		 
		  
		return mapping.findForward("add");
		 
		 }
		 
	 }
}