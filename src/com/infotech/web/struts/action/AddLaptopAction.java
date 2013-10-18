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

public class AddLaptopAction extends Action{

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
		 AssetForm assetForm = (AssetForm) form;
    	 System.out.println("test1");
    	 
    	 int assettypeID=assetForm.getAssettypeId();
    	 int ascId = assetForm.getAscId();
    	 String ascName = assetForm.getAscName();
    	 int locationId = assetForm.getLocationId();
         String model = assetForm.getModel();
         String computername = assetForm.getComputername();
         String ipAddress = assetForm.getIpAddress();
         String monitorTrackingNumber = null;
         String cpuTrackingNumber = assetForm.getCpuTrackingNumber();
         int ram = assetForm.getRam();
         int ramId = assetForm.getRamId();
         int hardDisk = assetForm.getHardDisk();
         String otherAssets = assetForm.getOtherAssets();
		  
         adminDAO.addAsset(assettypeID,ascId,locationId,model,computername,ipAddress,monitorTrackingNumber,cpuTrackingNumber,ram,ramId,hardDisk,otherAssets);
		  
		 return mapping.findForward("add");
		 }
	 }
}