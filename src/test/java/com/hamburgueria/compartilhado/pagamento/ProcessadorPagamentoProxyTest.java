package com.hamburgueria.compartilhado.pagamento;

import java.math.BigDecimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProcessadorPagamentoProxyTest {

    private static final BigDecimal LIMITE = new BigDecimal("100.00");

    @Test
    public void abaixoDoLimiteDelegaAoReal() {
        ProcessadorPagamento proxy = new ProcessadorPagamentoProxy(new ProcessadorCartao(), LIMITE);
        assertTrue(proxy.processar(new BigDecimal("50.00")).isAprovado());
    }

    @Test
    public void acimaDoLimiteRecusa() {
        ProcessadorPagamento proxy = new ProcessadorPagamentoProxy(new ProcessadorCartao(), LIMITE);
        assertFalse(proxy.processar(new BigDecimal("200.00")).isAprovado());
    }

    @Test
    public void recusaTrazMotivo() {
        ProcessadorPagamento proxy = new ProcessadorPagamentoProxy(new ProcessadorCartao(), LIMITE);
        assertEquals("recusado-acima-do-limite", proxy.processar(new BigDecimal("200.00")).getDetalhe());
    }
}
