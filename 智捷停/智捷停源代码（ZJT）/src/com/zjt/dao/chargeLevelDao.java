package com.zjt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zjt.common.DbObject;
import com.zjt.entity.chargeLevel;

public class chargeLevelDao {

	public chargeLevel findByparkingLotId(String parkingLotId) {
		chargeLevel cl = new chargeLevel();
		ResultSet rs=null;
		Connection cn=null;
		PreparedStatement st=null;
		
		cn = DbObject.getConnection();
		
		
		try {
			
			
			//ִ��SQL���
			
			String sql = "select * from zjt.chargeLevel where parkingLotId=?";
					
			st=cn.prepareStatement(sql);
			st.setString(1, parkingLotId);
			rs=st.executeQuery();
		
			if(rs.next()){
				
				
				
				
				cl.setLevelId(rs.getString("levelId"));
				cl.setParkingLotId(rs.getString("parkingLotId"));
				cl.setPname(rs.getString("pname"));
				cl.setMianfeiTime(rs.getInt("freeTime"));
				cl.setShoufeiMoney(rs.getInt("chargeLevel"));
				cl.setShoufeiTime(rs.getInt("chargeTime"));
				
			
				
			}
		}  catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, null);
		}
		return cl;
	}

	public void addChargeLevel(String parkingLotId, String pName,
			String freeTime, String chargeTime, String chargeLevel) {
		
		
		Connection cn=null;
		PreparedStatement st=null;
		
		cn = DbObject.getConnection();
		
		
		try {
			
			
			//ִ��SQL���
			
			String sql = "insert into zjt.chargeLevel(parkingLotId,pname,freeTime,chargeTime,chargeLevel) values(?,?,?,?,?) ";
					
			st=cn.prepareStatement(sql);
			
			st.setString(1, parkingLotId);
			st.setString(2,pName);
			st.setString(3,freeTime);
			st.setString(4,chargeTime);
			st.setString(5,chargeLevel);
			
			st.executeUpdate();
			
			 
			
			
		}  catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, null);
		}
		
	}

	public void modifyChargeLevelByParkingLotId(String parkingLotId,
			String freeTime, String chargeTime, String chargeLevel) {
		
		
		Connection cn=null;
		PreparedStatement st=null;
		cn=DbObject.getConnection();
		
		try {
			
			//ִ��SQL���
			
			String sql = "update zjt.chargeLevel set freeTime=?,chargeTime=?,chargeLevel=? where parkingLotId=? ";
			st = cn.prepareStatement(sql);
			
			
			st.setString(1, freeTime);
			st.setString(2, chargeTime);
			st.setString(3, chargeLevel);
			st.setString(4, parkingLotId);
			
			
			st.executeUpdate();
			
			
			
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, null);
		}
		
	}

}
