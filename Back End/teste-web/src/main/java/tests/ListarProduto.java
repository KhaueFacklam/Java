package tests;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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

        ProdutoDAO pdao = new ProdutoDAO();

		// Obtém a lista de produtos do ProdutoDAO
        List<Produto> listaProdutos = pdao.listar();

        // Defina os atributos para serem exibidos na página JSP
        req.setAttribute("listaProdutos", listaProdutos);

        // Redirecione para a página de exibição de dados
        req.getRequestDispatcher("listarCadastro.jsp").forward(req, resp);
    }
}
