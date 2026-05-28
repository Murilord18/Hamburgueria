package Hamburgueria;

import hamburgueria.factory.PedidoCreator;
import hamburgueria.model.Pedido;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FactoryMethodTest {
    @Test
    public void testCriarPedidoNomeLanche() {
        PedidoCreator creator = new PedidoCreator();
        assertEquals("X-Burguer", creator.criarPedido("X-Burguer").getLanche());
    }

    @Test
    public void testCriarPedidoStatusInicial() {
        PedidoCreator creator = new PedidoCreator();
        assertEquals(Pedido.Status.PEDIDO_FEITO, creator.criarPedido("X-Salada").getStatus());
    }

    @Test
    public void testCriarPedidoIdSequencial() {
        PedidoCreator creator = new PedidoCreator();
        Pedido p1 = creator.criarPedido("X-Burguer");
        Pedido p2 = creator.criarPedido("X-Bacon");
        assertEquals(p1.getId() + 1, p2.getId());
    }
}
