package com.library.connection;
import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static String password = "oracle";
	public static Connection getDBConnect() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system",password);
		
	}

	private ConnectionUtil() {
		super();
	}

}
