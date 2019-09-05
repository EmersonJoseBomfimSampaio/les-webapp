package com.bestgroup.app.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.bestgroup.app.domain.Category;
import com.bestgroup.core.dao.DAO;
import com.bestgroup.util.formater.StatementFormater;

public class CategoryDAO extends DAO<Category> {

	StatementFormater sf;
	
	public CategoryDAO(Connection connection) {
		super(connection);
		sf = new StatementFormater(connection);
	}

	@Override
	public List<Category> read(Category entity) throws SQLException {
		
		return null;
	}

	@Override
	public Category create(Category entity) throws SQLException {
		
		return null;
	}

	@Override
	public Category update(Category entity) throws SQLException {
		return null;
	}

	@Override
	public Category delete(Category entity) throws SQLException {
		return null;
	}	
}
