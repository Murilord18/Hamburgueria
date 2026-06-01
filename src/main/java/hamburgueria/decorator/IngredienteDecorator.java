package hamburgueria.decorator;

public abstract class IngredienteDecorator implements LancheBase {
    protected final LancheBase lancheDecorado;

    public IngredienteDecorator(LancheBase lancheDecorado) {
        this.lancheDecorado = lancheDecorado;
    }

    @Override
    public String getDescricao() {
        return lancheDecorado.getDescricao(); }

    @Override
    public double getPreco() {
        return lancheDecorado.getPreco(); }
}


