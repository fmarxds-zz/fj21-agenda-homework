<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" href="assets/css/bootstrap.css">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Agenda Online</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />
		<main class="container">	
			<table class="table">
				<thead>
					<tr bgcolor="#cccccc">
						<th>ID</th>
						<th>NOME</th>
						<th>EMAIL</th>
						<th>ENDERECO</th>
						<th>NASCIMENTO</th>
						<th>EXCLUIR</th>
						<th>MODIFICAR</th>
					</tr>
				</thead>
				<tbody>
					<!-- Realiza a inserção dos contatos na tabela -->
					<c:forEach var="contato" items="${contatos}" varStatus="id">
						<tr bgcolor="${id.count % 2 == 0 ? '#e6ffe6' : '#ffffff'}">
							<td>${contato.id}</td>
							<td>${contato.nome}</td>
							<td>
								<c:choose>
									<c:when test="${not empty contato.email}">
										<a href="mailto:${contato.email}">${contato.email}</a>
									</c:when>
									<c:otherwise>
										não cadastrado
									</c:otherwise>
								</c:choose>
							</td>
							<td>${contato.endereco}</td>
							<td>${contato.dataNascimento}</td>
							<td><a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Excluir</a>
							<td><a href="mvc?logica=ExibeContatoLogic&id=${contato.id}">Modificar</a>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</main>
		<c:import url="rodape.jsp" />
	</body>
</html>