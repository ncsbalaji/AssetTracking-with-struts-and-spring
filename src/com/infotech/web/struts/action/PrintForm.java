package com.infotech.web.struts.action;

import java.util.ArrayList;
import java.util.List;



import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class PrintForm extends org.apache.struts.action.ActionForm {
	
	
	 private ArrayList actorList;
	

	  public ArrayList getActorList() {
	        return actorList;
	    }
	
	  public void setActorList(ArrayList actorList) {
			
			 this.actorList = actorList;
			 
	    }

	public PrintForm() {
        super();
	}
	
	
	
   

   
}

