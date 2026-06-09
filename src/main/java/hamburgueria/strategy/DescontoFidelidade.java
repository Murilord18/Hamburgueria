package hamburgueria.strategy;

public class DescontoFidelidade implements DescontoStrategy {

    private static final double PERCENTUAL = 0.15;

    @Override
    public double calcularDesconto(double valorTotal) {
        return valorTotal * PERCENTUAL;
    }

    @Override
    public String getDescricao() {
        return "Desconto fidelidade (15%)";
    }
}

