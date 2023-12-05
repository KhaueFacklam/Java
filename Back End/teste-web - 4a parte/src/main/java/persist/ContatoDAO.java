package persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Contato;

public class ContatoDAO {

	private Connection connection;

	public ContatoDAO() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			System.out.println("Problemas ao abrir conexão na classe ContatoDAO.");
			e.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Xiii... Deu ruim na importação do jar no servidor.");
		}
	}

	public void adicionar(Contato contato) {
		try {
			// cria um preparedStatement
			String sql = "insert into contatos (nome, email, endereco) values (?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			// preenche os valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException sqle) {
			System.out.println("Nao foi possivel processar a insercao");
		} catch (Exception e) {
			System.out.println("Erro desconhecido. Lamentamos o ocorrido");
		}
	}

	public List<Contato> listar() {
		List<Contato> lista = new ArrayList<>();
		try {
			// consulta e apresenta na tela.
			ResultSet rs = connection.createStatement().executeQuery("select * from contatos");
			Contato c;
			while (rs.next()) {
				c = new Contato();

				c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setEndereco(rs.getString("endereco"));
				lista.add(c);
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

	public void alterar(Contato contato) {
		try {
			// cria um preparedStatement
			String sql = "update contatos set nome = ?, email = ?, endereco = ? where id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			// preenche os valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setLong(4, contato.getId());
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

	public void remover(Contato contato) {
		try {
			// cria um preparedStatement
			String sql = "delete from contatos where id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			// preenche os valores
			stmt.setLong(1, contato.getId());
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException sqle) {
			System.out.println("Nao foi possivel processar a exclusao");
		} catch (Exception e) {
			System.out.println("Erro desconhecido. Lamentamos o ocorrido");
		}
	}

	public Contato getContato(long id) {
		Contato c = new Contato();
		;
		String sql = "select * from contatos where `id` = ?";
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
				return c;
			}
			c.setId(rs.getLong("id"));
			c.setNome(rs.getString("nome"));
			c.setEmail(rs.getString("email"));
			c.setEndereco(rs.getString("endereco"));
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Nao foi possivel carregar o dado solicitado");
		}
		return c;
	}

}
