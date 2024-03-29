package com.bestgroup.app.web.filter.entity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bestgroup.core.facade.Result;
import com.bestgroup.web.filter.ViewHelperFilter;

@WebFilter(urlPatterns = {
		"/categories.create",
		"/categories.read",
		"/categories.update",
		"/categories.delete"})
public class CategoryViewHelper extends ViewHelperFilter {
	
	public CategoryViewHelper() {
	}

	@Override
	public void setResponse(Result result, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
	}
}
