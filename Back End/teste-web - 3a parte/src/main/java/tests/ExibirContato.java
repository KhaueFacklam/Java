package tests;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contato;
import persist.ContatoDAO;

@WebServlet("/ExibirContato")
public class ExibirContato extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // verifica se o usuario esta logado.
        ContatoDAO cdao = new ContatoDAO();
        long id = Long.parseLong(req.getParameter("id"));
		Contato c = cdao.getContato(id);
        req.setAttribute("contato", c);
        req.setAttribute("mensagem", "Eis o contato consultado");
        req.getRequestDispatcher("mostrarContato.jsp").forward(req, resp);
    }
}
