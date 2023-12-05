package tests;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contato;
import persist.ContatoDAO;

@WebServlet("/adicionarContato")
public class AdicionarContato extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ContatoDAO cdao = new ContatoDAO();
        String nome = req.getParameter("nomeContato");

        // Verifica se o nome já existe no banco de dados
        if (!verificarNomeExistente(nome)) {
            Contato c = new Contato();
            c.setNome(req.getParameter("nomeContato"));
            c.setEmail(req.getParameter("emailContato"));
            c.setEndereco(req.getParameter("enderecoContato"));

            cdao.adicionar(c);

            // Defina os atributos para serem exibidos na página JSP
            req.setAttribute("tipoCadastro", "contato");
            req.setAttribute("verificacao", "inexistente");
            req.setAttribute("nome", c.getNome());
            req.setAttribute("email", c.getEmail());
            req.setAttribute("endereco", c.getEndereco());
            req.setAttribute("mensagem", "Usuário cadastrado com sucesso!");

            // Redirecione para a página de exibição de dados
            req.getRequestDispatcher("mostrarCadastro.jsp").forward(req, resp);
        } else {
            // Nome já existe
            req.setAttribute("tipoCadastro", "contato");
            req.setAttribute("verificacao", "existente");
            req.setAttribute("mensagem", "Usuário já existe!");
            req.getRequestDispatcher("mostrarCadastro.jsp").forward(req, resp);
        }
    }

    private boolean verificarNomeExistente(String nome) {
        ContatoDAO cdao = new ContatoDAO();
        List<Contato> contatos = cdao.listar();

        for (Contato contato : contatos) {
            if (contato.getNome().equals(nome)) {
                return true; // Nome já existe
            }
        }
        return false; // Nome não existe
    }
}
