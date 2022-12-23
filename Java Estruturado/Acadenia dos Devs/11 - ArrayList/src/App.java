import java.util.ArrayList;

import classes.*;

public class App {
    public static void main(String[] args) throws Exception {

        // ------------------------- CRIANDO UM ARRAYLIST ---------------------------

        ArrayList<String> filmes = new ArrayList<String>();

        // --------------------------- PASSANDO VALORES -----------------------------

        // ------------------------------ 1ª OPÇÃO ----------------------------------
        filmes.add("Jurassic Park");
        filmes.add("Last Flying Flag");
        filmes.add("Interestellar");
        filmes.remove(2);
        filmes.clear();

        // Imprimindo
  
        for (int i = 0; i < filmes.size(); i++) {
            System.out.println(filmes.get(i));
        }

        // ------------------------------ 2ª OPÇÃO ---------------------------------
        
        Pessoa pessoa1 = new Pessoa();
        Pessoa pessoa2 = new Pessoa();
        
        ArrayList<Pessoa> vetPessoas1 = new ArrayList<Pessoa>();
        vetPessoas1.add(pessoa1);
        vetPessoas1.add(pessoa2);
        
        // ------------------------------ 3ª OPÇÃO ---------------------------------
        
        ArrayList<Pessoa> vetPessoas2 = new ArrayList<Pessoa>();
        vetPessoas2.add(new Pessoa());
        vetPessoas2.add(new Pessoa());

    }
}
