package com.bestgroup.web.servlet;

import java.io.IOException;
import java.util.function.Function;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bestgroup.core.domain.Entity;
import com.bestgroup.core.facade.Result;

public abstract class BaseServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public BaseServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Entity entity = (Entity) request.getAttribute("entity");
		if(entity != null) { 
			Function<Entity, Result> command = getCommand(request);
			Result result = command.apply(entity);
			request.setAttribute("result", result);			
		} else { 
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Entity not supplied.");
		}
	}
	
	protected abstract Function<Entity, Result> getCommand(HttpServletRequest request);
}
