public class App {
    public static void main(String[] args) throws Exception {

        Video videos[] = new Video[3];
        videos[0] = new Video("Aula 1 de POO");
        videos[1] = new Video("Aula 12 de PHP");
        videos[2] = new Video("Aula 10 de HTML5");

        Gafanhoto gafanhotos[] = new Gafanhoto[2];

        gafanhotos[0] = new Gafanhoto("Khaue", 33, "Masculino", "Kau");
        gafanhotos[1] = new Gafanhoto("Felipe", 28, "Feminino", "Lipe");  


        System.out.println(videos[0].toString());
        System.out.println(gafanhotos[1].toString());

        Visualizacao visualizacao [] = new Visualizacao[5];

        visualizacao[0] = new Visualizacao(gafanhotos[0], videos[0]);
        visualizacao[0].avaliar();
        System.out.println(visualizacao[0].toString());

        visualizacao[1] = new Visualizacao(gafanhotos[0], videos[1]);
        visualizacao[0].avaliar();
        System.out.println(visualizacao[1].toString());
        
    }   
}
