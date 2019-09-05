package com.bestgroup.core.facade;

import com.bestgroup.core.domain.Entity;

public interface Strategy {
	public void handle(Entity entity, Result result);
}
