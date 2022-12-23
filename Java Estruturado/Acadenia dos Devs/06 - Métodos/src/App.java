public class App {
    public static void main(String[] args) throws Exception {

        Televisao tv1 = new Televisao();
        tv1.marca = "Samsung";
        tv1.modelo = "XYZ01";
        tv1.numeroSerie = 521538;
        tv1.cor = "cinza";

        String filme1 = "Brasileirinhas - volume 02";

        // MÉTODOS SÂO CRIADOS DENTRO DA CLASSE ---------------
        tv1.ligar(); // chamando um método void...
        System.out.println(tv1.reproduzir(filme1)); // chamando um método com retorno e passando parametros

    }
}
