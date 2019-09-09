package com.bestgroup.app.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.bestgroup.core.dao.DAO;
import com.bestgroup.core.domain.Entity;

public class CustomerDAO extends DAO{
	
	public CustomerDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<Entity> read(Entity entity) throws SQLException {
		return null;
	}

	@Override
	public Entity create(Entity entity) throws SQLException {
		return null;
	}

	@Override
	public Entity update(Entity entity) throws SQLException {
		return null;
	}

	@Override
	public Entity delete(Entity entity) throws SQLException {
		return null;
	}
}
