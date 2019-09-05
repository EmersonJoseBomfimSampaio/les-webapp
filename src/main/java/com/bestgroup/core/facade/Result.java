package com.bestgroup.core.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bestgroup.core.domain.Entity;

public class Result {
	
	public Operation operation;
	public Entity entitySent;
	public List<Entity> entities = new ArrayList<>();
	public Map<String, String> errors = new HashMap<>();
	 
	
	
	public Result (Operation operation, Entity entitySent) { 
		this.operation = operation;
		this.entitySent = entitySent;
	}
	
	public List<Entity> getEntities() { 
		return entities;
	}
	
	public Operation getOperation() { 
		return operation;
	}
	
	public void addError(String origin, String reason) { 
		errors.put(origin, reason);
	}
	
	public boolean hasErrors() {
		return !errors.isEmpty();
	}
	
	public Entity getEntitySent() {
		return entitySent;
	}

	public Map<String, String> getErrors() {
		return errors;
	}
}
