package com.infotech.web.struts.action;

public class AssignAssetForm  extends org.apache.struts.validator.ValidatorForm{
	
	private int assetId=0;
	private int ascId = 0;
	
	public int getAssetId() {
		return assetId;
	}
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
	public int getAscId() {
		return ascId;
	}
	public void setAscId(int ascId) {
		this.ascId = ascId;
	}

}
