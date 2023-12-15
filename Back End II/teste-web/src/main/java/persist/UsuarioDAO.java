package persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    private Connection connection;

    public UsuarioDAO() {
        try {
            this.connection = new ConnectionFactory().getConnection();
        } catch (SQLException e) {
            System.out.println("Problemas ao abrir conexão na classe UsuarioDAO.");
            e.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Erro na importação do jar no servidor.");
        }
    }

    public boolean verificarCredenciais(String username, String password) {
        try {
            String sql = "SELECT * FROM Usuario WHERE username = ? AND password = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, password);

                try (ResultSet rs = stmt.executeQuery()) {
                    return rs.next(); // Retorna true se encontrou um usuário com essas credenciais
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
