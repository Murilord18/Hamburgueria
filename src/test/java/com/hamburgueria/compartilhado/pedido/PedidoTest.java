package com.hamburgueria.compartilhado.pedido;

import java.math.BigDecimal;

import com.hamburgueria.compartilhado.lanche.LancheBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PedidoTest {

    private Pedido pedido;

    @Before
    public void preparar() {
        pedido = new Pedido("P1");
        pedido.adicionarItem(new ItemPedido(
                new LancheBuilder().comPrecoBase(new BigDecimal("10.00")).construir(), 1));
    }

    @Test
    public void estadoInicialEhRecebido() {
        assertEquals("RECEBIDO", pedido.getEstado().nome());
    }

    @Test
    public void avancarMudaEstado() {
        pedido.avancarEstado();
        assertEquals("EM_PREPARO", pedido.getEstado().nome());
    }

    @Test
    public void totalSomaItens() {
        pedido.adicionarItem(new ItemPedido(
                new LancheBuilder().comPrecoBase(new BigDecimal("5.00")).construir(), 2));
        assertEquals(new BigDecimal("20.00"), pedido.total());
    }

    @Test
    public void cancelarMudaParaCancelado() {
        pedido.cancelar();
        assertEquals("CANCELADO", pedido.getEstado().nome());
    }

    @Test(expected = IllegalStateException.class)
    public void naoCancelaQuandoPronto() {
        pedido.avancarEstado();
        pedido.avancarEstado();
        pedido.cancelar();
    }

    @Test
    public void registraObservador() {
        pedido.registrar(p -> { });
        assertEquals(1, pedido.quantidadeObservadores());
    }

    @Test
    public void removeObservador() {
        com.hamburgueria.compartilhado.notificacao.ObservadorPedido obs = p -> { };
        pedido.registrar(obs);
        pedido.remover(obs);
        assertEquals(0, pedido.quantidadeObservadores());
    }
}
