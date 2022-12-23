public class Caneta {
    public String modelo;
    public String cor;
    private float ponta;
    protected int carga;
    protected boolean tampada;

    public void status() {
        System.out.println("Cor: " + this.cor);
        System.out.println("Modelo " + this.modelo);
        System.out.println("Ponta: " + this.ponta);
        System.out.println("Carga: " + this.carga + "%");
        System.out.println("Tampada? " + this.tampada);
    }

    public void rabiscar() {
        if (tampada == true) {
            System.out.println("Erro! A caneta está tampada");
        } else {
            System.out.println("Estou rabiscando!");
        }

    }

    public void tampar() {
        this.tampada = true;
    }

    public void destampar() {
        this.tampada = false;
    }

}
