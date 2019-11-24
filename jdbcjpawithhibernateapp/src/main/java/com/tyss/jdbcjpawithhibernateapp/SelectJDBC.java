package com.tyss.jdbcjpawithhibernateapp;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectJDBC {
	public static void main(String[] args) {
		Connection conn = null;              //Interface reference variable
		Statement stmt = null;
		ResultSet rs = null;
		try {
			
			//step 1 load the driver
//			Driver driver = new Driver();
//			DriverManager.registerDriver(driver);
			
			Class.forName("com.mysql.jdbc.Driver");
			
			//step 2 get the connection
			String url = "jdbc:mysql://localhost:3306/ust_ty_db";  //due to URL exception no suitable driver/could not create connection/access denial using password no/yes
			conn = DriverManager.getConnection(url, "root", "root");	//example of method overloading			//due to port number in URl exception connection link failure
			
			//step 3 Issue SQL query
			stmt = conn.createStatement();
			String sql = "select * from employee_info";
			rs = stmt.executeQuery(sql);
			
			//step 4 Read the Result
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int sal = rs.getInt("sal");
				String gender = rs.getString("gender");
				
				System.out.println("Id: "+id);
				System.out.println("Name: "+name);
				System.out.println("Salary: "+sal);
				System.out.println("Gender: "+gender);
				System.out.println("*********************************8");
			
			}
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
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} //end of main
}
