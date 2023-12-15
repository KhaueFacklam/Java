package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import model.Produto;
import persist.ProdutoDAO;

@WebServlet("/listarProduto")
public class ListarProduto extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Verifica se o usuário está logado
        Cookie[] cookies = req.getCookies();
        boolean isLoggedIn = false;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    isLoggedIn = true;
                    break;
                }
            }
        }

        if (!isLoggedIn) {
            // Se não estiver logado, redireciona para a página de login
            resp.sendRedirect("login.jsp");
            return;
        }

        ProdutoDAO pdao = new ProdutoDAO();

		// Recebe a lista de produtos do ProdutoDAO
        List<Produto> listaProdutos = pdao.listar();

        // Define os atributos para serem exibidos na página JSP
        req.setAttribute("listaProdutos", listaProdutos);

        // Redireciona para a página de exibição de dados
        req.getRequestDispatcher("listarCadastro.jsp").forward(req, resp);
    }
}
