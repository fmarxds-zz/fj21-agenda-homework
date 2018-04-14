package br.com.caelum.agenda.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class FiltroTempoDeExecucao implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		Long tempoInicial = System.currentTimeMillis();
		
		// Libera a lógica de negócios
		chain.doFilter(req, resp);
		
		// Cálcula o tempo total da execução da lógica
		Long tempoFinal = System.currentTimeMillis();
		Long tempoDeExecucao = tempoFinal - tempoInicial;
		
		// Imprime no console o tempo que levou para executar determinado recurso
		String uri = ((HttpServletRequest) req).getRequestURI();
		String parametros = ((HttpServletRequest)req).getParameter("logica");
		System.out.println("************** Tempo de requisição de " + uri + "?logica=" + parametros + " demorou (ms): " + tempoDeExecucao);
		
	}
}