package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contato;
import persist.ContatoDAO;

@WebServlet("/deletarContato")
public class DeletarContato extends HttpServlet {
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

        ContatoDAO cdao = new ContatoDAO();

        long id = Long.parseLong(req.getParameter("id"));
        Contato c = cdao.getContato(id);
        cdao.remover(c);

        // Adiciona uma mensagem antes de redirecionar
        req.setAttribute("mensagem", "Contato removido com sucesso!");

        req.getRequestDispatcher("cadastroDeletado.jsp").forward(req, resp);
    }
}
