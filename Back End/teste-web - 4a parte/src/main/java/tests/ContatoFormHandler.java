package tests;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contato;
import persist.ContatoDAO;

@WebServlet("/criarContato")
public class ContatoFormHandler extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		ContatoDAO cdao = new ContatoDAO();

		Contato c = new Contato(); // cria a classe instancia do Javabean
		c.setNome(req.getParameter("nome"));
		c.setEmail(req.getParameter("email"));
		c.setEndereco(req.getParameter("endereco"));

		cdao.adicionar(c);

	}
}
