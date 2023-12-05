package tests;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import persist.ProdutoDAO;

@WebServlet("/deletarProduto")
public class DeletarProduto extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ProdutoDAO pdao = new ProdutoDAO();

        long id = Long.parseLong(req.getParameter("id"));
        Produto p = pdao.getProduto(id);
        pdao.remover(p);

        // Adiciona a mensagem à requisição antes de redirecionar
        req.setAttribute("mensagem", "Prodruto removido com sucesso!");

        // Redireciona para a página mostrarPesquisa.jsp
        req.getRequestDispatcher("cadastroDeletado.jsp").forward(req, resp);
    }
}
