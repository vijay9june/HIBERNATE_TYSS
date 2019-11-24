package com.tyss.jdbcjpawithhibernateapp;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

public class Insert {
	public static void main(String[] args) {
		Connection conn = null;              
		Statement stmt = null;
		ResultSet rs = null;
		FileReader reader = null;
		PreparedStatement pstmt = null;
		try {
			reader = new FileReader("db.properties");
			Properties prop = new Properties();
			prop.load(reader);
			
			String driver=prop.getProperty("driver-class-name");
			Class.forName(driver);
			
			//step 2 get the connection
			String url = prop.getProperty("url");  
			conn = DriverManager.getConnection(url, prop);	
			
			//step 3 Issue SQL query
			String sql = prop.getProperty("insert-query");
			pstmt = conn.prepareStatement(sql);
			String empid = args[0];
			int id = Integer.parseInt(empid);
			pstmt.setInt(1, id);
			
			String name = args[1];
			pstmt.setString(2, name);
			
			String empsal = args[2];
			int sal = Integer.parseInt(empsal);
			pstmt.setInt(3, sal);
			
			String gender = args[3];
			pstmt.setString(4, gender);
			//int count = stmt.executeUpdate(sql);
			int count = pstmt.executeUpdate();
			
			//step 4 Read the Result
			System.out.println(count + "Row(s) Inserted");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// step 5 close all JDBC objects
			try {
				if(conn!=null) {
					conn.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				if(rs!=null) {
					rs.close();
				}
				if(reader!=null) {
					reader.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	} //end of main
}
