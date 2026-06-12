package hamburgueria.strategy;

public class DescontoCupom implements DescontoStrategy {

    private static final double PERCENTUAL = 0.20;

    @Override
    public double calcularDesconto(double valorTotal) {
        return valorTotal * PERCENTUAL;
    }

    @Override
    public String getDescricao() {
        return "Desconto promocao (20%)";
    }
}
