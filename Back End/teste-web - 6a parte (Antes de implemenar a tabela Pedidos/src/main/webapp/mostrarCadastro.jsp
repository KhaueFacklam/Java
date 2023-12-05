<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mostrando o Cadastro</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class='central'>
        <h1>Mostrando Cadastro</h1>
        
        <% if (request.getAttribute("tipoCadastro").equals("contato")) { %>
            <% if (request.getAttribute("verificacao").equals("inexistente")) { %>
                <h2><%= request.getAttribute("mensagem") %></h2>
                <b>Usuário Cadastrado:</b><br/>
                <b>Nome:</b> <%= request.getAttribute("nome") %> <br/>
                <b>Email:</b> <%= request.getAttribute("email") %> <br/>
                <b>Endereço:</b> <%= request.getAttribute("endereco") %> <br/>
            <% } else { %>
                <h2><%= request.getAttribute("mensagem") %></h2>
            <% } %>
        <% } else if (request.getAttribute("tipoCadastro").equals("produto")) { %>
            <h2><%= request.getAttribute("mensagem") %></h2>
            <b>Produto Cadastrado:</b><br/>
            <b>Nome:</b> <%= request.getAttribute("nomeProduto") %> <br/>
            <b>Descrição:</b> <%= request.getAttribute("descricaoProduto") %> <br/>
            <b>Preço:</b> <%= request.getAttribute("precoProduto") %> <br/>
        <% } %>

        <a href="cadastrar.jsp">Voltar</a>
    </div>
</body>
</html>
