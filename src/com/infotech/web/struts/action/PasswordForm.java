package com.infotech.web.struts.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.*;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class PasswordForm extends org.apache.struts.validator.ValidatorForm{
		
		  int ascid=0;
		  public int getAscid() {
			return ascid;
		}
		public void setAscid(int ascid) {
			this.ascid = ascid;
		}
		private String password1 = null;
		  private String password2 = null;
		  private String password3 = null;
		  
		  public String getPassword1() {
			  System.out.println("passw2");
			return password1;
		}
		public void setPassword1(String password1) {
			this.password1 = password1;
		}
		public String getPassword2() {
			return password2;
		}
		public void setPassword2(String password2) {
			this.password2 = password2;
		}
		public String getPassword3() {
			return password3;
		}
		public void setPassword3(String password3) {
			this.password3 = password3;
		}
		public PasswordForm() {
	        super();
	    }
		public ActionErrors validate( 
				  
			      ActionMapping mapping, HttpServletRequest request ) {
			    	  ActionErrors errors = super.validate(mapping, request);
			        
			      if( !(password2.equals(password3))) {
				        errors.add("password3",new ActionMessage("error.password.match"));
				      }
			      
			      

			      return errors;
			  }
	
}