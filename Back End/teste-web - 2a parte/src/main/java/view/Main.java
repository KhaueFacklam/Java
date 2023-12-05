package view;
import java.sql.SQLException;
import java.util.Scanner;

import model.Contato;
import persist.ContatoDAO;

public class Main {
    public static void main(String[] args) throws SQLException {

        ContatoDAO cdao = new ContatoDAO();
        Scanner scanner = new Scanner(System.in); // Abre a entrada padrão
        

        // LISTANDO OS CONTATOS
        System.out.println("Listando os Contatos:");
        for (Contato c : cdao.listar()) {
            System.out.println(c);
        }

        

        // COLETANDO UM NOVO CONTATO PARA INSERIR
        System.out.println("Informe um novo contato");
        Contato c = new Contato();
        System.out.println("Nome:");
        c.setNome(scanner.nextLine()); // lendo o nome
        System.out.println("Email:");
        c.setEmail(scanner.nextLine());
        System.out.println("Endereço:");
        c.setEndereco(scanner.nextLine());

        cdao.adicionar(c); // enviando o contato criado

        // ALTERANDO UM CONTATO
        System.out.println("Informe o id do contato a alterar:");
        int id = scanner.nextInt(); // lendo o id
        Contato c2 = cdao.getContato(id); // enviando e recebendo o contato pelo id
        System.out.println("O dado selecionado foi:");
        System.out.println(c2.getNome()); // mostrando o contato escolhido
        System.out.println("Informe o novo nome:");
        scanner.nextLine(); // apenas para limpar o buffer
        c2.setNome(scanner.nextLine()); // lendo o nome
        System.out.println("Os novos dados são:");
        System.out.println(c2); // mostrando o nome atualizado
        cdao.alterar(c2);
        System.out.println("Listando os Contatos:"); // conferindo todos os contatos novamente
        for (Contato contato : cdao.listar()) {
            System.out.println(c);
        }

        // EXCLUINDO UM CONTATO
        System.out.println("Informe o id do contato a alterar:");
        id = scanner.nextInt(); // lendo o id
        c2 = cdao.getContato(id);
        System.out.println("Contato excluido:");
        System.out.println(c2.getNome()); // mostrando o contato escolhido
        cdao.remover(c2);
        for (Contato contato : cdao.listar()) {
            System.out.println(c);
        }

        scanner.close(); // fecha a entrada padrao

    }
}
