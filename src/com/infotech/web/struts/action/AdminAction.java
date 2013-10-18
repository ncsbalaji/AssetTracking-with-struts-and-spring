package com.infotech.web.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.infotech.hibernate.Assetdetails;
import com.infotech.hibernate.Assettype;
import com.infotech.hibernate.Location;
import com.infotech.hibernate.Login;
import com.infotech.hibernate.Role;
import com.infotech.hibernate.dao.AdminDAO;
import com.infotech.hibernate.dao.AssetDetailsDAO;
import com.infotech.services.ServiceFinder;

public class AdminAction extends DispatchAction {
	
	public ActionForward addUser(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		
		AdminDAO adminDAO = (AdminDAO) ServiceFinder.getContext(request).getBean("AdminDAO");
		List<Role> roleList = adminDAO.getRoleList();
		request.setAttribute("rolelist", roleList);
		return mapping.findForward("addUser");
		
	}
	
	public ActionForward deleteUser(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		
		AdminDAO adminDAO = (AdminDAO) ServiceFinder.getContext(request).getBean("AdminDAO");
		
		List<Login> loginList = adminDAO.getLoginList();
		request.setAttribute("loginlist", loginList);
		
		return mapping.findForward("delUser");
	}
	
	public ActionForward addLocation(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		
		return mapping.findForward("addLocation");
		
	}
	
	public ActionForward addAsset(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		
		AdminDAO adminDAO = (AdminDAO) ServiceFinder.getContext(request).getBean("AdminDAO");
		
		List<Login> loginList = adminDAO.getLoginList();
		request.setAttribute("loginlist", loginList);
		
		List<Assettype> assettypeList = adminDAO.getAssettypeList();
		request.setAttribute("assettypelist", assettypeList);
		
		List<Location> locationList = adminDAO.getLocationList();
		request.setAttribute("locationlist", locationList);  
		
		return mapping.findForward("addAsset");
	}
	
	public ActionForward changePassword(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		
		return mapping.findForward("changePassword");
		
	}
	
	public ActionForward assignAsset(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		
		AssetDetailsDAO assetDetailsDAO = (AssetDetailsDAO) ServiceFinder.getContext(request).getBean("AssetDetailsDAO");
		
		System.out.println("$1");
		 
		List<Assetdetails> assetDetails = assetDetailsDAO.getTempAssetdetails();
	    request.setAttribute("TempAssetDetails", assetDetails);   
	     
		List<Login> loginList = assetDetailsDAO.getNoAssetAscIdList();
		System.out.println("AdminAction-->assignAsset");
		request.setAttribute("loginlist", loginList);
		
		System.out.println("$7");
		
		return mapping.findForward("assignAsset");
		
	}
	
	public ActionForward unassignAssets(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		
		AssetDetailsDAO assetDetailsDAO = (AssetDetailsDAO) ServiceFinder.getContext(request).getBean("AssetDetailsDAO");
		
		System.out.println("unassign assets");
		 
		List<Assetdetails> assetDetails = assetDetailsDAO.getTempAssetdetails();
	    request.setAttribute("TempAssetDetails1", assetDetails);   
	     
	    System.out.println("unassign assets-->end");
		
		return mapping.findForward("unassignAssets");
		
	}
	
	
}