package com.zjt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zjt.common.DbObject;
import com.zjt.entity.user;

public class userDao {

	public com.zjt.entity.user showInfo(String userName) {
		user user =new user();
		ResultSet rs=null;
		Connection cn=null;
		PreparedStatement st=null;
		cn=DbObject.getConnection();
		
		try {
			
			//ִ��SQL���
			
			String sql = "select * from zjt.users where userName=?";
			st = cn.prepareStatement(sql);
			
			st.setString(1, userName);
			
			
			rs=st.executeQuery();
			
			if(rs.next()){
				
				
				
				user.setUserName(rs.getString("userName"));
				user.setPasswords(rs.getString("passwords"));
				user.setRealName(rs.getString("realName"));
				user.setSex(rs.getString("sex"));
				user.setPhoneNUmber(rs.getString("phoneNumber"));
				
				return user;
				
				
				
			}
			else{
				
				return null;
			}
			
			
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, rs);
		}
		
		
		return user;
	}

	public com.zjt.entity.user addUser(user user) {
		Connection cn=null;
		PreparedStatement st=null;
		
		cn = DbObject.getConnection();
		
		
		try {
			
			
			//ִ��SQL���
			
			String sql = "insert into zjt.users(userName,passwords,realName,sex,phoneNumber) values(?,?,?,?,?) ";
					
			st=cn.prepareStatement(sql);
			
			st.setString(1, user.getUserName());
			st.setString(2,user.getPasswords());
			st.setString(3,user.getRealName());
			st.setString(4,user.getSex());
			st.setString(5,user.getPhoneNUmber());
			
			st.executeUpdate();
			
			 
			
			
		}  catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbObject.close(cn, st, null);
		}
		return user;
	}

	

}
