<%@ page import="java.time.LocalTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="assets/css/bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Agenda</title>
</head>
<body>
	<%-- Comentário em JSP --%>
	
	<%
		String mensagem = "Bem vindo ao sistema de Agenda";
		String desenvolvido = "Desenvolvido por Felipe Marques";
	%>
	
	<%= mensagem %>
	<br/>
	<%= desenvolvido %>
	
	<% System.out.println("Página bemvindo.jsp acessada!" + LocalTime.now()); %>
	
</body>
</html>