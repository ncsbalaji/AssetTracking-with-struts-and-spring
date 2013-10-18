package com.infotech.web.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.infotech.hibernate.Assetdetails;
import com.infotech.hibernate.dao.AssetDetailsDAO;
import com.infotech.services.ServiceFinder;

public class UpdateAction  extends Action{

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) throws Exception{
		UpdateForm updateForm = (UpdateForm) form;
		
		System.out.println("UpdateAction1a");
		
		
		System.out.println("assettype");
		int x=Integer.parseInt(request.getParameter("ab"));
		System.out.println("UpdateAction1");
		if(isCancelled(request)){
			int assetTypeID=x;
			AssetDetailsDAO assetDetailsDAO1 = (AssetDetailsDAO) ServiceFinder.getContext(request).getBean("AssetDetailsDAO");
			System.out.println("UpdateAction2");		 
			List<Assetdetails> assetDetails = assetDetailsDAO1.getAssetdetails(assetTypeID,-1);
			request.setAttribute("aDDetails", assetDetails); 
			System.out.println("UpdateAction3");
			return mapping.findForward("cancel");
		} else {
			System.out.println("rty 1");
			int assetID=0;
			int ascId = updateForm.getAscId();
			String ascName = null;
			int assetTypeID=x;
			int locationId = updateForm.getLocationId();
			String model = updateForm.getModel();
			String computername = updateForm.getComputername();
			String ipAddress = updateForm.getIpAddress();
			String monitorTrackingNumber = updateForm.getMonitorTrackingNumber();
			String cpuTrackingNumber = updateForm.getCpuTrackingNumber();
			int ram = updateForm.getRam();
			int hardDisk = updateForm.getHardDisk();
			String otherAssets = updateForm.getOtherAssets();

			System.out.println("UpdateAction4");

			AssetDetailsDAO assetDetailsDAO = (AssetDetailsDAO) ServiceFinder.getContext(request).getBean("AssetDetailsDAO");
			assetDetailsDAO.updateAsset(assetTypeID,assetID,ascId, ascName,locationId, model, computername, ipAddress, monitorTrackingNumber, cpuTrackingNumber, ram, hardDisk, otherAssets);

			System.out.println("UpdateAction5");

			AssetDetailsDAO assetDetailsDAO1 = (AssetDetailsDAO) ServiceFinder.getContext(request).getBean("AssetDetailsDAO");
			ActionMessages errors = new ActionMessages();

			List<Assetdetails> assetDetails = assetDetailsDAO1.getAssetdetails(assetTypeID,-1);
			request.setAttribute("aDDetails", assetDetails);   
			System.out.println("UpdateAction6");
			return mapping.findForward("update");
		}
	}

}
