import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner leitor = new Scanner(System.in); // CRIANDO o leitor

        System.out.println("Informe sua idade:"); // PEDINDO

        String valor = leitor.nextLine(); // GUARDANDO

        int idade = Integer.parseInt(valor); // CONVERTENDO
                // Float.parseFloat();
                // Double.parseDouble();

        System.out.println("Tenho " + idade + " anos!"); // IMPRIMINDO
        System.out.format("Tenho %s anos!\n", idade); // IMPRIMINDO no estilo C

    }
}
