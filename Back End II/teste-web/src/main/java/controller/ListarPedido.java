package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pedido;
import persist.PedidoDAO;

@WebServlet("/listarPedido")
public class ListarPedido extends HttpServlet {
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

        long idContato = Long.parseLong(req.getParameter("idContato"));

        PedidoDAO pedidoDAO = new PedidoDAO();
        List<Pedido> listaPedidos = pedidoDAO.listarPedidosPorContato(idContato);

        req.setAttribute("listaPedidos", listaPedidos);
        req.getRequestDispatcher("listarCadastro.jsp").forward(req, resp);
    }
}
