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

@WebServlet("/listarContatos")
public class ListarContatos extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		ContatoDAO cdao = new ContatoDAO();
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title> Salvando o contato</title>");
		out.println("	</head>");
		out.println("	<body>");
		out.println("		<table border='1'>");
		out.println("			<thead>");
		out.println("				<tr>");
		out.println("					<td>Nome</td>");
		out.println("					<td>e-mail</td>");
		out.println("					<td>Endereço</td>");
		out.println("					<td>Editar</td>");
		out.println("					<td>Excluir</td>");
		out.println("				</tr>");
		out.println("	 		</thead>");
		out.println("			<tbody>");
		for (Contato aux : cdao.listar()) {
			out.println("				<tr>");
			out.printf("					<td>%s</td>", aux.getNome());
			out.printf("					<td>%s</td>", aux.getEmail());
			out.printf("					<td>%s</td>", aux.getEndereco());
			out.printf("					<td><a href='exibirContato?id=%s'>Editar</a></td>", aux.getId());
			out.printf("					<td><a href='removerContato?id=%s'>Detetar</a></td>", aux.getId());
			out.println("				</tr>");
		}

		out.println("			</tbody>");
		out.println("		</table>");
		out.println("	</body>");
		out.println("</html>");
	}
}
