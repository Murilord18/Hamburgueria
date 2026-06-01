package hamburgueria.decorator;

public class BaconExtra extends IngredienteDecorator {

    public BaconExtra(LancheBase lancheDecorado) {
        super(lancheDecorado);
    }

    @Override
    public String getDescricao() { return lancheDecorado.getDescricao() + " + Bacon Extra"; }

    @Override
    public double getPreco() { return lancheDecorado.getPreco() + 4.00; }
}