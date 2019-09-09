package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.bestgroup.app.dao.RoleDAO;
import com.bestgroup.app.domain.Permission;
import com.bestgroup.app.domain.Role;
import com.bestgroup.core.dao.DAO;
import com.bestgroup.util.connection.ConnectionFactory;
import com.bestgroup.util.connection.MysqlConnectionFactory;

public class Main {	
	
	public static void main(String[] args) throws SQLException{
		ConnectionFactory connectionFactory = new MysqlConnectionFactory();
		Connection connection = connectionFactory.create();
		connection.setAutoCommit(false);
		
		DAO dao = new RoleDAO(connection);
		Role role = new Role();
		
		Permission createSomething, deleteSomething, nothing;
		createSomething = new Permission(); 
		deleteSomething = new Permission();
		nothing = new Permission();
		
		createSomething.setId(1l);
		deleteSomething.setId(23l);
		nothing.setId(88l);
		
		role.setPermissions(new ArrayList<Permission>());
		role.getPermissions().add(createSomething);
		//role.getPermissions().add(deleteSomething);
		role.getPermissions().add(nothing);
		
		
		role.setId(10l);
		role.setName("Some role");
		role.setDescription("A very strange role indeed.");
		role.setCreatedAt(new Date());
		role.setUpdatedAt(new Date());
		role.setDeletedAt(new Date());
		
		
		System.out.println(role.getId());
		try { 
			dao.update(role);
			connection.commit();
		} catch(SQLException e ) {
			connection.rollback();
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
}
