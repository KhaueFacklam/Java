import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {

    private Connection connection;

    public ContatoDAO() {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Deu ruim"); // não dê dica da estrutura interna. Gere um resposta genérica
            e.printStackTrace();
        }
    }

    public void adicionar(Contato contato) {
        try {
            // Cria um preparedStatement
            String sql = "insert into contatos (nome, email, endereco) values (?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            // Preenche os valores
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            // Executa
            stmt.execute();
            stmt.close();
        } catch (SQLException sqle) {
            System.out.println("Não foi possivel processar a inserção");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erro desconhecido. Lamentamos o ocorrido");
        }

    }

    public List<Contato> listar() {
        List<Contato> lista = new ArrayList<>();
        try {
            // consulta e apresenta na tela
            ResultSet rs = connection.createStatement().executeQuery("select * from contatos");
            Contato c;
            while (rs.next()) {
                c = new Contato();

                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setEndereco(rs.getString("endereco"));
                lista.add(c);
            }
            return lista;
        } catch (SQLException sqle) {
            System.out.println("Não foi possivel processar a listagem");
            return null;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erro desconhecido. Lamentamos o ocorrido");
            return null;
        }
    }

    public void alterar(Contato contato) {
        try {
            // Cria um preparedStatement
            String sql = "update contatos set nome = ?, email = ?, endereco = ? where id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            // Preenche os valores
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setLong(5, contato.getId());
            // Executa
            stmt.execute();
            stmt.close();
        } catch (SQLException sqle) {
            System.out.println("Não foi possivel processar a alteração");
            sqle.printStackTrace();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erro desconhecido. Lamentamos o ocorrido");
        }
    }

    public void remover(Contato contato) {
        try {
            // Cria um preparedStatement
            String sql = "delete from contatos where id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            // Preenche os valores
            stmt.setLong(1, contato.getId());
            // Executa
            stmt.execute();
            stmt.close();
        } catch (SQLException sqle) {
            System.out.println("Não foi possivel processar a exclusao");
            sqle.printStackTrace();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erro desconhecido. Lamentamos o ocorrido");
        }
    }

    public Contato getContato(int id) {
        try {
            // Cria um preparedStatement
            String sql = "select * from contatos where id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            // Preenche os valores
            stmt.setInt(1, id);

            // Executa a consulta
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Contato contato = new Contato();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));
                return contato;
            } else {
                return null;
            }
        } catch (SQLException sqle) {
            System.out.println("Não foi possível acessar o contato");
            sqle.printStackTrace();
            return null;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erro desconhecido. Lamentamos o ocorrido");
            return null;
        }

    }

}
