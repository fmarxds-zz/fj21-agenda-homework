package br.com.caelum.mvc.logica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDAO;
import br.com.caelum.agenda.modelo.Contato;

public class ModificaContatoLogic implements Logica {
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		// Obtem os parametros para modificar um usuário no banco de dados
		Long id = Long.parseLong(req.getParameter("id"));
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String dataNascimentoAux = req.getParameter("dataNascimento");
		
		// Trata a data de nascimento
		LocalDate dataNascimento = LocalDate.parse(dataNascimentoAux, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		// Instancia um objeto Contato com base nos parametros passados pelo HTTP
		Contato contato = new Contato(nome, email, endereco, dataNascimento);
		
		// Instancia o DAO e altera o contato
		ContatoDAO dao = new ContatoDAO();
		dao.modifyById(contato, id);
		dao.closeResources();
		
		return "mvc?logica=ListaContatosLogic";
	}
}
