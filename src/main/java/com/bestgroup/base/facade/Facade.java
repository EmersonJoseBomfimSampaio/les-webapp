package com.bestgroup.base.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.bestgroup.base.entity.Entity;

public abstract class Facade {

	private Map<FacadeOperation, Map<Class<? extends Entity>, List<BiConsumer<Entity, FacadeResult>>>> handlers = new HashMap<>();
	
	public FacadeResult perform(FacadeOperation operation, Entity entity) {
		FacadeResult result = new FacadeResult();
		try {
			handlers.get(operation).get(entity.getClass()).forEach(handler -> handler.accept(entity, result));				
		} catch (NullPointerException e ) { 
			System.err.println(String.format("Facade error: Operation %s not mapped for the type %s.", operation, entity.getClass().getSimpleName()));
		}
		return result;
	}
	
	public FacadeResult create(Entity entity) { 
		return perform(FacadeOperation.CREATE, entity);
	}
	
	public FacadeResult read(Entity entity) { 
		return perform(FacadeOperation.READ, entity);
	}
	
	public FacadeResult update(Entity entity) { 
		return perform(FacadeOperation.UPDATE, entity);
	}
	
	public FacadeResult delete(Entity entity) { 
		return perform(FacadeOperation.DELETE, entity);
	}
	
	public void on(FacadeOperation operation, Class<? extends Entity> entityClass,  Consumer<List<BiConsumer<Entity, FacadeResult>>> consumer) {
		List<BiConsumer<Entity, FacadeResult>> handlerList = new ArrayList<>();
		consumer.accept(handlerList);
		handlers.putIfAbsent(operation, new HashMap<>());
		handlers.get(operation).putIfAbsent(entityClass, handlerList);
	}
	
	public void onCreate(Class<? extends Entity> entityClass,  Consumer<List<BiConsumer<Entity, FacadeResult>>> consumer ) {
		on(FacadeOperation.CREATE, entityClass, consumer);
	}
	
	public void onRead(Class<? extends Entity> entityClass,  Consumer<List<BiConsumer<Entity, FacadeResult>>> consumer ) {
		on(FacadeOperation.READ, entityClass, consumer);
	}
	
	public void onUpdate(Class<? extends Entity> entityClass,  Consumer<List<BiConsumer<Entity, FacadeResult>>> consumer ) {
		on(FacadeOperation.UPDATE, entityClass, consumer);
	}
	
	public void onDelete(Class<? extends Entity> entityClass,  Consumer<List<BiConsumer<Entity, FacadeResult>>> consumer ) {
		on(FacadeOperation.DELETE, entityClass, consumer);
	}
	
	public void onAll(Class<? extends Entity> entityClass,  Consumer<List<BiConsumer<Entity, FacadeResult>>> consumer ) {
		for(FacadeOperation operation : FacadeOperation.values()) {
			on(operation, entityClass, consumer);			
		}
	}	
}
