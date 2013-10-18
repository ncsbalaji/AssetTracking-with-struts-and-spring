package com.infotech.web.struts.action;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;


import com.infotech.hibernate.Assetdetails;
import com.infotech.hibernate.Location;
import com.infotech.hibernate.dao.AdminDAO;
import com.infotech.hibernate.dao.AssetDetailsDAO;
import com.infotech.services.ServiceFinder;

public class UpdateDeleteAction extends DispatchAction {

	
	public ActionForward update(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	
		System.out.println("uda1");
    	ActionMessages errors = new ActionMessages();
    	String retString = null;
    	String assetID = request.getParameter("updateAssetID");
    	AssetDetailsDAO assetDetailsDAO = (AssetDetailsDAO) ServiceFinder.getContext(request).getBean("AssetDetailsDAO");
    	List<Assetdetails> assetDetail = assetDetailsDAO.getAssetdetails(-1, Integer.parseInt(assetID));
    	System.out.println("uda2");
    	AdminDAO adminDAO = (AdminDAO) ServiceFinder.getContext(request).getBean("AdminDAO");
    	List<Location> locationList = adminDAO.getLocationList();
		request.setAttribute("locationlist", locationList);
		System.out.println("uda3");
    	if(assetDetail.size() == 1 ) {    		
    			Iterator<Assetdetails> iterator = assetDetail.iterator();
    			request.setAttribute("assetDetail", iterator.next());
    			retString = "update";
		} else {		              	  
	    	  errors.add("login",new ActionMessage("error.assetDetail.invalidID"));
	          saveErrors(request,errors);		      	   
	          retString = "failure";
	    }	
    	
    	return mapping.findForward(retString);
    }
	public ActionForward delete(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		
		ActionMessages errors = new ActionMessages();
    	String retString = null;
		String assetID = request.getParameter("deleteAssetID");
		
    	AssetDetailsDAO assetDetailsDAO = (AssetDetailsDAO) ServiceFinder.getContext(request).getBean("AssetDetailsDAO");
    	List<Assetdetails> assetDetail = assetDetailsDAO.getAssetdetails(-1, Integer.parseInt(assetID));
    	System.out.println("In UpdateDeleteAction delete");
    	if(assetDetail.size() == 1 ) {    		
			Iterator<Assetdetails> iterator = assetDetail.iterator();
			request.setAttribute("assetDetail", iterator.next());
			retString = "delete";
	} else {		              	  
    	  errors.add("login",new ActionMessage("error.assetDetail.invalidID"));
          saveErrors(request,errors);		      	   
          retString = "failure";
    }	
    	
    	return mapping.findForward(retString);
 
	}
    
    
}
