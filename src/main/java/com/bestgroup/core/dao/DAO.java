package com.bestgroup.core.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.bestgroup.core.domain.Entity;

public abstract class DAO<E extends Entity> {
	
	protected Connection connection;
	protected boolean commit;
	
	public DAO(Connection connection) { 
		this(connection, true);
	}
	
	public DAO(Connection connection,boolean commit) { 
		this.connection = connection;
		this.commit = commit;
	}
	
	public abstract List<E> read(E entity) throws SQLException;
	
	public abstract E create(E entity) throws SQLException;

	public abstract E update(E entity) throws SQLException;

	public abstract E delete(E entity) throws SQLException;
}
