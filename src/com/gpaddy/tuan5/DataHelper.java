package com.gpaddy.tuan5;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DataHelper {
	
	private Connection connection = null;
	private static final String url = "jdbc:mysql://127.0.0.1/tivi_channel", user = "root", password = "";
	
	public DataHelper() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Where is your MySQL JDBC Driver!");
			e.printStackTrace();
			return;
		}
		System.out.println("MySQL JDBC Driver Registered!");

		try {
			connection = (Connection) DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
	
	public void getAll() throws SQLException {
		Statement st = (Statement) connection.createStatement();
		String sql = "SELECT * FROM channel;";
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt("id");
			String link = rs.getString("link");
			String time = rs.getString("update_time");
			System.out.println(id + " : " + link + " : " + time);
		}
	}
}
