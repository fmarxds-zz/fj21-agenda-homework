package br.com.caelum.mvc.logica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDAO;
import br.com.caelum.agenda.modelo.Contato;

public class ExibeContatoLogic implements Logica {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		// Recebe o ID do contato que será exibido
		Long id = Long.parseLong(req.getParameter("id"));
		
		// Busca os dados do contato no banco de dados com base em seu ID e instancia um objeto do tipo Contato
		ContatoDAO dao = new ContatoDAO();
		Contato contato = dao.getByID(id);
		dao.closeResources();
		
		// Preparando a data de exibição
		LocalDate localDate = contato.getDataNascimento();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataFormatada = localDate.format(formatter);
		req.setAttribute("dataFormatada", dataFormatada);
		
		// Adiciona o contato na requisição HTTP
		req.setAttribute("contato", contato);
		
		return "/WEB-INF/jsp/exibe-contato.jsp";
	}
	
}
