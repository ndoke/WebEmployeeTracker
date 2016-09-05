package com.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmployeeDeleteDAO {

	@SuppressWarnings("unused")
	public void deleteEmployee(int eid) {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		int myRs = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "@Godfather01");

			String sql = "DELETE FROM empdata.employee WHERE eid=?;";

			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, eid);
			myRs = myStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
