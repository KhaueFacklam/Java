package tests;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/oi")
public class OlaMundo extends HttpServlet{
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();		
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title> Minha Primeira Servlet </title>");
		out.println("	</head>");
		out.println("	<body>");
		out.println("		<h1> Olah mundo Servlet!</h1>");
		out.println("	</body>");
		out.println("</html>");
	}

	
	
}


