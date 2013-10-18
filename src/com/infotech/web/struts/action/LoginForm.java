package com.infotech.web.struts.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.*;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginForm extends org.apache.struts.validator.ValidatorForm{

	      private String action="add";
	      private int ascId = 0;
		  private String password = null;
		  private String error;
		  private String error1;
		  

		



		public void reset(ActionMapping mapping,HttpServletRequest request){
			
			  this.ascId=0;
			  this.password=null;
			 
			  this.action="add";

		  }

		  


		public String getAction() {
			return action;
		}


		public void setAction(String action) {
			this.action = action;
		}


		

		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public int getAscId() {
			System.out.println(ascId);
			return ascId;
			
		}


		public void setAscId(int ascId) {
			this.ascId = ascId;
			System.out.println("te1");
		}

		public LoginForm() {
	        super();
	    }




		public void setError(String error) {
			this.error = error;
		}




		public String getError() {
			return error;
		}




		public void setError1(String error1) {
			this.error1 = error1;
		}




		public String getError1() {
			return error1;
		}
		
		/*public ActionErrors validate( 
				  
			      ActionMapping mapping, HttpServletRequest request ) {
			    	  ActionErrors errors = super.validate(mapping, request);
			          
			      if( getAscId()<= 0 || getAscId() > 100000 ) {
			    	  System.out.println("valid3");
			        errors.add("ascId",new ActionMessage("error.ascId.required"));
			        System.out.println("valid4");
			      }
			      if( getPassword() == null || getPassword().length() < 4 ) {
			        errors.add("password",new ActionMessage("error.password.required"));
			      }
			      

			      return errors;
			  }*/

		

			 
	} 
	
	

