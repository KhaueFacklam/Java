<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Opções de Ação</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class='central'>
        <h1>Bem Vindo</h1>

        <!-- Botão de Logout -->
        <form action="logoutServlet" method="get">
            <input type="submit" value="Logout">
        </form>

        <form action="cadastrar.jsp" method="get">
            <input type="submit" value="Cadastrar">
        </form>

        <form action="pesquisar.jsp" method="get">
            <input type="submit" value="Pesquisar">
        </form>

    </div>
</body>
</html>
