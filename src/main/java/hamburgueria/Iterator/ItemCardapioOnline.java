package hamburgueria.Iterator;

public class ItemCardapioOnline {

    private String nome;
    private double preco;
    private String categoria;    // "LANCHE", "ACOMPANHAMENTO", "ADICIONAL"
    private int totalPedidos;    // quantidade de vezes que o item foi pedido

    public ItemCardapioOnline(String nome, double preco, String categoria, int totalPedidos) {
        this.nome          = nome;
        this.preco         = preco;
        this.categoria     = categoria;
        this.totalPedidos  = totalPedidos;
    }

    public String getNome()        {
        return nome; }

    public double getPreco()       {
        return preco; }

    public String getCategoria()   {
        return categoria; }

    public int getTotalPedidos()   {
        return totalPedidos; }

    public void setNome(String nome) {
        this.nome = nome; }

    public void setPreco(double preco) {
        this.preco = preco; }

    public void setCategoria(String categoria) {
        this.categoria = categoria; }

    public void setTotalPedidos(int totalPedidos) {
        this.totalPedidos = totalPedidos; }

    @Override
    public String toString() {
        return nome + " [" + categoria + "] - R$" + String.format("%.2f", preco)
                + " | pedidos: " + totalPedidos;
    }
}

