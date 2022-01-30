package com.library.connection;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	String password="oracle";
	public Connection getDBConnect() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system",this.password);
		
	}

	public ConnectionUtil() {
		super();
	}

}
