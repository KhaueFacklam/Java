package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import persist.ProdutoDAO;

@WebServlet("/exibirProduto")
public class ExibirProduto extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
        long id = Long.parseLong(req.getParameter("idProduto"));
        Produto p = pdao.getProduto(id);
        req.setAttribute("produto", p);
        req.setAttribute("mensagem", "Eis o produto consultado");
        req.getRequestDispatcher("mostrarPesquisa.jsp").forward(req, resp);
    }
}
