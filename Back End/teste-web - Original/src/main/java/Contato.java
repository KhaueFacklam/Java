
public class Contato {
    int id;
    String nome;
    String email;
    String endereco;

    @Override
    public String toString() {
        return "Contato [id = " + id + ", Nome = " + nome + ", E-mail = " + email + ", Endereço = " + endereco + " ]";
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
