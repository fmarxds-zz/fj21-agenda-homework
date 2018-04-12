package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovoContatoLogic implements Logica {
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return "/WEB-INF/jsp/adiciona-contato.jsp";
	}

}
