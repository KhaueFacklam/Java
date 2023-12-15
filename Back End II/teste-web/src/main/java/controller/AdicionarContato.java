package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contato;
import persist.ContatoDAO;

@WebServlet("/adicionarContato")
public class AdicionarContato extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Verifica se o usuário está logado
        Cookie[] cookies = req.getCookies();
        boolean isLoggedIn = false;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    isLoggedIn = true;
                    break;
                }
            }
        }

        if (!isLoggedIn) {
            // Se não estiver logado, redireciona para a página de login
            resp.sendRedirect("login.jsp");
            return;
        }

        ContatoDAO cdao = new ContatoDAO();
        String nome = req.getParameter("nomeContato");

        // Verifica se o nome já existe no banco de dados
        if (!verificarNomeExistente(nome)) {
            Contato c = new Contato();
            c.setNome(req.getParameter("nomeContato"));
            c.setEmail(req.getParameter("emailContato"));
            c.setEndereco(req.getParameter("enderecoContato"));

            cdao.adicionar(c);

            // Define os atributos para serem exibidos na página JSP
            req.setAttribute("tipoCadastro", "contato");
            req.setAttribute("verificacao", "inexistente");
            req.setAttribute("nome", c.getNome());
            req.setAttribute("email", c.getEmail());
            req.setAttribute("endereco", c.getEndereco());
            req.setAttribute("mensagem", "Usuário cadastrado com sucesso!");

            req.getRequestDispatcher("mostrarCadastro.jsp").forward(req, resp);
        } else {
            // Nome já existe
            req.setAttribute("tipoCadastro", "contato");
            req.setAttribute("verificacao", "existente");
            req.setAttribute("mensagem", "Usuário já existe!");
            req.getRequestDispatcher("mostrarCadastro.jsp").forward(req, resp);
        }
    }


}
