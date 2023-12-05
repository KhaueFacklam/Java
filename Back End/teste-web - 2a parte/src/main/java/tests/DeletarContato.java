package tests;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contato;
import persist.ContatoDAO;

@WebServlet("/removerContato")
public class DeletarContato extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		ContatoDAO cdao = new ContatoDAO();
		
		long id = Long.parseLong(req.getParameter("id"));
		Contato c = cdao.getContato(id);
		cdao.remover(c);
		
		PrintWriter out = resp.getWriter();
		//(..)
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title> O contato a seguir acaba de ser excluído</title>");
		out.println("	</head>");
		out.println("	<body>");
		out.printf("		<b>Nome</ b>: 		%s	<br />", c.getNome() );
		out.printf("		<b>e-mail</ b>:		%s	<br />", c.getEmail());
		out.printf("		<b>Endereco</ b>: 	%s	<br />", c.getEndereco() );
		out.println("	<a href='listarContatos'>Listar Contatos</a>");
		out.println("	</body>");
		out.println("</html>");
	}
}


