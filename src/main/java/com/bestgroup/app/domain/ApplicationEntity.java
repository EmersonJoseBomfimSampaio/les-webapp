package com.bestgroup.app.domain;

import java.util.Date;

import com.bestgroup.core.domain.Entity;

public class ApplicationEntity extends Entity {
	
	protected Date deletedAt;
	
	public Date getDeletedAt() {
		return deletedAt;
	}
	
	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}
}
