package com.pg.bean;

public class Pg_homeinfo {
	private String HomeInfoID;//ID
	private String Status;//状态(-1,删除 0,正常)
	private String ComponyName;//公司名称
	private String VsrsionName;//版本名称	
	private String Image;//版本名称	
	
	public String getHomeInfoID() {
		return HomeInfoID;
	}
	public void setHomeInfoID(String homeInfoID) {
		HomeInfoID = homeInfoID;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getComponyName() {
		return ComponyName;
	}
	public void setComponyName(String componyName) {
		ComponyName = componyName;
	}
	public String getVsrsionName() {
		return VsrsionName;
	}
	public void setVsrsionName(String vsrsionName) {
		VsrsionName = vsrsionName;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
}
