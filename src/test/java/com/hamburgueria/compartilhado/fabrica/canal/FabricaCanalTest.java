package com.hamburgueria.compartilhado.fabrica.canal;

import java.math.BigDecimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FabricaCanalTest {

    @Test
    public void presencialUsaBandeja() {
        FabricaCanal canal = new FabricaPresencial();
        assertEquals("bandeja", canal.criarEmbalagem().tipo());
    }

    @Test
    public void onlineUsaCaixaDelivery() {
        FabricaCanal canal = new FabricaOnline();
        assertEquals("caixa delivery", canal.criarEmbalagem().tipo());
    }

    @Test
    public void bandejaSemCusto() {
        assertEquals(new BigDecimal("0.00"), new EmbalagemBandeja().custo());
    }

    @Test
    public void deliveryComCusto() {
        assertEquals(new BigDecimal("2.50"), new EmbalagemDelivery().custo());
    }

    @Test
    public void presencialForneceCriadorDeLanche() {
        FabricaCanal canal = new FabricaPresencial();
        assertEquals("X-Burger",
                canal.criadorLanchePrincipal()
                        .produzir(new com.hamburgueria.compartilhado.lanche.FabricaIngredientes())
                        .getNome());
    }
}
