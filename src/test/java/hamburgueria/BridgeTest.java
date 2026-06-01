package hamburgueria;

import hamburgueria.bridge.EntregaMotoboy;
import hamburgueria.bridge.EntregaRetirada;
import hamburgueria.bridge.PedidoAgendado;
import hamburgueria.bridge.PedidoImediato;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BridgeTest {

    @Test
    public void testPedidoImediatoMotoboy() {
        PedidoImediato pedido = new PedidoImediato(new EntregaMotoboy(), "Rua A, 123");
        assertEquals("[IMEDIATO] Motoboy a caminho para: Rua A, 123", pedido.enviar());
    }

    @Test
    public void testPedidoImediatoRetirada() {
        PedidoImediato pedido = new PedidoImediato(new EntregaRetirada(), "Loja Centro");
        assertEquals("[IMEDIATO] Pedido disponivel para retirada em: Loja Centro", pedido.enviar());
    }

    @Test
    public void testPedidoAgendadoMotoboy() {
        PedidoAgendado pedido = new PedidoAgendado(new EntregaMotoboy(), "Rua B, 456", "19:30");
        assertEquals("[AGENDADO 19:30] Motoboy a caminho para: Rua B, 456", pedido.enviar());
    }

    @Test
    public void testPedidoAgendadoRetirada() {
        PedidoAgendado pedido = new PedidoAgendado(new EntregaRetirada(), "Loja Norte", "12:00");
        assertEquals("[AGENDADO 12:00] Pedido disponivel para retirada em: Loja Norte", pedido.enviar());
    }
}
