package hamburgueria.decorator;

public class XBurguer implements LancheBase {
    @Override
    public String getDescricao() { return "X-Burguer"; }

    @Override
    public double getPreco() { return 18.90; }
}