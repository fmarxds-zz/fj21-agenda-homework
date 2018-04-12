<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="assets/css/bootstrap.css" rel="stylesheet">
		<title>Agenda Online</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp"></c:import>
		<main class="container">
			<h3>Contato ${param.nome} adicionado com sucesso!</h3>
			<br/>
			<a href="mvc?logica=NovoContatoLogic">Adicionar mais contatos</a>
		</main>
		<c:import url="rodape.jsp"></c:import>
	</body>
</html>