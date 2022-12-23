public class ProjetoLivro {
    public static void main(String[] args) throws Exception {

        Pessoa[] pessoas = new Pessoa[2];
        pessoas[0] = new Pessoa("Khaue", 32, "M");
        pessoas[1] = new Pessoa("Goku", 38, "M");

        Livro[] livros = new Livro[2];
        livros[0] = new Livro("Dragon Ball", "Akira", 200, pessoas[0]);

        livros[0].abrir();
        livros[0].folhear(199);
        System.out.println(livros[0].detalhes());
        

    }
}