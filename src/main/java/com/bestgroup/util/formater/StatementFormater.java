package com.bestgroup.util.formater;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatementFormater {
	
	Connection connection;
	
	public StatementFormater(Connection connection) { 
		this.connection = connection;
	}
	
	public PreparedStatement format(String sql , Object ...params) throws SQLException{ 
		PreparedStatement statement;
		
		if(sql.contains("INSERT") || sql.contains("insert")) { 
			statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		} else { 
			statement = connection.prepareStatement(sql);
		}
		
		int index = 1; 
		
		for(Object o : params) { 
			statement.setObject(index++, o);
		}
		
		return statement;
	}
}
