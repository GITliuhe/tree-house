package com.zjt.service;

import java.util.List;

import com.zjt.dao.carDao;
import com.zjt.entity.car;

public class carService {

	public List<car> findCarByUserName(String userName) {
		carDao cdao = new carDao();
		return cdao.findCarByUserName(userName);
	}

	public car addCar(car car) {
		carDao cdao = new carDao();
		return cdao.addCar(car);		
	}

	public boolean carLicenseNumberexist(String carLicenseNumber) {
		carDao cdao = new carDao();
		if(cdao.findCarBycarLicenseNumber(carLicenseNumber)!=null){
		return false;
		}else
		{
			return true;
		}
	}

	public car delCar(car c1) {
		carDao cdao=new carDao();
		return cdao.delCar(c1);
	}


}
