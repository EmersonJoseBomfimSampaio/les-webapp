package com.bestgroup.app.web.filter.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bestgroup.web.filter.BaseFilter;

@WebFilter("/management/*")
public class ManagementSecurityFilter extends BaseFilter {

	List<String> exceptions = new ArrayList<>();
	
	public ManagementSecurityFilter() { 
		exceptions.add("/les-webapp/management/login/");
	}
	
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		chain.doFilter(request, response);
		
	}
}
