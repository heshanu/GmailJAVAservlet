package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	// Common Configurations
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/registration_form?useSSL=false";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "";

	// Main method - return connection object
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver class not found - " + e.getMessage());
		}

		try {
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (SQLException e) {
			System.out.println("Connection error - " + e.getMessage());
		}

		if (connection != null) {
			System.out.println("Connection is up and running !");
		} else {
			System.out.println("Connection is null !");
		}
		return connection;
	}
}
