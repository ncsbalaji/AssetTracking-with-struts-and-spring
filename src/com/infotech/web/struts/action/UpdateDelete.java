package com.infotech.web.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import com.infotech.hibernate.Assetdetails;
import com.infotech.hibernate.dao.AssetDetailsDAO;

import com.infotech.services.ServiceFinder;

public class UpdateDelete extends DispatchAction {
	public ActionForward update(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	 AssetForm assetForm = (AssetForm) form;
    	 
    	 int assetID=assetForm.getAssetId();
    	 int ascId = assetForm.getAscId();
    	 String ascName = assetForm.getAscName();
    	 int assetTypeID=Integer.parseInt(request.getParameter("ab"));
    	 int locationId = assetForm.getLocationId();
         String model = assetForm.getModel();
         String computername = assetForm.getComputername();
         String ipAddress = assetForm.getIpAddress();
         String monitorTrackingNumber = assetForm.getMonitorTrackingNumber();
         String cpuTrackingNumber = assetForm.getCpuTrackingNumber();
         int ram = assetForm.getRam();
         int hardDisk = assetForm.getHardDisk();
         String otherAssets = assetForm.getOtherAssets();
         
         
         
         AssetDetailsDAO assetDetailsDAO = (AssetDetailsDAO) ServiceFinder.getContext(request).getBean("AssetDetailsDAO");
         assetDetailsDAO.updateAsset(assetTypeID,assetID,ascId, ascName, locationId, model, computername, ipAddress, monitorTrackingNumber, cpuTrackingNumber, ram, hardDisk, otherAssets);
         
         
         
      AssetDetailsDAO assetDetailsDAO1 = (AssetDetailsDAO) ServiceFinder.getContext(request).getBean("AssetDetailsDAO");
		 /*ActionMessages errors = new ActionMessages();*/
      	 System.out.println("In updatedelete-1");
		 List<Assetdetails> assetDetails = assetDetailsDAO1.getAssetdetails(assetTypeID,-1);
		 System.out.println("In updatedelete-2");
	     request.setAttribute("Details1", assetDetails);   
         
        return mapping.findForward("update");
    }
	
	public ActionForward delete(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		AssetForm assetForm = (AssetForm) form;
		int ascId = assetForm.getAscId();
		   	 
   	 /*int assetID=assetForm.getAssetId();
   	int assetTypeID=Integer.parseInt(request.getParameter("ab"));*/
   	AssetDetailsDAO assetDetailsDAO = (AssetDetailsDAO) ServiceFinder.getContext(request).getBean("AssetDetailsDAO");
		assetDetailsDAO.deleteAsset(ascId);
		System.out.println("In updatedelete-delete"+ascId);
		return mapping.findForward("delete");
	}

}
