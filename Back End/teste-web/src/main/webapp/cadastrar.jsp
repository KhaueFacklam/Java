<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Usuário e Produto</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class='central'>
        <h1>Cadastro de Usuário</h1>
        <form action='adicionarContato' method="get">
            <b>Nome:</b> <input type="text" name="nomeContato" required/><br/>
            <b>Email:</b> <input type="email" name="emailContato" required/><br/>
            <b>Endereço:</b> <input type="text" name="enderecoContato" required/><br/>
            <input type="submit" value="Cadastrar Usuário"/>
        </form>

        <!-- Formulário para cadastrar produto -->
        <h1>Cadastro de Produto</h1>
        <form action='adicionarProduto' method="get">
            <b>Nome:</b> <input type="text" name="nomeProduto" required/><br/>
            <b>Descrição:</b> <input type="text" name="descricaoProduto" required/><br/>
            <b>Preço:</b> <input type="text" name="precoProduto" required/><br/>
            <input type="submit" value="Cadastrar Produto"/>
        </form>

    </div>
</body>
</html>
