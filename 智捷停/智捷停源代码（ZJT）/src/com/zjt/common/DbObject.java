package com.zjt.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbObject {
	public static Connection getConnection(){
		Connection cn = null;
		
		try {
			//1.注册数据库
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			
			//2.创建数据库连接串
			
			String url="jdbc:sqlserver://localhost:1433;user=sa;password=liuhe160510;database=ZJT";
			//String url="jdbc:sqlserver://localhost:1433;user=sa1;password=mis123456;database=ZJT";
			//String url="jdbc:sqlserver://localhost:1433;user=sa;password=wzd20002765;database=ZJT";
			
			//3.建立连接
			
			cn = DriverManager.getConnection(url);
			
			return cn;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public static void close(Connection cn, PreparedStatement st, ResultSet rs){
		//5.关闭数据库连接
		if (rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			rs = null;
		}
		if (st != null){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			st = null;
		}
		if (cn != null){
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			cn = null;
		}
	}


}
