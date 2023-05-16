package com.zjt.entity;

public class bill {
	
	private String billNumber;
	private String carLicenseNumber;//车牌
	private String inTime;//入场时间
	private String outTime;//入场时间
	private String inPicture;//入场图片
	private String outPic;//出场图片
	private int carFee;//停车费
	private int status;//状态0：未收费，1已收费，2：免费
	private String userName;//车主
	private String remark;//备注
	private int minutes;//停车时长（分钟）
	public String getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
	public String getCarLicenseNumber() {
		return carLicenseNumber;
	}
	public void setCarLicenseNumber(String carLicenseNumber) {
		this.carLicenseNumber = carLicenseNumber;
	}
	public String getInTime() {
		return inTime;
	}
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	public String getInPicture() {
		return inPicture;
	}
	public void setInPicture(String inPicture) {
		this.inPicture = inPicture;
	}
	public String getOutPic() {
		return outPic;
	}
	public void setOutPic(String outPic) {
		this.outPic = outPic;
	}
	
	
	
	
	public int getCarFee() {
		return carFee;
	}
	public void setCarFee(int carFee) {
		this.carFee = carFee;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
	
	

}
