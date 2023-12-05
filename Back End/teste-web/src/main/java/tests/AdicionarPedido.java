package tests;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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

            // Define atributos para serem exibidos na página JSP
            req.setAttribute("tipoCadastro", "pedido");
            req.setAttribute("mensagem", "Pedido cadastrado com sucesso!");
            req.setAttribute("produto", produto);
            req.setAttribute("pedido", pedido);
        } else {
            req.setAttribute("mensagem", "Erro ao cadastrar o pedido. Contato ou produto não encontrado.");
        }

        // Redireciona para a página de exibição de dados do pedido
        req.getRequestDispatcher("mostrarCadastro.jsp").forward(req, resp);
    }
}
