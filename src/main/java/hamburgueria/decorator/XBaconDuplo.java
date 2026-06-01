package hamburgueria.decorator;

public class XBaconDuplo implements LancheBase {
    @Override
    public String getDescricao() {
        return "X-Bacon Duplo"; }

    @Override
    public double getPreco() {
        return 32.90; }
}
