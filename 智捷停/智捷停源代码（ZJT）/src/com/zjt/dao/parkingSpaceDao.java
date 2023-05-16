package com.zjt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zjt.common.DbObject;
import com.zjt.entity.parkingLot;
import com.zjt.entity.parkingSpace;

public class parkingSpaceDao {

	public List<parkingSpace> findSpaceByplId(String parkingLotId) {
		ArrayList<parkingSpace> parkingSpaceList = new ArrayList<parkingSpace>();
		ResultSet rs=null;
		Connection cn=null;
		PreparedStatement st=null;
		cn=DbObject.getConnection();
		
		try {
			
			//Ö´ÐÐSQLÓï¾ä
			
			String sql = "select * from zjt.parkingSpace where parkingLotId=? and spaceStatment=1 ";
			st = cn.prepareStatement(sql);
			
			
			st.setString(1, parkingLotId);
			
			rs=st.executeQuery();
			
			while(rs.next()){
				
				parkingSpace space = new parkingSpace();
				
				space.setSpaceId(rs.getString("spaceId"));
				space.setSpaceNumber(rs.getString("spaceNumber"));
				space.setRates(rs.getString("rates"));
				
				
				
				
				
				parkingSpaceList.add(space);
				
				
				
				
				
				
				
			}
			
			
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, rs);
		}
		
		
		
		
		
		return parkingSpaceList;
	}

	public void updateSpaceStatment(String spaceId) {
		Connection cn=null;
		PreparedStatement st=null;
		cn=DbObject.getConnection();
		
		try {
			
			//Ö´ÐÐSQLÓï¾ä
			
			String sql = "update zjt.parkingSpace set spaceStatment=0 where spaceId=? ";
			st = cn.prepareStatement(sql);
			
			
			st.setString(1, spaceId);
			
			
			st.executeUpdate();
			
			
			
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, null);
		}
		
		
		
		
		
		
		
	}

	public List<parkingSpace> findAllSpace(String parkinglotId) {
		ArrayList<parkingSpace> parkingSpaceList = new ArrayList<parkingSpace>();
		ResultSet rs=null;
		Connection cn=null;
		PreparedStatement st=null;
		cn=DbObject.getConnection();
		
		try {
			
			//Ö´ÐÐSQLÓï¾ä
			
			String sql = "select * from zjt.parkingSpace where parkingLotId=? ";
			st = cn.prepareStatement(sql);
			
			
			st.setString(1, parkinglotId);
				
			rs=st.executeQuery();
			
			while(rs.next()){
				
				parkingSpace space = new parkingSpace();
				
				space.setSpaceId(rs.getString("spaceId"));
				space.setParkingLotId(parkinglotId);
				space.setSpaceNumber(rs.getString("spaceNumber"));
				space.setSpaceStatment(rs.getString("spaceStatment"));
				space.setRates(rs.getString("rates"));
				parkingSpaceList.add(space);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, rs);
		}
		return parkingSpaceList;
		
	}

	public void addParkingSpace(parkingSpace pSpace) {
		Connection cn = null;
		PreparedStatement st = null;
		
		cn = DbObject.getConnection();
		
	try {
		String sql = "insert into zjt.parkingSpace(parkingLotId ,spaceNumber,rates ) values(?,?,?)";
			st = cn.prepareStatement(sql);
			
		st.setString(1,pSpace.getParkingLotId());
		st.setString(2,pSpace.getSpaceNumber());
		st.setString(3,pSpace.getRates());
		
		
		
		int ret = st.executeUpdate();
	}catch (SQLException e) {
	    e.printStackTrace();
	}finally{
		DbObject.close(cn , st , null);
	}
		
	}

	public parkingSpace findSpaceByspaceId(String spaceId) {
		ResultSet rs=null;
		Connection cn=null;
		PreparedStatement st=null;
		cn=DbObject.getConnection();
		parkingSpace space = new parkingSpace();
		
		try {
			
			//Ö´ÐÐSQLÓï¾ä
			
			String sql = "select * from zjt.parkingSpace where spaceId=?";
			st = cn.prepareStatement(sql);
			
			
			st.setString(1, spaceId);
			
			rs=st.executeQuery();
			
			if(rs.next()){
				
				
				space.setSpaceId(rs.getString("spaceId"));
				space.setSpaceNumber(rs.getString("spaceNumber"));
				space.setRates(rs.getString("rates"));
				space.setSpaceStatment(rs.getString("spaceStatment"));
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
			
			
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, rs);
		}
		
		
		
		
		
		return space;
	}

	public void forbiddenSpace(String spaceId) {
		Connection cn=null;
		PreparedStatement st=null;
		cn=DbObject.getConnection();
		
		try {
			
			//Ö´ÐÐSQLÓï¾ä
			
			String sql = "update zjt.parkingSpace set spaceStatment=0 where spaceId=? ";
			st = cn.prepareStatement(sql);
			
			
			st.setString(1, spaceId);
			
			st.executeUpdate();
			
			
			
			
			
			
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, null);
		}
		
		
		
		
	}

	public void availableSpace(String spaceId) {
		Connection cn=null;
		PreparedStatement st=null;
		cn=DbObject.getConnection();
		
		try {
			
			//Ö´ÐÐSQLÓï¾ä
			
			String sql = "update zjt.parkingSpace set spaceStatment=1 where spaceId=? ";
			st = cn.prepareStatement(sql);
			
			
			st.setString(1, spaceId);
			
			st.executeUpdate();
			
			
			
			
			
			
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, null);
		}
		
	}

	public String findParkingLoIdBySpaceId(String spaceId) {
		ResultSet rs=null;
		Connection cn=null;
		PreparedStatement st=null;
		cn=DbObject.getConnection();
		String parkingLotId = null;
		
		try {
			
			//Ö´ÐÐSQLÓï¾ä
			
			String sql = "select parkingLotId from zjt.parkingSpace where spaceId=?";
			st = cn.prepareStatement(sql);
			
			
			st.setString(1, spaceId);
			
			rs=st.executeQuery();
			
			if(rs.next()){
				
				
				parkingLotId=rs.getString("parkingLotId");
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
			
			
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, rs);
		}
		
		
		
		
		
		return parkingLotId;
	}

	public int findSumSpaceByparkingLotId(String parkinglotId) {
		ResultSet rs=null;
		Connection cn=null;
		PreparedStatement st=null;
		cn=DbObject.getConnection();
		int sum = 0;
		
		try {
			
			//Ö´ÐÐSQLÓï¾ä
			
			String sql = "select count(*) sum from zjt.parkingSpace where parkingLotId=?";
			st = cn.prepareStatement(sql);
			
			
			st.setString(1, parkinglotId);
			
			rs=st.executeQuery();
			
			if(rs.next()){
				
				
				sum=rs.getInt("sum");
	
			}
			
			
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, rs);
		}

		return sum;
	}

	public int findOrderedSpaceByparkingLotId(String parkinglotId) {
		ResultSet rs=null;
		Connection cn=null;
		PreparedStatement st=null;
		cn=DbObject.getConnection();
		int ordered = 0;
		
		try {
			
			//Ö´ÐÐSQLÓï¾ä
			
			String sql = "select count(*) ordered from zjt.parkingSpace where parkingLotId=? and spaceStatment=0";
			st = cn.prepareStatement(sql);
			
			
			st.setString(1, parkinglotId);
			
			rs=st.executeQuery();
			
			if(rs.next()){
				
				
				ordered=rs.getInt("ordered");
	
			}
			
			
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, rs);
		}

		return ordered;
	}

	

}
