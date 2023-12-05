package model;

public class Pedido {
    long id;
    Contato contato;
    Produto produto;
    int quantidade;
    double total;

    // Construtor
    public Pedido(Contato contato, Produto produto, int quantidade) {
        this.contato = contato;
        this.produto = produto;
        this.quantidade = quantidade;
        this.total = quantidade * produto.getPreco();
    }

    // Getters e Setters

    // Métodos de acesso para a tabela Pedidos
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pedido [id=" + id + ", contato=" + contato + ", produto=" + produto + ", quantidade=" + quantidade
                + ", total=" + total + "]";
    }
}
