package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDAO;

public class RemoveContatoLogic implements Logica {
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		// Recebe o ID que será excluido via parametro HTTP
		Long id = Long.parseLong(req.getParameter("id"));
		
		// Obtem a conexão com o banco pelo FiltroConexao
		Connection cn = (Connection) req.getAttribute("connection");
		
		// Instancia um novo objeto DAO
		ContatoDAO dao = new ContatoDAO(cn);
		
		// Remove o contato solicitado
		dao.removeById(id);		
		
		// Redireciona o usuário para a lista de contatos
		return "mvc?logica=ListaContatosLogic";
	}

}
