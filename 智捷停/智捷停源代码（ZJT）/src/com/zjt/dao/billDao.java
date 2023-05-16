package com.zjt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zjt.common.DbObject;
import com.zjt.entity.bill;

public class billDao {

	public void createBill(bill billInfo) {
		Connection cn=null;
		PreparedStatement st=null;
		
		cn = DbObject.getConnection();
		
		
		try {
			
			
			//执锟斤拷SQL锟斤拷锟�
			
			String sql = "insert into zjt.bill(userName,carLicenseNumber,inPicture,inTime,remark) values(?,?,?,?,?) ";
					
			st=cn.prepareStatement(sql);
			
			st.setString(1,billInfo.getUserName());
			st.setString(2,billInfo.getCarLicenseNumber());
			st.setString(3,billInfo.getInPicture());
			st.setString(4,billInfo.getInTime());
			st.setString(5,billInfo.getRemark());
			
			st.executeUpdate();
			
			 
			
			
		}  catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, null);
		}
		
	}
	

	public bill findByStatus(String carNo, String orderDate) {
		
		bill bl = new bill();
		ResultSet rs=null;
		Connection cn=null;
		PreparedStatement st=null;
		
		cn = DbObject.getConnection();
		
		
		try {
			
			
			//执锟斤拷SQL锟斤拷锟�
			
			String sql = "select billId,carLicenseNumber,inTime,outTime,inPicture,outPicture,carFee,billStatus,userName,remark,(datediff(minute,?,getDate())) parkMinutes from zjt.bill where carLicenseNumber=? and outTime is null  ";
					
			st=cn.prepareStatement(sql);
			st.setString(1,orderDate );
			st.setString(2, carNo);
			
			rs=st.executeQuery();
		
			if(rs.next()){
				
				
				
				bl.setBillNumber(rs.getString("billId"));
				bl.setCarLicenseNumber(rs.getString("carLicenseNumber"));
				bl.setInTime(rs.getString("inTime"));
				bl.setOutTime(rs.getString("outTime"));
				bl.setInPicture(rs.getString("inPicture"));
				bl.setOutPic(rs.getString("outPicture"));
				bl.setCarFee(rs.getInt("carFee"));
				bl.setStatus(rs.getInt("billStatus"));
				bl.setUserName(rs.getString("userName"));
				bl.setMinutes(rs.getInt("parkMinutes"));
				bl.setRemark(rs.getString("remark"));
				
				
			
				
			}
		}  catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, null);
		}
		return bl;

     }

	public void updateBillInfoByBillId(bill billOut) {
		Connection cn=null;
		PreparedStatement st=null;
		cn=DbObject.getConnection();
		
		try {
			
			//执锟斤拷SQL锟斤拷锟�
			
			String sql = "update zjt.bill set outTime=?,outPicture=?,carFee=?,billStatus=?,parkMinutes=? where billId=? ";
			st = cn.prepareStatement(sql);
			
			
			st.setString(1,billOut.getOutTime() );
			st.setString(2,billOut.getOutPic() );
			st.setInt(3,billOut.getCarFee() );
			st.setInt(4,billOut.getStatus() );
			st.setInt(5,billOut.getMinutes() );
			st.setString(6,billOut.getBillNumber() );
			
			
			
			st.executeUpdate();
			
			
			
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, null);
		}
		
	}


	public bill findBillInfoByCarLicenseNumber(String carLicenseNumber) {
		bill bl = new bill();
		ResultSet rs=null;
		Connection cn=null;
		PreparedStatement st=null;
		
		cn = DbObject.getConnection();
		
		
		try {
			
			
			//执锟斤拷SQL锟斤拷锟�
			
			String sql = "select * from zjt.bill where carLicenseNumber=? and outTime is not null and billStatus=0";
					
			st=cn.prepareStatement(sql);
			st.setString(1,carLicenseNumber );
			
			
			rs=st.executeQuery();
		
			if(rs.next()){
				
				
				
				bl.setBillNumber(rs.getString("billId"));
				bl.setCarLicenseNumber(rs.getString("carLicenseNumber"));
				bl.setInTime(rs.getString("inTime"));
				bl.setOutTime(rs.getString("outTime"));
				bl.setInPicture(rs.getString("inPicture"));
				bl.setOutPic(rs.getString("outPicture"));
				bl.setCarFee(rs.getInt("carFee"));
				bl.setStatus(rs.getInt("billStatus"));
				bl.setUserName(rs.getString("userName"));
				bl.setMinutes(rs.getShort("parkMinutes"));
				bl.setRemark(rs.getString("remark"));
				
				
			
				
			}
		}  catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, null);
		}
		return bl;
	}


	public void createCancelOrderBill(bill billOut) {
		Connection cn=null;
		PreparedStatement st=null;
		
		cn = DbObject.getConnection();
		
		
		try {
			
			
			//执锟斤拷SQL锟斤拷锟�
			
			String sql = "insert into zjt.bill(userName,carLicenseNumber,carFee,inTime,outTime,parkMinutes,remark) values(?,?,?,?,?,?,?) ";
					
			st=cn.prepareStatement(sql);
			
			st.setString(1,billOut.getUserName());
			st.setString(2,billOut.getCarLicenseNumber());
			st.setInt(3,billOut.getCarFee());
			st.setString(4,billOut.getInTime());
			st.setString(5,billOut.getOutTime());
			st.setInt(6,billOut.getMinutes());
			st.setString(7,billOut.getRemark());
			
			st.executeUpdate();
			
			 
			
			
		}  catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, null);
		}
		
	}


	public List<bill> showBillListByUserNameStatus(String userName) {
		ArrayList<bill> billList = new ArrayList<bill>();
		ResultSet rs=null;
		Connection cn=null;
		PreparedStatement st=null;
		
		cn = DbObject.getConnection();
		
		
		try {
			
			
			//执锟斤拷SQL锟斤拷锟�
			
			String sql = "select * from zjt.bill where userName=? and billStatus=0";
					
			st=cn.prepareStatement(sql);
			st.setString(1, userName);
			rs=st.executeQuery();
		
			while(rs.next()){
					
				bill bill = new bill();
				
				bill.setUserName(rs.getString("userName"));
				bill.setBillNumber(rs.getString("billId"));
				bill.setCarLicenseNumber(rs.getString("carLicenseNumber"));
				bill.setInTime(rs.getString("inTime"));
				bill.setOutTime(rs.getString("outTime"));
				bill.setInPicture(rs.getString("inPicture"));
				bill.setOutPic(rs.getString("outPicture"));
				bill.setCarFee(rs.getInt("carFee"));
				bill.setMinutes(rs.getInt("parkMinutes"));
				bill.setStatus(rs.getInt("billStatus"));
				bill.setRemark(rs.getString("remark"));			
				billList.add(bill);
			}
		}  catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, null);
		}
		return billList;
	}


	public List<bill> showBillListByUserName(String userName) {
		ArrayList<bill> billList = new ArrayList<bill>();
		ResultSet rs=null;
		Connection cn=null;
		PreparedStatement st=null;
		
		cn = DbObject.getConnection();
		
		
		try {
			
			
			//执锟斤拷SQL锟斤拷锟�
			
			String sql = "select * from zjt.bill where userName=?";
					
			st=cn.prepareStatement(sql);
			st.setString(1, userName);
			rs=st.executeQuery();
		
			while(rs.next()){
				
				bill bill = new bill();
				
				
				bill.setUserName(rs.getString("userName"));
				bill.setBillNumber(rs.getString("billId"));
				bill.setCarLicenseNumber(rs.getString("carLicenseNumber"));
				bill.setInTime(rs.getString("inTime"));
				bill.setOutTime(rs.getString("outTime"));
				bill.setInPicture(rs.getString("inPicture"));
				bill.setOutPic(rs.getString("outPicture"));
				bill.setCarFee(rs.getInt("carFee"));
				bill.setMinutes(rs.getInt("parkMinutes"));
				bill.setStatus(rs.getInt("billStatus"));
				bill.setRemark(rs.getString("remark"));			
				billList.add(bill);
			}
		}  catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, null);
		}
		return billList;
	}


	public void updateBillStausByBillId(String billNumber) {
		Connection cn=null;
		PreparedStatement st=null;
		cn=DbObject.getConnection();
		
		try {
			
			//执锟斤拷SQL锟斤拷锟�
			
			String sql = "update zjt.bill set billStatus=1 where billId=? ";
			st = cn.prepareStatement(sql);
			
			
			st.setString(1,billNumber);
			
			
			
			
			st.executeUpdate();
			
			
			
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, null);
		}
		
	}

}
