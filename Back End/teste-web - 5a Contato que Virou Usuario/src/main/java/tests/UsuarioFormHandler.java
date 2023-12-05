package tests;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import persist.UsuarioDAO;

@WebServlet("/criarUsuario")
public class UsuarioFormHandler extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		UsuarioDAO cdao = new UsuarioDAO();

		Usuario u = new Usuario(); // cria a classe instancia do Javabean
		u.setNome(req.getParameter("nome"));
		u.setEmail(req.getParameter("email"));
		u.setEndereco(req.getParameter("endereco"));

		cdao.adicionar(u);

	}
}

