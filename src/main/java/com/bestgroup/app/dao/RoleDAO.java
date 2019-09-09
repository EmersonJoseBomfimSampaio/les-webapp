package com.bestgroup.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.bestgroup.app.domain.Permission;
import com.bestgroup.app.domain.Role;
import com.bestgroup.core.dao.DAO;
import com.bestgroup.core.domain.Entity;
import com.bestgroup.util.formater.StatementFormater;

public class RoleDAO extends DAO {

	public RoleDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Entity> read(Entity entity) throws SQLException {
		return null;
	}

	@Override
	public Entity create(Entity entity) throws SQLException {
		
		// Cast the entity and set the createdAt 
		Role role = (Role) entity;
		role.setCreatedAt(new Date());
		
		// Create the statement 
		ResultSet generatedKeys;
		StatementFormater formater = new StatementFormater(this.connection);
		PreparedStatement statement = formater.format("INSERT INTO "
				+ "roles(employee_id, name, description, created_at) "
				+ "VALUES(?, ?, ?, ?)",
				role.getEmployee() == null ? null : role.getEmployee().getId(),
				role.getName(),
				role.getDescription(),
				role.getCreatedAt());
		
		// Create the role 
		statement.executeUpdate();
		
		// Get the generated keys 
		generatedKeys = statement.getGeneratedKeys();
		generatedKeys.next();
		role.setId(generatedKeys.getLong(1));
		
		// If the role has permissions
		if(role.getPermissions() != null && !role.getPermissions().isEmpty())
		{
			String sql = "INSERT INTO "
					+ "roles_permissions(role_id, permission_id, created_at) "
					+ "VALUES(?, ?, ?) ";
			// For each permission 
			for(Permission permission : role.getPermissions()) {
				
				// Create the statement
				statement = formater.format(sql,
						role.getId(),
						permission.getId(),
						role.getCreatedAt());
				
				//Save the relationship
				statement.executeUpdate();
			}
		}
		
		return role;
	}

	@Override
	public Entity update(Entity entity) throws SQLException {
		
		// Cast the entity and set the updatedAt
		Role role = (Role) entity;
		role.setUpdatedAt(new Date());

		// Create the statement 
		StatementFormater formater = new StatementFormater(this.connection);
		PreparedStatement statement;
		
		statement = formater.format("UPDATE roles "
				+ "SET employee_id = ? , name = ?, description = ?, updated_at = ? "
				+ "WHERE id = ? ",
				role.getEmployee() == null ? null : role.getEmployee().getId(),
				role.getName(),
				role.getDescription(),
				role.getUpdatedAt(),
				role.getId());
		
		// Update the role 
		statement.executeUpdate();
		
		// If the role has permissions
		if(role.getPermissions() != null && !role.getPermissions().isEmpty())
		{
			// Remove the current relationships;
			statement = formater.format("UPDATE roles_permissions "
					+ "SET deleted_at = ? WHERE role_id = ?",
					role.getUpdatedAt(),
					role.getId());
			
			statement.executeUpdate();
			
			// Recreate the relationships
			String sql = "INSERT INTO "
					+ "roles_permissions(role_id, permission_id, created_at) "
					+ "VALUES(?, ?, ?) ";
			
			// For each permission 
			for(Permission permission : role.getPermissions()) {
				
				// Create the statement
				statement = formater.format(sql,
						role.getId(),
						permission.getId(),
						role.getCreatedAt());
				
				//Save the relationship
				statement.executeUpdate();
			}
		}
		
		return role;
	}

	@Override
	public Entity delete(Entity entity) throws SQLException {
		
		
		
		return null;
	}

}
