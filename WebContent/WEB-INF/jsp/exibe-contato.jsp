<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="assets/css/bootstrap.css">
		<link rel="stylesheet" href="assets/css/jquery-ui.css">
		<script type="text/javascript" src="assets/js/jquery.js"></script>
		<script type="text/javascript" src="assets/js/jquery-ui.js"></script>
		<title>Agenda Online</title>
	</head>
	<body>
		<h2>Editar Contato</h2>
		<main class="container">
			<form action="mvc?logica=ModificaContatoLogic" method="post">
				<table class="table">
					<tr>
						<td>ID</td>
						<td><input name="id" type="text" value="${contato.id}" readonly="readonly" /></td>
					</tr>
					<tr>
						<td>NOME</td>
						<td><input name="nome" type="text" value="${contato.nome}" /></td>
					</tr>
					<tr>
						<td>EMAIL</td>
						<td><input name="email" type="text" value="${contato.email}" /></td>
					</tr>
					<tr>
						<td>ENDEREÇO</td>
						<td><input name="endereco" type="text" value="${contato.endereco}" /></td>
					</tr>
					<tr>
						<td>NASCIMENTO:</td>
                       	<td><input name="dataNascimento" type="text" value="${dataFormatada}" /></td>
					</tr>
				</table>
				<input type="submit" value="GRAVAR" />
			</form>
		</main>
	</body>
</html>