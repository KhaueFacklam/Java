public class Bolsista extends Aluno {
    private int bolsa;

    public void renovarBolsa() {
        System.out.println("Bolsa de " + this.getNome() + " renovada com sucesso");
    }

    @Override
    public void pagarMensalidade() {
        System.out.println(this.getNome() + " é bolsista! Pagamento facilitado.");
    }

    // ================ Getters e Setters ================

    public int getBolsa() {
        return bolsa;
    }

    public void setBolsa(int bolsa) {
        this.bolsa = bolsa;
    }

}
