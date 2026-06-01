package hamburgueria;

import hamburgueria.decorator.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DecoratorTest {

    //  Bases sem adicionais

    @Test
    public void testXBurguerSemAdicionais() {
        LancheBase lanche = new XBurguer();
        assertEquals("X-Burguer", lanche.getDescricao());
        assertEquals(18.90, lanche.getPreco(), 0.01);
    }

    @Test
    public void testXBaconSemAdicionais() {
        LancheBase lanche = new XBacon();
        assertEquals("X-Bacon", lanche.getDescricao());
        assertEquals(24.90, lanche.getPreco(), 0.01);
    }

    @Test
    public void testXSaladaSemAdicionais() {
        LancheBase lanche = new XSalada();
        assertEquals("X-Salada", lanche.getDescricao());
        assertEquals(22.00, lanche.getPreco(), 0.01);
    }

    @Test
    public void testXBaconDuploSemAdicionais() {
        LancheBase lanche = new XBaconDuplo();
        assertEquals("X-Bacon Duplo", lanche.getDescricao());
        assertEquals(32.90, lanche.getPreco(), 0.01);
    }

    //  XBurguer com um adicional cada

    @Test
    public void testXBurguerComQueijo() {
        LancheBase lanche = new QueijoExtra(new XBurguer());
        assertEquals("X-Burguer + Queijo", lanche.getDescricao());
        assertEquals(21.40, lanche.getPreco(), 0.01);
    }

    @Test
    public void testXBurguerComBaconExtra() {
        LancheBase lanche = new BaconExtra(new XBurguer());
        assertEquals("X-Burguer + Bacon Extra", lanche.getDescricao());
        assertEquals(22.90, lanche.getPreco(), 0.01);
    }

    @Test
    public void testXBurguerComOvo() {
        LancheBase lanche = new OvoExtra(new XBurguer());
        assertEquals("X-Burguer + Ovo", lanche.getDescricao());
        assertEquals(20.90, lanche.getPreco(), 0.01);
    }

    @Test
    public void testXBurguerComCebolaCaramelizada() {
        LancheBase lanche = new CebolaCaramelizadaExtra(new XBurguer());
        assertEquals("X-Burguer + Cebola Caramelizada", lanche.getDescricao());
        assertEquals(21.90, lanche.getPreco(), 0.01);
    }

    //  XBacon com um adicional cada

    @Test
    public void testXBaconComQueijo() {
        LancheBase lanche = new QueijoExtra(new XBacon());
        assertEquals("X-Bacon + Queijo", lanche.getDescricao());
        assertEquals(27.40, lanche.getPreco(), 0.01);
    }

    @Test
    public void testXBaconComBaconExtra() {
        LancheBase lanche = new BaconExtra(new XBacon());
        assertEquals("X-Bacon + Bacon Extra", lanche.getDescricao());
        assertEquals(28.90, lanche.getPreco(), 0.01);
    }

    //  XBaconDuplo com adicionais

    @Test
    public void testXBaconDuploComQueijo() {
        LancheBase lanche = new QueijoExtra(new XBaconDuplo());
        assertEquals("X-Bacon Duplo + Queijo", lanche.getDescricao());
        assertEquals(35.40, lanche.getPreco(), 0.01);
    }

    @Test
    public void testXBaconDuploComBaconExtra() {
        LancheBase lanche = new BaconExtra(new XBaconDuplo());
        assertEquals("X-Bacon Duplo + Bacon Extra", lanche.getDescricao());
        assertEquals(36.90, lanche.getPreco(), 0.01);
    }

    @Test
    public void testXBaconDuploComVariosAdicionais() {
        LancheBase lanche = new CebolaCaramelizadaExtra(new QueijoExtra(new BaconExtra(new XBaconDuplo())));
        assertEquals("X-Bacon Duplo + Bacon Extra + Queijo + Cebola Caramelizada", lanche.getDescricao());
        assertEquals(42.40, lanche.getPreco(), 0.01);
    }

    //  Combinações múltiplas

    @Test
    public void testXBaconComVariosAdicionais() {
        LancheBase lanche = new CebolaCaramelizadaExtra(new QueijoExtra(new OvoExtra(new XBacon())));
        assertEquals("X-Bacon + Ovo + Queijo + Cebola Caramelizada", lanche.getDescricao());
        assertEquals(32.40, lanche.getPreco(), 0.01);
    }

    @Test
    public void testXBurguerComDoisQueijos() {
        LancheBase lanche = new QueijoExtra(new QueijoExtra(new XBurguer()));
        assertEquals("X-Burguer + Queijo + Queijo", lanche.getDescricao());
        assertEquals(23.90, lanche.getPreco(), 0.01);
    }

    @Test
    public void testXBurguerComTodosAdicionais() {
        LancheBase lanche = new CebolaCaramelizadaExtra(new QueijoExtra(new BaconExtra(new OvoExtra(new XBurguer()))));
        assertEquals("X-Burguer + Ovo + Bacon Extra + Queijo + Cebola Caramelizada", lanche.getDescricao());
        assertEquals(30.40, lanche.getPreco(), 0.01);
    }

    @Test
    public void testXSaladaComOvoEQueijo() {
        LancheBase lanche = new QueijoExtra(new OvoExtra(new XSalada()));
        assertEquals("X-Salada + Ovo + Queijo", lanche.getDescricao());
        assertEquals(26.50, lanche.getPreco(), 0.01);
    }
}