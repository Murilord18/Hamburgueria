package hamburgueria.decorator;

public class XBacon implements LancheBase {
    @Override
    public String getDescricao() { return "X-Bacon"; }

    @Override
    public double getPreco() { return 24.90; }
}