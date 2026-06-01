package hamburgueria;

import hamburgueria.state.PedidoContext;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StateTest {

    @Test
    public void testEstadoInicialPedidoFeito() {
        PedidoContext ctx = new PedidoContext("X-Burguer");
        assertEquals("Pedido Feito", ctx.getEstadoAtual());
    }

    @Test
    public void testTransicaoParaPreparando() {
        PedidoContext ctx = new PedidoContext("X-Burguer");
        ctx.preparar();
        assertEquals("Preparando Pedido", ctx.getEstadoAtual());
    }

    @Test
    public void testTransicaoParaConcluido() {
        PedidoContext ctx = new PedidoContext("X-Burguer");
        ctx.preparar();
        ctx.concluir();
        assertEquals("Pedido Concluido", ctx.getEstadoAtual());
    }

    @Test
    public void testTransicaoParaACaminho() {
        PedidoContext ctx = new PedidoContext("X-Burguer");
        ctx.preparar();
        ctx.concluir();
        ctx.enviar();
        assertEquals("Pedido a Caminho", ctx.getEstadoAtual());
    }

    @Test
    public void testTransicaoParaCancelado() {
        PedidoContext ctx = new PedidoContext("X-Salada");
        ctx.cancelar();
        assertEquals("Pedido Cancelado", ctx.getEstadoAtual());
    }

    @Test
    public void testAcaoInvalidaNaoMudaEstado() {
        PedidoContext ctx = new PedidoContext("X-Bacon");
        ctx.cancelar();
        ctx.preparar();
        assertEquals("Pedido Cancelado", ctx.getEstadoAtual());
    }
}
