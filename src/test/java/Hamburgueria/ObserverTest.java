package Hamburgueria;

import hamburgueria.model.Pedido;
import hamburgueria.observer.Cliente;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ObserverTest {

    @Test
    public void testNotificaStatusPreparando() {
        Pedido pedido = new Pedido(1, "X-Burguer");
        Cliente cliente = new Cliente("Joao");
        pedido.adicionarObserver(cliente);
        pedido.setStatus(Pedido.Status.PREPARANDO);
        assertEquals("Preparando pedido", cliente.getUltimaNotificacao());
    }

    @Test
    public void testNotificaStatusConcluido() {
        Pedido pedido = new Pedido(2, "X-Bacon");
        Cliente cliente = new Cliente("Maria");
        pedido.adicionarObserver(cliente);
        pedido.setStatus(Pedido.Status.PEDIDO_CONCLUIDO);
        assertEquals("Pedido concluido", cliente.getUltimaNotificacao());
    }

    @Test
    public void testNotificaStatusACaminho() {
        Pedido pedido = new Pedido(3, "X-Salada");
        Cliente cliente = new Cliente("Ana");
        pedido.adicionarObserver(cliente);
        pedido.setStatus(Pedido.Status.PEDIDO_A_CAMINHO);
        assertEquals("Pedido a caminho", cliente.getUltimaNotificacao());
    }

    @Test
    public void testObserverRemovidoNaoNotifica() {
        Pedido pedido = new Pedido(4, "X-Burguer");
        Cliente cliente = new Cliente("Carlos");
        pedido.adicionarObserver(cliente);
        pedido.removerObserver(cliente);
        pedido.setStatus(Pedido.Status.PREPARANDO);
        assertNull(cliente.getUltimaNotificacao());
    }
}
