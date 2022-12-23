import classes.*;

public class App {
    public static void main(String[] args) throws Exception {

        Caneta caneta1 = new Caneta("Bic", 0.5, "Azul");

        System.out.println(caneta1.getCor() + caneta1.getModelo() + caneta1.getPonta() + caneta1.isTampada());

    }
}
