package com.bestgroup.base.facade;

import com.bestgroup.base.entity.Entity;

public interface FacadeStrategy {
	
	public void handle(Entity entity, FacadeResult result);
}
