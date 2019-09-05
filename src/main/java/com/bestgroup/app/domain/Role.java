package com.bestgroup.app.domain;

import java.util.List;

import com.bestgroup.core.domain.Entity;

public class Role extends Entity {
	protected String name;
	protected List<Permission> permissions;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Permission> getPermissions() {
		return permissions;
	}
	
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
}
