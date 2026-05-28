package Hamburgueria;

import hamburgueria.factory.ComboPremiumFactory;
import hamburgueria.factory.ComboTradicionalFactory;
import hamburgueria.factory.LancheFactory;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class AbstractFactoryTest {

    @Test
    public void testComboTradicionalLanche() {
        LancheFactory factory = new ComboTradicionalFactory();
        assertEquals("X-Burguer", factory.criarLanche().getNome());
    }

    @Test
    public void testComboTradicionalAcompanhamento() {
        LancheFactory factory = new ComboTradicionalFactory();
        assertEquals("Batata Frita P", factory.criarAcompanhamento().getNome());
    }

    @Test
    public void testComboPremiumLanche() {
        LancheFactory factory = new ComboPremiumFactory();
        assertEquals("X-Bacon Duplo", factory.criarLanche().getNome());
    }

    @Test
    public void testComboPremiumAcompanhamento() {
        LancheFactory factory = new ComboPremiumFactory();
        assertEquals("Batata Frita G + Onion Rings", factory.criarAcompanhamento().getNome());
    }
}
