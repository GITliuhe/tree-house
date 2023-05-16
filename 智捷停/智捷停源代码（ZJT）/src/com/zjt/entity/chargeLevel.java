package com.zjt.entity;

public class chargeLevel {
	private String levelId;
	private String parkingLotId;
	private String pname;
	private int mianfeiTime;//免费时间（分钟)
	private int shoufeiTime;//收费时间基数(分钟)
	private int shoufeiMoney;//收费金额(收费时间基数)
	public String getLevelId() {
		return levelId;
	}
	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}
	public String getParkingLotId() {
		return parkingLotId;
	}
	public void setParkingLotId(String parkingLotId) {
		this.parkingLotId = parkingLotId;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getMianfeiTime() {
		return mianfeiTime;
	}
	public void setMianfeiTime(int mianfeiTime) {
		this.mianfeiTime = mianfeiTime;
	}
	public int getShoufeiTime() {
		return shoufeiTime;
	}
	public void setShoufeiTime(int shoufeiTime) {
		this.shoufeiTime = shoufeiTime;
	}
	public int getShoufeiMoney() {
		return shoufeiMoney;
	}
	public void setShoufeiMoney(int shoufeiMoney) {
		this.shoufeiMoney = shoufeiMoney;
	}
	
	
	

	
}
