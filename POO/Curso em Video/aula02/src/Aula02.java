import javax.net.ssl.Status;

public class Aula02 {
    public static void main(String[] args) throws Exception {

        Caneta c1 = new Caneta();
        c1.cor = "Azul";
        c1.ponta = 0.5f;
        c1.modelo = "BIC";
        c1.carga = 95;
        c1.tampar();
        c1.destampar();
        
        c1.status();
        c1.rabiscar();
        
        Caneta c2 = new Caneta();
        c2.cor = "Preta";
        c2.ponta = 0.7f;
        c2.modelo = "Hostnet";
        c2.carga = 80;
        c2.tampar();
        
        c2.status();
        c2.rabiscar();




    }
}
