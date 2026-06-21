package com.hamburgueria.compartilhado.pedido.memento;

import java.math.BigDecimal;

import com.hamburgueria.compartilhado.lanche.LancheBuilder;
import com.hamburgueria.compartilhado.pedido.ItemPedido;
import com.hamburgueria.compartilhado.pedido.Pedido;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HistoricoPedidoTest {

    private Pedido pedido;
    private HistoricoPedido historico;

    @Before
    public void preparar() {
        pedido = new Pedido("P1");
        pedido.adicionarItem(new ItemPedido(
                new LancheBuilder().comPrecoBase(new BigDecimal("10.00")).construir(), 1));
        historico = new HistoricoPedido();
    }

    @Test
    public void restauraEstadoAnterior() {
        historico.salvar(pedido.salvar());
        pedido.avancarEstado();
        pedido.restaurar(historico.desfazer());
        assertEquals("RECEBIDO", pedido.getEstado().nome());
    }

    @Test
    public void restauraItens() {
        PedidoMemento snap = pedido.salvar();
        pedido.adicionarItem(new ItemPedido(
                new LancheBuilder().comPrecoBase(new BigDecimal("20.00")).construir(), 1));
        pedido.restaurar(snap);
        assertEquals(1, pedido.quantidadeItens());
    }

    @Test
    public void historicoControlaTamanho() {
        historico.salvar(pedido.salvar());
        historico.salvar(pedido.salvar());
        assertEquals(2, historico.tamanho());
    }

    @Test
    public void historicoVazioInicialmente() {
        assertFalse(historico.temHistorico());
    }

    @Test
    public void historicoComItemPossuiHistorico() {
        historico.salvar(pedido.salvar());
        assertTrue(historico.temHistorico());
    }
}
