public class App {
    public static void main(String[] args) throws Exception {

        Lutador lutadores[] = new Lutador[6]; // instanciando VETOR
        lutadores[0] = new Lutador("Khaue", "Brasil", 33, 1.74f, 64f, 0, 1000, 0);
        lutadores[1] = new Lutador("Goku", "Japão", 36, 1.76f, 65f, 1000, 1, 1);

        Luta luta = new Luta();
        luta.marcarLuta(lutadores[0], lutadores[1]);
        luta.lutar(); 

    }
}
