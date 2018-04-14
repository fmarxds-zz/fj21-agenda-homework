package br.com.caelum.mvc.logica;

import java.sql.Connection;
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
		
		// Obtem a conexão com o banco pelo FiltroConexao
		Connection cn = (Connection) req.getAttribute("connection");
		
		// Busca os dados do contato no banco de dados com base em seu ID e instancia um objeto do tipo Contato
		ContatoDAO dao = new ContatoDAO(cn);
		Contato contato = dao.getByID(id);
		
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
