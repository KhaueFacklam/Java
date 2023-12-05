package persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Contato;
import model.Pedido;
import model.Produto;

public class PedidoDAO {

    private Connection connection;

    public PedidoDAO() {
        try {
            this.connection = new ConnectionFactory().getConnection();
        } catch (SQLException e) {
            System.out.println("Problemas ao abrir conexão na classe PedidoDAO.");
            e.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Xiii... Deu ruim na importação do jar no servidor.");
        }
    }

    public void adicionar(Pedido pedido) {
        try {
            // cria um preparedStatement
            String sql = "INSERT INTO pedidos (contato_id, produto_id, quantidade, total) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            // preenche os valores
            stmt.setLong(1, pedido.getContato().getId());
            stmt.setLong(2, pedido.getProduto().getId());
            stmt.setInt(3, pedido.getQuantidade());
            stmt.setDouble(4, pedido.getTotal());
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException sqle) {
            System.out.println("Não foi possível processar a inserção do pedido");
            sqle.printStackTrace();
        } catch (Exception e) {
            System.out.println("Erro desconhecido. Lamentamos o ocorrido");
        }
    }

    public List<Pedido> listar() {
        List<Pedido> lista = new ArrayList<>();
        try {
            // consulta e apresenta na tela.
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM pedidos");
            Pedido pedido;
            while (rs.next()) {
                pedido = new Pedido();
                pedido.setId(rs.getLong("id"));
                pedido.setContato(getContato(rs.getLong("contato_id")));
                pedido.setProduto(getProduto(rs.getLong("produto_id")));
                pedido.setQuantidade(rs.getInt("quantidade"));
                pedido.setTotal(rs.getDouble("total"));
                lista.add(pedido);
            }
            return lista;
        } catch (SQLException sqle) {
            System.out.println("Não foi possível processar a listagem de pedidos");
            return null;
        } catch (Exception e) {
            System.out.println("Erro desconhecido. Lamentamos o ocorrido");
            return null;
        }
    }

    public void alterar(Pedido pedido) {
        try {
            // cria um preparedStatement
            String sql = "UPDATE pedidos SET contato_id = ?, produto_id = ?, quantidade = ?, total = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            // preenche os valores
            stmt.setLong(1, pedido.getContato().getId());
            stmt.setLong(2, pedido.getProduto().getId());
            stmt.setInt(3, pedido.getQuantidade());
            stmt.setDouble(4, pedido.getTotal());
            stmt.setLong(5, pedido.getId());
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException sqle) {
            System.out.println("Não foi possível processar a alteração do pedido");
            sqle.printStackTrace();
        } catch (Exception e) {
            System.out.println("Erro desconhecido. Lamentamos o ocorrido");
        }
    }

    public void remover(Pedido pedido) {
        try {
            // cria um preparedStatement
            String sql = "DELETE FROM pedidos WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            // preenche os valores
            stmt.setLong(1, pedido.getId());
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException sqle) {
            System.out.println("Não foi possível processar a exclusão do pedido");
        } catch (Exception e) {
            System.out.println("Erro desconhecido. Lamentamos o ocorrido");
        }
    }

    public Pedido getPedido(long id) {
        Pedido pedido = new Pedido();
        String sql = "SELECT * FROM pedidos WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                System.out.println("Pedido não encontrado");
                return pedido;
            }
            pedido.setId(rs.getLong("id"));
            pedido.setContato(getContato(rs.getLong("contato_id")));
            pedido.setProduto(getProduto(rs.getLong("produto_id")));
            pedido.setQuantidade(rs.getInt("quantidade"));
            pedido.setTotal(rs.getDouble("total"));
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Não foi possível carregar o pedido solicitado");
        }
        return pedido;
    }

    // Método auxiliar para obter um Contato pelo ID
    private Contato getContato(long id) throws SQLException {
        ContatoDAO contatoDAO = new ContatoDAO();
        return contatoDAO.getContato(id);
    }

    // Método auxiliar para obter um Produto pelo ID
    private Produto getProduto(long id) throws SQLException {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.getProduto(id);
    }
}
