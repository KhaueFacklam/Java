package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persist.PedidoDAO;

@WebServlet("/deletarPedido")
public class DeletarPedido extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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

        // Recebe o ID do pedido que será excluído
        long idPedido = Long.parseLong(req.getParameter("idPedido"));

        PedidoDAO pedidoDAO = new PedidoDAO();

        // Remove o pedido
        pedidoDAO.remover(idPedido);

        // Adicionar a mensagem à requisição antes de redirecionar
        req.setAttribute("mensagem", "Pedido removido com sucesso!");

        req.getRequestDispatcher("cadastroDeletado.jsp").forward(req, resp);
    }
}
