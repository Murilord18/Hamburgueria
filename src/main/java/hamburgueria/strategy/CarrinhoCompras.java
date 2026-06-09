package hamburgueria.strategy;

public class CarrinhoCompras {

    private double valorTotal;
    private DescontoStrategy descontoStrategy;

    public CarrinhoCompras(double valorTotal) {
        this.valorTotal = valorTotal;
        this.descontoStrategy = new SemDesconto();
    }

    public void setDescontoStrategy(DescontoStrategy strategy) {
        this.descontoStrategy = strategy;
    }

    public double calcularTotal() {
        double desconto = descontoStrategy.calcularDesconto(valorTotal);
        return valorTotal - desconto;
    }

    public double getDesconto() {
        return descontoStrategy.calcularDesconto(valorTotal);
    }

    public String getDescricaoDesconto() {
        return descontoStrategy.getDescricao();
    }

    public double getValorTotal() {
        return valorTotal;
    }
}
