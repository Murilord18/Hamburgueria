package hamburgueria.decorator;

public class CebolaCaramelizadaExtra extends IngredienteDecorator {

    public CebolaCaramelizadaExtra(LancheBase lancheDecorado) {
        super(lancheDecorado);
    }

    @Override
    public String getDescricao() {
        return lancheDecorado.getDescricao() + " + Cebola Caramelizada"; }

    @Override
    public double getPreco() {
        return lancheDecorado.getPreco() + 3.00; }
}
