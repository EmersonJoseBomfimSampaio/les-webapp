package com.bestgroup.core.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.bestgroup.core.domain.Entity;

public abstract class DAO {
	
	protected Connection connection;
	protected boolean commit;
	
	public DAO(Connection connection) { 
		this.connection = connection;
	}
	
	public abstract List<Entity> read(Entity entity) throws SQLException;
	
	public abstract Entity create(Entity entity) throws SQLException;

	public abstract Entity update(Entity entity) throws SQLException;

	public abstract Entity delete(Entity entity) throws SQLException;
}
