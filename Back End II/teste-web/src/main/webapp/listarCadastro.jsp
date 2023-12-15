<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Contato, model.Produto, model.Pedido" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listando os Cadastros</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>

    <div class='central'>
        <h2>Lista de Cadastros</h2>

        <% 
            List<Contato> listaContatos = (List<Contato>) request.getAttribute("listaContatos");
            List<Produto> listaProdutos = (List<Produto>) request.getAttribute("listaProdutos");
            List<Pedido> listaPedidos = (List<Pedido>) request.getAttribute("listaPedidos");

            if (listaContatos != null && !listaContatos.isEmpty()) {
                %>
                <h3>Contatos:</h3>
                <%
                for (Contato c : listaContatos) {
                %>
                    <p>ID: <%= c.getId() %>, Nome: <%= c.getNome() %>, E-mail: <%= c.getEmail() %>, Endereço: <%= c.getEndereco() %></p>
                <%
                }
            }

            if (listaProdutos != null && !listaProdutos.isEmpty()) {
                %>
                <h3>Produtos:</h3>
                <%
                for (Produto p : listaProdutos) {
                %>
                    <p>ID: <%= p.getId() %>, Nome: <%= p.getNome() %>, Descrição: <%= p.getDescricao() %>, Preço: <%= p.getPreco() %></p>
                <%
                }
            }

            if (listaPedidos != null && !listaPedidos.isEmpty()) {
                %>
                <h3>Pedidos:</h3>
                <%
                for (Pedido pedido : listaPedidos) {
                    Produto produtoDoPedido = pedido.getProduto();
                %>
                    <p>ID do Pedido: <%= pedido.getId() %>, Produto: <%= produtoDoPedido.getNome() %>, Descrição: <%= produtoDoPedido.getDescricao() %>, Valor da Unidade: <%= produtoDoPedido.getPreco() %>, Quantidade: <%= pedido.getQuantidade() %>, Total: <%= pedido.getTotal() %></p>
                <%
                }
            }

            if ((listaContatos == null || listaContatos.isEmpty()) && (listaProdutos == null || listaProdutos.isEmpty()) && (listaPedidos == null || listaPedidos.isEmpty())) {
            %>
                <p>Nenhum cadastro encontrado.</p>
            <%
            }
        %>
        <a href="pesquisar.jsp">Voltar</a>
    </div>

</body>
</html>
