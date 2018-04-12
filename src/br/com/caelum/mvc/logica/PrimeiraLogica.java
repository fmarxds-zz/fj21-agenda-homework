package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeiraLogica implements Logica {
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		System.out.println("executando a logica...");
		System.out.println("retornando a página JSP...");
		return "/WEB-INF/jsp/primeira-logica.jsp";
	}
	
}
