package com.bestgroup.app.web.filter.entity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bestgroup.app.domain.Customer;
import com.bestgroup.core.facade.Result;
import com.bestgroup.util.assembler.EntityAssembler;
import com.bestgroup.web.filter.ViewHelperFilter;

@WebFilter(urlPatterns = {
		"/customers.create",
		"/customers.read",
		"/customers.update",
		"/customers.delete"})
public class CustomerViewHelper extends ViewHelperFilter{
	
	public CustomerViewHelper() { 
		assembler = EntityAssembler.of(Customer::new);
	}
	
	@Override
	public void setResponse(Result result, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
	}
}
