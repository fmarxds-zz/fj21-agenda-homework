<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, br.com.caelum.agenda.dao.*, br.com.caelum.agenda.modelo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" href="assets/css/bootstrap.css">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Agenda Online</title>
	</head>
	<body>
		<main class="container">
			
			<table class="table">
			
				<thead>
					<tr>
						<th>ID</th>
						<th>NOME</th>
						<th>EMAIL</th>
						<th>ENDEREÇO</th>
						<th>NASCIMENTO</th>
					</tr>
				</thead>
				
				<tbody>
			
					<%
						ContatoDAO dao = new ContatoDAO();
						List<Contato> contatos = dao.getList();
						
						for (Contato c : contatos){
					%>

					<tr>
						<td> <%= c.getId() %> </td>
						<td> <%= c.getNome() %> </td>
						<td> <%= c.getEmail() %> </td>
						<td> <%= c.getEndereco() %> </td>
						<td> <%= c.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) %> </td>
					</tr>
					
					<% } %>
					
				</tbody>
			
			</table>
			
		</main>	
	</body>
</html>