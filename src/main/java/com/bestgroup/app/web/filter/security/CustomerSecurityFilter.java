package com.bestgroup.app.web.filter.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bestgroup.app.domain.Customer;
import com.bestgroup.web.filter.BaseFilter;

@WebFilter("/customer/*")
public class CustomerSecurityFilter extends BaseFilter {

	List<String> exceptions = new ArrayList<>();
	
	public CustomerSecurityFilter() { 
		
	}
	
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		
		if(customer != null || exceptions.contains(request.getRequestURI())) { 
			chain.doFilter(request, response);
		} else  { 
			response.sendRedirect("/les-webapp/login/");
		}
	}
}
