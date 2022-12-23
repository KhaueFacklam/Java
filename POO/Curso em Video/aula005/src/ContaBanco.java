public class ContaBanco {

    public Integer numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    public void abrirConta(String tipo) {
        this.setTipo(tipo);
        this.setStatus(true);

        if (this.getTipo() == "CC") {
            this.setSaldo(50);
        } else if (this.getTipo() == "CP") {
            this.setSaldo(150);
        }
        System.out.println("Conta aberta");
    }

    public void fecharConta() {
        if (this.getSaldo() > 0) {
            System.out.println("ERRO! Você possui saldo: " + this.getSaldo());
        } else if (this.getSaldo() < 0) {
            System.out.println("ERRO! Conta em débito: " + this.getSaldo());
        } else {
            System.out.println("Conta encerrada.");
        }

    }

    public void depositar(float valor) {
        if (this.getStatus() == false) {
            System.out.println("Conta não existe");
        } else {
            this.setSaldo(this.getSaldo() + valor);
            System.out.println("Valor de " + valor + " depositado. Saldo atual: " + this.getSaldo());
        }
    }

    public void sacar(float valor) {
        if (this.getStatus() == false) {
            System.out.println("Conta não existe");
        } else {
            if (this.getSaldo() >= valor) {
                this.setSaldo(this.getSaldo() - valor);
                System.out.println(
                        "Saque de " + valor + " realizado na conta de " + getDono() + ". Saldo atual: " + getSaldo());
            } else {
                System.out.println("Saldo insuficiente");
            }
        }
    }

    public void pagarMensal() {
        int v = 0;

        if (this.getTipo() == "CC") {
            v = 12;
        } else if (this.getTipo() == "CP") {
            v = 20;
        }

        if (this.getStatus() == true) {
            this.setSaldo(this.getSaldo() - v);
            System.out.println("Sua mensalidade no valor de " + v + " foi paga.");
        } else {
            System.out.println("Impossivel pagar uma conta que não foi aberta.");
        }
    }

    public ContaBanco() {
        this.setSaldo(0);
        this.setStatus(false);
    }

    public Integer getNumConta() {
        return numConta;
    }

    public void setNumConta(Integer numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
