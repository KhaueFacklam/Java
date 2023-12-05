<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.Usuario" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/styles.css">
<title>Salvando o usuario</title>
</head>
<body>
<% 	
Usuario u = (Usuario) request.getAttribute("usuario");
%>
	<div class='central'>
		<h1>Mostrando o usuario</h1>
		<h2><%= request.getAttribute("mensagem") %></h2>
		<form action='AtualizarUsuario' method="post">
			<input type="text" name="id" value="<%= u.getId()%>">
            <b>Nome:</b> <input type="text"	name="nome" value="<% out.print(u.getNome());%>" />  <br />
            <b>e-mail:</b> <input type="text" name="email" value="<%= u.getEmail() %>" />   <br />
            <b>Endereco: </b> <input type="text" name="endereco" value="<%= u.getEndereco() %>" />" <br />
			<input type="submit" value="Atualizar"/>
		</form>
	</div>
</body>
</html>

