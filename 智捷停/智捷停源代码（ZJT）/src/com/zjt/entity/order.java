package com.zjt.entity;

public class order {
	private String orderNumber;
	private String userName;
	private String carLicenseNumber;
	private String spaceId;
	private String orderDate;
	private String finishDate;
	private String phoneNumber;
	private int status;
	private String parkingLot;
	private String spaceNumber;
	
	
	
	
	
	
	public String getParkingLot() {
		return parkingLot;
	}
	public void setParkingLot(String parkingLot) {
		this.parkingLot = parkingLot;
	}
	public String getSpaceNumber() {
		return spaceNumber;
	}
	public void setSpaceNumber(String spaceNumber) {
		this.spaceNumber = spaceNumber;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCarLicenseNumber() {
		return carLicenseNumber;
	}
	public void setCarLicenseNumber(String carLicenseNumber) {
		this.carLicenseNumber = carLicenseNumber;
	}
	public String getSpaceId() {
		return spaceId;
	}
	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}
}
