public class Livro implements Publicacao {

    private String titulo;
    private String autor;
    private int totalPaginas;
    private int pagAtual;
    private boolean aberto;
    private Pessoa leitor;

    public Livro(String titulo, String autor, int totalPaginas, Pessoa leitor) {
        this.titulo = titulo;
        this.autor = autor;
        this.totalPaginas = totalPaginas;
        this.leitor = leitor;
        this.aberto = false;
        this.pagAtual = 0;
    }

    @Override
    public void abrir() {
        this.setAberto(true);
    }

    @Override
    public void fechar() {
        this.setAberto(false);
    }

    @Override
    public void folhear(int pagina) {
        if (pagina > this.getTotalPaginas()) {
            System.out.println("Página Inexistente!");
        } else {
            this.setPagAtual(pagina);
        }
    }

    @Override
    public void avancarPagina() {
        this.setPagAtual(getPagAtual() + 1);
    }

    @Override
    public void voltarPagina() {
        this.setPagAtual(this.getPagAtual() - 1);
    }

    public String detalhes() {
        return "Livro [aberto=" + aberto + ", autor=" + autor + ", leitor=" + leitor.getNome() + ", pagAtual="
                + pagAtual
                + ", titulo=" + titulo + ", totalPaginas=" + totalPaginas + "]";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    public int getPagAtual() {
        return pagAtual;
    }

    public void setPagAtual(int pagAtual) {
        this.pagAtual = pagAtual;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public Pessoa getLeitor() {
        return leitor;
    }

    public void setLeitor(Pessoa leitor) {
        this.leitor = leitor;
    }

}
