package com.bestgroup.app.web.filter.entity.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bestgroup.core.facade.Result;
import com.bestgroup.web.filter.ViewHelperFilter;

@WebFilter(urlPatterns = {
		"/admin/categories.create",
		"/admin/categories.read",
		"/admin/categories.update",
		"/admin/categories.delete"})
public class AdminCategoryViewHelper extends ViewHelperFilter {
	
	public AdminCategoryViewHelper() {
	}

	@Override
	public void setResponse(Result result, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
	}
}
