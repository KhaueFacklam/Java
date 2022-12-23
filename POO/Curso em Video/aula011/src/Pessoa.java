public abstract class Pessoa {

    // classe abstrata é aquela que não pode virar um objeto
    private String nome;
    private int idade;
    private String sexo;

    public void fazerAniversario() {
        this.setIdade(this.getIdade() + 1);
    }

    @Override
    public String toString() {
        return "Pessoa [idade=" + idade + ", nome=" + nome + ", sexo=" + sexo + "]";
    }

    // ================ Getters e Setters ================

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}
