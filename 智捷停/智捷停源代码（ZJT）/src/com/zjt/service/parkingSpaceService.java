package com.zjt.service;

import java.util.List;

import com.zjt.dao.parkingSpaceDao;
import com.zjt.entity.parkingLot;
import com.zjt.entity.parkingSpace;

public class parkingSpaceService {

	public List<parkingSpace> findSpaceByplId(String parkingLotId) {
		parkingSpaceDao pdao = new parkingSpaceDao();
		return pdao.findSpaceByplId(parkingLotId);
	}

	public void updateSpaceStatment(String spaceId) {
		parkingSpaceDao pdao = new parkingSpaceDao();
		pdao.updateSpaceStatment(spaceId);
	}

	public List<parkingSpace> findAllSpace(String parkinglotId) {
		parkingSpaceDao pdao = new parkingSpaceDao();
		return pdao.findAllSpace(parkinglotId);
	}

	public void addParkingSpace(parkingSpace pSpace) {
		parkingSpaceDao pdao = new parkingSpaceDao();
		pdao.addParkingSpace(pSpace);
	}

	

	public parkingSpace findSpaceByspaceId(String spaceId) {
		parkingSpaceDao pdao = new parkingSpaceDao();
		return pdao.findSpaceByspaceId(spaceId);
	}

	public void forbiddenSpace(String spaceId) {
		parkingSpaceDao pdao = new parkingSpaceDao();
		pdao.forbiddenSpace(spaceId);
		
	}

	public void availableSpace(String spaceId) {
		parkingSpaceDao pdao = new parkingSpaceDao();
		pdao.availableSpace(spaceId);
		
	}

	public String findParkingLoIdBySpaceId(String spaceId) {
		parkingSpaceDao pdao = new parkingSpaceDao();
		return pdao.findParkingLoIdBySpaceId(spaceId);
	}

	public int findSumSpaceByparkingLotId(String parkinglotId) {
		parkingSpaceDao pdao = new parkingSpaceDao();
		return pdao.findSumSpaceByparkingLotId(parkinglotId);
	}

	public int findOrderedSpaceByparkingLotId(String parkinglotId) {
		parkingSpaceDao pdao = new parkingSpaceDao();
		return pdao.findOrderedSpaceByparkingLotId(parkinglotId);
	}

}
