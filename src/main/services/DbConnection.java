package main.services;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;


public class DbConnection {
	
	String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
	String dblink, dbuser, dbpass;
	Connection con;
	
	public DbConnection(String dblink, String dbuser, String dbpass) throws Exception {
		this.dblink = dblink;
		this.dbuser = dbuser;
		this.dbpass = dbpass;
		try{  
			Class.forName(this.JDBC_DRIVER);
			con = DriverManager.getConnection(this.dblink, this.dbuser, this.dbpass); 
		}
		catch(Exception e){
			throw new Exception("Failed to connect to database.");
		}  
	}
	
	public Map<Object, Object> login(String username, String password)  {
		Map<Object, Object> retMap = new HashMap<Object, Object>();
		if(username.equals("") || password.equals("")) {
			retMap.put("success", false);
			retMap.put("error", "Login fields cannot be empty.");
			return retMap;
		}
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * from users WHERE userName=?");
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			if(!rs.next()) {
				retMap.put("success", false);
				retMap.put("error", "Username does not exist.");
				return retMap;
			}
			if(!rs.getString("password").equals(password)) {
				retMap.put("success", false);
				retMap.put("error", "Incorrect password.");
				return retMap;
			}
			retMap.put("success", true);
			retMap.put("userId", rs.getString("userId"));
			retMap.put("fullName", rs.getString("fullName"));
			retMap.put("userName", rs.getString("userName"));
			return retMap;
		} catch (SQLException e) {
			retMap.put("success", false);
			retMap.put("error", "Unexpected error occured.");
			return retMap;
		}  
	}

	public Map<Object, Object> signup(String fullname, String username, String password){
		Map<Object, Object> retMap = new HashMap<Object, Object>();
		if(fullname.equals("") || username.equals("") || password.equals("")) {
			retMap.put("success", false);
			retMap.put("error", "Signup fields cannot be empty.");
			return retMap;
		}
		if(password.length() < 8) {
			retMap.put("success", false);
			retMap.put("error", "Password must be atleast 8 characters long.");
			return retMap;
		}
		try {
			PreparedStatement stmt_one = con.prepareStatement("SELECT * from users WHERE userName=?");
			stmt_one.setString(1, username);
			ResultSet rs = stmt_one.executeQuery();
			if(rs.next()) {
				retMap.put("success", false);
				retMap.put("error", "Username already exists.");
				return retMap;
			}
			PreparedStatement stmt_two = con.prepareStatement("INSERT INTO users(fullName, userName, password) VALUES(?,?,?)");
			stmt_two.setString(1, fullname);
			stmt_two.setString(2, username);
			stmt_two.setString(3, password);
			stmt_two.executeUpdate();
			retMap = this.login(username, password);
			return retMap;
		}
		catch (SQLException e) {
			retMap.put("success", false);
			retMap.put("error", "Unexpected error occured.");
			return retMap;
		}  
	}
	
	// if authorized returns String array with employee data else returns null
//	public Employee loginVerification(String employeeId, String pin) {
//		String query = "SELECT * FROM employee WHERE employeeId=" + employeeId + " and pin="+pin;
//		Statement st;
//		try {
//			st = con.createStatement();
//			ResultSet rs = st.executeQuery(query); 
//	        if (rs.next()) {
//	            return new Employee(rs.getString("EmployeeId"), rs.getString("Name"), rs.getString("Position"));
//	        }
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        return null;
//	}
	
}
