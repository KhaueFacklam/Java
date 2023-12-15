package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persist.UsuarioDAO;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Verifica as credenciais no UsuarioDAO
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if (usuarioDAO.verificarCredenciais(username, password)) {
            // Cria um cookie de sessão
            Cookie userCookie = new Cookie("user", username);
            userCookie.setMaxAge(60 * 60 * 24); // Tempo de vida do cookie em segundos (1 dia)
            response.addCookie(userCookie);

            // Redireciona para a página principal depois do login
            response.sendRedirect("inicio.jsp");
        } else {
            // Credenciais incorretas, redirecione de volta para a página de login
            response.sendRedirect("login.jsp?error=true");
        }
    }
}
