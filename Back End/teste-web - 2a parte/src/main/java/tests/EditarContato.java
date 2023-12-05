package tests;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contato;
import persist.ContatoDAO;

@WebServlet("/editarContato")
public class EditarContato extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		ContatoDAO cdao = new ContatoDAO();
		
		Contato c = cdao.getContato(Long.parseLong(req.getParameter("id"))); 	
		c.setNome(req.getParameter("nome"));
		c.setEmail(req.getParameter("email"));
		c.setEndereco(req.getParameter("endereco"));
		cdao.alterar(c);
		
		PrintWriter out = resp.getWriter();
		//(..)
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title>Contato Editado</title>");
		out.println("	</head>");
		out.println("	<body>");
		out.println("		<h1>O contato foi editado assim:</h1>");
		out.printf("			Nome:		%s	<br />\n", c.getNome());
		out.printf("			e-mail: 	%s	<br />\n",c.getEmail());
		out.printf("			Endereco: 	%s  <br />\n",c.getEndereco());
		out.println("	<a href='listarContatos'>Listar Contatos</a>");
		out.println("	</body>");
		out.println("</html>");
	}
}


