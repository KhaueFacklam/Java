package persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Produto;

public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO() {
        try {
            this.connection = new ConnectionFactory().getConnection();
        } catch (SQLException e) {
            System.out.println("Problemas ao abrir conexão na classe ProdutoDAO.");
            e.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Xiii... Deu ruim na importação do jar no servidor.");
        }
    }

    public void adicionar(Produto produto) {
        try {
            // cria um preparedStatement
            String sql = "INSERT INTO produtos (nome, descricao, preco) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            // preenche os valores
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPreco());
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException sqle) {
            System.out.println("Não foi possível processar a inserção do produto");
            sqle.printStackTrace();
        } catch (Exception e) {
            System.out.println("Erro desconhecido. Lamentamos o ocorrido");
        }
    }

    public List<Produto> listar() {
        List<Produto> lista = new ArrayList<>();
        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM produtos");
            Produto produto;
            while (rs.next()) {
                produto = new Produto();
                produto.setId(rs.getLong("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                lista.add(produto);
            }
            return lista;
        } catch (SQLException sqle) {
            System.out.println("Não foi possível processar a listagem de produtos");
            return null;
        } catch (Exception e) {
            System.out.println("Erro desconhecido. Lamentamos o ocorrido");
            return null;
        }
    }

    public void alterar(Produto produto) {
        try {
            // cria um preparedStatement
            String sql = "UPDATE produtos SET nome = ?, descricao = ?, preco = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            // preenche os valores
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPreco());
            stmt.setLong(4, produto.getId());
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException sqle) {
            System.out.println("Não foi possível processar a alteração do produto");
            sqle.printStackTrace();
        } catch (Exception e) {
            System.out.println("Erro desconhecido. Lamentamos o ocorrido");
        }
    }

    public void remover(Produto produto) {
        try {
            // Exclui todos os pedidos associados ao produto
            PedidoDAO pedidoDAO = new PedidoDAO();
            pedidoDAO.removerPorProduto(produto.getId());
            
            // cria um preparedStatement
            String sql = "DELETE FROM produtos WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            // preenche os valores
            stmt.setLong(1, produto.getId());
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException sqle) {
            System.out.println("Não foi possível processar a exclusão do produto");
        } catch (Exception e) {
            System.out.println("Erro desconhecido. Lamentamos o ocorrido");
        }
    }

    public Produto getProduto(long id) {
        Produto produto = new Produto();
        String sql = "SELECT * FROM produtos WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                System.out.println("Produto não encontrado");
                return produto;
            }
            produto.setId(rs.getLong("id"));
            produto.setNome(rs.getString("nome"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setPreco(rs.getDouble("preco"));
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Não foi possível carregar o produto solicitado");
        }
        return produto;
    }
}
