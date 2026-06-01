package hamburgueria.decorator;

public class XSalada implements LancheBase{
    @Override
    public String getDescricao() { return "X-Salada"; }

    @Override
    public double getPreco() { return 22.00; }
}
