package com.zjt.service;

import com.zjt.dao.parkingLotOwnerDao;
import com.zjt.entity.parkingLotOwner;

public class parkingLotOwnerService {

	public void addParkingLotOwner(parkingLotOwner pOwner) {
		parkingLotOwnerDao pDao = new parkingLotOwnerDao();
		pDao.addParkingLotOwner(pOwner);
		
	}

	public parkingLotOwner getOwnerByphoneNumber(String phoneNumber) {
		parkingLotOwnerDao pDao = new parkingLotOwnerDao();
		return pDao.getOwnerByphoneNumber(phoneNumber);
	}

	public boolean loginVerify(String ownerId, String phoneNumber) {
		parkingLotOwnerDao pDao = new parkingLotOwnerDao();
		parkingLotOwner pOwner = pDao.getOwnerByphoneNumber(phoneNumber);
		System.out.println(ownerId);
		System.out.println(pOwner.getOwnerId());
		if(pOwner.getOwnerId().equals(ownerId)){
		      return true;
	  }
  else{
		      return false;
	    }
	}

	public String getNameByid(String ownerId) {
		parkingLotOwnerDao pDao = new parkingLotOwnerDao();
		return pDao.getNameByid(ownerId);
	}

	

	

}
