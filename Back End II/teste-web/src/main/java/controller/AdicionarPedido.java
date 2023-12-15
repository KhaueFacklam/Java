package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contato;
import model.Pedido;
import model.Produto;
import persist.ContatoDAO;
import persist.PedidoDAO;
import persist.ProdutoDAO;

@WebServlet("/adicionarPedido")
public class AdicionarPedido extends HttpServlet {
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

        ContatoDAO cdao = new ContatoDAO();
        ProdutoDAO pdao = new ProdutoDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();

        long idContato = Long.parseLong(req.getParameter("idContato"));
        long idProduto = Long.parseLong(req.getParameter("idProduto"));
        int quantidade = Integer.parseInt(req.getParameter("quantidade"));

        Contato contato = cdao.getContato(idContato);
        Produto produto = pdao.getProduto(idProduto);

        if (contato.getId() != 0 && produto.getId() != 0) {
            Pedido pedido = new Pedido(contato, produto, quantidade);
            pedidoDAO.adicionar(pedido);

            // Define os atributos que vão ser exibidos na página JSP
            req.setAttribute("tipoCadastro", "pedido");
            req.setAttribute("mensagem", "Pedido cadastrado com sucesso!");
            req.setAttribute("produto", produto);
            req.setAttribute("pedido", pedido);
        } else {
            req.setAttribute("mensagem", "Erro ao cadastrar o pedido. Contato ou produto não encontrado.");
        }

        req.getRequestDispatcher("mostrarCadastro.jsp").forward(req, resp);
    }
}
