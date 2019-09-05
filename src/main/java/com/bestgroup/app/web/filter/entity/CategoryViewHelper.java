package com.bestgroup.app.web.filter.entity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bestgroup.app.domain.Category;
import com.bestgroup.app.domain.Customer;
import com.bestgroup.app.domain.Employee;
import com.bestgroup.core.facade.Result;
import com.bestgroup.util.assembler.EntityAssembler;
import com.bestgroup.web.filter.ViewHelperFilter;

@WebFilter(urlPatterns = {
		"/categories.create",
		"/categories.read",
		"/categories.update",
		"/categories.delete"})
public class CategoryViewHelper extends ViewHelperFilter {
	
	public CategoryViewHelper() {
		assembler = EntityAssembler.of(Category::new);
	}

	@Override
	public void setResponse(Result result, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		
		if(employee != null) {
			
			switch(result.getOperation()) {
			
			case CREATE:
				
				break;
				
			case DELETE:
				
				break;
				
			case READ:
				
				break;
				
			case UPDATE:
				
				break;
			}
		}
		
		if(customer != null) { 
			switch(result.getOperation()) {
			
			case CREATE:
				
				break;
				
			case DELETE:
				
				break;
				
			case READ:
				
				break;
				
			case UPDATE:
				
				break;
			}
		}
	}
}
