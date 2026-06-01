package hamburgueria.decorator;

public class QueijoExtra extends IngredienteDecorator {

    public QueijoExtra(LancheBase lancheDecorado) {
        super(lancheDecorado);
    }

    @Override
    public String getDescricao() { return lancheDecorado.getDescricao() + " + Queijo"; }

    @Override
    public double getPreco() { return lancheDecorado.getPreco() + 2.50; }
}
