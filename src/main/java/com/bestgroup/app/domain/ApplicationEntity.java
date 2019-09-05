package com.bestgroup.app.domain;

import java.util.Date;

import com.bestgroup.core.domain.Entity;

public class ApplicationEntity extends Entity {
	
	protected User owner;
	protected Date deletedAt;
	
	public User getOwner() {
		return owner;
	}
	
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	public Date getDeletedAt() {
		return deletedAt;
	}
	
	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}
}
