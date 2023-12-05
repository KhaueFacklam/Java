package persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioDAO {

	private Connection connection;

	public UsuarioDAO() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			System.out.println("Problemas ao abrir conexão na classe UsuarioDAO.");
			e.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Xiii... Deu ruim na importação do jar no servidor.");
		}
	}

	public void adicionar(Usuario usuario) {
		try {
			// cria um preparedStatement
			String sql = "insert into usuarios (nome, email, endereco) values (?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			// preenche os valores
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getEndereco());
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException sqle) {
			System.out.println("Nao foi possivel processar a insercao");
		} catch (Exception e) {
			System.out.println("Erro desconhecido. Lamentamos o ocorrido");
		}
	}

	public List<Usuario> listar() {
		List<Usuario> lista = new ArrayList<>();
		try {
			// consulta e apresenta na tela.
			ResultSet rs = connection.createStatement().executeQuery("select * from usuario");
			Usuario u;
			while (rs.next()) {
				u = new Usuario();

				u.setId(rs.getLong("id"));
				u.setNome(rs.getString("nome"));
				u.setEmail(rs.getString("email"));
				u.setEndereco(rs.getString("endereco"));
				lista.add(u);
			}
			return lista;
		} catch (SQLException sqle) {
			System.out.println("Nao foi possivel processar a listagem");
			return null;
		} catch (Exception e) {
			System.out.println("Erro desconhecido. Lamentamos o ocorrido");
			return null;
		}
	}

	public void alterar(Usuario usuario) {
		try {
			// cria um preparedStatement
			String sql = "update usuario set nome = ?, email = ?, endereco = ? where id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			// preenche os valores
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getEndereco());
			stmt.setLong(4, usuario.getId());
			// executa
			System.out.println(stmt.toString());
			stmt.execute();
			stmt.close();
		} catch (SQLException sqle) {
			System.out.println("Nao foi possivel processar a alteracao");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("Erro desconhecido. Lamentamos o ocorrido");
		}
	}

	public void remover(Usuario usuario) {
		try {
			// cria um preparedStatement
			String sql = "delete from usuario where id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			// preenche os valores
			stmt.setLong(1, usuario.getId());
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException sqle) {
			System.out.println("Nao foi possivel processar a exclusao");
		} catch (Exception e) {
			System.out.println("Erro desconhecido. Lamentamos o ocorrido");
		}
	}

	public Usuario getUsuario(long id) {
		Usuario u = new Usuario();
		;
		String sql = "select * from usuario where `id` = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id); // preenche o valor do ID na query
			// executa
			ResultSet rs = stmt.executeQuery();
			// como só vai ter um, chamo next() uma vez só. o resultSet começa com
			// o ponteiro apontando para antes do primerio resultado se tem resultado
			// na consulta, ele retorna verdadeiro e aponta para ele.
			if (!rs.next()) {
				System.out.println("dado nao encontrado");
				return u;
			}
			u.setId(rs.getLong("id"));
			u.setNome(rs.getString("nome"));
			u.setEmail(rs.getString("email"));
			u.setEndereco(rs.getString("endereco"));
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Nao foi possivel carregar o dado solicitado");
		}
		return u;
	}

}
