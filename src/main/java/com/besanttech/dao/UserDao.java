package com.besanttech.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.besanttech.entities.User;

public class UserDao {
	static Connection con = null;
	static {
		// initialize data source connections
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myshoppingstore", "root", "Kavilan@2022");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public User getUserDetails(User user) {

		try {
		String loginQuery = "select * from users where user_name =? and user_pwd=?";
		PreparedStatement stmt = con.prepareStatement(loginQuery);
		stmt.setString(1, user.getUserName());
		stmt.setString(2, user.getPassword());

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.print("login details correct");
			return user;
		}

	
	}

	catch(Exception e){
		System.out.println("Exception: "+e.getMessage());
	}
		return null;
}}

