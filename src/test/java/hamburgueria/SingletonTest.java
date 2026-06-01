package hamburgueria;

import hamburgueria.singleton.Cardapio;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SingletonTest {

    //  Singleton — instância única

    @Test
    public void testMesmaInstancia() {
        Cardapio c1 = Cardapio.getInstancia();
        Cardapio c2 = Cardapio.getInstancia();
        assertEquals(c1, c2);
    }

    //  Lanches — quantidade e preços

    @Test
    public void testQuantidadeLanches() {
        assertEquals(4, Cardapio.getInstancia().getLanches().size());
    }

    @Test
    public void testPrecoXBurguer() {
        assertEquals(18.90, getPrecoLanche("X-Burguer"), 0.01);
    }

    @Test
    public void testPrecoXBacon() {
        assertEquals(24.90, getPrecoLanche("X-Bacon"), 0.01);
    }

    @Test
    public void testPrecoXSalada() {
        assertEquals(22.00, getPrecoLanche("X-Salada"), 0.01);
    }

    @Test
    public void testPrecoXBaconDuplo() {
        assertEquals(32.90, getPrecoLanche("X-Bacon Duplo"), 0.01);
    }

    //  Acompanhamentos — quantidade e preços

    @Test
    public void testQuantidadeAcompanhamentos() {
        assertEquals(3, Cardapio.getInstancia().getAcompanhamentos().size());
    }

    @Test
    public void testPrecoBatataPequena() {
        assertEquals(8.00, getPrecoAcompanhamento("Batata Frita P"), 0.01);
    }

    @Test
    public void testPrecoBatataGrande() {
        assertEquals(12.00, getPrecoAcompanhamento("Batata Frita G"), 0.01);
    }

    @Test
    public void testPrecoOnionRings() {
        assertEquals(10.00, getPrecoAcompanhamento("Onion Rings"), 0.01);
    }

    //  Adicionais — quantidade e preços

    @Test
    public void testQuantidadeAdicionais() {
        assertEquals(4, Cardapio.getInstancia().getAdicionais().size());
    }

    @Test
    public void testPrecoAdicionalQueijo() {
        assertEquals(2.50, getPrecoAdicional("+ Queijo"), 0.01);
    }

    @Test
    public void testPrecoAdicionalBaconExtra() {
        assertEquals(4.00, getPrecoAdicional("+ Bacon Extra"), 0.01);
    }

    @Test
    public void testPrecoAdicionalOvo() {
        assertEquals(2.00, getPrecoAdicional("+ Ovo"), 0.01);
    }

    @Test
    public void testPrecoAdicionalCebolaCaramelizada() {
        assertEquals(3.00, getPrecoAdicional("+ Cebola Caramelizada"), 0.01);
    }

    //  Helpers

    private double getPrecoLanche(String nome) {
        return Cardapio.getInstancia().getLanches().stream()
                .filter(l -> l.getNome().equals(nome))
                .mapToDouble(l -> l.getPreco())
                .findFirst()
                .orElse(-1.0);
    }

    private double getPrecoAcompanhamento(String nome) {
        return Cardapio.getInstancia().getAcompanhamentos().stream()
                .filter(l -> l.getNome().equals(nome))
                .mapToDouble(l -> l.getPreco())
                .findFirst()
                .orElse(-1.0);
    }

    private double getPrecoAdicional(String nome) {
        return Cardapio.getInstancia().getAdicionais().stream()
                .filter(l -> l.getNome().equals(nome))
                .mapToDouble(l -> l.getPreco())
                .findFirst()
                .orElse(-1.0);
    }
}