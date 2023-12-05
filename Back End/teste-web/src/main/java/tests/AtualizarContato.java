package tests;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contato;
import persist.ContatoDAO;

@WebServlet("/atualizarContato")
public class AtualizarContato extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // verifica se o usuario esta logado.
        ContatoDAO cdao = new ContatoDAO();
        long id = Long.parseLong(req.getParameter("id")); // pega o ID
        Contato c = cdao.getContato(id); // carrega o contato do banco
        // agora atualiza o contato com as novas informações
        c.setNome(req.getParameter("nome"));
        c.setEmail(req.getParameter("email"));
        c.setEndereco(req.getParameter("endereco"));

        // agora eu salvo o c, que tá na memoria ainda, no banco.
        cdao.alterar(c);
        // redireciono para a view que vai mostrar o contato, agora com novos dados.
        req.setAttribute("contato", c);
        req.setAttribute("mensagem", "Atualizacoes salvas");

        req.getRequestDispatcher("mostrarPesquisa.jsp").forward(req, resp);
    }
}
