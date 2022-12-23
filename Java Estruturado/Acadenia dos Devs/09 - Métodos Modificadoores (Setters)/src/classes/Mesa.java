package classes;

public class Mesa {

    private Integer livros = 50; // defini uma quantidade de livros

    public void setLivros(Integer livros) {
        this.livros += livros;
    }

    public Integer getLivros() {
        return livros;
    }

}
