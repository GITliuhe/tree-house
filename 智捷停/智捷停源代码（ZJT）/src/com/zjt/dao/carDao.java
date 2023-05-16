package com.zjt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zjt.common.DbObject;
import com.zjt.entity.car;
import com.zjt.entity.parkingLot;

public class carDao {

	public List<car> findCarByUserName(String userName) {
		ArrayList<car> carList = new ArrayList<car>();
		ResultSet rs=null;
		Connection cn=null;
		PreparedStatement st=null;
		cn=DbObject.getConnection();
		
		try {
			
			//执行SQL语句
			
			String sql = "select * from zjt.car where userName=? ";
			st = cn.prepareStatement(sql);
			
			
			st.setString(1, userName);
			
			rs=st.executeQuery();
			
			while(rs.next()){
				
				car car = new car();
				car.setCarLicenseNumber(rs.getString("carLicenseNumber"));
				car.setUserName(userName);
				
				
				carList.add(car);
				
				
				
				
				
				
				
			}
			
			
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, rs);
		}
		
		
		
		
		
		return carList;
	}

	public car addCar(car car) {
		Connection cn=null;
		PreparedStatement st=null;
		cn=DbObject.getConnection();
try {
			
			//执行SQL语句
			
			String sql = "insert into zjt.car(userName,carLicenseNumber) values(?,?)";
			st = cn.prepareStatement(sql);
			
			
			st.setString(1, car.getUserName());
			st.setString(2, car.getCarLicenseNumber());
			
			st.executeUpdate();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, null);
		}
	return car;
	}

	public Object findCarBycarLicenseNumber(String carLicenseNumber) {
		String carNumber=null;
		ResultSet rs=null;
		Connection cn=null;
		PreparedStatement st=null;
		cn=DbObject.getConnection();
		
		try {
			
			//执行SQL语句
			
			String sql = "select * from zjt.car where carLicenseNumber=? ";
			st = cn.prepareStatement(sql);
			
			
			st.setString(1, carLicenseNumber);
			
			rs=st.executeQuery();
			
			while(rs.next()){
				carNumber=rs.getString("carLicenseNumber");			
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, rs);
		}
		return carNumber;
	}

	public car delCar(car c1) {
		Connection cn = null;
		PreparedStatement st = null;
		cn=DbObject.getConnection();
		try {
			

			//4.执行sql
			
			String sql = "delete from zjt.car where carLicenseNumber=? ";
			st = cn.prepareStatement(sql);
			st.setString(1, c1.getCarLicenseNumber());
			int ret = st.executeUpdate();
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5.关闭数据库连接
			DbObject.close(cn, st, null);
		}
		
		//访问数据库，删除一篇文章
		//.......
		return c1;
	}

}
