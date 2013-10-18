package com.infotech.web.struts.action;

public class UpdateForm  extends org.apache.struts.validator.ValidatorForm{
	
	private int ascId = 0;
	private int locationId = 0;
	private String model = null;
	private String computername = null;
	private String ipAddress = null;
	private String monitorTrackingNumber = null;
	private String cpuTrackingNumber = null;
	private int ram = 0;
	public int ramId = 0;
	private int hardDisk = 0;
	private String otherAssets = null;
	
	public int getAscId() {
		return ascId;
	}
	public void setAscId(int ascId) {
		this.ascId = ascId;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getComputername() {
		return computername;
	}
	public void setComputername(String computername) {
		this.computername = computername;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getMonitorTrackingNumber() {
		return monitorTrackingNumber;
	}
	public void setMonitorTrackingNumber(String monitorTrackingNumber) {
		this.monitorTrackingNumber = monitorTrackingNumber;
	}
	public String getCpuTrackingNumber() {
		return cpuTrackingNumber;
	}
	public void setCpuTrackingNumber(String cpuTrackingNumber) {
		this.cpuTrackingNumber = cpuTrackingNumber;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getRamId() {
		return ramId;
	}
	public void setRamId(int ramId) {
		this.ramId = ramId;
	}
	public int getHardDisk() {
		return hardDisk;
	}
	public void setHardDisk(int hardDisk) {
		this.hardDisk = hardDisk;
	}
	public String getOtherAssets() {
		return otherAssets;
	}
	public void setOtherAssets(String otherAssets) {
		this.otherAssets = otherAssets;
	}
	public UpdateForm() {
        super();
    }
	
	/*public ActionErrors validate( 
			  
		      ActionMapping mapping, HttpServletRequest request ) {
		    	  ActionErrors errors = super.validate(mapping, request);
		          
		      if( getModel()== null || getModel().length() < 4) {
		    	  System.out.println("model");
		        errors.add("model",new ActionMessage("error.model.required"));
		      }
		      return errors;
		  }*/

}
