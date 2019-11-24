package com.tyss.jdbcjpawithhibernateapp;

public class DeleteJDBC {
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		
	try {
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
		conn = DriverManager.getConnection(url);
		
		String sql = " delete from employee_info where id=10 ";
		stmt = conn.createStatement();
		int count = stmt.executeUpdate(sql);
		
		System.out.println(count + "Employee table updated ");
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}if(stmt!=null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	 
	}
}
