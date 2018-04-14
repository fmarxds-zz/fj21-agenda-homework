package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDAO;
import br.com.caelum.agenda.modelo.Contato;

public class AdicionarContatoLogic implements Logica {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		// Recebe os valores da requisição
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String txtDataNasc = req.getParameter("dataNascimento");
		
		// Trata a data
		LocalDate dataNascimento = LocalDate.parse(txtDataNasc, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		// Instancia o objeto a ser gravado no Banco de Dados
		Contato contato = new Contato(nome, email, endereco, dataNascimento);
		
		// Obtem a conexão com o banco pelo FiltroConexao
		Connection cn = (Connection) req.getAttribute("connection");
		
		// Instancia a DAO para gravar o contato no banco
		ContatoDAO dao = new ContatoDAO(cn);
		dao.adiciona(contato);
		
		return "/WEB-INF/jsp/contato-adicionado.jsp";
	}
	
}
