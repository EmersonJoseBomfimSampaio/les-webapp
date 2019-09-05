package com.bestgroup.app.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.bestgroup.app.domain.Customer;
import com.bestgroup.core.dao.DAO;

public class CustomerDAO extends DAO<Customer> {

	public CustomerDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<Customer> read(Customer entity) throws SQLException {
		return null;
	}

	@Override
	public Customer create(Customer entity) throws SQLException {
		
		return entity;
	}

	@Override
	public Customer update(Customer entity) throws SQLException {
		return null;
	}

	@Override
	public Customer delete(Customer entity) throws SQLException {
		return null;
	}

}
