package com.zjt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zjt.common.DbObject;
import com.zjt.entity.parkingLot;

public class parkingLotDao {

	public List<parkingLot> findAllparkingLot() {
		ArrayList<parkingLot> parkingLotList = new ArrayList<parkingLot>();
		ResultSet rs=null;
		Connection cn=null;
		PreparedStatement st=null;
		cn=DbObject.getConnection();
		
		try {
			
			//执行SQL语句
			
			String sql = "select * from zjt.parkingLot ";
			st = cn.prepareStatement(sql);
			
			
			
			
			rs=st.executeQuery();
			
			while(rs.next()){
				
				parkingLot pl = new parkingLot();
				
				pl.setOwnerId(rs.getString("ownerId"));
				pl.setParkingLotId(rs.getString("parkingLotId"));
				pl.setPname(rs.getString("pName"));
				pl.setPlocation(rs.getString("pLocation"));
				pl.setParkingSpaceQuatity(rs.getString("parkingSpaceQuatity"));
				pl.setRates(rs.getString("rates"));
				
				parkingLotList.add(pl);
				
				
				
				
				
				
				
			}
			
			
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, rs);
		}
		
		
		
		
		
		return parkingLotList;
	}

	public List<parkingLot> findAllowner(String ownerId) {
		ArrayList<parkingLot> parkingLotList = new ArrayList<parkingLot>();
		ResultSet rs=null;
		Connection cn=null;
		PreparedStatement st=null;
		cn=DbObject.getConnection();
		
		try {
			
			//执行SQL语句
			
			String sql = "select * from zjt.parkingLot where ownerId=?";
			st = cn.prepareStatement(sql);
			st.setString(1, ownerId);
			
			
			
			rs=st.executeQuery();
			
			while(rs.next()){
				
				parkingLot pl = new parkingLot();
				
				pl.setOwnerId(rs.getString("ownerId"));
				pl.setParkingLotId(rs.getString("parkingLotId"));
				pl.setPname(rs.getString("pName"));
				pl.setPlocation(rs.getString("pLocation"));
				pl.setParkingSpaceQuatity(rs.getString("parkingSpaceQuatity"));
				pl.setRates(rs.getString("rates"));
				
				parkingLotList.add(pl);
				
				
				
				
				
				
				
			}
			
			
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, rs);
		}
		
		
		
		
		
		return parkingLotList;
	}

	public parkingLot addparkingLot(parkingLot parkinglot) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		cn=DbObject.getConnection();
		try {
			
			String sql = "insert into zjt.parkingLot (ownerId,pName,pLocation,parkingSpaceQuatity,rates) values(?,?,?,?,?)";
			
			st = cn.prepareStatement(sql);
			
			
			st.setString(1, parkinglot.getOwnerId());
			st.setString(2, parkinglot.getPname());
			st.setString(3, parkinglot.getPlocation());
			st.setString(4, parkinglot.getParkingSpaceQuatity());
			st.setString(5, parkinglot.getRates());
			
			int ret = st.executeUpdate();
				
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		try {
			String sql  = "select * from zjt.parkingLot where pLocation = ? ";
			st = cn.prepareStatement(sql);
			st.setString(1, parkinglot.getPlocation());
			rs = st.executeQuery();
			if(rs.next()){
		    	parkingLot parkinglot1 = new parkingLot();
		    	parkinglot1.setOwnerId(String.valueOf(rs.getInt("ownerId")));
		    	parkinglot1.setRates(rs.getString("rates"));
		    	parkinglot1.setPname(rs.getString("pName"));
		    	parkinglot1.setPlocation(rs.getString("pLocation"));
				parkinglot1.setParkingSpaceQuatity(rs.getString("parkingSpaceQuatity"));
				parkinglot1.setParkingLotId(rs.getString("parkingLotId"));
		    	
		    	return parkinglot1;
		    }
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DbObject.close(cn, st, null);			
			}
		return null;
	}

	public parkingLot delParkingLot(parkingLot pl) {
		Connection cn = null;
		PreparedStatement st = null;
		cn=DbObject.getConnection();
		try {
			

			//4.执行sql
			
			String sql = "delete from zjt.parkingLot where parkingLotId=? ";
			st = cn.prepareStatement(sql);
			st.setString(1, pl.getParkingLotId());
			int ret = st.executeUpdate();
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5.关闭数据库连接
			DbObject.close(cn, st, null);
		}
		
		//访问数据库，删除一篇文章
		//.......
		return pl;
	}

	public parkingLot findByParkingLotId(String parkingLotId) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		parkingLot pl=new parkingLot();
		cn=DbObject.getConnection();//实现封装
		if(cn==null)
			return null;//数据库连接没有获取到
		
		try {
			//4.执行sql
			String sql = "select * from zjt.parkingLot where parkingLotId=?";
			st = cn.prepareStatement(sql);
			
			st.setString(1, parkingLotId);
						
			rs = st.executeQuery();
			if (rs.next()){
				
				pl.setOwnerId(rs.getString("ownerId"));
				pl.setParkingLotId(rs.getString("parkingLotId"));
				pl.setPname(rs.getString("pName"));
				pl.setPlocation(rs.getString("pLocation"));
				pl.setParkingSpaceQuatity(rs.getString("parkingSpaceQuatity"));
				pl.setRates(rs.getString("rates"));
				
				
				
			}else{
				return null;//没有找到对象
			}
			
		 /*}catch (ClassNotFoundException e) {
			e.printStackTrace();*/
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5.关闭数据库连接
			DbObject.close(cn, st, rs);
		}
		
		return pl;
	
	}

	public parkingLot updateParkingLot(parkingLot pl) {
		Connection cn = null;
		PreparedStatement st = null;
		PreparedStatement st1 = null;
		PreparedStatement st2 = null;
		PreparedStatement st3 = null;
		
		cn = DbObject.getConnection();

		try {
			//4.执行sql
			String sql = "update zjt.parkingLot set pName=? where parkingLotId=?";
			String sql1 = "update zjt.parkingLot set pLocation=? where parkingLotId=?";
			String sql2 = "update zjt.parkingLot set parkingSpaceQuatity=? where parkingLotId=?";
			String sql3 = "update zjt.parkingLot set  rates=? where parkingLotId=?";
			
			st = cn.prepareStatement(sql);
			st1 = cn.prepareStatement(sql1);
			st2 = cn.prepareStatement(sql2);
			st3 = cn.prepareStatement(sql3);
			
			
			st.setString(1, pl.getPname());
			st.setString(2, pl.getParkingLotId());
			st1.setString(1, pl.getPlocation());
			st1.setString(2, pl.getParkingLotId());
			st2.setString(1, pl.getParkingSpaceQuatity());
			st2.setString(2, pl.getParkingLotId());
			st3.setString(1, pl.getRates());
			st3.setString(2, pl.getParkingLotId());
			
			
			int ret = st.executeUpdate();
			int ret1 = st1.executeUpdate();
			int ret2 = st2.executeUpdate();
			int ret3 = st3.executeUpdate();
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5.关闭数据库连接
			DbObject.close(cn, st, null);
			DbObject.close(cn, st1, null);
			DbObject.close(cn, st2, null);
			DbObject.close(cn, st3, null);
			
		}
		return pl;
	}

	public List<parkingLot> findAllparkingLotByLocation(String location) {
		ArrayList<parkingLot> parkingLotList = new ArrayList<parkingLot>();
		ResultSet rs=null;
		Connection cn=null;
		PreparedStatement st=null;
		cn=DbObject.getConnection();
		
		try {
			
			//执行SQL语句
			
			String sql = "select * from zjt.parkingLot where pLocation like ?";
			st = cn.prepareStatement(sql);
			
			
			st.setString(1, "%"+location+"%");
			
			rs=st.executeQuery();
			
			while(rs.next()){
				
				parkingLot pl = new parkingLot();
				
				pl.setOwnerId(rs.getString("ownerId"));
				pl.setParkingLotId(rs.getString("parkingLotId"));
				pl.setPname(rs.getString("pName"));
				pl.setPlocation(rs.getString("pLocation"));
				pl.setParkingSpaceQuatity(rs.getString("parkingSpaceQuatity"));
				pl.setRates(rs.getString("rates"));
				
				
				parkingLotList.add(pl);
							
			}
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, rs);
		}
	
		return parkingLotList;
	}

	

}
