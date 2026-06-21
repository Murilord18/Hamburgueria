package com.hamburgueria.compartilhado.pagamento;

import java.math.BigDecimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PagamentoTest {

    @Test
    public void aVistaComCartaoCobraValorCheio() {
        Pagamento p = new PagamentoAVista(new ProcessadorCartao());
        assertEquals(new BigDecimal("10.00"), p.pagar(new BigDecimal("10.00")).getValorCobrado());
    }

    @Test
    public void aVistaComPixIdentificaProcessador() {
        Pagamento p = new PagamentoAVista(new ProcessadorPix());
        assertEquals("pix", p.pagar(new BigDecimal("10.00")).getDetalhe());
    }

    @Test
    public void dinheiroAprovado() {
        Pagamento p = new PagamentoAVista(new ProcessadorDinheiro());
        assertTrue(p.pagar(new BigDecimal("5.00")).isAprovado());
    }

    @Test
    public void parceladoAplicaJuros() {
        Pagamento p = new PagamentoParcelado(new ProcessadorCartao(), 3);
        assertEquals(new BigDecimal("10.60"), p.pagar(new BigDecimal("10.00")).getValorCobrado());
    }

    @Test
    public void parceladoMantemQuantidadeParcelas() {
        PagamentoParcelado p = new PagamentoParcelado(new ProcessadorCartao(), 6);
        assertEquals(6, p.getParcelas());
    }
}
