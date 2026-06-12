package hamburgueria;

import hamburgueria.strategy.CarrinhoCompras;
import hamburgueria.strategy.DescontoFidelidade;
import hamburgueria.strategy.DescontoCupom;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StrategyTest {

    private static final double DELTA = 0.001;

    @Test
    public void testSemDesconto() {
        CarrinhoCompras carrinho = new CarrinhoCompras(50.0);
        assertEquals(50.0, carrinho.calcularTotal(), DELTA);
    }



    @Test
    public void testDescontoFidelidade15Porcento() {
        CarrinhoCompras carrinho = new CarrinhoCompras(100.0);
        carrinho.setDescontoStrategy(new DescontoFidelidade());
        assertEquals(85.0, carrinho.calcularTotal(), DELTA);
    }

    @Test
    public void testDescontoPromocao20Porcento() {
        CarrinhoCompras carrinho = new CarrinhoCompras(100.0);
        carrinho.setDescontoStrategy(new DescontoCupom());
        assertEquals(80.0, carrinho.calcularTotal(), DELTA);
    }

    @Test
    public void testTrocarEstrategiaEmTempoDeExecucao() {
        CarrinhoCompras carrinho = new CarrinhoCompras(200.0);

        carrinho.setDescontoStrategy(new DescontoFidelidade());
        assertEquals(170.0, carrinho.calcularTotal(), DELTA);

        carrinho.setDescontoStrategy(new DescontoCupom());
        assertEquals(160.0, carrinho.calcularTotal(), DELTA);
    }



    @Test
    public void testDescricaoSemDesconto() {
        CarrinhoCompras carrinho = new CarrinhoCompras(50.0);
        assertEquals("Sem desconto", carrinho.getDescricaoDesconto());
    }



    @Test
    public void testDescricaoDescontoFidelidade() {
        CarrinhoCompras carrinho = new CarrinhoCompras(50.0);
        carrinho.setDescontoStrategy(new DescontoFidelidade());
        assertEquals("Desconto fidelidade (15%)", carrinho.getDescricaoDesconto());
    }

    @Test
    public void testDescricaoDescontoPromocao() {
        CarrinhoCompras carrinho = new CarrinhoCompras(50.0);
        carrinho.setDescontoStrategy(new DescontoCupom());
        assertEquals("Desconto promocao (20%)", carrinho.getDescricaoDesconto());
    }
}
