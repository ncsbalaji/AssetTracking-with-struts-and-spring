package com.infotech.web.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.infotech.hibernate.dao.AdminDAO;
import com.infotech.services.ServiceFinder;

public class AddAssetAction extends Action{

	 public ActionForward execute(
			    ActionMapping mapping,
			    ActionForm form,
			    HttpServletRequest request,
			    HttpServletResponse response) throws Exception{
		 System.out.println("b test ");
		 
		 AdminDAO adminDAO = (AdminDAO) ServiceFinder.getContext(request).getBean("AdminDAO");
		 
			 /*List<Assetdetails> assetDetails1 = adminDAO.getAscIdList();
		     request.setAttribute("aDDetails1", assetDetails1);*/
		 
		 int a=Integer.parseInt(request.getParameter("a"));
		 System.out.println("a "+a);
		 
		 if(isCancelled(request)){
			 return mapping.findForward("cancel");
		 } else {
			 AssetForm assetForm = (AssetForm) form;
	    	 System.out.println("test1.1");
	    	 
	    	 int assettypeID=assetForm.getAssettypeId();
	    	 int ascId = assetForm.getAscId();
	    	 String ascName = assetForm.getAscName();
	    	 int locationId = assetForm.getLocationId();
	         String model = assetForm.getModel();
	         String computername = assetForm.getComputername();
	         String ipAddress = assetForm.getIpAddress();
	         String monitorTrackingNumber = assetForm.getMonitorTrackingNumber();
	         String cpuTrackingNumber = assetForm.getCpuTrackingNumber();
	         int ram = assetForm.getRam();
	         int ramId = assetForm.getRamId();
	         int hardDisk = assetForm.getHardDisk();
	         String otherAssets = assetForm.getOtherAssets();
	         System.out.println("test1.2");
	         System.out.println(assettypeID);
			 adminDAO.addAsset(assettypeID,ascId,locationId,model,computername,ipAddress,monitorTrackingNumber,cpuTrackingNumber,ram,ramId,hardDisk,otherAssets);
			 System.out.println("test1.3");
			 return mapping.findForward("add");
		 
			 
		 }
		 
	 }
}