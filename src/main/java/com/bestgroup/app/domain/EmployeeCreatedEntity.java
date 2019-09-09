package com.bestgroup.app.domain;

public class EmployeeCreatedEntity extends ApplicationEntity {
	protected Employee employee;
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public Employee getEmployee() { 
		return this.employee;
	}
}
