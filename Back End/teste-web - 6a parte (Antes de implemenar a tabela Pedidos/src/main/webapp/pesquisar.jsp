<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Pesquisar</title>
		<link rel="stylesheet" href="css/styles.css">
	</head>

	<body>
		
		<div class='central'>
			<form action="exibirContato" method="get">
				<h1>Pesquisa de Usuário:</h1>
				<label>ID do Usuário</label>
				<input type="text" name="idContato" /> <br />
				<input type="submit" value="Pesquisar Usuário" />
			</form>

			<!-- Formulário de Listagem de Usuários -->
			<form action="listarContato" method="get">
				<input type="submit" value="Listar Usuários" />
			</form>

			<!-- Formulário de Pesquisa de Produto -->
			<form action="exibirProduto" method="get">
				<h1>Pesquisa de Produto:</h1>
				<label>ID do Produto</label>
				<input type="text" name="idProduto" /> <br />
				<input type="submit" value="Pesquisar Produto" />
			</form>

			<!-- Formulário de Listagem de Produtos -->
			<form action="listarProduto" method="get">
				<input type="submit" value="Listar Produtos" />
			</form>
		</div>
	</body>

	</html>
