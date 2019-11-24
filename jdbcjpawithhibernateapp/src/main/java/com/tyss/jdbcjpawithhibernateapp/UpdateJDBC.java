package com.tyss.jdbcjpawithhibernateapp;

public class UpdateJDBC {
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
			String sql = prop.getProperty("update-query");
			pstmt = conn.prepareStatement(sql);
			
			String empid = args[0];
			int id = Integer.parseInt(empid);
			
			String name  = args[1];
			
			String empsal = args[2];
			int sal = Integer.parseInt(empsal);
			
			String gender = args[3];
			
			pstmt.setInt(4, id);
			pstmt.setString(1, name);
			pstmt.setInt(2, sal);
			pstmt.setString(3, gender);
			
			int count = pstmt.executeUpdate();
			
			System.out.println(count + "Row(s) updated ");
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
