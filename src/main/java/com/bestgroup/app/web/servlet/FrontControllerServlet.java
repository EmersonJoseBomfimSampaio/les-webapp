package com.bestgroup.app.web.servlet;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import com.bestgroup.app.core.facade.ApplicationFacade;
import com.bestgroup.core.domain.Entity;
import com.bestgroup.core.facade.Facade;
import com.bestgroup.core.facade.Result;
import com.bestgroup.web.servlet.BaseServlet;

@WebServlet(urlPatterns= {"*.create", "*.read", "*.update", "*.delete"})
public class FrontControllerServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;
	protected Map<String, Function<Entity, Result>> commands = new HashMap<>();
	protected Facade facade = new ApplicationFacade();
	
	public FrontControllerServlet() {
		commands.put(".create", facade::create);
		commands.put(".read", facade::read);
		commands.put(".delete", facade::delete);
		commands.put(".update", facade::update);
	}
	
	@Override
	protected Function<Entity, Result> getCommand(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String command = uri.substring(uri.lastIndexOf("."));
		return commands.get(command);
	}
}
