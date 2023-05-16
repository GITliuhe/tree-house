package com.zjt.service;

import com.zjt.dao.chargeLevelDao;

public class chargeLevelService {

	public com.zjt.entity.chargeLevel findByparkingLotId(String parkingLotId) {
		chargeLevelDao cDao = new chargeLevelDao();
		return cDao.findByparkingLotId(parkingLotId);
	}

	public void addChargeLevel(String parkingLotId, String pName,
			String freeTime, String chargeTime, String chargeLevel) {
		chargeLevelDao cDao = new chargeLevelDao();
		cDao.addChargeLevel(parkingLotId,pName,freeTime,chargeTime,chargeLevel);
	}

	public void modifyChargeLevelByParkingLotId(String parkingLotId, String freeTime, String chargeTime, String chargeLevel) {
		chargeLevelDao cDao = new chargeLevelDao();
		cDao.modifyChargeLevelByParkingLotId(parkingLotId,freeTime,chargeTime,chargeLevel);
		
	}

}
