package com.bestgroup.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.bestgroup.app.domain.Employee;
import com.bestgroup.core.dao.DAO;
import com.bestgroup.core.domain.Entity;
import com.bestgroup.util.formater.StatementFormater;

public class EmployeeDAO extends DAO {

	public EmployeeDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<Entity> read(Entity entity) throws SQLException {
		return null;
	}

	@Override
	public Entity create(Entity entity) throws SQLException {
		
		Employee employee = (Employee) entity;
		employee.setCreatedAt(new Date());
		
		ResultSet generatedKeys;
		StatementFormater formater = new StatementFormater(this.connection);
		PreparedStatement statement = formater.format("INSERT INTO "
				+ "employees(role_id, employee_id, name, email, password, created_at) "
				+ "VALUES(?, ?, ? ,? ,? ,?) ",
					employee.getRole() == null ? null : employee.getRole().getId(),
					employee.getEmployee() == null ? null : employee.getEmployee().getId(),
					employee.getName(),
					employee.getEmail(),
					employee.getPassword(),
					employee.getCreatedAt()
				);	
		
		statement.executeUpdate();
		generatedKeys = statement.getGeneratedKeys();
		generatedKeys.next();
		employee.setId(generatedKeys.getLong(1));
		
		return employee;
	}

	@Override
	public Entity update(Entity entity) throws SQLException {
		
		Employee employee = (Employee) entity;
		employee.setUpdatedAt(new Date());
		
		StatementFormater formater = new StatementFormater(this.connection);
		PreparedStatement statement = formater.format("UPDATE employees "
				+ "SET role_id = ?, employee_id = ?, name = ?, email = ?, password = ?, updated_at = ?"
				+ "WHERE id = ? ",
					employee.getRole() == null ? null : employee.getRole().getId(),
					employee.getEmployee() == null ? null : employee.getEmployee().getId(),
					employee.getName(),
					employee.getEmail(),
					employee.getPassword(),
					employee.getUpdatedAt(),
					employee.getId()
				);
		
		statement.executeUpdate();
		
		return employee;
	}

	@Override
	public Entity delete(Entity entity) throws SQLException {
		
		Employee employee = (Employee) entity;
		employee.setDeletedAt(new Date());
		
		StatementFormater formater = new StatementFormater(this.connection);
		PreparedStatement statement = formater.format("UPDATE employees SET deleted_at = ? WHERE id = ?",
				employee.getDeletedAt(),
				employee.getId());
		
		statement.executeUpdate();
		return entity;
	}
}
