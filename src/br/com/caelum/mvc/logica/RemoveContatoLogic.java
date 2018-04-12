package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDAO;

public class RemoveContatoLogic implements Logica {
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		// Recebe o ID que será excluido via parametro HTTP
		Long id = Long.parseLong(req.getParameter("id"));
		
		// Instancia um novo objeto DAO
		ContatoDAO dao = new ContatoDAO();
		
		// Remove o contato solicitado
		dao.removeById(id);
		
		// Encerra a conexão com o Banco de Dados aberta ao instanciar o DAO
		dao.closeResources();		
		
		// Redireciona o usuário para a lista de contatos
		return "mvc?logica=ListaContatosLogic";
	}

}
