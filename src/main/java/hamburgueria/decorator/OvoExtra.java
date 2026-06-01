package hamburgueria.decorator;

public class OvoExtra extends IngredienteDecorator {

    public OvoExtra(LancheBase lancheDecorado) {
        super(lancheDecorado);
    }

    @Override
    public String getDescricao() {
        return lancheDecorado.getDescricao() + " + Ovo"; }

    @Override
    public double getPreco() {
        return lancheDecorado.getPreco() + 2.00; }
}
