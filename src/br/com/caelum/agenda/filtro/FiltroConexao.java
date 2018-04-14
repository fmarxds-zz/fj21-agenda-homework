package br.com.caelum.agenda.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.caelum.agenda.ConnectionFactory;

@WebFilter("/*")
public class FiltroConexao implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		try {
			
			// Obtem a conexão com o banco de dados
			Connection connection = new ConnectionFactory().getConnection();
			
			// Adiciona a conexao como parâmetro HTTP na requisição
			req.setAttribute("connection", connection);
			
			// Libera a aplicação para execução da lógica
			chain.doFilter(req, resp);
			
			// Encerra a conexão após o response
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}

}
