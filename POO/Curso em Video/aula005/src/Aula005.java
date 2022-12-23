public class Aula005 {
    public static void main(String[] args) throws Exception {

        ContaBanco c1 = new ContaBanco();
        c1.abrirConta("CC");
        c1.setDono("Khaue");
        c1.depositar(150);
        c1.sacar(10);
        c1.pagarMensal();
        c1.sacar(15);
        c1.fecharConta();


        
    }
}
