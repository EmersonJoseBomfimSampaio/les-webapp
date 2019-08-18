package com.bestgroup.base.facade;

import java.util.ArrayList;
import java.util.List;

public class FacadeResult {
	
	public List<String> errors = new ArrayList<>();
	
	public void addError(String error) { 
		errors.add(error);
	}
	
	public boolean hasErrors() {
		return !errors.isEmpty();
	}
}
