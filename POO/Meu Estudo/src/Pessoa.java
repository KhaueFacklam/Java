public class Pessoa {

    private String nome;
    private int idade;
    private float altura;
    private boolean acordado;

    public Pessoa(String nome, int idade, float altura, boolean acordado) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.acordado = acordado;
    }

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

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public boolean isAcordado() {
        return acordado;
    }

    public void setAcordado(boolean acordado) {
        this.acordado = acordado;
    }

}
