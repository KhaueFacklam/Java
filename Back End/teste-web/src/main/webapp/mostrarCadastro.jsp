<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat, model.Contato, model.Produto, model.Pedido" %>

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
                <h1><%= request.getAttribute("mensagem") %></h1>
                <b>Usuário Cadastrado:</b><br/>
                <b>Nome:</b> <%= request.getAttribute("nome") %> <br/>
                <b>Email:</b> <%= request.getAttribute("email") %> <br/>
                <b>Endereço:</b> <%= request.getAttribute("endereco") %> <br/>
            <% } else { %>
                <h1   h2><%= request.getAttribute("mensagem") %></h1>
            <% } %>
        <% } else if (request.getAttribute("tipoCadastro").equals("produto")) { %>
                <h1><%= request.getAttribute("mensagem") %></h1>
                <b>Produto Cadastrado:</b><br/>
                <b>Nome:</b> <%= request.getAttribute("nomeProduto") %> <br/>
                <b>Descrição:</b> <%= request.getAttribute("descricaoProduto") %> <br/>
                <b>Preço:</b> <%= request.getAttribute("precoProduto") %> <br/>
        <% } else if (request.getAttribute("tipoCadastro").equals("pedido")) { %>
                <h1><%= request.getAttribute("mensagem") %></h1>
                <b>Nome:</b> <%= ((Produto)request.getAttribute("produto")).getNome() %> <br/>
                <b>Descrição:</b> <%= ((Produto)request.getAttribute("produto")).getDescricao() %> <br/>
                <b>Preço:</b> <%= ((Produto)request.getAttribute("produto")).getPreco() %> <br/>
                <b>Quantidade:</b> <%= ((Pedido)request.getAttribute("pedido")).getQuantidade() %> <br/>
                <b>Total:</b> <%= ((Pedido)request.getAttribute("pedido")).getTotal() %> <br/>

        <% } %>

        <a href="cadastrar.jsp">Voltar</a>
    </div>
</body>
</html>
