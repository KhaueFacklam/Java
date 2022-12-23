public class Aula06 {
    public static void main(String[] args) throws Exception {

        ControleRemoto c1 = new ControleRemoto();
        c1.ligar();
        c1.play();
        c1.maisVolume();
        c1.maisVolume();
        c1.pause();
        c1.abrirMenu(); 
    }
}
