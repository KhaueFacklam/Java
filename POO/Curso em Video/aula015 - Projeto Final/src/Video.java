public class Video implements AcoesVideo {

    private String titulo;
    private Integer avaliacao;
    private Integer views;
    private Integer curtidas;
    private boolean reproduzindo;

    public Video(String titulo) {
        this.titulo = titulo;
        this.setAvaliacao(1);
        this.setViews(0);
        this.setCurtidas(0);
        this.setReproduzindo(false);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        // int nova;
        // nova = (int) ((this.avaliacao + avaliacao) / this.views); DEU ERRO!
        // this.avaliacao = nova;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(Integer curtidas) {
        this.curtidas = curtidas;
    }

    public boolean isReproduzindo() {
        return reproduzindo;
    }

    public void setReproduzindo(boolean reproduzindo) {
        this.reproduzindo = reproduzindo;
    }

    @Override
    public void play() {
        this.reproduzindo = true;
    }

    @Override
    public void pause() {
        this.reproduzindo = false;
    }

    @Override
    public void like() {
        this.curtidas++;
    }

    @Override
    public String toString() {
        return "Video [avaliacao = " + avaliacao + ", curtidas = " + curtidas + ", reproduzindo = " + reproduzindo
                + ", titulo = " + titulo + ", views = " + views + "]";
    }

}
