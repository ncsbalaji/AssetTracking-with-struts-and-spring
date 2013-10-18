package com.infotech.web.struts.action;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMessages;

import com.infotech.hibernate.Assetdetails;
import com.infotech.hibernate.Location;
import com.infotech.hibernate.Login;
import com.infotech.hibernate.dao.AdminDAO;
import com.infotech.services.ServiceFinder;

public class PrintAction extends org.apache.struts.action.Action {
   
    private final static String SUCCESS = "success";                   
    
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	 
    	 PrintForm printForm = (PrintForm) form;
         ActorData actorData = new ActorData();
         printForm.setActorList(actorData.loadData());
         return mapping.findForward(SUCCESS);
    }
}

