package persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Pedido;


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

}
