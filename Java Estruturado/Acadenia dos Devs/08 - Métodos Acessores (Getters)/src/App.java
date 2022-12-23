import classes.*;

public class App {
    public static void main(String[] args) throws Exception {

        Mesa mesa = new Mesa();

        System.out.println("Existem " + mesa.getLivros() + " livros na estante"); // informa a quantidade de livros
    }
}
