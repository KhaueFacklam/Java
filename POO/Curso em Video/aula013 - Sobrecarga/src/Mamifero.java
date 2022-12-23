public class Mamifero extends Animal {
    private String corPelo;

    @Override
    public void emitirSom() {
        System.out.println("Emitindo som de mamífero...");
    }

    public String getCorPelo() {
        return corPelo;
    }

    public void setCorPelo(String corPelo) {
        this.corPelo = corPelo;
    }

}
