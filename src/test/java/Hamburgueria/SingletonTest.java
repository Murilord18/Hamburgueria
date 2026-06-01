package Hamburgueria;

import hamburgueria.singleton.Cardapio;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SingletonTest {

    @Test
    public void testMesmaInstancia() {
        Cardapio c1 = Cardapio.getInstancia();
        Cardapio c2 = Cardapio.getInstancia();
        assertEquals(c1, c2);
    }

    @Test
    public void testTamanhoInicialCardapio() {
        assertEquals(3, Cardapio.getInstancia().getLanches().size());
    }
}