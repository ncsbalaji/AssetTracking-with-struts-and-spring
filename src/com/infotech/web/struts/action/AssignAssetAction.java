package com.infotech.web.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.infotech.hibernate.dao.AdminDAO;
import com.infotech.hibernate.dao.AssetDetailsDAO;
import com.infotech.services.ServiceFinder;

public class AssignAssetAction extends Action {
	
	public ActionForward execute(
		    ActionMapping mapping,
		    ActionForm form,
		    HttpServletRequest request,
		    HttpServletResponse response) throws Exception{
		System.out.println("Assigning Asset Action");
		 if(isCancelled(request)){
			 System.out.println("Assigning Asset Action-->cancel");
			 return mapping.findForward("cancel");
		 } else {
			 
			 AssignAssetForm assignAssetForm = (AssignAssetForm) form;
		 int assetId=assignAssetForm.getAssetId();
		 int ascId = assignAssetForm.getAscId();
		 
		 System.out.println("Assigning Asset Action"+assetId+","+ascId);

		 AssetDetailsDAO assetDetailsDAO = (AssetDetailsDAO) ServiceFinder.getContext(request).getBean("AssetDetailsDAO");
		 
		 assetDetailsDAO.assignAsset(assetId,ascId);

     	 System.out.println("AssignAssetAction--end");
	 
     	 return mapping.findForward("assign");
	 
 }

	}	

}
