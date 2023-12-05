package tests;

import java.io.IOException;
import java.io.PrintWriter;

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

		PrintWriter out = resp.getWriter();
		// (..)
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title> Salvando o contato</title>");
		out.println("	</head>");
		out.println("	<body>");
		out.printf("		<b>Nome</ b>: 		%s	<br />", req.getParameter("nome"));
		out.printf("		<b>e-mail</ b>:		%s	<br />", req.getParameter("email"));
		out.printf("		<b>Endereco</ b>: 	%s	<br />", req.getParameter("endereco"));
		out.println("	</body>");
		out.println("</html>");
	}
}
