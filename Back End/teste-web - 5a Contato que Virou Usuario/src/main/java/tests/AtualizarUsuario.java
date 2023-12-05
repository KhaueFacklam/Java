package tests;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import persist.UsuarioDAO;

@WebServlet("/AtualizarUsuario")
public class AtualizarUsuario extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // verifica se o usuario esta logado.
        UsuarioDAO cdao = new UsuarioDAO();
        long id = Long.parseLong(req.getParameter("id")); // pega o ID
        Usuario c = cdao.getUsuario(id); // carrega o usuario do banco
        // agora atualiza o usuario com as novas informações
        c.setNome(req.getParameter("nome"));
        c.setEmail(req.getParameter("email"));
        c.setEndereco(req.getParameter("endereco"));

        // agora eu salvo o c, que tá na memoria ainda, no banco.
        cdao.alterar(c);
        // redireciono para a view que vai mostrar o usuario, agora com novos dados.
        req.setAttribute("usuario", c);
        req.setAttribute("mensagem", "Atualizacoes salvas");

        req.getRequestDispatcher("mostrarUsuario.jsp").forward(req, resp);
    }
}
