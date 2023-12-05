package tests;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import persist.UsuarioDAO;

@WebServlet("/ExibirUsuario")
public class ExibirUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // verifica se o usuario esta logado.
        UsuarioDAO cdao = new UsuarioDAO();
        long id = Long.parseLong(req.getParameter("id"));
		Usuario u = cdao.getUsuario(id);
        req.setAttribute("usuario", u);
        req.setAttribute("mensagem", "Eis o usuario consultado");
        req.getRequestDispatcher("mostrarUsuario.jsp").forward(req, resp);
    }
}
