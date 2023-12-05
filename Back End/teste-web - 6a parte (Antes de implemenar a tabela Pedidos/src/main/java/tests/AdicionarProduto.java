package tests;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import persist.ProdutoDAO;

@WebServlet("/adicionarProduto")
public class AdicionarProduto extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ProdutoDAO pdao = new ProdutoDAO();

        Produto p = new Produto();
        p.setNome(req.getParameter("nomeProduto"));
        p.setDescricao(req.getParameter("descricaoProduto"));
        p.setPreco(Double.parseDouble(req.getParameter("precoProduto")));

        pdao.adicionar(p);

        // Defina os atributos para serem exibidos na página JSP
        req.setAttribute("tipoCadastro", "produto");
        req.setAttribute("nomeProduto", p.getNome());
        req.setAttribute("descricaoProduto", p.getDescricao());
        req.setAttribute("precoProduto", p.getPreco());
        req.setAttribute("mensagem", "Produto cadastrado com sucesso!");
                
        // Redirecione para a página de exibição de dados do produto
        req.getRequestDispatcher("mostrarCadastro.jsp").forward(req, resp);
    }
}
