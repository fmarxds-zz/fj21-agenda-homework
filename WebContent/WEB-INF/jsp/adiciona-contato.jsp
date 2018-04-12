<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="assets/css/bootstrap.css">
		<link rel="stylesheet" href="assets/css/jquery-ui.css">
		<script src="assets/js/jquery.js" type="text/javascript"></script>
		<script src="assets/js/jquery-ui.js" type="text/javascript"></script>
		<title>Agenda Online</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp"></c:import>
        <main class="container">
        	<p />
            <h1>Adicionar novo contato</h1>
            <hr />
            <form action="mvc?logica=AdicionarContatoLogic" method="post">
                <table class="table">
                    <tr>
                        <td>NOME:</td>
                        <td><input type="text" name="nome" /></td>
                    </tr>
                    <tr>
                        <td>EMAIL:</td>
                        <td><input type="text" name="email" /></td>
                    </tr>
                    <tr>
                        <td>ENDERECO:</td>
                        <td><input type="text" name="endereco" /></td>
                    </tr>
                    <tr>
                        <td>DATA DE NASCIMENTO:</td>
                        <td><tag:campoData id="dataNascimento" /></td>
                    </tr>
                </table>
                <br />
                <input type="submit" value="GRAVAR" />
            </form>
        </main>
        <c:import url="rodape.jsp"></c:import>
    </body>
</html>