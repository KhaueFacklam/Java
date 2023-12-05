package tests;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contato;
import persist.ContatoDAO;

@WebServlet("/listarContato")
public class ListarContato extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		ContatoDAO cdao = new ContatoDAO();

		// Obtém a lista de contatos do ContatoDAO
		List<Contato> listaContatos = cdao.listar();

		// Define a lista de contatos como um atributo na requisição
		req.setAttribute("listaContatos", listaContatos);

		// Redirecione para a página de exibição de dados
		req.getRequestDispatcher("/listarCadastro.jsp").forward(req, resp);

	}
}
