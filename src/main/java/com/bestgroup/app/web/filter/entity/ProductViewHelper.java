package com.bestgroup.app.web.filter.entity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bestgroup.app.domain.Product;
import com.bestgroup.core.facade.Result;
import com.bestgroup.util.assembler.EntityAssembler;
import com.bestgroup.web.filter.ViewHelperFilter;


@WebFilter(urlPatterns = {
		"/products.create",
		"/products.read",
		"/products.update",
		"/products.delete"})
public class ProductViewHelper extends ViewHelperFilter {
	
	public ProductViewHelper() { 
		this.assembler = EntityAssembler.of(Product::new);
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
