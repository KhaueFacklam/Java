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
            String sql = "INSERT INTO pedidos (id_contato, id_produto, quantidade, total) VALUES (?, ?, ?, ?)";
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

    public List<Pedido> listarPedidosPorContato(long idContato) {
        List<Pedido> listaPedidos = new ArrayList<>();

        try {
            String sql = "SELECT * FROM pedidos WHERE id_contato = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, idContato);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                long id = rs.getLong("id");
                long idProduto = rs.getLong("id_produto");
                int quantidade = rs.getInt("quantidade");
                double total = rs.getDouble("total");

                // Recupera o contato e o produto que fora, associados aos pedidos
                ContatoDAO contatoDAO = new ContatoDAO();
                ProdutoDAO produtoDAO = new ProdutoDAO();

                Contato contato = contatoDAO.getContato(idContato);
                Produto produto = produtoDAO.getProduto(idProduto);

                // Cria um objeto Pedido e adicione à lista
                Pedido pedido = new Pedido(contato, produto, quantidade);
                pedido.setId(id);
                pedido.setTotal(total);
                listaPedidos.add(pedido);
            }

            rs.close();
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return listaPedidos;
    }

    public void remover(long idPedido) {
        try {
            // cria um preparedStatement
            String sql = "DELETE FROM pedidos WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            // preenche os valores
            stmt.setLong(1, idPedido);
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
        Pedido pedido = new Pedido(null, null, 0); // Crie um pedido vazio inicialmente
    
        String sql = "SELECT * FROM pedidos WHERE id = ?";
    
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
    
            ResultSet rs = stmt.executeQuery();
    
            if (rs.next()) {
                long idContato = rs.getLong("id_contato");
                long idProduto = rs.getLong("id_produto");
                int quantidade = rs.getInt("quantidade");
                double total = rs.getDouble("total");
    
                // Recupere o contato e o produto associados aos pedidos
                ContatoDAO contatoDAO = new ContatoDAO();
                ProdutoDAO produtoDAO = new ProdutoDAO();
    
                Contato contato = contatoDAO.getContato(idContato);
                
                // Verifica se o idProduto é diferente de zero antes de obter o produto
                Produto produto = (idProduto != 0) ? produtoDAO.getProduto(idProduto) : null;
    
                // Cria um objeto Pedido
                pedido = new Pedido(contato, produto, quantidade);
                pedido.setId(id);
                pedido.setTotal(total);
            }
    
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Não foi possível carregar o pedido solicitado");
        }
    
        return pedido;
    }

    public void removerPorContato(long idContato) {
        try {
            String sql = "DELETE FROM pedidos WHERE id_contato = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, idContato);
            stmt.execute();
            stmt.close();
        } catch (SQLException sqle) {
            System.out.println("Não foi possível processar a exclusão dos pedidos do contato");
        } catch (Exception e) {
            System.out.println("Erro desconhecido. Lamentamos o ocorrido");
        }
    }
    
    public void removerPorProduto(long idProduto) {
        try {
            String sql = "DELETE FROM pedidos WHERE id_produto = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, idProduto);
            stmt.execute();
            stmt.close();
        } catch (SQLException sqle) {
            System.out.println("Não foi possível processar a exclusão dos pedidos do produto");
        } catch (Exception e) {
            System.out.println("Erro desconhecido. Lamentamos o ocorrido");
        }
    }
    
    
    

}
