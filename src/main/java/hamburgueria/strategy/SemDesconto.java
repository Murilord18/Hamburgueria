package hamburgueria.strategy;

public class SemDesconto implements DescontoStrategy {

    @Override
    public double calcularDesconto(double valorTotal) {
        return 0.0;
    }

    @Override
    public String getDescricao() {
        return "Sem desconto";
    }
}
