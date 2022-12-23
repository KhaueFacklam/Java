public class Mamifero extends Animal {

    private String corPelo;

    @Override
    public void alimentar() {
        System.out.println("Mamando...");
    }

    @Override
    public void emitirSom() {
        System.out.println("Emitindo som de mamífero");
    }

    @Override
    public void locomover() {
        System.out.println("Correndo...");
    }

    // ============ getters e setters ============

    public String getCorPelo() {
        return corPelo;
    }

    public void setCorPelo(String corPelo) {
        this.corPelo = corPelo;
    }

}
