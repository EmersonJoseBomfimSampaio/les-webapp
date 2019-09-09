package com.bestgroup.util.formater;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StatementFormater {
	
	protected Connection connection;
	protected final Pattern pattern = Pattern.compile("(\\d)\\{(.[^\\{\\}]*)\\}");
	
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
	
	public PreparedStatement formatWithoutNulls(String sql, Object ...params) throws SQLException{
		
		PreparedStatement statement;
		
		StringBuilder sb = new StringBuilder();
		Matcher matcher = pattern.matcher(sql);
		
		Map<String, Object> paramValues = new HashMap<>();
		List<Object> paramsToAdd = new ArrayList<>();
		
		for(int i = 0; i < params.length; i++) {
			paramValues.put(i + 1 + "", params[i]);
		}
		
		int sPos = 0;
		
		while(matcher.find()) {
			sb.append(sql.substring(sPos, matcher.start()));
			sPos = matcher.end();
			if(paramValues.get(matcher.group(1)) != null) {
				sb.append(matcher.group(2));
				if(matcher.group(2).contains("?")) { 
					paramsToAdd.add(paramValues.get(matcher.group(1)));
				};
			}
		}
		
		sb.append(sql.substring(sPos, sql.length()));
		
		String newSql = sb.toString();
		
		if(sql.contains("INSERT") || newSql.contains("insert")) { 
			statement = connection.prepareStatement(newSql, PreparedStatement.RETURN_GENERATED_KEYS);
		} else { 
			statement = connection.prepareStatement(newSql);
		}
		
		int index = 1; 
		
		for(Object o : paramsToAdd) { 
			statement.setObject(index++, o);
		}
		
		return statement;
	}
}
