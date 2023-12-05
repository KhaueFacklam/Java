package tests;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contato;
import persist.ContatoDAO;

@WebServlet("/deletarContato")
public class DeletarContato extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ContatoDAO cdao = new ContatoDAO();

        long id = Long.parseLong(req.getParameter("id"));
        Contato c = cdao.getContato(id);
        cdao.remover(c);

        // Adiciona a mensagem à requisição antes de redirecionar
        req.setAttribute("mensagem", "Contato removido com sucesso!");

        // Redireciona para a página mostrarPesquisa.jsp
        req.getRequestDispatcher("cadastroDeletado.jsp").forward(req, resp);
    }
}

