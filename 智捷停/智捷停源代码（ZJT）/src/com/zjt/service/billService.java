package com.zjt.service;

import java.util.List;

import com.zjt.dao.billDao;
import com.zjt.entity.bill;

public class billService {

	public void createBill(bill billInfo) {
		billDao bDao = new billDao();
		bDao.createBill(billInfo);
		
	}

	

	public void updateBillInfoByBillId(bill billOut) {
		billDao bDao = new billDao();
		bDao.updateBillInfoByBillId(billOut);
	}

	public bill findByStatus(String carNo, String orderDate) {
		billDao bDao = new billDao();
		return bDao.findByStatus(carNo,orderDate);
	}



	public bill findBillInfoByCarLicenseNumber(String carLicenseNumber) {
		billDao bDao = new billDao();
		return bDao.findBillInfoByCarLicenseNumber(carLicenseNumber);
	}



	public void createCancelOrderBill(bill billOut) {
		billDao bDao = new billDao();
		bDao.createCancelOrderBill(billOut);
		
	}



	public List<bill> showBillListByUserNameStatus(String userName) {
		billDao bDao =new billDao();
		return bDao.showBillListByUserNameStatus(userName);
	}



	public List<bill> showBillListByUserName(String userName) {
		billDao bDao =new billDao();
		return bDao.showBillListByUserName(userName);
	}



	public void updateBillStausByBillId(String billNumber) {
		billDao bDao =new billDao();
		bDao.updateBillStausByBillId(billNumber);
	}

	

	

}
