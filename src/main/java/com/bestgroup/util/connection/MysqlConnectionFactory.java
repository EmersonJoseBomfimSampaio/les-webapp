package com.bestgroup.util.connection;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnectionFactory implements ConnectionFactory{
	
	protected String username = "les_webapp_username"; 
	protected String password = "les_webapp_password";
	protected String database = "les_webapp_database";
	protected String connectionString = "jdbc:mysql://localhost/";
	
	@Override
	public Connection create() {
		

        try {
			Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
