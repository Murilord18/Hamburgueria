package com.hamburgueria.compartilhado.pagamento;

import java.math.BigDecimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdaptadorGatewayExternoTest {

    @Test
    public void converteReaisEAprova() {
        ProcessadorPagamento ad = new AdaptadorGatewayExterno(new GatewayExternoLegado());
        assertTrue(ad.processar(new BigDecimal("25.00")).isAprovado());
    }

    @Test
    public void mantemValorNoResultado() {
        ProcessadorPagamento ad = new AdaptadorGatewayExterno(new GatewayExternoLegado());
        assertEquals(new BigDecimal("25.00"), ad.processar(new BigDecimal("25.00")).getValorCobrado());
    }

    @Test
    public void identificaOrigemGateway() {
        ProcessadorPagamento ad = new AdaptadorGatewayExterno(new GatewayExternoLegado());
        assertEquals("gateway-externo", ad.processar(new BigDecimal("25.00")).getDetalhe());
    }
}
