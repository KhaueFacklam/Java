import classes.*;

public class App {
    public static void main(String[] args) throws Exception {
        Integer livros = 15;

        Mesa mesa = new Mesa();

        mesa.setLivros(livros); // adciona livros novos a mesa

        System.out.println("Existem " + mesa.getLivros() + " livros na estante"); // informa a quantidade de livros
    }
}
