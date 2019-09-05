package com.bestgroup.app.core.facade.strategies.customer;

import com.bestgroup.core.domain.Entity;
import com.bestgroup.core.facade.Result;
import com.bestgroup.core.facade.Strategy;
import com.bestgroup.util.connection.ConnectionFactory;
import com.bestgroup.util.connection.MysqlConnectionFactory;

public class CreateCustomer implements Strategy {

	ConnectionFactory connectionFactory = new MysqlConnectionFactory();
	
	@Override
	public void handle(Entity entity, Result result) {
		result.getEntities().add(entity);
	}
}
