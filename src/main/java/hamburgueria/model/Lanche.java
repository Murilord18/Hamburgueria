package hamburgueria.model;

public class Lanche {

    private final String nome;
    private final double preco;
    public Lanche(String nome, double preco) { this.nome = nome; this.preco = preco; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public String toString() { return nome + " - R$" + preco; }
}
