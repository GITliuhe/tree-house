package com.zjt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zjt.common.DbObject;
import com.zjt.entity.order;

public class orderDao {

	public void createOrder(String userName, String carLicenseNumber,
			String spaceId,String phoneNumber, String spaceNumber, String parkingLot) {
		Connection cn=null;
		PreparedStatement st=null;
		
		cn = DbObject.getConnection();
		
		
		try {
			
			
			//执锟斤拷SQL锟斤拷锟�
			
			String sql = "insert into zjt.orders(userName,carLicenseNumber,spaceId,phoneNumber,spaceNumber,parkingLot) values(?,?,?,?,?,?) ";
					
			st=cn.prepareStatement(sql);
			
			st.setString(1, userName);
			st.setString(2,carLicenseNumber);
			st.setString(3,spaceId);
			st.setString(4,phoneNumber);
			st.setString(5,spaceNumber);
			st.setString(6,parkingLot);
			
			st.executeUpdate();
			
			 
			
			
		}  catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, null);
		}
	
		
	}

	

	public List<order> showOrderListByUserName(String userName) {
		ArrayList<order> orderList = new ArrayList<order>();
		ResultSet rs=null;
		Connection cn=null;
		PreparedStatement st=null;
		
		cn = DbObject.getConnection();
		
		
		try {
			
			
			//执锟斤拷SQL锟斤拷锟�
			
			String sql = "select * from zjt.orders where userName=?";
					
			st=cn.prepareStatement(sql);
			st.setString(1, userName);
			rs=st.executeQuery();
		
			while(rs.next()){
				
				order order = new order();
				
				
				order.setUserName(rs.getString("userName"));
				order.setOrderNumber(rs.getString("orderNumber"));
				order.setCarLicenseNumber(rs.getString("carLicenseNumber"));
				order.setSpaceId(rs.getString("spaceId"));
				order.setFinishDate(rs.getString("finishDate"));
				order.setOrderDate(rs.getString("orderDate"));
				order.setParkingLot(rs.getString("parkingLot"));
				order.setSpaceNumber(rs.getString("spaceNumber"));
			
				orderList.add(order);
			}
		}  catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, null);
		}
		return orderList;
	}



	public order findCarByCarNumb(String carNo) {
		order order = new order();
		ResultSet rs=null;
		Connection cn=null;
		PreparedStatement st=null;
		
		cn = DbObject.getConnection();
		
		
		try {
			
			
			//执锟斤拷SQL锟斤拷锟�
			
			String sql = "select * from zjt.orders where carLicenseNumber=? and finishDate is null ";
					
			st=cn.prepareStatement(sql);
			st.setString(1, carNo);
			rs=st.executeQuery();
		
			if(rs.next()){
				
				
				
				
				order.setUserName(rs.getString("userName"));
				order.setOrderNumber(rs.getString("orderNumber"));
				order.setCarLicenseNumber(rs.getString("carLicenseNumber"));
				order.setSpaceId(rs.getString("spaceId"));
				order.setFinishDate(rs.getString("finishDate"));
				order.setOrderDate(rs.getString("orderDate"));
				order.setPhoneNumber(rs.getString("phoneNumber"));
				order.setStatus(rs.getInt("status"));
			
				
			}
		}  catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, null);
		}
		return order;
	}



	public void updateOrderStatus(String orderNumber) {
		Connection cn=null;
		PreparedStatement st=null;
		cn=DbObject.getConnection();
		
		try {
			
			//执锟斤拷SQL锟斤拷锟�
			
			String sql = "update zjt.orders set status=1 where orderNumber=? ";
			st = cn.prepareStatement(sql);
			
			
			st.setString(1, orderNumber);
			
			
			st.executeUpdate();
			
			
			
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, null);
		}
		
	}



	public void updateOrderFinishDate(String orderNumber) {
		Connection cn=null;
		PreparedStatement st=null;
		cn=DbObject.getConnection();
		
		try {
			
			//执锟斤拷SQL锟斤拷锟�
			
			String sql = "update zjt.orders set finishDate=getDate() where orderNumber=? ";
			st = cn.prepareStatement(sql);
			
			
			st.setString(1, orderNumber);
			
			
			st.executeUpdate();
			
			
			
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, null);
		}
		
	}



	public order findOrderInfoByCarLicenseNumber(String carLicenseNumber) {
		order order = new order();
		ResultSet rs=null;
		Connection cn=null;
		PreparedStatement st=null;
		
		cn = DbObject.getConnection();
		
		
		try {
			
			
			//执锟斤拷SQL锟斤拷锟�
			
			String sql = "select * from zjt.orders where carLicenseNumber=? and finishDate is null and status=0 ";
					
			st=cn.prepareStatement(sql);
			st.setString(1, carLicenseNumber);
			rs=st.executeQuery();
		
			if(rs.next()){
				
				
				
				
				order.setUserName(rs.getString("userName"));
				order.setOrderNumber(rs.getString("orderNumber"));
				order.setCarLicenseNumber(rs.getString("carLicenseNumber"));
				order.setSpaceId(rs.getString("spaceId"));
				order.setFinishDate(rs.getString("finishDate"));
				order.setOrderDate(rs.getString("orderDate"));
				order.setPhoneNumber(rs.getString("phoneNumber"));
				order.setStatus(rs.getInt("status"));
			
				
			}
		}  catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, null);
		}
		return order;
	}



	public List<order> showUnUsedOrderListByUserName(String userName) {
		ArrayList<order> orderList = new ArrayList<order>();
		ResultSet rs=null;
		Connection cn=null;
		PreparedStatement st=null;
		
		cn = DbObject.getConnection();
		
		
		try {
			
			
			//执锟斤拷SQL锟斤拷锟�
			
			String sql = "select * from zjt.orders where userName=? and status=0";
					
			st=cn.prepareStatement(sql);
			st.setString(1, userName);
			rs=st.executeQuery();
		
			while(rs.next()){
				
				order order = new order();
				
				
				order.setUserName(rs.getString("userName"));
				order.setOrderNumber(rs.getString("orderNumber"));
				order.setCarLicenseNumber(rs.getString("carLicenseNumber"));
				order.setSpaceId(rs.getString("spaceId"));
				order.setFinishDate(rs.getString("finishDate"));
				order.setOrderDate(rs.getString("orderDate"));
				order.setParkingLot(rs.getString("parkingLot"));
				order.setSpaceNumber(rs.getString("spaceNumber"));
			
				orderList.add(order);
			}
		}  catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, null);
		}
		return orderList;
	}



	public order findCancelOrderTime(String orderNumber, String orderDate) {
		order order = new order();
		ResultSet rs=null;
		Connection cn=null;
		PreparedStatement st=null;
		
		cn = DbObject.getConnection();
		
		
		try {
			
			
			//执锟斤拷SQL锟斤拷锟�
			
			String sql = "select (datediff(minute,?,getDate())) status from zjt.orders where orderNumber=?";
					
			st=cn.prepareStatement(sql);
			st.setString(1, orderDate);
			st.setString(2, orderNumber);
			rs=st.executeQuery();
		
			while(rs.next()){
				
				
				
				
				
				order.setStatus(rs.getInt("status"));
				
			
				
			}
		}  catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, null);
		}
		return order;
	}



	public order findOrderInfoByOrderNumber(String orderNumber) {
		order order = new order();
		ResultSet rs=null;
		Connection cn=null;
		PreparedStatement st=null;
		
		cn = DbObject.getConnection();
		
		
		try {
			
			
			//执锟斤拷SQL锟斤拷锟�
			
			String sql = "select * from zjt.orders where orderNumber=?";
					
			st=cn.prepareStatement(sql);
			st.setString(1, orderNumber);
			rs=st.executeQuery();
		
			while(rs.next()){
				
				
				
				
				order.setUserName(rs.getString("userName"));
				order.setOrderNumber(rs.getString("orderNumber"));
				order.setCarLicenseNumber(rs.getString("carLicenseNumber"));
				order.setSpaceId(rs.getString("spaceId"));
				order.setFinishDate(rs.getString("finishDate"));
				order.setOrderDate(rs.getString("orderDate"));
				order.setParkingLot(rs.getString("parkingLot"));
				order.setSpaceNumber(rs.getString("spaceNumber"));
				order.setPhoneNumber(rs.getString("phoneNumber"));
			
				
			}
		}  catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, null);
		}
		return order;
	}



	public int findQuantityBydate(String monday) {
		int quantity = 0;
		ResultSet rs=null;
		Connection cn=null;
		PreparedStatement st=null;
		
		cn = DbObject.getConnection();
		
		
		try {
			
			
			//执锟斤拷SQL锟斤拷锟�
			
			String sql = "select count(*) quantity from zjt.orders where orderdate between ? and ?";
					
			st=cn.prepareStatement(sql);
			st.setString(1, monday+" "+"0:00:00");
			st.setString(2, monday+" "+"23:59:59");
			rs=st.executeQuery();
		
			if(rs.next()){
				
				
				quantity=rs.getInt("quantity");
	
			}
		}  catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, null);
		}
		return quantity;
	}

	

}
