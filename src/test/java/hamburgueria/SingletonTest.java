package hamburgueria;

import hamburgueria.model.Lanche;
import hamburgueria.singleton.Cardapio;
import org.junit.Test;
import static org.junit.Assert.*;

public class SingletonTest {


    //  Singleton


    @Test
    public void testMesmaInstancia() {
        Cardapio c1 = Cardapio.getInstancia();
        Cardapio c2 = Cardapio.getInstancia();
        assertSame(c1, c2);
    }


    //  Lanches


    @Test
    public void testQuantidadeInicialLanches() {
        assertEquals(4, Cardapio.getInstancia().getLanches().size());
    }

    @Test
    public void testCardapioPossuiXBurguer() {
        assertTrue(contemNome(Cardapio.getInstancia().getLanches(), "X-Burguer"));
    }

    @Test
    public void testCardapioPossuiXBacon() {
        assertTrue(contemNome(Cardapio.getInstancia().getLanches(), "X-Bacon"));
    }

    @Test
    public void testCardapioPossuiXSalada() {
        assertTrue(contemNome(Cardapio.getInstancia().getLanches(), "X-Salada"));
    }

    @Test
    public void testCardapioPossuiXBaconDuplo() {
        assertTrue(contemNome(Cardapio.getInstancia().getLanches(), "X-Bacon Duplo"));
    }

    @Test
    public void testPrecoXBurguer() {
        assertEquals(18.90, getPreco(Cardapio.getInstancia().getLanches(), "X-Burguer"), 0.01);
    }

    @Test
    public void testPrecoXBacon() {
        assertEquals(24.90, getPreco(Cardapio.getInstancia().getLanches(), "X-Bacon"), 0.01);
    }

    @Test
    public void testPrecoXSalada() {
        assertEquals(22.00, getPreco(Cardapio.getInstancia().getLanches(), "X-Salada"), 0.01);
    }

    @Test
    public void testPrecoXBaconDuplo() {
        assertEquals(32.90, getPreco(Cardapio.getInstancia().getLanches(), "X-Bacon Duplo"), 0.01);
    }


    //  Acompanhamentos


    @Test
    public void testQuantidadeInicialAcompanhamentos() {
        assertEquals(3, Cardapio.getInstancia().getAcompanhamentos().size());
    }

    @Test
    public void testCardapioPossuiBatataPequena() {
        assertTrue(contemNome(Cardapio.getInstancia().getAcompanhamentos(), "Batata Frita P"));
    }

    @Test
    public void testCardapioPossuiBatataGrande() {
        assertTrue(contemNome(Cardapio.getInstancia().getAcompanhamentos(), "Batata Frita G"));
    }

    @Test
    public void testCardapioPossuiOnionRings() {
        assertTrue(contemNome(Cardapio.getInstancia().getAcompanhamentos(), "Onion Rings"));
    }

    @Test
    public void testPrecoBatataPequena() {
        assertEquals(8.00, getPreco(Cardapio.getInstancia().getAcompanhamentos(), "Batata Frita P"), 0.01);
    }

    @Test
    public void testPrecoBatataGrande() {
        assertEquals(12.00, getPreco(Cardapio.getInstancia().getAcompanhamentos(), "Batata Frita G"), 0.01);
    }

    @Test
    public void testPrecoOnionRings() {
        assertEquals(10.00, getPreco(Cardapio.getInstancia().getAcompanhamentos(), "Onion Rings"), 0.01);
    }


    //  Adicionais (Decorator)


    @Test
    public void testQuantidadeInicialAdicionais() {
        assertEquals(4, Cardapio.getInstancia().getAdicionais().size());
    }

    @Test
    public void testCardapioPossuiAdicionalQueijo() {
        assertTrue(contemNome(Cardapio.getInstancia().getAdicionais(), "+ Queijo"));
    }

    @Test
    public void testCardapioPossuiAdicionalBacon() {
        assertTrue(contemNome(Cardapio.getInstancia().getAdicionais(), "+ Bacon Extra"));
    }

    @Test
    public void testCardapioPossuiAdicionalOvo() {
        assertTrue(contemNome(Cardapio.getInstancia().getAdicionais(), "+ Ovo"));
    }

    @Test
    public void testCardapioPossuiAdicionalCebola() {
        assertTrue(contemNome(Cardapio.getInstancia().getAdicionais(), "+ Cebola Caramelizada"));
    }

    @Test
    public void testPrecoAdicionalQueijo() {
        assertEquals(2.50, getPreco(Cardapio.getInstancia().getAdicionais(), "+ Queijo"), 0.01);
    }

    @Test
    public void testPrecoAdicionalBacon() {
        assertEquals(4.00, getPreco(Cardapio.getInstancia().getAdicionais(), "+ Bacon Extra"), 0.01);
    }

    @Test
    public void testPrecoAdicionalOvo() {
        assertEquals(2.00, getPreco(Cardapio.getInstancia().getAdicionais(), "+ Ovo"), 0.01);
    }

    @Test
    public void testPrecoAdicionalCebola() {
        assertEquals(3.00, getPreco(Cardapio.getInstancia().getAdicionais(), "+ Cebola Caramelizada"), 0.01);
    }


    //  Adição dinâmica


    @Test
    public void testAdicionarLancheDinamicamente() {
        Cardapio cardapio = Cardapio.getInstancia();
        int antes = cardapio.getLanches().size();
        cardapio.adicionarLanche(new Lanche("X-Frango", 21.90));
        assertEquals(antes + 1, cardapio.getLanches().size());
        assertTrue(contemNome(cardapio.getLanches(), "X-Frango"));
    }

    @Test
    public void testAdicionarAcompanhamentoDinamicamente() {
        Cardapio cardapio = Cardapio.getInstancia();
        int antes = cardapio.getAcompanhamentos().size();
        cardapio.adicionarAcompanhamento(new Lanche("Mandioca Frita", 9.00));
        assertEquals(antes + 1, cardapio.getAcompanhamentos().size());
        assertTrue(contemNome(cardapio.getAcompanhamentos(), "Mandioca Frita"));
    }

    @Test
    public void testAdicionarAdicionalDinamicamente() {
        Cardapio cardapio = Cardapio.getInstancia();
        int antes = cardapio.getAdicionais().size();
        cardapio.adicionarAdicional(new Lanche("+ Jalapeño", 1.50));
        assertEquals(antes + 1, cardapio.getAdicionais().size());
        assertTrue(contemNome(cardapio.getAdicionais(), "+ Jalapeño"));
    }


    //  Imutabilidade das listas expostas


    @Test(expected = UnsupportedOperationException.class)
    public void testListaLanchesImutavel() {
        Cardapio.getInstancia().getLanches().add(new Lanche("Teste", 0.0));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testListaAcompanhamentosImutavel() {
        Cardapio.getInstancia().getAcompanhamentos().add(new Lanche("Teste", 0.0));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testListaAdicionaisImutavel() {
        Cardapio.getInstancia().getAdicionais().add(new Lanche("Teste", 0.0));
    }


    //  Helpers


    private boolean contemNome(java.util.List<Lanche> lista, String nome) {
        return lista.stream().anyMatch(l -> l.getNome().equals(nome));
    }

    private double getPreco(java.util.List<Lanche> lista, String nome) {
        return lista.stream()
                .filter(l -> l.getNome().equals(nome))
                .mapToDouble(Lanche::getPreco)
                .findFirst()
                .orElse(-1.0);
    }
}
