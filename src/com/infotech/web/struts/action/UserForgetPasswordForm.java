package com.infotech.web.struts.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.*;

public class UserForgetPasswordForm extends ActionForm
{
	 
      /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String action="add";

	  private int ascid = 0;
	  private String ascname = null;
	  private String password=null;
	  private String emailid = null;
	 
      public void setAction(String action){
		this.action=action;
	  }

	  public String getAction(){
		return this.action;
	  }

	  public void reset(ActionMapping mapping,HttpServletRequest request){  
		  
		  this.setAscid(0);
		  this.setEmailid(null);
		 
		  this.action="add";

	  }
    
	public void setAscid(int ascid) {
		this.ascid = ascid;
	}

	public int getAscid() {
		return ascid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setAscname(String ascname) {
		this.ascname = ascname;
	}

	public String getAscname() {
		return ascname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	} 
	
} 