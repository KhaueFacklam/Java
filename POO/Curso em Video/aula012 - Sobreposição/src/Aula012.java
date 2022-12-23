public class Aula012 {
    public static void main(String[] args) throws Exception {

        Mamifero mamifero = new Mamifero();
        Reptil reptil = new Reptil();
        Peixe peixe = new Peixe();
        Ave ave = new Ave();

        Canguru canguru = new Canguru();

        mamifero.setPeso(45f);
        mamifero.setCorPelo("Marrom");
        mamifero.alimentar();
        mamifero.locomover();
        mamifero.emitirSom();

        ave.locomover();
        peixe.locomover();
        canguru.locomover();

        
        

    }
}
