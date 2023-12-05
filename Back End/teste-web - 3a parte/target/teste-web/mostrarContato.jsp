<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.Contato" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/styles.css">
<title>Salvando o contato</title>
</head>
<body>
<% 	
	Contato c = (Contato) request.getAttribute("contato");
%>
	<div class='central'>
		<h1>Mostrando o contato</h1>
		<h2><%= request.getAttribute("mensagem") %></h2>
		<form action='AtualizarContato' method="post">
			<input type="text" name="id" value="<%= c.getId()%>">
            <b>Nome:</b> <input type="text"	name="nome" value="<% out.print(c.getNome());%>" />  <br />
            <b>e-mail:</b> <input type="text" name="email" value="<%= c.getEmail() %>" />   <br />
            <b>Endereco: </b> <input type="text" name="endereco" value="<%= c.getEndereco() %>" />" <br />
			<input type="submit" value="Atualizar"/>
		</form>
	</div>
</body>
</html>

