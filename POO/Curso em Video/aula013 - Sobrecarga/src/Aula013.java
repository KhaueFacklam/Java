public class Aula013 {
    public static void main(String[] args) throws Exception {

        Mamifero mamifero = new Mamifero();
        Lobo lobo = new Lobo();
        Cachorro cachorro = new Cachorro();


        mamifero.emitirSom();
        lobo.emitirSom();
        cachorro.emitirSom();
        cachorro.reagir("Olá");
        cachorro.reagir(11, 45);
        cachorro.reagir(19, 10);
        cachorro.reagir(true);
        cachorro.reagir(false);



    }
}
