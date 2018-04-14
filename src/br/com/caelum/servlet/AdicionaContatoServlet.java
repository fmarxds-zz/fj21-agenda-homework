package br.com.caelum.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDAO;
import br.com.caelum.agenda.modelo.Contato;

@SuppressWarnings("serial")
@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet{
	
	// Inicializa a Servlet (opicional)
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		log("Iniciando a servlet AdicionaContatoServlet");
	}
	
	// Método para tratar a requisição HTTP
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
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
		
		// Redireciona o usuário para exibir que o contato foi salvo com sucesso
		RequestDispatcher rd = req.getRequestDispatcher("/contato-adicionado.jsp");
		rd.forward(req, resp);
		
	}
	
	// Finaliza a Servlet (opicional)
	@Override
	public void destroy() {
		super.destroy();
		log("Destruindo a servlet AdicionaContatoServlet");
	}

}
