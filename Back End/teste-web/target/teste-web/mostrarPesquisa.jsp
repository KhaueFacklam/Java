<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.text.SimpleDateFormat, model.Contato, model.Produto" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mostrando Pesquisa</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>

<% 
    Contato c = (Contato) request.getAttribute("contato");
    Produto p = (Produto) request.getAttribute("produto");
%>

<div class='central'>
    <h1>Mostrando a Pesquisa</h1>
    <h2><%= request.getAttribute("mensagem") %></h2>
    
    <% if (c != null) { %>
        <!-- Detalhes do Contato -->
        <form action='atualizarContato' method="post">
            <b>ID:</b> <input type="text" name="id" value="<%= c.getId()%>">
            <b>Nome:</b> <input type="text" name="nome" value="<%= c.getNome() %>" />  <br />
            <b>E-mail:</b> <input type="text" name="email" value="<%= c.getEmail() %>" />   <br />
            <b>Endereço: </b> <input type="text" name="endereco" value="<%= c.getEndereco() %>" /> <br />
            <input type="submit" value="Atualizar"/>
        </form>

        <form action='deletarContato' method="get">
            <input type="hidden" name="id" value="<%= c.getId()%>">
            <input type="submit" value="Excluir"/>
        </form>
        <!-- Formulário para cadastrar um novo pedido -->
        <form action='adicionarPedido' method="post">
            <input type="hidden" name="idContato" value="<%= c.getId()%>">
            <h2>Cadastrar Novo Pedido:</h2>
            <label>ID do Produto:</label>
            <input type="text" name="idProduto" />
            <br />
            <label>Quantidade:</label>
            <input type="text" name="quantidade" />
            <br />
            <input type="submit" value="Cadastrar Pedido"/>
        </form>
    <% } else if (p != null) { %>
        <!-- Detalhes do Produto -->
        <form action='atualizarProduto' method="post">
            <b>ID:</b> <input type="text" name="id" value="<%= p.getId()%>">
            <b>Nome:</b> <input type="text" name="nome" value="<%= p.getNome() %>" />  <br />
            <b>Descrição:</b> <input type="text" name="descricao" value="<%= p.getDescricao() %>" />   <br />
            <b>Preço:</b> <input type="text" name="preco" value="<%= p.getPreco() %>" /> <br />
            <input type="submit" value="Atualizar"/>
        </form>

        <form action='deletarProduto' method="get">
            <input type="hidden" name="id" value="<%= p.getId()%>">
            <input type="submit" value="Excluir"/>
        </form>
    <% } %>
</div>

</body>
</html>
