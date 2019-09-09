package com.bestgroup.app.web.filter.entity.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bestgroup.core.facade.Result;
import com.bestgroup.web.filter.ViewHelperFilter;

@WebFilter(urlPatterns = {
		"/admin/products.create",
		"/admin/products.read",
		"/admin/products.update",
		"/admin/products.delete"})
public class AdminProductViewHelper extends ViewHelperFilter {
	
	public AdminProductViewHelper() { 
	}
	
	@Override
	public void setResponse(Result result, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		switch(result.getOperation())
		{
		
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
