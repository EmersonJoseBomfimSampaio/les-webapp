package com.bestgroup.util.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnectionFactory implements ConnectionFactory{
	
	protected String username = "les_webapp_username"; 
	protected String password = "les_webapp_password";
	protected String database = "les_webapp_database";
	protected String connectionString = "jdbc:mysql://127.0.0.0:3360/";
	
	@Override
	public Connection create() {
		
		try {
			return DriverManager.getConnection(connectionString + database, username, password);
		} catch (SQLException ex) {
		    // handle any errors
			ex.printStackTrace();
		    System.out.println("Exception: " + ex.getMessage());
		}
		
		return null;
	}
}
