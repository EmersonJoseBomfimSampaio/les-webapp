package com.bestgroup.core.facade;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bestgroup.core.domain.Entity;

public abstract class Facade {

	private Map<Operation, Map<Class<? extends Entity>, List<Strategy>>> handlers = new HashMap<>();
	
	public Result perform(Operation operation, Entity entity) {
		Result result = new Result(operation, entity);
		try {
			handlers.get(operation).get(entity.getClass()).forEach(strategy -> strategy.handle(entity, result));
		} catch (NullPointerException e ) {
			System.err.println(String.format("Facade error: Operation %s not mapped for the type %s.", operation, entity.getClass().getSimpleName()));
		}
		return result;
	}
	
	public Result create(Entity entity) {
		return perform(Operation.CREATE, entity);
	}
	
	public Result read(Entity entity) { 
		return perform(Operation.READ, entity);
	}
	
	public Result update(Entity entity) { 
		return perform(Operation.UPDATE, entity);
	}
	
	public Result delete(Entity entity) { 
		return perform(Operation.DELETE, entity);
	}
	
	public void on(Operation operation, Class<? extends Entity> entityClass, Strategy ...strategies) {
		handlers.putIfAbsent(operation, new HashMap<>());
		handlers.get(operation).putIfAbsent(entityClass, Arrays.asList(strategies));
	}
	
	public void onCreate( Class<? extends Entity> entityClass, Strategy ...strategies) {
		on(Operation.CREATE, entityClass, strategies);
	}
	
	public void onRead( Class<? extends Entity> entityClass, Strategy ...strategies) {
		on(Operation.CREATE, entityClass, strategies);
	}
	
	public void onUpdate( Class<? extends Entity> entityClass, Strategy ...strategies) {
		on(Operation.CREATE, entityClass, strategies);
	}
	
	public void onDelete( Class<? extends Entity> entityClass, Strategy ...strategies) {
		on(Operation.CREATE, entityClass, strategies);
	}
}

