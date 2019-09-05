package com.bestgroup.web.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bestgroup.core.domain.Entity;
import com.bestgroup.core.facade.Result;
import com.bestgroup.util.assembler.EntityAssembler;

public abstract class ViewHelperFilter extends BaseFilter {
	
	@SuppressWarnings("rawtypes")
	protected EntityAssembler assembler;
	
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		Entity entity = getEntity(request);
		
		request.setAttribute("entity", entity);
		chain.doFilter(request, response);
		
		Result result = (Result) request.getAttribute("result");
		
		Map<Object, Object> old = new HashMap<>();
		
		Iterator<String> iterator= request.getParameterNames().asIterator();
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			old.put(key, request.getParameter(key));
		}
		
		if(result.hasErrors()) {
			request.getSession().setAttribute("old", old);
			request.getSession().setAttribute("errors", result.getErrors());
			response.sendRedirect(request.getParameter("referer"));
		} else {
			request.getSession().setAttribute("errors", null);
			request.getSession().setAttribute("old", null);
			setResponse(result, request, response);
		}
	}
	
	public Entity getEntity(ServletRequest request) { 
		return assembler.get(request);	
	}
	
	public abstract void setResponse(Result result, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;

	public void redirect(String location, HttpServletRequest request, HttpServletResponse response) throws IOException { 
		response.sendRedirect(request.getContextPath() + location);
	}
}
