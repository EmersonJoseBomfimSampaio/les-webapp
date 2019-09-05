package test;

import java.sql.Connection;
import java.sql.SQLException;

import com.bestgroup.util.connection.ConnectionFactory;
import com.bestgroup.util.connection.MysqlConnectionFactory;

public class Main {
	
	public static void main(String[] args) throws SQLException  {
		ConnectionFactory f = new MysqlConnectionFactory();
		Connection connection = f.create();
		System.out.println(connection.isClosed());
		connection.close();
	}
}
