package com.hamburgueria.online.pagamento;

import java.math.BigDecimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SistemaPagamentoOnlineTest {

    private static final BigDecimal LIMITE = new BigDecimal("30.00");

    @Test
    public void cobraViaPixDentroDoLimite() {
        SistemaPagamentoOnline sistema = new SistemaPagamentoOnline(LIMITE);
        assertTrue(sistema.cobrar(new BigDecimal("20.00")).isAprovado());
    }

    @Test
    public void identificaProcessadorPix() {
        SistemaPagamentoOnline sistema = new SistemaPagamentoOnline(LIMITE);
        assertEquals("pix", sistema.cobrar(new BigDecimal("20.00")).getDetalhe());
    }

    @Test
    public void recusaAcimaDoLimitePeloProxy() {
        SistemaPagamentoOnline sistema = new SistemaPagamentoOnline(LIMITE);
        assertFalse(sistema.cobrar(new BigDecimal("50.00")).isAprovado());
    }

    @Test
    public void construtorPadraoAprovaValorComum() {
        assertTrue(new SistemaPagamentoOnline().cobrar(new BigDecimal("25.00")).isAprovado());
    }
}
