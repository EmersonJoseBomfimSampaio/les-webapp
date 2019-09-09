package com.bestgroup.app.domain;

public class Employee extends User {
	
	protected Employee employee; 
	protected Role role;
	
	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public Role getRole() {
		return this.role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
}
