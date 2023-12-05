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

@WebServlet("/exibirContato")
public class ExibirContato extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		ContatoDAO cdao = new ContatoDAO();
		
		Contato c = cdao.getContato(Long.parseLong(req.getParameter("id"))); 	
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title> Salvando o contato</title>");
		out.println("	</head>");
		out.println("	<body>");
		out.println("		<h1>Editar contato</h1>");
		out.println("		<form action='editarContato'>");
		out.printf("			<input type='hidden' 	name = 'id' value='%s'/><br />", c.getId());
		out.printf("			Nome: 		<input type='text' 	name = 'nome' value='%s'/><br />", c.getNome());
		out.printf("			e-mail: 	<input type='text' 	name = 'email' value='%s'/><br />",c.getEmail());
		out.printf("			Endereco: 	<input type='text'	name = 'endereco' value='%s'/><br />",c.getEndereco());
		out.println("			<input type='submit' value = 'Gravar'/>");
		out.println("		</form>");
		out.println("	<a href='listarContatos'>cancelar</a>");
		out.println("	</body>");
		out.println("</html>");
	}
}


