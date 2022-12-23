public class Peixe extends Animal {
    private String corEscama;

    @Override
    public void locomover() {
        System.out.println("Nadando...");
    }

    @Override
    public void alimentar() {
        System.out.println("Comendo algas...");
    }

    @Override
    public void emitirSom() {
        System.out.println("Emitindo som de peixe");
    }

    // ============ getters e setters ============

    public String getCorEscama() {
        return corEscama;
    }

    public void setCorEscama(String corEscama) {
        this.corEscama = corEscama;
    }

}
