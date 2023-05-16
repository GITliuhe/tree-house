package com.zjt.service;

import java.util.List;

import com.zjt.dao.orderDao;
import com.zjt.entity.order;

public class orderService {

	public void createOrder(String userName, String carLicenseNumber,
			String spaceId,String phoneNumber, String spaceNumber, String parkingLot) {
		orderDao odao = new orderDao();
		odao.createOrder(userName,carLicenseNumber,spaceId,phoneNumber,spaceNumber,parkingLot);
		
	}

	

	public List<order> showOrderListByUserName(String userName) {
		orderDao odao=new orderDao();
		return odao.showOrderListByUserName(userName);
	}



	public order findCarByCarNumb(String carNo) {
		orderDao odao=new orderDao();
		return odao.findCarByCarNumb(carNo);
	}



	public void updateOrderStatus(String orderNumber) {
		orderDao odao=new orderDao();
		odao.updateOrderStatus(orderNumber);
	}



	public void updateOrderFinishDate(String orderNumber) {
		orderDao odao=new orderDao();
		odao.updateOrderFinishDate(orderNumber);
		
	}



	public order findOrderInfoByCarLicenseNumber(String carLicenseNumber) {
		orderDao odao=new orderDao();
		return odao.findOrderInfoByCarLicenseNumber(carLicenseNumber);
		
	}



	public List<order> showUnUsedOrderListByUserName(String userName) {
		orderDao odao=new orderDao();
		return odao.showUnUsedOrderListByUserName(userName);
	}



	public order findCancelOrderTime(String orderNumber, String orderDate) {
		orderDao odao=new orderDao();
		return odao.findCancelOrderTime(orderNumber,orderDate);
	}



	public order findOrderInfoByOrderNumber(String orderNumber) {
		orderDao odao=new orderDao();
		return odao.findOrderInfoByOrderNumber(orderNumber);
	}



	public int findQuantityBydate(String monday) {
		orderDao odao=new orderDao();
		return odao.findQuantityBydate(monday);
	}

	
}
