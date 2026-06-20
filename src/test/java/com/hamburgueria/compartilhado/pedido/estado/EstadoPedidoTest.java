package com.hamburgueria.compartilhado.pedido.estado;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EstadoPedidoTest {

    @Test
    public void recebidoAvancaParaEmPreparo() {
        assertEquals("EM_PREPARO", new EstadoRecebido().avancar().nome());
    }

    @Test
    public void emPreparoAvancaParaPronto() {
        assertEquals("PRONTO", new EstadoEmPreparo().avancar().nome());
    }

    @Test
    public void prontoAvancaParaEntregue() {
        assertEquals("ENTREGUE", new EstadoPronto().avancar().nome());
    }

    @Test
    public void entregueEhTerminal() {
        EstadoPedido entregue = new EstadoEntregue();
        assertEquals("ENTREGUE", entregue.avancar().nome());
    }

    @Test
    public void recebidoPodeCancelar() {
        assertTrue(new EstadoRecebido().podeCancelar());
    }

    @Test
    public void prontoNaoPodeCancelar() {
        assertFalse(new EstadoPronto().podeCancelar());
    }

    @Test
    public void canceladoEhTerminalENaoCancelaDeNovo() {
        EstadoPedido cancelado = new EstadoCancelado();
        assertEquals("CANCELADO", cancelado.avancar().nome());
    }
}
