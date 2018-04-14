package br.com.caelum.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.mvc.logica.Logica;

@SuppressWarnings("serial")
@WebServlet(name="servlet", urlPatterns={"/mvc"})
public class ControllerServlet extends HttpServlet {
	
	// Inicializa a Servlet (opicional)
		@Override
		public void init(ServletConfig config) throws ServletException {
			super.init(config);
			log("Iniciando a servlet AdicionaContatoServlet");
		}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Obtem para qual classe a Servlet deverá redirecionar a solicitação
		String parametro = req.getParameter("logica");
		String nomeDaClasse = "br.com.caelum.mvc.logica." + parametro;
		
		/* Execução da Regra de Negócio */
		try {
			
			// Com base no parametro "logica" obtido da requisição HTTP, instância a classe responsável por executar a lógica correta
			Class<?> classe = Class.forName(nomeDaClasse);
			Logica logica = (Logica) classe.newInstance();
			
			// Executa a lógica correta e obtem a página para qual o usuário será redirecionado
			String pagina = logica.execute(req, resp);
			
			// Redireciona o usuário após a execução da lógica
			req.getRequestDispatcher(pagina).forward(req, resp);
			
		} catch (Exception e) {
			throw new ServletException("Erro na regra de negocio (SERVLET)", e);
		}
		
	}
	
	// Finaliza a Servlet (opicional)
		@Override
		public void destroy() {
			super.destroy();
			log("Destruindo a servlet AdicionaContatoServlet");
		}

}
