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

import com.infotech.hibernate.Assetdetails;
import com.infotech.hibernate.dao.AssetDetailsDAO;
import com.infotech.hibernate.dao.LoginDAO;
import com.infotech.services.ServiceFinder;

public class DeleteAction  extends Action{

	 public ActionForward execute(
			    ActionMapping mapping,
			    ActionForm form,
			    HttpServletRequest request,
			    HttpServletResponse response) throws Exception{
			
			 if(isCancelled(request)){
				 int assetTypeID=Integer.parseInt(request.getParameter("ab"));
				 AssetDetailsDAO assetDetailsDAO1 = (AssetDetailsDAO) ServiceFinder.getContext(request).getBean("AssetDetailsDAO");
				 List<Assetdetails> assetDetails = assetDetailsDAO1.getAssetdetails(assetTypeID,-1);
			     request.setAttribute("aDDetails", assetDetails);
				 return mapping.findForward("cancel");
			 } 
			 else{
				 UpdateForm updateForm = (UpdateForm) form;
			//int assetID=assetForm.getAssetId();
		 	int ascId=updateForm.getAscId();
			int assetTypeID=Integer.parseInt(request.getParameter("ab"));
			
	   	 /*int ascId = assetForm.getAscId();
	   	   int assetTypeID=Integer.parseInt(request.getParameter("ab"));*/
			
			System.out.println("a");
			AssetDetailsDAO assetDetailsDAO = (AssetDetailsDAO) ServiceFinder.getContext(request).getBean("AssetDetailsDAO");
			assetDetailsDAO.deleteAsset(ascId);
			System.out.println("b");
			
			AssetDetailsDAO assetDetailsDAO1 = (AssetDetailsDAO) ServiceFinder.getContext(request).getBean("AssetDetailsDAO");
			 ActionMessages errors = new ActionMessages();
			
			 System.out.println("c");
			 List<Assetdetails> assetDetails = assetDetailsDAO1.getAssetdetails(assetTypeID,-1);
		     request.setAttribute("aDDetails", assetDetails);
		     System.out.println("d");
		     
			
			return mapping.findForward("delete");
			 }
		  	 
	 }
}
