package com.zjt.service;

import java.util.List;

import com.zjt.dao.parkingLotDao;
import com.zjt.entity.parkingLot;

public class parkingLotService {
	
	public List<parkingLot> findAllparkingLot() {
		parkingLotDao pdao = new parkingLotDao();
		return pdao.findAllparkingLot();
	}

	public List<parkingLot> findAllowner(String ownerId) {
		parkingLotDao pdao = new parkingLotDao();
		return pdao.findAllowner(ownerId);
	}

	public parkingLot addparkingLot(parkingLot parkinglot) {

		parkingLotDao pdao=new parkingLotDao();
		parkingLot newparkingLot=pdao.addparkingLot(parkinglot);
		
		return newparkingLot;
	}

	public parkingLot delParkingLot(parkingLot pl) {
		parkingLotDao pdao=new parkingLotDao();
		parkingLot newparkingLot=pdao.delParkingLot(pl);
		
		//记录日志等
		//.......
		return newparkingLot;
	}

	public parkingLot findByParkingLotId(String parkingLotId) {
		parkingLotDao pdao=new parkingLotDao();
		
		return pdao.findByParkingLotId(parkingLotId);
	}

	public parkingLot updateparkingLot(parkingLot pl) {
		parkingLotDao pdao=new parkingLotDao();
		
		parkingLot newparkingLot=pdao.updateParkingLot(pl);
		
		//记录日志等。。。。。。
		
		return newparkingLot;
	}

	public List<parkingLot> findAllparkingLotByLocation(String location) {
		parkingLotDao pdao=new parkingLotDao();
		
		return pdao.findAllparkingLotByLocation(location);
	}

	

	
}
