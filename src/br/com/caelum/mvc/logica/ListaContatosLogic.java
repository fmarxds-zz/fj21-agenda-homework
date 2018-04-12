package br.com.caelum.mvc.logica;

import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDAO;
import br.com.caelum.agenda.modelo.Contato;

public class ListaContatosLogic implements Logica {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		// Obtem a lista de contatos e organiza por ordem alfabetica
		List<Contato> contatos = new ContatoDAO().getList().stream().sorted((x, y) -> x.getNome().compareTo(y.getNome())).collect(Collectors.toList());
		
		// Adiciona a lista na requisição HTTP
		req.setAttribute("contatos", contatos);		
		
		return "/WEB-INF/jsp/lista-contatos.jsp";
	}
	
}
