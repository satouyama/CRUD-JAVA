package com.crud.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/crud";
		String user = "root";
		String password = "";

		try {
			// Class.forName(com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

}
