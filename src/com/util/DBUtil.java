package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection con;

	public static Connection getDBConn() {
		String userNameDb = "root";
		String passwordDb = "Varunn@11";
		String urlDb = "jdbc:mysql://localhost:3306/learnings";
		String driverName = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver could not be Loaded");
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(urlDb, userNameDb, passwordDb);
		} catch (SQLException e) {
			System.out.println("Connection could not be established");
			e.printStackTrace();
		}

		return con;

	}

	public static void dbClose() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Connection could not be closed");
			e.printStackTrace();
		}
	}
}
