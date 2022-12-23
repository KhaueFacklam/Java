public class Televisao {
    String marca;
    String modelo;
    Integer numeroSerie;
    String cor;

    // MÉTODO (os nomes começam em minúsculo) --------------------------
    void ligar() {
        System.out.println("Sua TV " + marca + " LIGOU");
    }

    String reproduzir(String filme){
        return "Sua TV " + marca + " tá reproduzindo o filme " + filme;

    }


}
