package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contato;
import persist.ContatoDAO;

@WebServlet("/atualizarContato")
public class AtualizarContato extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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

        // Verifica se o usuario esta logado.
        ContatoDAO cdao = new ContatoDAO();
        long id = Long.parseLong(req.getParameter("id")); // pega o ID
        Contato c = cdao.getContato(id); // carrega o contato do banco de dados
        // agora atualiza o contato com as novas informações
        c.setNome(req.getParameter("nome"));
        c.setEmail(req.getParameter("email"));
        c.setEndereco(req.getParameter("endereco"));

        // agora eu salvo o c, que tá na memoria ainda, no banco.
        cdao.alterar(c);

        // redireciona para a view que vai mostrar o contato com novos dados.
        req.setAttribute("contato", c);
        req.setAttribute("mensagem", "Atualizacoes salvas");

        req.getRequestDispatcher("mostrarPesquisa.jsp").forward(req, resp);
    }
}
