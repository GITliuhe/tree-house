package com.zjt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zjt.common.DbObject;
import com.zjt.entity.parkingLotOwner;

public class parkingLotOwnerDao {

	public void addParkingLotOwner(parkingLotOwner pOwner) {
		Connection cn=null;
		PreparedStatement st=null;
		
		cn = DbObject.getConnection();
		
		
		
		
		try {
			
			
			//Ö´ÐÐSQLÓï¾ä
			
			String sql = "insert into zjt.parkingLotOwner(ownerName,phoneNumber,businessLicenseNumber) values(?,?,?) ";
					
			st=cn.prepareStatement(sql);
			
			st.setString(1, pOwner.getOwnerName());
			st.setString(2,pOwner.getPhoneNumber());
			st.setString(3,pOwner.getBusinessLicenseNumber());
			
			
			st.executeUpdate();
			
			
			 
			
			
			
		}  catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, null);
		}
		
		
	
	}

	public parkingLotOwner getOwnerByphoneNumber(String phoneNumber) {
		Connection cn=null;
		PreparedStatement st=null;
		ResultSet rs = null;
		parkingLotOwner pOwner= new parkingLotOwner();
		cn = DbObject.getConnection();
		
		
		
		
		try {
			
			
			//Ö´ÐÐSQLÓï¾ä
			
			String sql = "select * from zjt.parkingLotOwner where phoneNumber=?";
					
			st=cn.prepareStatement(sql);
			
			st.setString(1, phoneNumber);
			
			
			
			rs=st.executeQuery();
			if(rs.next()){
				pOwner.setOwnerId(rs.getString("ownerId"));
				pOwner.setPhoneNumber(rs.getString("phoneNumber"));
				
			}
			
			
			 
			
			
			
		}  catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, rs);
		}
		return pOwner;
		
	}

	public String getNameByid(String ownerId) {
		Connection cn=null;
		PreparedStatement st=null;
		ResultSet rs = null;
		String name = null;
		cn = DbObject.getConnection();
		
		
		
		
		try {
			
			
			//Ö´ÐÐSQLÓï¾ä
			
			String sql = "select * from zjt.parkingLotOwner where ownerId=?";
					
			st=cn.prepareStatement(sql);
			
			st.setString(1, ownerId);
			
			
			
			rs=st.executeQuery();
			if(rs.next()){
				name=rs.getString("ownerName");
				
			}
			
			
			 
			
			
			
		}  catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, rs);
		}
		return name;
	}

	

}
