package com.gpaddy.tuan5;

import java.sql.SQLException;

public class Dictionary {
	public static void main(String[] args) throws SQLException {
		DataHelper db = new DataHelper();
		db.getAll();
	}
}
