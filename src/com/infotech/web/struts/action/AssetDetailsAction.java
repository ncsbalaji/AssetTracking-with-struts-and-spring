package com.infotech.web.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.infotech.hibernate.Assetdetails;
import com.infotech.hibernate.dao.AssetDetailsDAO;
import com.infotech.services.ServiceFinder;

public class AssetDetailsAction extends Action{
	public ActionForward execute(
		    ActionMapping mapping,
		    ActionForm form,
		    HttpServletRequest request,
		    HttpServletResponse response) throws Exception{
		
		 System.out.println("In AssetDetailsAction");
		
		 AssetDetailsDAO assetDetailsDAO = (AssetDetailsDAO) ServiceFinder.getContext(request).getBean("AssetDetailsDAO");
		 ActionMessages errors = new ActionMessages();
		 
		 int a=Integer.parseInt(request.getParameter("ab"));
		 
		 System.out.println("In AssetDetailsAction-1");		 		 
		 List<Assetdetails> assetDetails = assetDetailsDAO.getAssetdetails(a, -1);
		 System.out.println("In AssetDetailsAction-2");		 
	     request.setAttribute("aDDetails", assetDetails);   
	     System.out.println("In AssetDetailsAction-2");	
	    
	    return mapping.findForward("ddetails");
	    
	}
}
